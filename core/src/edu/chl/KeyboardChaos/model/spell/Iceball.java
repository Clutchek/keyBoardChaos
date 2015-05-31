package edu.chl.KeyboardChaos.model.spell;
/**
 * A class that represents an ice spell in the keyBoardChaos game.
*/
public class Iceball implements Spell{
	
	private static final long serialVersionUID = -7105427562354348157L;
	private int damage, projectileSpeed;
	private final float radius;
	
	public final static String DESCRIPTION = "This is a description of an iceball.";
	public final static String NAME = "Iceball";

	public Iceball(){
		this.damage = 2;
		this.projectileSpeed = 3;
		//this.originPlayer = originPlayer;
		radius = 10f;
	}
	
	@Override
	public float getCooldown(){
		return 7f;
	}
	
	@Override
	public float getDuration(){
		return 1/60f;
	}
	
	/**
	 * @return The damage of the iceball
	 */
	public float getDamage(){
		return this.damage;
	}
	
	/**
	 * @return The movement speed of the iceball 
	 */
	public int getProjectileSpeed(){
		return this.projectileSpeed;
	}
	
	public float getRadius(){
		return radius;
	}
	
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
