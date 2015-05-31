package edu.chl.KeyboardChaos.controller.battlecontroller;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import edu.chl.KeyboardChaos.controller.MatchStats;
import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
//import edu.chl.KeyboardChaos.model.spell.Spell;
import edu.chl.KeyboardChaos.model.spell.OffensiveSpell;




/**
 * A custom contact listener. This class listens to contacts between two box2D fixtures.
 * When a contact happens, it will determine which two bodies that's in contact, and 
 * proceed with the appropriate action.
 * 
 * @author Kristoffer
 *
 */


public class KCContactListener implements ContactListener {
	
	private FixtureManager fixtureManager;
	private MatchStats matchStats;
	
	public KCContactListener(FixtureManager fixtureManager, MatchStats matchStats){
		this.fixtureManager = fixtureManager;
		this.matchStats = matchStats;
	}
	
	@Override
	public void beginContact(Contact contact) {
		if(isLavaInContact(contact) && isPlayerInContact(contact)){
			Player player = getPlayerFromContact(contact);
			player.takeDamage(1f / 60f);
			if(!player.isAlive()){
				matchStats.playerKilled(player);
				matchStats.playerKills(player.getEnemyAggrssor() - 1);
			}
		
		}else if(isTwoSpellsInContact(contact)){
			Fixture fixA = contact.getFixtureA();
			Fixture fixB = contact.getFixtureB();
			
			if(!fixA.getBody().equals(fixB.getBody())){	
				fixtureManager.addToDisposeList(fixA.getBody());
				fixtureManager.addToDisposeList(fixB.getBody());
			}
		}else if(isPlayerInContact(contact) && isSpellInContact(contact)){
			OffensiveSpell spell = getSpellFromContact(contact);
			fixtureManager.addToDisposeList(getSpellFixture(contact).getBody());
						
			Player player = getPlayerFromContact(contact);

			if(spell instanceof Fireball){
				Fireball fb = (Fireball)spell;
				player.takeDamage(fb.getDamage());
				System.out.println(fb.getOriginPlayerNumber());
				player.setEnemyAggressor(player.getPlayerNumber());
				if (!player.isAlive()){
					this.matchStats.playerKilled(player);
					this.matchStats.playerKills(fb.getOriginPlayerNumber()-1);
				}
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
	
	
	private OffensiveSpell getSpellFromContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		if(fixA.getUserData() instanceof OffensiveSpell){
			return (OffensiveSpell)(fixA.getUserData());
		}else if(fixB.getUserData() instanceof OffensiveSpell){
			return (OffensiveSpell)(fixB.getUserData());
		}else
			return null; 	//Denna metod ropas aldrig pÂ om man inte redan vet att en fixture i en contact ‰r en spell
							//sÂ null borde aldrig bli returnerat. Fortfarande inte snyggt med null... Exception?
				
	}
	
	private boolean isLavaInContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		return (fixA.getUserData().equals("lava") || fixB.getUserData().equals("lava"));

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
		return ((fixA.getUserData() instanceof OffensiveSpell) && (fixB.getUserData() instanceof OffensiveSpell));
		

	}

	private boolean isSpellInContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		return ((fixA.getUserData() instanceof OffensiveSpell) || (fixB.getUserData() instanceof OffensiveSpell));
	}
	
	private Fixture getSpellFixture(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		if(fixA.getUserData() instanceof OffensiveSpell){
			return fixA;
		}else if(fixB.getUserData() instanceof OffensiveSpell){
			return fixB;
		}else
			return null;
	}
	
}
