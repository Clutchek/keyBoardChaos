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
	
	public void setDamage(int dmg){
		this.damage = dmg;
	}
	
	public void increaseDamage(int increase){
		damage = damage + increase;
	}
	
	public void decreaseDamage(int decrease){
		damage = damage - decrease;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void castSpell(){
		new FireballFixture( damage, projectileSpeed, originPlayer);
	}

}
