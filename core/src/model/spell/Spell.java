package model.spell;

import model.main.DirectionVector;

public abstract class Spell {
	
	private DirectionVector vector;
	
	public Spell() {
		this.vector = new DirectionVector(0, 0);
	}
	
	/**
	 * Fire the spell
	 */
	public abstract void castSpell();
	
	public DirectionVector setVector() {
		return this.vector;
	}
	
	public DirectionVector getVector(){
		return this.vector;
	}
}
