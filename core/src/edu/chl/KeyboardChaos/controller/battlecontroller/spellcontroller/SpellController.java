package edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller;

import com.badlogic.gdx.physics.box2d.Body;


/*
 * Interface for all spells
 */
public interface SpellController {
	
	
	public void update();
	public boolean isActive();
	public Body getBody();
	
}
