package controller;

import model.player.Player;
import model.spell.Fireball;
import model.spell.Spell;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import controller.body.FixtureManager;

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
			PlayerController pc = getPlayerFromContact(contact);
			
		
		}else if(isTwoSpellsInContact(contact)){
			fixtureManager.addToDisposeList(contact.getFixtureA());
			fixtureManager.addToDisposeList(contact.getFixtureB());
		
		}else if(isPlayerInContact(contact) && isSpellInContact(contact)){
			Spell spell = getSpellFromContact(contact);
			fixtureManager.addToDisposeList(getSpellFixture(contact));
						
			PlayerController pc = getPlayerFromContact(contact);

			if(spell instanceof Fireball){
				Fireball fb = (Fireball)spell;
				pc.getPlayer().setHealthPoints(pc.getPlayer().getHealthPoints() - fb.getDamage());
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
		
	private PlayerController getPlayerFromContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		if(fixA.getUserData() instanceof PlayerController){
			return (PlayerController)(fixA.getUserData());
		}else if(fixB.getUserData() instanceof PlayerController){
			return (PlayerController)(fixB.getUserData());
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
		if(fixA.getUserData() instanceof PlayerController || fixB.getUserData() instanceof PlayerController){
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
