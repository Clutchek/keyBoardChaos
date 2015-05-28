package model.gui.component;

import controller.eventbus.BusEvent;

public abstract class Component {
	
	private final int posX, posY;
	private BusEvent event;
	
	public Component(int posX, int posY, BusEvent event) {
		this.posX = posX;
		this.posY = posY;
		this.event = event;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	/**
	 * @return The BusEvent of this component.
	 */
	public BusEvent getEvent() {
		return this.event;
	}
}
