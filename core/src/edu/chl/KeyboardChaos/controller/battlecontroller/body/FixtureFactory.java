package edu.chl.KeyboardChaos.controller.battlecontroller.body;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.model.spell.OffensiveSpell;
import edu.chl.KeyboardChaos.util.KCConstants;

/*
 * Factory class that can create fixtures and bodies for both players and spells
 */


public class FixtureFactory {
	private World world;
	private float PPM;
	private Body body;
	
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
		//Nullpointervarning h�r
		if(body.getUserData() instanceof OffensiveSpell){
			System.out.println("Im in fixturecreation fireball");
			fixtureDef.filter.maskBits = KCConstants.MASK_SPELL;
			fixtureDef.filter.categoryBits = KCConstants.BIT_SPELL;
			OffensiveSpell oSpell = (OffensiveSpell)body.getUserData();
			fixtureRadius = oSpell.getRadius() / PPM;
			
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
		bodyDef.type = BodyType.DynamicBody;
		
		if(o instanceof Player){
			Player player = (Player)o;
			bodyDef.position.set(player.getPosX() / PPM, player.getPosY() / PPM);
			body = world.createBody(bodyDef);
			body.setUserData(player);
		}else if(o instanceof OffensiveSpell){
			System.out.println("Im in bodycreation for spell");
			OffensiveSpell oSpell = (OffensiveSpell)o;
			bodyDef.position.set(oSpell.getPosX() / PPM, oSpell.getPosY() / PPM);
			System.out.println("Next is creating the body in the world, problematic step");
			body = world.createBody(bodyDef);
			System.out.println("...but it worked");
			if(oSpell instanceof Fireball){
				Fireball fireball = (Fireball)oSpell;
				body.setUserData(fireball);
				System.out.println("The if did not crash it");
			}
			
		}
		bodyDef.type = BodyType.DynamicBody;
		body.setLinearDamping(0.5f);
		System.out.println("Is passed through creating body");
		return body;
		
	}
	
}
