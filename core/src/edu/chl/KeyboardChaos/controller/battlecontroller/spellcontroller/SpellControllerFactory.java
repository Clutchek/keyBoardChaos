package edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller;

import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.model.spell.Iceball;
import edu.chl.KeyboardChaos.model.spell.OffensiveSpell;
import edu.chl.KeyboardChaos.model.spell.Spell;


/*
 * Factory class for the creation of SpellControllers
 */

public class SpellControllerFactory {
	
	private FixtureManager fixtureManager;
	
	public SpellControllerFactory(FixtureManager fixtureManager){
		this.fixtureManager = fixtureManager;
	}
	
	protected SpellController createSpellController(Spell spell, Player player){
		//kan beh�va kolla efter null
		if(spell instanceof OffensiveSpell){
			
			/*
			 * spaceX and spaceY is the distance away from the player the spell is created
			 * in order to not be created and instantly collide with the player.
			 * 
			 * So we move the creation point for the spell by checking what direction the
			 * player is facing, adding on the radius of the spell aswell as adding on a
			 * "safety" space of 10 pixels
			 * 
			 * If the player is checking diagonally (both x and y in the vector != 0),
			 * the distance is multiplied with 1/sqrt2.
			 */
			
			OffensiveSpell oSpell = (OffensiveSpell)spell;
			float spaceX = player.getVector().getX()*(player.getSize()+oSpell.getRadius()+10);
			float spaceY = player.getVector().getY()*(player.getSize()+oSpell.getRadius()+10);
			if (player.getVector().getX() != 0 && player.getVector().getY() != 0) {
				spaceX *= 1/Math.sqrt(2);
				spaceY *= 1/Math.sqrt(2);
			}
			float posX = player.getPosX() + spaceX;
			float posY = player.getPosY() + spaceY;
			
			oSpell.setPosX(posX);
			oSpell.setPosY(posY);
			OffensiveSpell copySpell = oSpell.clone();
			return new OffensiveSpellController(copySpell, player, fixtureManager);
			
		}

		throw new IllegalArgumentException("Spell not yet implemented");
		
	}

}
