package edu.chl.KeyboardChaos.view.gui.screen;

import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.view.gui.component.Component;



public abstract class Screen {
	private List<Component> components;
	
	public Screen() {
		this.components = new ArrayList<Component>();
	}
	
	public List<Component> getComponents() {
		return this.components;
	}
}