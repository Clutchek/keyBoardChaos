package model.gui;

import model.gui.component.PlayerSettingsPanel;
import controller.eventbus.BusEvent;

public class ControllerSettingsMenu extends Screen {

	private PlayerSettingsPanel psp1;
	private PlayerSettingsPanel psp2;
	private PlayerSettingsPanel psp3;
	private PlayerSettingsPanel psp4;
	
	public ControllerSettingsMenu(){
		super();
		this.psp1 = new PlayerSettingsPanel(700, 700, new BusEvent("hej"));
		this.psp2 = new PlayerSettingsPanel(700, 700, new BusEvent("hej"));
		this.psp3 = new PlayerSettingsPanel(700, 700, new BusEvent("hej"));
		this.psp4 = new PlayerSettingsPanel(700, 700, new BusEvent("hej"));
	}
	
	public void loadComponentList(){
		super.getComponents().add(this.psp1);
		super.getComponents().add(this.psp2);
		super.getComponents().add(this.psp3);
		super.getComponents().add(this.psp4);
		
	}
	
}
