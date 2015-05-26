package model.gui;

import model.gui.component.PlayerSettingsPanel;
import controller.eventbus.BusEvent;
import controller.eventbus.EventHandler;

public class SettingsMenu extends Screen implements EventHandler {
	private PlayerSettingsPanel psp1;
	private PlayerSettingsPanel psp2;
	private PlayerSettingsPanel psp3;
	private PlayerSettingsPanel psp4;

	public SettingsMenu(){
	
		psp1 = new PlayerSettingsPanel(20, 50, null);
		psp2 = new PlayerSettingsPanel(180, 50, null);
		psp3 = new PlayerSettingsPanel(240, 50, null);
		psp4 = new PlayerSettingsPanel(400, 50, null);
		
		loadComponentList();
	}

	private void loadComponentList(){
		super.getComponents().add(this.psp1);
		super.getComponents().add(this.psp2);
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
