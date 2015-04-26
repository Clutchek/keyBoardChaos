package model.spell;

import model.player.Player;

public class Fireball implements Spell{
	
	private int damage, projectileSpeed;
	private Player originPlayer;
	private final float fireballRadius;

	
	public Fireball(Player originPlayer){
		this.damage = 10;
		this.projectileSpeed = 1;
		this.originPlayer = originPlayer;
		fireballRadius = 3f;
		
	}
	
	/**
	 * Casts fireball spell
	 */
	
	@Override
	public void castSpell(){
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

}
