package edu.chl.KeyboardChaos.controller.battlecontroller;

import java.util.List;
import java.util.Timer;

import com.badlogic.gdx.InputAdapter;

import edu.chl.KeyboardChaos.controller.battlecontroller.playercontroller.PlayerController;
import edu.chl.KeyboardChaos.settingsservice.Options;



/*
 * 
 * Class that receives key inputs from all players during a battle
 * and notifies all the player controllers what keys are pressed and which
 * keys are not.
 * 
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
		for(PlayerController p : playerControllerList){
			int index = playerControllerList.indexOf(p);
			int playerNumber = optionsService.getActivePlayers().get(index);
	
			if(keycode == optionsService.getUpButtonForPlayer(playerNumber)){
				p.setUp(true);
			}
			else if(keycode == optionsService.getLeftButtonForPlayer(playerNumber)){
				p.setLeft(true);
			}
			else if(keycode == optionsService.getDownButtonForPlayer(playerNumber)){
				p.setDown(true);
			}
			else if(keycode == optionsService.getRightButtonForPlayer(playerNumber)){
				p.setRight(true);
			}
			else if(keycode == optionsService.getFirstSpellButtonForPlayer(playerNumber)){
				p.useFirstSpell();
			}
			else if(keycode == optionsService.getSecondSpellButtonForPlayer(playerNumber)){
				p.useSecondSpell();
			}
		}
		return true;

	}

	@Override
	public boolean keyUp(int keycode) {
		for(PlayerController p : playerControllerList){
			int index = playerControllerList.indexOf(p);
			int playerNumber = optionsService.getActivePlayers().get(index);
	
			if(keycode == optionsService.getUpButtonForPlayer(playerNumber)){
				p.setUp(false);
			}
			else if(keycode == optionsService.getLeftButtonForPlayer(playerNumber)){
				p.setLeft(false);
			}
			else if(keycode == optionsService.getDownButtonForPlayer(playerNumber)){
				p.setDown(false);
			}
			else if(keycode == optionsService.getRightButtonForPlayer(playerNumber)){
				p.setRight(false);
			}
		}

		return true;
	}
}
