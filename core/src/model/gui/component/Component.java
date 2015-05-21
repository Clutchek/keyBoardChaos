package model.gui.component;

import controller.eventbus.BusEvent;

public abstract class Component {
	
	private BusEvent event;
	
	public Component(BusEvent event) {
		this.event = event;
	}
	
	/**
	 * @return The BusEvent of this component.
	 */
	public BusEvent getEvent() {
		return this.event;
	}
}
