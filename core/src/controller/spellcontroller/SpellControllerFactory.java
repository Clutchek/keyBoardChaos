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
			return new FireballController(new Fireball(), player, fixtureManager);
		}
		return null;
	}

}
