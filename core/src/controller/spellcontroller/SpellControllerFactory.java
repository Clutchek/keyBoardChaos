package controller.spellcontroller;

import model.spell.Fireball;
import model.spell.Spell;
import controller.PlayerController;

public class SpellControllerFactory {
	
	public SpellController createSpellController(Spell spell, PlayerController playerController){
		//kan behöva kolla efter null
		if(spell instanceof Fireball){
			Fireball fireball = (Fireball)spell;
			return new FireballController(fireball, playerController);
		}
		return null;
	}

}
