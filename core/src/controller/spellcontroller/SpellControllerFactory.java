package controller.spellcontroller;

import model.player.Player;
import model.spell.Fireball;
import model.spell.Spell;
import controller.KCConstants;
import controller.body.FixtureManager;

public class SpellControllerFactory {
	
	private FixtureManager fixtureManager;
	
	public SpellControllerFactory(FixtureManager fixtureManager){
		this.fixtureManager = fixtureManager;
	}
	
	protected SpellController createSpellController(Spell spell, Player player){
		//kan behöva kolla efter null
		if(spell instanceof Fireball){
			Fireball fireball = new Fireball();
			float spaceX = player.getVector().getX()*(player.getSize()+fireball.getFireballRadius());
			float spaceY = player.getVector().getY()*(player.getSize()+fireball.getFireballRadius());
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
