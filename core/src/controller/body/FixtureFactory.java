package controller.body;

import model.player.Player;
import model.spell.Spell;

import com.badlogic.gdx.math.Vector2;
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
	
	protected Fixture createBody(Object o){
		if(isOfAcceptedType(o)){
			if(o instanceof Player){
				return createPlayerFixture((Player)o);
			}else if(o instanceof Spell){
				return createSpellFixture((Spell)o);
			}else
				return null;
		}else
			return null;
	}
	
	private boolean isOfAcceptedType(Object o){
		if(o != null){
			if(o instanceof Player || o instanceof Spell){
				return true;
			}else
				return false;
			
		}else 
			return false;
	}
	
	private Fixture createSpellFixture(Spell spellObject){
		BodyDef bodyDef = new BodyDef();
		FixtureDef fixtureDef = new FixtureDef();
		
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(new Vector2(0, 0)); //Problem: Need to know where player is located in order to get the right position
		
		Body body = world.createBody(bodyDef);
		
		CircleShape cshape = new CircleShape();
		cshape.setRadius(5f); //Gonna need tweaking
		
		fixtureDef.shape = cshape;
		fixtureDef.filter.categoryBits = controller.KCConstants.BIT_SPELL;
		fixtureDef.filter.maskBits = controller.KCConstants.MASK_SPELL;
		
		Fixture fixture = body.createFixture(fixtureDef);
		
		fixture.setUserData(spellObject);
		fixture.
		
		return fixture;
	}
	
	private Fixture createPlayerFixture(Player playerObject){	
		
		
		return null;
	}
	
}
