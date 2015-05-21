package model.gui;

import java.util.ArrayList;
import java.util.List;

import model.gui.component.Component;

public abstract class Screen {
	private List<Component> components;
	
	public Screen() {
		this.components = new ArrayList<Component>();
	}
	
	public List<Component> getComponents() {
		return this.components;
	}
}
