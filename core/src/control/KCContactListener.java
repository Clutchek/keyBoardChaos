package control;

import models.player.Player;
import models.spell.FireballFixture;
import models.spell.Spell;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class KCContactListener implements ContactListener {

	/*
	 * This is a help class that, when implemented, will check 
	 * when two entities are in contact, and take the appropriate
	 * action.
	 */
	
	
	@Override
	public void beginContact(Contact contact) {
		
		if(isPlayerSpellCollision(contact)){
			FireballFixture f = getFireballFixtureFromContact(contact);
			f.dispose();
			getPlayerFromContact(contact).takeDamage(f.getDamage());
			

		
		}else if(isPlayerLavaCollision(contact)){
			System.out.println("Lava!");
		
		}
		
	}

	@Override
	public void endContact(Contact contact) {

		if(isPlayerSpellCollision(contact)){
			System.out.println("Hit ended");
		}else if(isPlayerLavaCollision(contact)){
			System.out.println("No more lava");
		}
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isPlayerSpellCollision(Contact contact){
		Object oa = contact.getFixtureA().getUserData();
		Object ob = contact.getFixtureB().getUserData();
		
		if((oa instanceof Player && ob instanceof FireballFixture)
				||
			(oa instanceof FireballFixture && ob instanceof Player)){
			return true;
		}else return false;
	}
	
	private boolean isPlayerLavaCollision(Contact contact){

		Object oa = contact.getFixtureA().getUserData();
		Object ob = contact.getFixtureB().getUserData();
		
		if(oa.equals("lava")){
			return ob instanceof Player; 
		}else if(ob.equals("lava")){
			return oa instanceof Player;
		}else return false;
	}
	
	private boolean isSpellWorldWallCollision(Contact contact){
		Object oa = contact.getFixtureA().getUserData();
		Object ob = contact.getFixtureB().getUserData();
		
		if(oa.equals("world wall")){ //Unsure what this should be equals to, since it's not yet created
			return ob instanceof Spell;
		}else if(ob.equals("world wall")){
			return oa instanceof Player;
		}else return false;
	}
	
	private boolean isSpellObstacleCollsion(Contact contact){
		Object oa = contact.getFixtureA().getUserData();
		Object ob = contact.getFixtureB().getUserData();
		
		if(oa.equals("obstacle")){ //Same goes here, this might end up as an object
			return ob instanceof FireballFixture;
		}else if(ob.equals("obstale")){
			return oa instanceof FireballFixture;
		}else return false;
		
		
	}
	
	private FireballFixture getFireballFixtureFromContact(Contact c){
		return c.getFixtureA().getUserData() instanceof FireballFixture ? 
								(FireballFixture) c.getFixtureA().getUserData() : 
								(FireballFixture) c.getFixtureB().getUserData();
	}
	
	private Player getPlayerFromContact(Contact c){
		return c.getFixtureA().getUserData() instanceof Player ? 
								(Player) c.getFixtureA().getUserData() : 
								(Player) c.getFixtureB().getUserData();
	}
	
	

}
