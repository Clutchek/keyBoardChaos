package edu.chl.KeyboardChaos.view.gui.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.view.gui.FontUtil;


/*
 * This abstract class is used by visual components in the GUI part of keyboardChaos
 */
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
	
	public abstract void render(SpriteBatch batch, ShapeRenderer shapeRenderer, FontUtil fontUtil);
	
	/**
	 * @return The BusEvent of this component.
	 */
	public BusEvent getEvent() {
		return this.event;
	}
}
