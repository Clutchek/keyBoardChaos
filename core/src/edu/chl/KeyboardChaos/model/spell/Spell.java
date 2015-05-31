package edu.chl.KeyboardChaos.model.spell;

import java.io.Serializable;
/**
 * An interface for all spells
 */
public abstract class Spell implements Serializable, Cloneable{
	private float cooldownTime;
	
	public Spell(){
		cooldownTime = getCooldown()*60;
	}
	
	public abstract float getCooldown();
	public float getTicksSpentInCooldown(){
		return cooldownTime;
	}
	public void tickCooldownTimer(){
		if(cooldownTime < getCooldown()*60){
			cooldownTime = cooldownTime+1;
		}
	}
	public boolean isOnCoolDown(){
		return (getCooldown()*60 > getTicksSpentInCooldown());
	}
	public void resetCooldownTimer(){
		cooldownTime = 0;
	}
	public abstract float getDuration();
	public abstract String getDescription();
	public abstract String getName();
	
	//This clone implementation seem strange, but super.clone() is unreachable if clone was abstract here.
	//That would make it impossible for other abstract classes extending this class to create their own clone method.
	//Clone was needed here to show that all Spells will have clone().
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; //never invoked
		}
	}
	public abstract boolean equals(Object o);
}
