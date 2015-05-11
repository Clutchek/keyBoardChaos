package controller.body;

import model.player.Player;
import model.spell.Spell;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class FixtureFactory {
	private World world;
	
	protected FixtureFactory(World world){
		this.world = world;
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
		if(body.getUserData() instanceof Spell){
			fixtureDef.filter.maskBits = controller.KCConstants.MASK_SPELL;
			fixtureDef.filter.categoryBits = controller.KCConstants.BIT_SPELL;
			fixtureRadius = 5f;
			
		}else if(body.getUserData() instanceof Player){
			fixtureDef.filter.maskBits = controller.KCConstants.MASK_PLAYER;
			fixtureDef.filter.categoryBits = controller.KCConstants.BIT_PLAYER;
			fixtureRadius = 10f;
			fixtureDef.friction = 0.1f; //Tweaking needed probably
		}
		
		CircleShape cshape = new CircleShape();
		cshape.setRadius(fixtureRadius); //Size not written in stone
		
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
		//**** Some way to get position ****//
		//body.position.set();
		bodyDef.type = BodyType.DynamicBody;
		
		Body body = world.createBody(bodyDef);
		body.setUserData(o);
		return body;
	}
	
}
