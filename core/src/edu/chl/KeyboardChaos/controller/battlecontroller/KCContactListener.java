package edu.chl.KeyboardChaos.controller.battlecontroller;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
//import edu.chl.KeyboardChaos.model.spell.Spell;
import edu.chl.KeyboardChaos.model.spell.OffensiveSpell;
import edu.chl.KeyboardChaos.util.MatchStats;




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
		if(isLavaInContact(contact) && isPlayerInContact(contact)){ // if player is in contact with lave he reveives dmg
			Player player = getPlayerFromContact(contact);

			player.takeDamage(1f / 60f);
			player.setPlayerInLava(true);

		
		}else if(isTwoSpellsInContact(contact)){ // if two spells collide, both gets destroyed
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

			if(spell instanceof Fireball){ //if player gets struck by a fireball he receives dmg
				Fireball fb = (Fireball)spell;
				player.takeDamage(fb.getDamage());

				player.setAggressor(fb.getOriginPlayerNumber());
				if (!player.isAlive()){ 	// if player dies gamestats will change
					this.matchStats.playerKilled(player);
					this.matchStats.playerKills(fb.getOriginPlayerNumber()-1);
				}

			}
		}
		
	}

	@Override
	public void endContact(Contact contact) {
		if(isLavaInContact(contact) && isPlayerInContact(contact)){ // when player is out of lava he stops receiving dmg
			Player player = getPlayerFromContact(contact);
			player.setPlayerInLava(false);
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
		
	private Player getPlayerFromContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		if(fixA.getUserData() instanceof Player){
			return (Player)(fixA.getUserData());
		}else if(fixB.getUserData() instanceof Player){
			return (Player)(fixB.getUserData());
		}else
			return null;
			
	}
	
	
	private OffensiveSpell getSpellFromContact(Contact c){
		Fixture fixA = c.getFixtureA();
		Fixture fixB = c.getFixtureB();
		
		if(fixA.getUserData() instanceof OffensiveSpell){
			return (OffensiveSpell)(fixA.getUserData());
		}else if(fixB.getUserData() instanceof OffensiveSpell){
			return (OffensiveSpell)(fixB.getUserData());
		}else
			return null; 	
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
