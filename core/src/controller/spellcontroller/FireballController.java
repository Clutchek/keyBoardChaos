package controller.spellcontroller;

import model.spell.Fireball;
import controller.PlayerController;

public class FireballController implements SpellController{
	private Fireball fireball;
	private PlayerController playerController;
	
	public FireballController(Fireball f, PlayerController p){
		fireball = f;
		playerController = p;
	}
	
	public void castSpell(){}

}
