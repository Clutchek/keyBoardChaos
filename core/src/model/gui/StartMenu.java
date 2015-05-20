package model.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import model.gui.component.Component;
import model.gui.component.TextButton;

public class StartMenu{
	
	private List<Component> components;
	private TextButton playButton;
	private TextButton exitButton;
	
	public StartMenu(){
		this.playButton = new TextButton("Play", 50, 50, 50, 10, Color.GREEN);
		this.exitButton = new TextButton("Exit", 50, 100, 50, 10, Color.GREEN);
		loadComponentList();
	}
	
	private void loadComponentList(){
		components = new ArrayList();
		components.add(this.playButton);
		components.add(this.exitButton);
	}

}
