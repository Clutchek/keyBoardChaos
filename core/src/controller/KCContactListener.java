package controller;

import old.models.player.Player;
import old.models.spell.FireballFixture;
import old.models.spell.Spell;

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
		
		} else if (isSpellWorldWallCollision(contact)) {
			getFireballFixtureFromContact(contact).dispose();
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
	
	/**
	 * Check if a spell hit a player
	 * @param contact the contact between two shapes
	 * @return true if spell and player is in contact, false otherwise
	 */
	private boolean isPlayerSpellCollision(Contact contact){
		Object oa = contact.getFixtureA().getUserData();
		Object ob = contact.getFixtureB().getUserData();
		
		if((oa instanceof Player && ob instanceof FireballFixture)
				||
			(oa instanceof FireballFixture && ob instanceof Player)){
			return true;
		}else return false;
	}
	
	/**
	 * Checks if a player is in lava
	 * @param contact the contact between two shapes
	 * @return true if player is in contact with lava, false otherwise
	 */
	private boolean isPlayerLavaCollision(Contact contact){

		Object oa = contact.getFixtureA().getUserData();
		Object ob = contact.getFixtureB().getUserData();
		
		if(oa.equals("lava")){
			return ob instanceof Player; 
		}else if(ob.equals("lava")){
			return oa instanceof Player;
		}else return false;
	}
	
	/**
	 * Checks if a spell hits a world wall
	 * @param contact the contact between two shapes
	 * @return true if spell is in contact with wall, false otherwise
	 */
	private boolean isSpellWorldWallCollision(Contact contact){
		Object oa = contact.getFixtureA().getUserData();
		Object ob = contact.getFixtureB().getUserData();
		
		if(oa.equals("world wall")){ //Unsure what this should be equals to, since it's not yet created
			return ob instanceof FireballFixture; // Might add a class SpellFixture later on?
		}else if(ob.equals("world wall")){
			return oa instanceof FireballFixture;
		}else return false;
	}
	
	/**
	 * Checks if a spell hits an obstacle
	 * @param contact the contact between two shapes
	 * @return true if spell is in contact with obstacle, false otherwise
	 */
	private boolean isSpellObstacleCollsion(Contact contact){
		Object oa = contact.getFixtureA().getUserData();
		Object ob = contact.getFixtureB().getUserData();
		
		if(oa.equals("obstacle")){ //Same goes here, this might end up as an object
			return ob instanceof FireballFixture;
		}else if(ob.equals("obstacle")){
			return oa instanceof FireballFixture;
		}else return false;
		
		
	}
	
	/**
	 * Returns the FireballFixture object from a contact
	 * @param c the contact between two shapes
	 * @return the FireballFixture object that is in contact with another shape
	 */
	private FireballFixture getFireballFixtureFromContact(Contact c){
		return c.getFixtureA().getUserData() instanceof FireballFixture ? 
								(FireballFixture) c.getFixtureA().getUserData() : 
								(FireballFixture) c.getFixtureB().getUserData();
	}
	
	/**
	 * Returns the Player object from a contact
	 * @param c the contact between two shapes
	 * @return the Player object that is in contact with another shape
	 */
	private Player getPlayerFromContact(Contact c){
		return c.getFixtureA().getUserData() instanceof Player ? 
								(Player) c.getFixtureA().getUserData() : 
								(Player) c.getFixtureB().getUserData();
	}
	
	

}
