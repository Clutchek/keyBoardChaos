package edu.chl.KeyboardChaos.model.spell;

import edu.chl.KeyboardChaos.util.DirectionVector;

/**
 * A class that represents an attacking projectile spell in the keyBoardChaos game.
 */

public abstract class OffensiveSpell implements Spell {
	
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
	
	@Override
	public OffensiveSpell clone(){
		try {
			OffensiveSpell oSpell = (OffensiveSpell)super.clone();
			DirectionVector copy = new DirectionVector(vector);
			oSpell.vector = copy;
			return oSpell;
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null; //never invoked
		}
		
		
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
	
	public void setPlayerNumber(int playerNumber) {
		this.originPlayerNumber = playerNumber;
	}
}
