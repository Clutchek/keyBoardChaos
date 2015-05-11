package model.spell;

import model.player.Player;
import model.spell.Fireball;

public class SpellFactory {

	
	/**
	 * A factory methods that creates a spell based on what String input it gets
	 * 
	 * @param spellName the name of the spell that should be created
	 * @param originPlayer Reference to the player that wants the spell created
	 * 
	 * @return the spell object that was created
	 */
	protected Spell createSpell(String spellName, Player originPlayer){
		if(spellName.equals("Fireball")){
			//return new Fireball(originPlayer);
		}
		return null;
	}
}
