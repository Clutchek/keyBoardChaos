package edu.chl.KeyboardChaos.model;

import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Spell;
import edu.chl.KeyboardChaos.settingsservice.Options;

/*
 * This is the model that represents the game KeyboardChaos.
 */
public class KeyboardChaos {
	
	
	private List<Player> playerList;
	
	public KeyboardChaos(){
		playerList = new ArrayList<Player>();
	}
	
	/**
	 * Creates a player and stores it in a playerList, which can be retrieved from <b>getPlayerList</b>
	 * 
	 * @return
	 */
	public void createPlayers(){
		//Kolla settings antal aktiva spelare?
		this.playerList.clear();
		
		//Skapa spelare utifr�n settings
		Options options = Options.getOptionsInstance();
		if (options.getActivePlayers().contains(1))
			playerList.add(new Player("Player1", 10f,10f, options.getFirstSpell(1), options.getSecondSpell(1), 1));
		if (options.getActivePlayers().contains(2))
			playerList.add(new Player("Player2", 20f,20f, options.getFirstSpell(2), options.getSecondSpell(2), 2));
		if (options.getActivePlayers().contains(3))
			playerList.add(new Player("Player3", 30f,30f, options.getFirstSpell(3), options.getSecondSpell(3), 3));
		if (options.getActivePlayers().contains(4))
			playerList.add(new Player("Player4", 40f,40f, options.getFirstSpell(4), options.getSecondSpell(4), 4));
	}
	
	/**
	 * @return The list of all player objects
	 */
	public List<Player> getPlayerList(){
		return this.playerList;
	}

}
