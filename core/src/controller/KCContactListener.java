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
	
	private void handleContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		
	}
	
	private void determineContactType(Contact c){
		Object fixtureAData;
		Object fixtureBData;
		
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		//************************************NULL CHECK*************************************// Remove?
		if(fixA.getUserData() != null && fixB.getUserData() != null){
			System.out.println("Some fixtures user data is null");
		//***********************************************************************************//
			
			//Checks if the contacts contain of one player fixture and one spell fixture
			if((fixA.getUserData() instanceof Spell || fixA.getUserData() instanceof PlayerController)
					&& (fixB.getUserData() instanceof Spell || fixB.getUserData() instanceof PlayerController)){
				Spell spell = getSpellFromContact(c);
				Fireball fb = (Fireball)spell;
				PlayerController pc = getPlayerFromContact(c);
				
				pc.getPlayer().setHealthPoints(pc.getPlayer().getHealthPoints() - fb.getDamage()); //Deal damage to player
				
				//This can be done prettier - Adds a spell fixture to the dispose list since it has hit something...
				if(fixA.getUserData() instanceof Spell){
					fixtureManager.addToDisposeList(fixA);
				}else if(fixB.getUserData() instanceof Spell){
					fixtureManager.addToDisposeList(fixB);
				}
				
				
			
			//Checks if the contacts are two spell fixtures	
			}else if(fixA.getUserData() instanceof Spell && fixB.getUserData() instanceof Spell){
				fixtureManager.addToDisposeList(fixA);
				fixtureManager.addToDisposeList(fixB);
				
			//Checks if the contact is between a player fixture and lava	
			}else if((fixA.getUserData() instanceof PlayerController || fixA.getUserData().equals("lava")
					&& (fixB.getUserData() instanceof PlayerController || fixB.getUserData().equals("lava")))){
				/*
				 * So, here we need some algorithm to dish out damage to the player as long as this contact is maintained
				 */
			}
			
		}
		
	}
	
	private PlayerController getPlayerFromContact(Contact c){
		
		if(c.getFixtureA().getUserData() instanceof PlayerController){
			return (PlayerController)c.getFixtureA().getUserData();
		}else if(c.getFixtureB().getUserData() instanceof PlayerController){
			return (PlayerController)c.getFixtureB().getUserData();
		}else
			return null; 	//Denna metod ropas aldrig pÂ om man inte redan vet att en fixture i en contact ‰r en player
							//sÂ null borde aldrig bli returnerat. Fortfarande inte snyggt med null... Exception?
			
	}
	
	
	private Spell getSpellFromContact(Contact c){
		
		if(c.getFixtureA().getUserData() instanceof Spell){
			return (Spell)c.getFixtureA().getUserData();
		}else if(c.getFixtureB().getUserData() instanceof Spell){
			return (Spell)c.getFixtureB().getUserData();
		}else
			return null; 	//Denna metod ropas aldrig pÂ om man inte redan vet att en fixture i en contact ‰r en spell
							//sÂ null borde aldrig bli returnerat. Fortfarande inte snyggt med null... Exception?
				
	}
	

	
	
}
