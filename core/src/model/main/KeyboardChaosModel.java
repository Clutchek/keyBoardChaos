package model.main;

import java.util.ArrayList;
import java.util.List;

import model.player.Player;


public class KeyboardChaosModel {
	
	
	private List<Player> playerList;

	/**
	 * Creates a player
	 * 
	 * @return
	 */
	
	public KeyboardChaosModel(){
		playerList = new ArrayList<Player>();
	}
	
	public void createPlayer(){
		playerList.add(new Player());
	}
	
	/**
	 * @return The list of all player objects
	 */
	public List<Player> getPlayerList(){
		return this.playerList;
	}
	
	
	
	
}
