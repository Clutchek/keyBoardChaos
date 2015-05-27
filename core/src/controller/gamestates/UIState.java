package controller.gamestates;

import model.gui.SettingsMenu;
import model.gui.StartMenu;
import view.gui.UIView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;

import controller.MouseInputProcessor;
import view.gui.UIView;
import model.gui.SpellMenu;
import model.gui.StartMenu;
import controller.eventbus.BusEvent;
import controller.eventbus.EventBusService;
import controller.eventbus.EventHandler;

public class UIState implements GameState, EventHandler {

	private StartMenu startMenu;
	private SpellMenu spellMenu;
	private UIView uiView;
	private MouseInputProcessor inputProcessor;
	private SettingsMenu settingsMenu;
	
	public UIState() {
		startMenu = new StartMenu();
		settingsMenu = new SettingsMenu();
		//spellMenu = new SpellMenu();
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
		inputProcessor.loadComponents(startMenu.getComponents());
	}
	
	private void switchToSettingMenu(){
		uiView.changeScreen(settingsMenu);
		inputProcessor.loadComponents(settingsMenu.getComponents());
	}
	
	private void switchToSpellMenu(){
		uiView.changeScreen(spellMenu);
		inputProcessor.loadComponents(spellMenu.getComponents());
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
		if (e != null) {
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
}