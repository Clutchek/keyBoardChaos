package model.gui;

import model.gui.component.PlayerSettingsPanel;
import model.gui.component.SpellPanel;
import model.gui.component.TextButton;
import controller.KCConstants;
import controller.eventbus.BusEvent;
import controller.eventbus.EventHandler;

public class SettingsMenu extends Screen implements EventHandler {
	private PlayerSettingsPanel psp1, psp2, psp3, psp4;
	private TextButton backButton, nextButton;
	
	int halfOfScreen = KCConstants.GAME_WIDTH/2;
	int space = 20;

	public SettingsMenu(){
	
		psp1 = new PlayerSettingsPanel(halfOfScreen - space*3 - SpellPanel.WIDTH*2, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null);
		psp2 = new PlayerSettingsPanel(halfOfScreen - space - SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null);
		psp3 = new PlayerSettingsPanel(halfOfScreen + space, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null);
		psp4 = new PlayerSettingsPanel(halfOfScreen + space*3 + SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null);
		
		this.backButton = new TextButton("Back", 10, 10, 100, 100, new BusEvent("StartMenu"), false);
		this.nextButton = new TextButton("Next", KCConstants.GAME_WIDTH - 100 - 10, 10, 100, 100, new BusEvent("SpellSettings"), false);
		
		loadComponentList();
	}

	private void loadComponentList(){
		super.getComponents().add(this.psp1);
		super.getComponents().addAll(this.psp1.getComponents());
		super.getComponents().add(this.psp2);
		super.getComponents().addAll(this.psp2.getComponents());
		super.getComponents().add(this.psp3);
		super.getComponents().addAll(this.psp3.getComponents());
		super.getComponents().add(this.psp4);
		super.getComponents().addAll(this.psp4.getComponents());
		super.getComponents().add(backButton);
		super.getComponents().add(nextButton);
	}
	
	private void savePlayerKeys(){
		// be options spara keysen för varje player
	}

	@Override
	public void onEvent(BusEvent e) {
		if (e.getBusCommand().equals("SpellSettings")){
		savePlayerKeys();	
		}
		
	}


}
