package controller.spellcontroller;

import model.player.Player;
import model.spell.Fireball;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class FireballController implements SpellController{
	private Fireball fireball;
	private Player player;
	
	private Vector2 direction;
	private Body body;
	
	public FireballController(Fireball f, Player p){
		fireball = f;
		player = p;
	}
	
	public void castSpell(){}

	public Vector2 getVector(){
		return direction;
	}
	
	public Body getBody(){
		return body;
	}
	
}
