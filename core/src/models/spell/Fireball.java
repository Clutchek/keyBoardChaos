package models.spell;

import models.player.Player;

public class Fireball implements Spell{
	
	protected int damage, projectileSpeed;
	protected Player originPlayer;
	
	public Fireball(int damage, int projectileSpeed, Player originPlayer){
		this.damage = damage;
		this.projectileSpeed = projectileSpeed;
		this.originPlayer = originPlayer;
		
	}
	
	public void castSpell(){
		new FireballFixture( damage, projectileSpeed, originPlayer);
	}

}
