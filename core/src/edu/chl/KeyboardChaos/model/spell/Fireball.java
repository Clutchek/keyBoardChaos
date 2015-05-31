package edu.chl.KeyboardChaos.model.spell;

/**
 * A class that represents a fireball in the keyBoardChaos game.
 */

public class Fireball extends OffensiveSpell{
	
	private static final long serialVersionUID = 8857635637656332791L;
	private float damage, projectileSpeed;
	private final float fireballRadius;
	
	public final static String DESCRIPTION = "This is a description of a fireball.";

	public final static String NAME = "Fireball";
	
	public Fireball(){
		super();
		this.damage = 10;
		this.projectileSpeed = 3f;
		fireballRadius = 3f;
	}
	
	@Override
	public float getCooldown(){
		return 1.5f;
	}
	
	@Override
	public float getDuration(){
		return 10f;
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
