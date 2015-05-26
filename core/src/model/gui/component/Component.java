package model.gui.component;

import controller.eventbus.BusEvent;

public abstract class Component {
	
	private final int posX, posY, width, height;
	private BusEvent event;
	
	public Component(int posX, int posY, int width, int height, BusEvent event) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.event = event;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * @return The BusEvent of this component.
	 */
	public BusEvent getEvent() {
		return this.event;
	}
}
