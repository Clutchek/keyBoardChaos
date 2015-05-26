package model.gui;

import model.gui.component.PlayerSettingsPanel;
import model.gui.component.SpellPanel;
import controller.KCConstants;
import controller.eventbus.BusEvent;
import controller.eventbus.EventHandler;

public class SettingsMenu extends Screen implements EventHandler {
	private PlayerSettingsPanel psp1;
	private PlayerSettingsPanel psp2;
	private PlayerSettingsPanel psp3;
	private PlayerSettingsPanel psp4;
	
	int halfOfScreen = KCConstants.GAME_WIDTH/2;
	int space = 20;

	public SettingsMenu(){
	
		psp1 = new PlayerSettingsPanel(halfOfScreen - space*3 - SpellPanel.WIDTH*2, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null);
		psp2 = new PlayerSettingsPanel(halfOfScreen - space - SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null);
		psp3 = new PlayerSettingsPanel(halfOfScreen + space, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null);
		psp4 = new PlayerSettingsPanel(halfOfScreen + space*3 + SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null);
		
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
