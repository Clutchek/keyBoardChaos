package edu.chl.KeyboardChaos.model.spell;

/**
 * A class that represents a fireball in the keyBoardChaos game.
 */

public class Fireball extends OffensiveSpell{
	
	private int damage, projectileSpeed;
	private final float fireballRadius;
	
	public final static String DESCRIPTION = "Fire is the rapid oxidation of a material in the exothermic chemical "
			+ "process of combustion, releasing heat, light, and various reaction products.[1] Slower oxidative processes "
			+ "like rusting or digestion are not included by this definition.";

	public final static String NAME = "Fireball";
	
	public Fireball(){
		super();
		this.damage = 10;
		this.projectileSpeed = 1;
		//this.originPlayer = originPlayer;
		fireballRadius = 3f;
	}
	
	/**
	 * @return The damage of the fireball
	 */
	public int getDamage(){
		return this.damage;
	}
	
	/**
	 * @return The movement speed of the fireball 
	 */
	public int getProjectileSpeed(){
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
