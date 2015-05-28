package edu.chl.KeyboardChaos.controll;

import java.util.List;
import java.util.Timer;

import com.badlogic.gdx.InputAdapter;

import edu.chl.KeyboardChaos.controll.playercontroller.PlayerController;
import edu.chl.KeyboardChaos.settingsservice.Options;



/*
 * If, in the future, this for some reason needs to extend 
 * another class, it is possible to implement InputProcessor 
 * instead of extending InputAdapter.
 * 
 */

public class KCInputProcessor extends InputAdapter{
	Timer timer;
	private List<PlayerController> playerControllerList;
	private Options optionsService;
	
	public KCInputProcessor(List<PlayerController> pcList){
		timer = new Timer();
		playerControllerList = pcList;		
		optionsService = Options.getOptionsInstance();
	}
	
	@Override
	public boolean keyDown(int keycode) {
		for(int i = 1; i < optionsService.getNbrOfPlayers(); i++){
			PlayerController p = playerControllerList.get(i);
	
			if(keycode == optionsService.getUpButtonForPlayer(i)){
				p.setUp(true);
			}
			else if(keycode == optionsService.getLeftButtonForPlayer(i)){
				p.setLeft(true);
			}
			else if(keycode == optionsService.getDownButtonForPlayer(i)){
				p.setDown(true);
			}
			else if(keycode == optionsService.getRightButtonForPlayer(i)){
				p.setRight(true);
			}
			else if(keycode == optionsService.getFirstSpellButtonForPlayer(i)){
				p.useFirstSpell();
			}
			else if(keycode == optionsService.getSecondSpellButtonForPlayer(i)){
				p.useSecondSpell();
			}
		}
		return true;

	}

	@Override
	public boolean keyUp(int keycode) {
		for(int i = 1; i < optionsService.getNbrOfPlayers(); i++){
			PlayerController p = playerControllerList.get(i);
	
			if(keycode == optionsService.getUpButtonForPlayer(i)){
				p.setUp(false);
			}
			else if(keycode == optionsService.getLeftButtonForPlayer(i)){
				p.setLeft(false);
			}
			else if(keycode == optionsService.getDownButtonForPlayer(i)){
				p.setDown(false);
			}
			else if(keycode == optionsService.getRightButtonForPlayer(i)){
				p.setRight(false);
			}
		}

		return true;
	}
}
