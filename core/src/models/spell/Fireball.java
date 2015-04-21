package models.spell;

import models.player.Player;

public class Fireball implements Spell{
	
	private int damage, projectileSpeed;
	private Player originPlayer;
	
	public Fireball(int damage, int projectileSpeed, Player originPlayer){
		this.damage = damage;
		this.projectileSpeed = projectileSpeed;
		this.originPlayer = originPlayer;
		
	}
	
	/**
	 * Sets the damage dealt by fireballs
	 * @param dmg the damage fireballs are to deal
	 */
	public void setDamage(int dmg){
		this.damage = dmg;
	}
	
	/**
	 * Increases the damage dealt by fireballs
	 * @param increase the increase in damage dealt by fireballs
	 */
	public void increaseDamage(int increase){
		damage = damage + increase;
	}
	
	/**
	 * Decreases the damage dealt by fireballs
	 * @param decrease the decrease in damage dealt by fireballs
	 */
	public void decreaseDamage(int decrease){
		damage = damage - decrease;
	}
	
	/**
	 * @return the damage dealt by fireballs
	 */
	public int getDamage(){
		return damage;
	}
	
	/**
	 * Casts a fireball
	 */
	public void castSpell(){
		new FireballFixture( damage, projectileSpeed, originPlayer);
	}
}
