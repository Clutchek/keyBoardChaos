package edu.chl.KeyboardChaos.model.spell;

import java.io.Serializable;
/**
 * An interface for all spells
 */
public interface Spell extends Serializable{	
	public String getDescription();
	public String getName();
}
