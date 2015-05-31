package edu.chl.KeyboardChaos.model.spell;

import edu.chl.KeyboardChaos.util.DirectionVector;

/**
 * A class that represents an attacking projectile spell in the keyBoardChaos game.
 */

public abstract class OffensiveSpell implements Spell {
	private DirectionVector vector;
	private float posX, posY;
	protected float radius;
	
	public OffensiveSpell() {
		this.vector = new DirectionVector(0, 0);
	}
	
	public DirectionVector getVector() {
		return this.vector;
	}
	
	public void setVector(DirectionVector vector) {
		this.vector = vector;
	}
	
	public float getPosX() {
		return this.posX;
	}
	
	public float getPosY() {
		return this.posY;
	}
	
	public void setPosX(float x) {
		this.posX = x;
	}
	
	public void setPosY(float y) {
		this.posY = y;
	}
	
	public float getRadius(){
		return this.radius;
	}
}
