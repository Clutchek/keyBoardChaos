package controller.spellcontroller;

import model.spell.Spell;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class OffensiveSpellController {

	protected Vector2 vector;
	protected Spell s;
	protected Body body;
	private boolean isActive;
	
	protected OffensiveSpellController(Spell s){
		
	}
	
	protected void update(){
		
	
	}
	
	public boolean isActive(){
		return isActive;
	}
}
