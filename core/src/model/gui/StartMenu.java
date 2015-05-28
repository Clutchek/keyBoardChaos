package model.gui;

import java.awt.Color;

import model.gui.component.Component;
import model.gui.component.PlayerSettingsPanel;
import model.gui.component.TextButton;
import controller.eventbus.BusEvent;

public class StartMenu extends Screen{

	private TextButton playButton;
	private TextButton exitButton;

	public StartMenu(){
		super();
		this.playButton = new TextButton("Play", 200, 600, 500, 150, new Color(150, 150, 150), new BusEvent("ControllerSettings"), false);
		this.exitButton = new TextButton("Exit", 200, 300, 500, 150, new Color(150, 150, 150), new BusEvent("exit"), false);
		loadComponentList();
	}

	private void loadComponentList(){
		super.getComponents().add(this.playButton);
		super.getComponents().add(this.exitButton);
	}

}


