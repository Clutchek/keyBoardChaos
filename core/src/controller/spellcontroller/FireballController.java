package controller.spellcontroller;

import model.main.DirectionVector;
import model.player.Player;
import model.spell.Fireball;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import controller.body.FixtureManager;

public class FireballController extends OffensiveSpellController{
	private Fireball fireball;
	private Player player;
	private FixtureManager fixtureManager;
	
	private Body body;
	
	public FireballController(Fireball f, Player p, FixtureManager fixtureManager){
		super(f);
		fireball = f;
		player = p;
		f.setVector(new DirectionVector(p.getVector().getX(), p.getVector().getY()));
		this.fixtureManager = fixtureManager;
		createBody();
	}
	
	private void createBody(){
		body = fixtureManager.createFixture(fireball).getBody();
	}
	
	public Body getBody(){
		return body;
	}
	
	public void update() {
		body.applyForceToCenter(getVector(), true);
		updatePosition();
		updateDirection();
	}
	
	//kanske kan refaktorera ut till offensiveSpellController
	private void updatePosition() {
		Vector2 position = body.getPosition();
		fireball.setPosX(position.x);
		fireball.setPosY(position.y);
	}
	
	public boolean isActive(){
		return true;
	}

}
