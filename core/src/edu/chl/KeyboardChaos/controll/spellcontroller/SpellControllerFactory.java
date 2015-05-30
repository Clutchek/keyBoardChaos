package edu.chl.KeyboardChaos.controll.spellcontroller;

import edu.chl.KeyboardChaos.controll.body.FixtureManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
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
		if(spell instanceof Fireball){
			Fireball fireball = new Fireball();
			float spaceX = player.getVector().getX()*(player.getSize()+fireball.getFireballRadius()+10);
			float spaceY = player.getVector().getY()*(player.getSize()+fireball.getFireballRadius()+10);
			if (player.getVector().getX() != 0 && player.getVector().getY() != 0) {
				spaceX *= Math.sqrt(2)/2;
				spaceY *= Math.sqrt(2)/2;
			}
			float posX = player.getPosX() + spaceX;
			float posY = player.getPosY() + spaceY;
			
			fireball.setPosX(posX);
			fireball.setPosY(posY);
			return new FireballController(fireball, player, fixtureManager);
		}
		return null;
	}

}
