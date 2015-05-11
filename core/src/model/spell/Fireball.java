package model.spell;

import model.main.DirectionVector;
import model.player.Player;

import com.badlogic.gdx.math.Vector2;

import controller.spellcontroller.FireballController;

public class Fireball implements Spell{
	
	private int damage, projectileSpeed;
	private Player originPlayer;
	private Fireball fireball;
	private final float fireballRadius;
	private float posX, posY;
	private DirectionVector vector;

	
	public Fireball(Player originPlayer){
		this.damage = 10;
		this.projectileSpeed = 1;
		this.originPlayer = originPlayer;
		this.fireball = new Fireball(originPlayer);
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
	
	public DirectionVector getVector(){
		return vector;
	}
	
	public void setPosX(float x){
		this.posX = x;
	}
	
	public void setPosY(float y){
		this.posY = y;
	}
	
	public float getPosX(){
		return posX;
	}
	
	public float getPosY(){
		return posY;
	}

}
