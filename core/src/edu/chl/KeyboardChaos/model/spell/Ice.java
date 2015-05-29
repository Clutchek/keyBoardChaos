package edu.chl.KeyboardChaos.model.spell;
/**
 * A class that represents an ice spell in the keyBoardChaos game.
*/
public class Ice extends OffensiveSpell{
	
	private int damage, projectileSpeed;
	private final float radius;
	
	public final static String DESCRIPTION = "This is a description of ice.";
	public final static String NAME = "Ice";

	public Ice(){
		super();
		this.damage = 2;
		this.projectileSpeed = 3;
		//this.originPlayer = originPlayer;
		radius = 10f;
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
