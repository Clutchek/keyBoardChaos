package controller.spellcontroller;

import model.player.Player;
import model.spell.Fireball;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class FireballController implements SpellController{
	private Fireball fireball;
	private Player player;
	
	private Body body;
	
	public FireballController(Fireball f, Player p){
		fireball = f;
		player = p;
	}
	
	public void castSpell(){}

	public Vector2 getVector(){
		return fireball.getVector();
	}
	
	public Body getBody(){
		return body;
	}
	
	public void update() {
		body.applyForceToCenter(fireball.getVector(), true);
		updatePosition();
	}
	
	private void updatePosition() {
		Vector2 position = body.getPosition();
		fireball.setPosX(position.x);
		fireball.setPosY(position.y);
	}
}
