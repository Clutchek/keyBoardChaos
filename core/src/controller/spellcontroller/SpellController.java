package controller.spellcontroller;

import model.player.Player;

import com.badlogic.gdx.math.Vector2;

public abstract class SpellController {
	protected Vector2 vector;
	protected Spell s;
	protected body;
	
	protected SpellController(Spell s){
		
	}
	
	protected void update(){
		if(s instanceof OffensiveSpell){
			
		}
	}
	
	public abstract void castSpell();

}
