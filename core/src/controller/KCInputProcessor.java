package controller;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import model.player.Player;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

/*
 * If, in the future, this for some reason needs to extend 
 * another class, it is possible to implement InputProcessor 
 * instead of extending InputAdapter.
 * 
 */

public class KCInputProcessor extends InputAdapter{
	Timer timer;
	private List<PlayerController> playerControllerList;
	
	public KCInputProcessor(List<PlayerController> pcList){
		timer = new Timer();
		playerControllerList = pcList;
		
	}
	
	@Override
	public boolean keyDown(int keycode) {
		PlayerController p = playerControllerList.get(0);
//		for(PlayerController p : playerControllerList){
//			p.
//		}

		if(keycode == Keys.W){
			p.setUp(true);
		}
		else if(keycode == Keys.A){
			p.setLeft(true);
		}
		else if(keycode == Keys.S){
			p.setDown(true);
		}
		else if(keycode == Keys.D){
			p.setRight(true);
		}
		else if(keycode == Keys.W){
			p.useFirstSpell();
		}
		else if(keycode == Keys.Q){
			p.useFirstSpell();
		}
		else if(keycode == Keys.E){
			p.useSecondSpell();
		}
			
//			if(keycode == p.getUpKey()){
//				p.setUp(true);
//			}else if(keycode == p.getDownKey()){
//				p.setDown(true);
//			}else if(keycode == p.getRightKey()){
//				p.setRight(true);
//			}else if(keycode == p.getLeftKey()){
//				p.setLeft(true);
//			}else if(keycode == p.getfirstSpellKey()){
//				p.useFirstSpell();
//			}else if(keycode == p.getSecondSpellKey()){
//				p.useSecondSpell();
//			}
//		}
		return true;

	}

	@Override
	public boolean keyUp(int keycode) {
		PlayerController p = playerControllerList.get(0);
		
		if(keycode == Keys.W){
			p.setUp(false);
		}
		else if(keycode == Keys.A){
			p.setLeft(false);
		}
		else if(keycode == Keys.S){
			p.setDown(false);
		}
		else if(keycode == Keys.D){
			p.setRight(false);
		}
		
//		for(final Player p : old.control.states.StandardMode.getPlayerList()){
//			final Vector2 oldDirection = p.getVector();
//			
//			if(keycode == p.getUpKey()){
//				p.setUp(false);
//			}else if(keycode == p.getDownKey()){
//				p.setDown(false);
//			}else if(keycode == p.getRightKey()){
//				p.setRight(false);
//			}else if(keycode == p.getLeftKey()){
//				p.setLeft(false);
//			}
//			
//			if (p.isGettingInput()) {
//				timer.schedule(new TimerTask() {
//					  @Override
//					  public void run() {
//						  if (!p.isGettingInput()) {
//							  p.setDirection(oldDirection);
//							  System.out.println(oldDirection);
//						  }
//					  }
//				}, 50);
//			}
//		}
		return true;
	}
}
