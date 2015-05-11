package controller.spellcontroller;

import model.player.Player;
import model.spell.Fireball;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import controller.body.FixtureManager;

public class FireballController extends SpellController{
	private Fireball fireball;
	private Player player;
	private FixtureManager fixtureManager;
	
	private Body body;
	
	public FireballController(Fireball f, Player p, FixtureManager fixtureManager){
		//super();
		fireball = f;
		player = p;
		this.fixtureManager = fixtureManager;
		createBody();
	}
	
	private void createBody(){
		body = fixtureManager.createFixture(fireball).getBody();
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
