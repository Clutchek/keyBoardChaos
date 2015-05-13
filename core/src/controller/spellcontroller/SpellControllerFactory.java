package controller.spellcontroller;

import model.player.Player;
import model.spell.Fireball;
import model.spell.Spell;
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
			fireball.setPosX(player.getPosX() + player.getVector().getX()*10);
			fireball.setPosY(player.getPosY() + player.getVector().getY()*10);
			return new FireballController(fireball, player, fixtureManager);
		}
		return null;
	}

}
