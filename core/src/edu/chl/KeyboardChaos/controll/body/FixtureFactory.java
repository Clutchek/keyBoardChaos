package edu.chl.KeyboardChaos.controll.body;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.util.KCConstants;




public class FixtureFactory {
	private World world;
	private float PPM;
	
	protected FixtureFactory(World world){
		this.world = world;
		this.PPM = KCConstants.PPM;
	}
	
	/**
	 * Creates and returns a fixture. The returned fixture will have a reference
	 * to the object that is being represented. This is accessed using the fixture's
	 * method <b>getUserData()</b>.
	 * 
	 * @param body The body which is getting a graphical representation (a fixture)
	 * @return the newly created fixture
	 */
	protected Fixture createFixture(Body body){
		FixtureDef fixtureDef = new FixtureDef();
		float fixtureRadius = 0f;
		//Nullpointervarning här
		if(body.getUserData() instanceof Fireball){
			fixtureDef.filter.maskBits = KCConstants.MASK_SPELL;
			fixtureDef.filter.categoryBits = KCConstants.BIT_SPELL;
			Fireball fireball = (Fireball)body.getUserData();
			fixtureRadius = fireball.getFireballRadius() / PPM;
			
		}else if(body.getUserData() instanceof Player){
			fixtureDef.filter.maskBits = KCConstants.MASK_PLAYER;
			fixtureDef.filter.categoryBits = KCConstants.BIT_PLAYER;
			Player player = (Player)body.getUserData();
			fixtureRadius = (float)(player.getSize() / PPM);
			fixtureDef.friction = 0.1f; //Tweaking needed probably
		}
		
		CircleShape cshape = new CircleShape();
		cshape.setRadius(fixtureRadius);
		
		fixtureDef.shape = cshape;
		
		Fixture fixture = body.createFixture(fixtureDef);
		fixture.setUserData(body.getUserData());
		return fixture;
	}
	/**
	 * Creates a body in the world and returns it
	 * 
	 * @param o The object thats getting a body representation
	 * @return The newly created body
	 */
	protected Body createBody(Object o){
		BodyDef bodyDef = new BodyDef();
		if(o instanceof Player){
			Player player = (Player)o;
			bodyDef.position.set(player.getPosX() / PPM, player.getPosY() / PPM);	
		}else if(o instanceof Fireball){
			Fireball fireball = (Fireball)o;
			bodyDef.position.set(fireball.getPosX() / PPM, fireball.getPosY() / PPM);
		}
		bodyDef.type = BodyType.DynamicBody;
		
		Body body = world.createBody(bodyDef);
		body.setUserData(o);
		body.setLinearDamping(0.5f);
		return body;
	}
	
}
