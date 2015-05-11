package controller.spellcontroller;

import model.player.Player;

import com.badlogic.gdx.math.Vector2;

public abstract class SpellController {
	protected Vector2 vector;
	
	protected SpellController(){
		
	}
	
	public abstract void castSpell();

}
