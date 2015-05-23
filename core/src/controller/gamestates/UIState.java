package controller.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import controller.MouseInputProcessor;
import view.gui.UIView;
import model.gui.StartMenu;

public class UIState implements GameState {

	private StartMenu startMenu;
	private UIView uiView;
	private InputProcessor inputProcessor;
	
	public UIState() {
		startMenu = new StartMenu();
		uiView = new UIView(startMenu);
		this.inputProcessor = new MouseInputProcessor(startMenu.getComponents());
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
		uiView.render();
	}

	public InputProcessor getInputProcessor() {
		return this.inputProcessor;
	}
}