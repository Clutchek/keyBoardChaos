package edu.chl.KeyboardChaos.controll;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import edu.chl.KeyboardChaos.controll.body.FixtureManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.model.spell.Spell;



/**
 * A custom contact listener. This class listens to contacts between two libGDX fixtures.
 * When a contact happens, it will determine which two bodies that's in contact, and 
 * proceed with the appropriate action.
 * 
 * @author Kristoffer
 *
 */


public class KCContactListener implements ContactListener {
	
	FixtureManager fixtureManager;
	
	public KCContactListener(FixtureManager fixtureManager){
		this.fixtureManager = fixtureManager;
	}
	
	@Override
	public void beginContact(Contact contact) {
		if(isLavaInContact(contact) && isPlayerInContact(contact)){
			Player player = getPlayerFromContact(contact);
			player.takeDamage(1f / 60f);
		
		}else if(isTwoSpellsInContact(contact)){
			Fixture fixA = contact.getFixtureA();
			Fixture fixB = contact.getFixtureB();
			
			
			if(fixA != null){	
				fixtureManager.addToDisposeList(fixA);
			}
			if(fixB != null){
				fixtureManager.addToDisposeList(fixB);
			}
		}else if(isPlayerInContact(contact) && isSpellInContact(contact)){
			Spell spell = getSpellFromContact(contact);
			fixtureManager.addToDisposeList(getSpellFixture(contact));
						
			Player player = getPlayerFromContact(contact);

			if(spell instanceof Fireball){
				Fireball fb = (Fireball)spell;
				player.takeDamage(fb.getDamage());
			}
		}
		
	}

	@Override
	public void endContact(Contact contact) {

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}
		
	private Player getPlayerFromContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		if(fixA.getUserData() instanceof Player){
			return (Player)(fixA.getUserData());
		}else if(fixB.getUserData() instanceof Player){
			return (Player)(fixB.getUserData());
		}else
			return null; 	//Denna metod ropas aldrig pÂ om man inte redan vet att en fixture i en contact ‰r en player
							//sÂ null borde aldrig bli returnerat. Fortfarande inte snyggt med null... Exception?
			
	}
	
	
	private Spell getSpellFromContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		if(fixA.getUserData() instanceof Spell){
			return (Spell)(fixA.getUserData());
		}else if(fixB.getUserData() instanceof Spell){
			return (Spell)(fixB.getUserData());
		}else
			return null; 	//Denna metod ropas aldrig pÂ om man inte redan vet att en fixture i en contact ‰r en spell
							//sÂ null borde aldrig bli returnerat. Fortfarande inte snyggt med null... Exception?
				
	}
	
	private boolean isLavaInContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		if (fixA.getUserData().equals("lava") || fixB.getUserData().equals("lava")){
			return true;
		}else
			return false;
	}
	
	private boolean isPlayerInContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		if(fixA.getUserData() instanceof Player || fixB.getUserData() instanceof Player){
			return true;
		}else
			return false;
	}
	
	private boolean isTwoSpellsInContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		if((fixA.getUserData() instanceof Spell) && (fixB.getUserData() instanceof Spell)){
			return true;
		}else
			return false;
	}

	private boolean isSpellInContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		if((fixA.getUserData() instanceof Spell) || (fixB.getUserData() instanceof Spell)){
			return true;
		}else
			return false;
	}
	
	private Fixture getSpellFixture(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		if(fixA.getUserData() instanceof Spell){
			return fixA;
		}else if(fixB.getUserData() instanceof Spell){
			return fixB;
		}else
			return null;
	}
	
}
