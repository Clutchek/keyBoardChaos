package controller.gamestates;

import model.gui.SettingsMenu;
import model.gui.StartMenu;
import view.gui.UIView;

import com.badlogic.gdx.InputProcessor;

import controller.MouseInputProcessor;
import controller.eventbus.BusEvent;
import controller.eventbus.EventBusService;
import controller.eventbus.EventHandler;

public class UIState implements GameState, EventHandler {

	private StartMenu startMenu;
	private UIView uiView;
	private InputProcessor inputProcessor;
	private SettingsMenu settingsMenu;
	//private SpellMenu spellMenu;
	
	public UIState() {
		startMenu = new StartMenu();
		settingsMenu = new SettingsMenu();
	//	spellMenu = new SpellMenu();
		uiView = new UIView(startMenu);
		this.inputProcessor = new MouseInputProcessor(startMenu.getComponents());
		EventBusService.getInstance().subscribe(this);
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	private void switchToStartMenu(){
		uiView.changeScreen(startMenu);
	}
	
	private void switchToSettingMenu(){
		uiView.changeScreen(settingsMenu);
	}
	
	private void switchToSpellMenu(){
		uiView.changeScreen(spellMenu);
	}

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

	@Override
	public void onEvent(BusEvent e) {
		
		if(e.getBusCommand().equals("StartMenu")){
			switchToStartMenu();
		}
		else if(e.getBusCommand().equals("ControllerSettings")){
			switchToSettingMenu();
		}
		else if(e.getBusCommand().equals("SpellSettings")){
			switchToSpellMenu();
		}
	}
}