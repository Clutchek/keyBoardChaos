package edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller;

import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Spell;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.BusEventHandler;


/*
 * Class for managing which spell controllers should be active and inactive
 */
public class SpellControllerManager implements BusEventHandler{

	private SpellControllerFactory spellControllerFactory;
	private List<SpellController> spellControllerList;
	private List<SpellController> controllersToBeRemoved;
	
	public SpellControllerManager(FixtureManager fixtureManager){
		spellControllerFactory = new SpellControllerFactory(fixtureManager);
		spellControllerList = new ArrayList<SpellController>();
		controllersToBeRemoved = new ArrayList<SpellController>();
	}
	
	/**
	 * A factory method that takes care of creating spell controllers.
	 * 
	 * @param spells the spell that should be created
	 * @param player the player which will own this spell controller
	 */
	public void createSpellController(Spell spell, Player player){
			SpellController SC = spellControllerFactory.createSpellController(spell, player);
			spellControllerList.add(SC);
	}
	
	private void removeInactiveSpellControllers(){
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
			if(sc != null){
				sc.update();
			}
	
		}
		removeInactiveSpellControllers();
	}
	
	public void addControllerToRemove(SpellController controller) {
		if (!controllersToBeRemoved.contains(controller))
			this.controllersToBeRemoved.add(controller);
	}
	
	public void removeControllers() {
		this.spellControllerList.removeAll(controllersToBeRemoved);
	}
	
	public List<SpellController> getSpellControllers() {
		return this.spellControllerList;
	}

	@Override
	public void onEvent(BusEvent e) {
		if(e.getBusCommand().equals("RemoveSpellController") && e.getObject() instanceof SpellController){
			SpellController sc = (SpellController)e.getObject();
			addControllerToRemove(sc);
		}
		
	}
}
