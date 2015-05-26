package model.spell;

import model.player.Player;

public class Water extends OffensiveSpell{
	
	private int damage, projectileSpeed;
	private Player originPlayer;
	private final float fireballRadius;
	
	public final static String DESCRIPTION = "A drip of this shit and you will never forget the man who invaded your anal.";
	public final static String NAME = "Water";

	public Water(){
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
	
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
