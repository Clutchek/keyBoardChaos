package edu.chl.KeyboardChaos.view.gui.screen;

import java.awt.Color;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.view.gui.component.TextButton;



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


