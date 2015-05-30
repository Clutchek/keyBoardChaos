package edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.util.DirectionVector;
import edu.chl.KeyboardChaos.util.KCConstants;


/*
 * Class that handles the controlling of a fireball that has been fired from a player.
 * It keeps the positioning of an active fireball updated
 */
public class FireballController extends OffensiveSpellController{
	private Fireball fireball;
	private FixtureManager fixtureManager;
	
	private Body body;
	
	public FireballController(Fireball f, Player p, FixtureManager fixtureManager){
		super(f);
		fireball = f;
		f.setVector(new DirectionVector(p.getVector()));
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
		if(body != null){	
			float speed = fireball.getProjectileSpeed();
			body.setLinearVelocity(getVector().setLength(speed));
		}
		//body.applyForceToCenter(getVector(), true);
		updatePosition();
	}
	
	//kanske kan refaktorera ut till offensiveSpellController
	private void updatePosition() {
		Vector2 position = body.getPosition();
		fireball.setPosX(position.x * KCConstants.PPM);
		fireball.setPosY(position.y * KCConstants.PPM);
	}
	
	public boolean isActive(){
		return true;
	}

}
