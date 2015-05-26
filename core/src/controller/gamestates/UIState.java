package controller.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;

import controller.MouseInputProcessor;
import view.gui.UIView;
import model.gui.SpellSelect;
import model.gui.StartMenu;

public class UIState implements GameState {

	private StartMenu startMenu;
	private SpellSelect spellSelect;
	private UIView uiView;
	private InputProcessor inputProcessor;
	
	public UIState() {
		startMenu = new StartMenu();
		spellSelect = new SpellSelect();
		uiView = new UIView(spellSelect);
		this.inputProcessor = new MouseInputProcessor(spellSelect.getComponents());
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void switchToPlayerSettingMenu(){}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		uiView.render();
	}

	public InputProcessor getInputProcessor() {
		return this.inputProcessor;
	}
}