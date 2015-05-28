package edu.chl.KeyboardChaos.controll.gamestates;

import com.badlogic.gdx.InputProcessor;

import edu.chl.KeyboardChaos.controll.UIInputProcessor;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.EventHandler;
import edu.chl.KeyboardChaos.view.gui.UIView;
import edu.chl.KeyboardChaos.view.gui.screen.SettingsMenu;
import edu.chl.KeyboardChaos.view.gui.screen.SpellMenu;
import edu.chl.KeyboardChaos.view.gui.screen.StartMenu;



public class UIState implements GameState, EventHandler {

	private StartMenu startMenu;
	private SpellMenu spellMenu;
	private UIView uiView;
	private UIInputProcessor inputProcessor;
	private SettingsMenu settingsMenu;
	
	public UIState() {
		startMenu = new StartMenu();
		settingsMenu = new SettingsMenu();
		spellMenu = new SpellMenu();
		uiView = new UIView(startMenu);
		this.inputProcessor = new UIInputProcessor(startMenu.getComponents());
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