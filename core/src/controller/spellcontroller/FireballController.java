package controller.spellcontroller;

import model.spell.Fireball;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import controller.PlayerController;

public class FireballController implements SpellController{
	private Fireball fireball;
	private PlayerController playerController;
	
	private Vector2 direction;
	private Body body;
	
	public FireballController(Fireball f, PlayerController p){
		fireball = f;
		playerController = p;
	}
	
	public void castSpell(){}

	public Vector2 getVector(){
		return direction;
	}
	
	public Body getBody(){
		return body;
	}
	
}
