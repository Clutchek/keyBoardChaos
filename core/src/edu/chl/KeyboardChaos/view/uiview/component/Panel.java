package edu.chl.KeyboardChaos.view.uiview.component;

import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;

/**
 * A component containing other components
 */
public abstract class Panel extends Component {
	private final List<Component> components;
	
	public Panel(int posX, int posY) {
		super(posX, posY);
		this.components = new ArrayList<Component>();
	}
	
	public List<Component> getComponents() {
		return this.components;
	}
	
	public void addComponents(List<Component> components) {
		this.components.addAll(components);
	}
}
