/*
 * Class handles mouse inputs in menu screens
 */


package edu.chl.KeyboardChaos.controll;

import java.util.List;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import edu.chl.KeyboardChaos.model.gui.component.Component;
import edu.chl.KeyboardChaos.model.gui.component.SpellPanel;
import edu.chl.KeyboardChaos.model.gui.component.TextButton;
import edu.chl.KeyboardChaos.util.playersettings.Options;




public class UIInputProcessor implements InputProcessor {

	private List<Component> components;
	private TextButton selectedButton;

	public UIInputProcessor(List<Component> components){
		this.components = components;
	}

	@Override
	public boolean keyDown(int keycode) {
		Options options = Options.getOptionsInstance();
		if(selectedButton != null){
			selectedButton.setText(Input.Keys.toString(keycode));
			selectedButton = null;
		}
		for (Component c : components) {
			if (c instanceof SpellPanel) {
				SpellPanel panel = (SpellPanel)c;
				int playerNbr = panel.getPlayerNumber();
				if (keycode == options.getLeftButtonForPlayer(playerNbr)||
						keycode == options.getRightButtonForPlayer(playerNbr)) {
					panel.toggleSelectedSpellBox();
				}
				if (keycode == options.getUpButtonForPlayer(playerNbr)) {
					panel.nextSpell();
				} else if (keycode == options.getDownButtonForPlayer(playerNbr)) {
					panel.previousSpell();
				}
			}
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		for(Component c : components){
			if(c instanceof TextButton){
				TextButton button2 = (TextButton)c;
				if(button2.isMouseOver(screenX, screenY)){
					button2.buttonPressEvent();
				}
			}
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		for(Component c : components){
			
					
			if(c instanceof TextButton){
				TextButton button2 = (TextButton)c;
				if(button2.isMouseOver(screenX, screenY)){
					button2.buttonReleaseEvent();
					if(button2.isSelectable()){
						button2.toggleSelect();
						
						if (selectedButton == button2) {
							selectedButton = null;
						} else if (selectedButton != null) {
							selectedButton.toggleSelect();
							selectedButton = button2;
						} else if (selectedButton == null) {
							selectedButton = button2;
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {

		for(Component c : components){
			if(c instanceof TextButton){
				TextButton button = (TextButton)c;
				if(button.isMouseOver(screenX, screenY)){
					button.hover();
				} else if(!button.isMouseOver(screenX, screenY)){
					button.noHover();
				}
			}
		}
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void loadComponents(List<Component> components) {
		this.components = components;
	}
}
