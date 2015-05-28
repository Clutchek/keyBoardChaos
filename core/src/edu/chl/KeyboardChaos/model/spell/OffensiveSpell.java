package edu.chl.KeyboardChaos.model.spell;

import edu.chl.KeyboardChaos.model.main.DirectionVector;



public abstract class OffensiveSpell implements Spell {
	private DirectionVector vector;
	private float posX, posY;
	
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
}
