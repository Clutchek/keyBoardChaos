package controller.gamestates;

import view.gui.UIView;
import model.gui.StartMenu;

public class UIState implements GameState {

	private StartMenu startMenu;
	private UIView uiView;
	
	public UIState() {
		startMenu = new StartMenu();
		uiView = new UIView(startMenu);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		uiView.render();
	}

}