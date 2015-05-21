package model.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import controller.eventbus.BusEvent;
import model.gui.component.Component;
import model.gui.component.TextButton;

public class StartMenu extends Screen{
	
	private TextButton playButton;
	private TextButton exitButton;
	
	public StartMenu(){
		super();
		this.playButton = new TextButton("Play", 50, 50, 50, 10, new Color(150, 150, 150), new BusEvent("play"));
		this.exitButton = new TextButton("Exit", 50, 100, 50, 10, new Color(150, 150, 150), new BusEvent("exit"));
		loadComponentList();
	}
	
	private void loadComponentList(){
		super.getComponents().add(this.playButton);
		super.getComponents().add(this.exitButton);
	}

}
