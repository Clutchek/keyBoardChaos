package edu.chl.KeyboardChaos.model.spell;

import java.io.Serializable;
/**
 * An interface for all spells
 */
public interface Spell extends Serializable, Cloneable{	
	public String getDescription();
	public String getName();
	public float getCooldown();
	public float getDuration();
	public Spell clone();
	public boolean equals(Object o);
}
