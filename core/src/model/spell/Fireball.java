package model.spell;

import model.player.Player;

import com.badlogic.gdx.math.Vector2;

import controller.spellcontroller.FireballController;

public class Fireball implements Spell{
	
	private int damage, projectileSpeed;
	private Player originPlayer;
	private Fireball fireball;
	private final float fireballRadius;
	private FireballController fireballController;

	
	public Fireball(Player originPlayer){
		this.damage = 10;
		this.projectileSpeed = 1;
		this.originPlayer = originPlayer;
		this.fireball = new Fireball(originPlayer);
		this.fireballController = new FireballController(this, originPlayer);
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
	
	public Vector2 getVector(){
		
	}
	
	public float getPosX(){
		return fireballController.getBody().getPosition().x;
	}
	
	public float getPosY(){
		return fireballController.getBody().getPosition().y;
	}

}
