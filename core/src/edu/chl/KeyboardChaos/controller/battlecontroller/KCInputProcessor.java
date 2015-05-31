package edu.chl.KeyboardChaos.controller.battlecontroller;

import java.util.List;
import java.util.Timer;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import edu.chl.KeyboardChaos.controller.battlecontroller.playercontroller.PlayerController;
import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.BusEventHandler;



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

public class KCInputProcessor extends InputAdapter implements BusEventHandler{
	private final Timer timer;
	private final List<PlayerController> playerControllerList;
	private final Options optionsService;
	private boolean roundIsOver;
	
	public KCInputProcessor(List<PlayerController> pcList){
		timer = new Timer();
		playerControllerList = pcList;		
		optionsService = Options.getOptionsInstance();
		this.roundIsOver = false;
		EventBusService.getInstance().subscribe(this);
	}
	
	@Override
	public boolean keyDown(int keycode) {
		for(PlayerController p : playerControllerList){
			int playerNumber = p.getPlayer().getPlayerNumber();
	
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
		
		if (roundIsOver && keycode == Input.Keys.ENTER) {
			EventBusService.getInstance().publish(new BusEvent("menu"));
		}
		
		return true;

	}

	@Override
	public boolean keyUp(int keycode) {
		for(PlayerController p : playerControllerList){
			int playerNumber = p.getPlayer().getPlayerNumber();
	
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
	
	@Override
	public void onEvent(BusEvent e) {
		if (e.getBusCommand().equals("round over"))
			this.roundIsOver = true;
		else if (e.getBusCommand().equals("play"))
			this.roundIsOver = false;
	}
}
