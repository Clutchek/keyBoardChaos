package edu.chl.KeyboardChaos.controller.gamestates;

import com.badlogic.gdx.InputProcessor;

import edu.chl.KeyboardChaos.controller.UIInputProcessor;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.EventHandler;
import edu.chl.KeyboardChaos.view.uiview.screen.SettingsMenu;
import edu.chl.KeyboardChaos.view.uiview.screen.SpellMenu;
import edu.chl.KeyboardChaos.view.uiview.screen.StartMenu;
import edu.chl.KeyboardChaos.view.uiview.screen.ScreenView;

/*
 * Class that handles the UI state of the program, from the startup of the program until a battle is started
 * When the players switch from one UI menu to another this class switches to the correct one
 */

public class UIState implements GameState, EventHandler {

	private StartMenu startMenu;
	private SpellMenu spellMenu;
	private ScreenView uiView;
	private UIInputProcessor inputProcessor;
	private SettingsMenu settingsMenu;
	
	public UIState() {
		startMenu = new StartMenu();
		settingsMenu = new SettingsMenu();
		spellMenu = new SpellMenu();
		uiView = new ScreenView(startMenu);
		this.inputProcessor = new UIInputProcessor(startMenu.getAllComponents());
		EventBusService.getInstance().subscribe(this);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	private void switchToStartMenu(){
		uiView.changeScreen(startMenu);
		inputProcessor.loadComponents(startMenu.getAllComponents());
	}
	
	private void switchToSettingMenu(){
		uiView.changeScreen(settingsMenu);
		inputProcessor.loadComponents(settingsMenu.getAllComponents());
	}
	
	private void switchToSpellMenu(){
		uiView.changeScreen(spellMenu);
		inputProcessor.loadComponents(spellMenu.getAllComponents());
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