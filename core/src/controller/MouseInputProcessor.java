/*
 * Class handles mouse inputs in menu screens
 */


package controller;


import java.util.List;

import model.gui.component.Component;
import model.gui.component.TextButton;

import com.badlogic.gdx.InputProcessor;

public class MouseInputProcessor implements InputProcessor {

	private List<Component> components;
	private TextButton selectedButton;

	public MouseInputProcessor(List<Component> components){
		this.components = components;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
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
						selectedButton = button2;
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

}