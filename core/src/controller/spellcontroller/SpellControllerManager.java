package controller.spellcontroller;

import java.util.List;

import model.player.Player;
import model.spell.Fireball;
import model.spell.Spell;
import controller.body.FixtureManager;

public class SpellControllerManager {

	private SpellControllerFactory spellControllerFactory;
	private List<SpellController> spellControllerList;
//	private List<SpellController> controllersToBeRemoved;
	
	public SpellControllerManager(FixtureManager fixtureManager){
		spellControllerFactory = new SpellControllerFactory(fixtureManager);
	}
	
	/**
	 * A factory method that takes care of creating spell controllers.
	 * 
	 * @param spell the spell that should be created
	 * @param player the player which will own this spell controller
	 */
	public void createSpellController(Spell spell, Player player){
		if(spell instanceof Spell){
			SpellController SC = spellControllerFactory.
					createSpellController(spell, player);
			spellControllerList.add(SC);
		}else{
			System.out.println("NONONONONO");
		}
	}
	
	private void removeInactiveSpells(){
		for(int i = 0; i < spellControllerList.size(); i++){
			if(!spellControllerList.get(i).isActive()){
				spellControllerList.remove(i);
			}
		}
	}
	/**
	 * Loops through all active SpellControllers and updates their data.
	 * After it's done it checks if any SpellController is marked as inactive
	 * and removes them for next iteration.
	 */
	public void update(){
		for(SpellController sc : spellControllerList){
			sc.update();
	
		}
		removeInactiveSpells();
	}
	
}
