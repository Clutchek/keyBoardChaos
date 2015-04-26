package controller;

import java.util.List;

import model.player.Player;

public class PlayerManager {
	
	List<PlayerController> pControllers;
	
	public PlayerManager(List<Player> players){
		PlayerController p1 = new PlayerController(players.get(0));
		PlayerController p2 = new PlayerController(players.get(1));
		PlayerController p3 = new PlayerController(players.get(2));
		PlayerController p4 = new PlayerController(players.get(3));
		
		pControllers.add(p1);
		pControllers.add(p2);
		pControllers.add(p3);
		pControllers.add(p4);
	}
	
	public List<PlayerController> getPlayerControllers(){
		return pControllers;
	}
}
