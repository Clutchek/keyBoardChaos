package edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller;

import com.badlogic.gdx.physics.box2d.Body;

import edu.chl.KeyboardChaos.model.spell.Spell;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;


/*
 * Interface for all spells
 */
public abstract class SpellController {
	private boolean isActive;
	protected float ticksActivated;
	private final Spell spell;
	
	public SpellController(Spell s){
		isActive = true;
		spell = s;
		ticksActivated = 0;
	}
	
	public void update(){
		if(ticksActivated >= spell.getDuration()*60){
			EventBusService.getInstance().publish(new BusEvent("RemoveSpellController", this));
			isActive = false;
		}else{
			ticksActivated = ticksActivated + 1;
		}
	}
	public float getTicksActivated(){
		return ticksActivated;
	}
	
	public boolean isActive(){
		return isActive;
	}
	
	
}
