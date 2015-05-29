package edu.chl.KeyboardChaos.view.uiview.screen;

import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.view.uiview.component.Component;
import edu.chl.KeyboardChaos.view.uiview.component.Panel;

/*
 * This abstract class represents any view on the GUI part of KeyboardChaos
 */

public abstract class Screen {
	private List<Component> components;
	
	public Screen() {
		this.components = new ArrayList<Component>();
	}
	
	public List<Component> getComponents() {
		return this.components;
	}
	
	public List<Component> getAllComponents() {
		List<Component> allComponents = new ArrayList<Component>();
		allComponents.addAll(components);
		
		for (Component c : components) {
			if (c instanceof Panel) {
				allComponents.addAll(((Panel) c).getComponents());
			}
		}
		
		return allComponents;
	}
}
