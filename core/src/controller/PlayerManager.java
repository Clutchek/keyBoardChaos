package controller;

import java.util.ArrayList;
import java.util.List;

import model.player.Player;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.physics.box2d.Body;

public class PlayerManager {
	
	List<PlayerController> pControllers;
	PlayerManager playerManager;
	
	public PlayerManager(List<Player> players){
		pControllers = new ArrayList<PlayerController>();
		
		PlayerController p1 = new PlayerController(players.get(0),Keys.W ,Keys.S,Keys.A, Keys.D,Keys.Q,Keys.E);
		PlayerController p2 = new PlayerController(players.get(1), Keys.U, Keys.J, Keys.H, Keys.K, Keys.Y, Keys.I);
		PlayerController p3 = new PlayerController(players.get(2), Keys.UNKNOWN, Keys.UNKNOWN, Keys.UNKNOWN, Keys.UNKNOWN, Keys.UNKNOWN, Keys.UNKNOWN);
		PlayerController p4 = new PlayerController(players.get(3), Keys.UNKNOWN, Keys.UNKNOWN, Keys.UNKNOWN, Keys.UNKNOWN, Keys.UNKNOWN, Keys.UNKNOWN);
		
		pControllers.add(p1);
		pControllers.add(p2);
		pControllers.add(p3);
		pControllers.add(p4);
	}
	
	public void updatePlayers(){
		for(PlayerController p: pControllers){
			p.update();
		}
	}
	
	public List<PlayerController> getPlayerControllers(){
		return pControllers;
	}
	
	public List<Body> getPlayerBodies(){
		List<Body> bodies = new ArrayList<Body>();
		for(PlayerController p: pControllers){
			bodies.add(p.getBody());
		}
		return bodies;
	}
}
