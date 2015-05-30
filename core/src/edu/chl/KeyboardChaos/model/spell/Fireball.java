package edu.chl.KeyboardChaos.model.spell;

/**
 * A class that represents a fireball in the keyBoardChaos game.
 */

public class Fireball extends OffensiveSpell{
	
	private float damage, projectileSpeed;
	private final float fireballRadius;
	
	public final static String DESCRIPTION = "This is a description of a fireball.";

	public final static String NAME = "Fireball";
	
	public Fireball(){
		super();
		this.damage = 10;
		this.projectileSpeed = 3f;
		//this.originPlayer = originPlayer;
		fireballRadius = 3f;
	}
	
	/**
	 * @return The damage of the fireball
	 */
	public float getDamage(){
		return this.damage;
	}
	
	/**
	 * @return The movement speed of the fireball 
	 */
	public float getProjectileSpeed(){
		return this.projectileSpeed;
	}
	
	public float getFireballRadius(){
		return fireballRadius;
	}
	
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
