package edu.chl.KeyboardChaos.model.spell;

import edu.chl.KeyboardChaos.util.DirectionVector;

/**
 * A class that represents an attacking projectile spell in the keyBoardChaos game.
 */

public abstract class OffensiveSpell extends Spell {
	
	private static final long serialVersionUID = 4246452556975709909L;
	private DirectionVector vector;
	private float posX, posY;
	private float damage, radius, projectileSpeed, duration, cooldown;
	private int originPlayerNumber;
	
	public OffensiveSpell(Float damage, Float projectileSpeed,Float radius , Float duration, Float cooldown, int originPlayerNumber) {
		this.vector = new DirectionVector(0, 0);
		this.radius = radius;
		this.projectileSpeed = projectileSpeed;
		this.damage = damage;
		this.duration = duration;
		this.cooldown = cooldown;
		this.originPlayerNumber = originPlayerNumber;
		
	}
	//Koperingskonstruktor
	public OffensiveSpell(OffensiveSpell spell){
		this(spell.damage, spell.projectileSpeed,spell.radius , spell.duration,spell.cooldown, spell.originPlayerNumber);
		this.vector = new DirectionVector(spell.vector.getX(), spell.vector.getY());
	}
	
	@Override
	public OffensiveSpell clone(){
			
			OffensiveSpell oSpell = (OffensiveSpell)super.clone();
			DirectionVector copy = new DirectionVector(vector);
			oSpell.vector = copy;
			return oSpell;
			//return new OffensiveSpell(this);
		
		
	}
	
	public int getOriginPlayerNumber(){
		return originPlayerNumber;
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
	
	public float getDamage(){
		return this.damage;
	}
	
	@Override
	public float getCooldown(){
		return cooldown;
	}
	
	@Override
	public float getDuration(){
		return duration;
	}
	
	public float getProjectileSpeed(){
		return this.projectileSpeed;
	}
	@Override
	public boolean equals(Object otherObject){
		if(otherObject == this){
			return true;
		}
		if(otherObject == null){
			return false;
		}
		if(otherObject.getClass() != this.getClass()){
			return false;
		}
		OffensiveSpell otherSpell = (OffensiveSpell)otherObject;
		return (vector.equals(otherSpell.vector) &&
				radius == otherSpell.radius &&
				projectileSpeed == otherSpell.projectileSpeed &&
				damage == otherSpell.damage &&
				duration == otherSpell.duration &&
				cooldown == otherSpell.cooldown &&
				originPlayerNumber == originPlayerNumber &&
				posX == otherSpell.posX && posY == otherSpell.posY
				);
	}
	
	public void setPlayerNumber(int playerNumber) {
		this.originPlayerNumber = playerNumber;
	}
}
