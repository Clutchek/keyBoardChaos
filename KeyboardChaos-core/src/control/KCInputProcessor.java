package control;

import models.player.Player;

import com.badlogic.gdx.InputAdapter;

/*
 * If, in the future, this for some reason needs to extend 
 * another class, it is possible to implement InputProcessor 
 * instead of extending InputAdapter.
 * 
 */

public class KCInputProcessor extends InputAdapter{

	@Override
	public boolean keyDown(int keycode) {
		
		for(Player p : control.states.StandardMode.players){
			if(keycode == p.moveUp){
				p.setUp(true);
			}else if(keycode == p.moveDown){
				p.setDown(true);
			}else if(keycode == p.moveRight){
				p.setRight(true);
			}else if(keycode == p.moveLeft){
				p.setLeft(true);
			}
		}
		return true;

	}

	@Override
	public boolean keyUp(int keycode) {
		
		for(Player p : control.states.StandardMode.players){
			if(keycode == p.moveUp){
				p.setUp(false);
			}else if(keycode == p.moveDown){
				p.setDown(false);
			}else if(keycode == p.moveRight){
				p.setRight(false);
			}else if(keycode == p.moveLeft){
				p.setLeft(false);
			}
		}
		return true;
	}
}
