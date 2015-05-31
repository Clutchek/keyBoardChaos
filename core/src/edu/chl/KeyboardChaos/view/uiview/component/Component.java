package edu.chl.KeyboardChaos.view.uiview.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.view.uiview.FontUtil;


/*
 * This abstract class is used by visual components in the GUI part of keyboardChaos
 */
public abstract class Component {
	
	private final int posX, posY;
	
	public Component(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public abstract void render(SpriteBatch batch, ShapeRenderer shapeRenderer, FontUtil fontUtil);
}
