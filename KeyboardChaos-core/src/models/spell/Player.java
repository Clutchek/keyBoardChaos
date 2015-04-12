package models.spell;

import models.player.Spell;

public abstract class Player {
	
	protected int healthPoints;
	protected int speed; // This needs to be a force in newtons, by itself or made to a force through methods
	protected 1
	
	
	
	
	protected Spell spell1, spell2;
	
	protected void setFirstSpell(Spell spell){
		spell1 = spell;
	}
	
	protected void setSecondsSpell(Spell spell){
		spell2 = spell;
	}
	
	protected void incrementSpeed(){
		speed*=1.1;
	}
	
	
	
	
	
	

	
}
