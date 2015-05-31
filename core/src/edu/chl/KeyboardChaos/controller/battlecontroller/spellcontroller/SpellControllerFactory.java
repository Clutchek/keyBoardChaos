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
			OffensiveSpell oSpell = (OffensiveSpell)spell;
			float spaceX = player.getVector().getX()*(player.getSize()+oSpell.getRadius()+10);
			float spaceY = player.getVector().getY()*(player.getSize()+oSpell.getRadius()+10);
			if (player.getVector().getX() != 0 && player.getVector().getY() != 0) {
				spaceX *= Math.sqrt(2)/2;
				spaceY *= Math.sqrt(2)/2;
			}
			float posX = player.getPosX() + spaceX;
			float posY = player.getPosY() + spaceY;
			
			oSpell.setPosX(posX);
			oSpell.setPosY(posY);
			return new OffensiveSpellController(oSpell, player, fixtureManager);
			/*
			if(spell instanceof Fireball){
				Fireball fireball = new Fireball();
				fireball.setPosX(posX);
				fireball.setPosY(posY);
				return new FireballController(fireball, player, fixtureManager);*/
		}else if(spell instanceof Iceball){
				//Stub
				
			
		}
		return null;
	}

}
