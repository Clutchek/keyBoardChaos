package model.spell;

public class Fireball implements Spell{
	
	private int damage, projectileSpeed;
	private Player originPlayer;
	
	public Fireball(Player originPlayer){
		this.damage = 10;
		this.projectileSpeed = 1;
		this.originPlayer = originPlayer;
		
	}
	
	
	
	@Override
	public void castSpell(){
		//Used to create a fixture of the spell, which it can't do now since it's just model stuff... Major BS
	}
	
	/**
	 * @return The damage of the spell
	 */
	public int getDamage(){
		return this.damage;
	}
	
	/**
	 * 
	 * @return The movement speed of the spell 
	 */
	public int getProjectileSpeed(){
		return this.projectileSpeed;
	}

}
