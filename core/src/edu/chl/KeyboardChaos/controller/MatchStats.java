package edu.chl.KeyboardChaos.controller;

import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.settingsservice.Options;
/*
 * This class handles the stats of all players during a battle in KeyboardChaos
 */
public class MatchStats {

	private int playerOneScore;
	private int playerTwoScore;
	private int playerThreeScore;
	private int playerFourScore;

	private int playerOneKills;
	private int playerTwoKills;
	private int playerThreeKills;
	private int playerFourKills;

	private int playerOneDeaths;
	private int playerTwoDeaths;
	private int playerThreeDeaths;
	private int playerFourDeaths;

	private int killScore;

	private List<Integer> playerScores;
	private List<Integer> playerKills;
	private List<Integer> playerDeaths;

	public MatchStats(){
		this.killScore = 10;
		this.resetMatchStats();



		playerScores = new ArrayList<Integer>();
		playerKills = new ArrayList<Integer>();
		playerDeaths = new ArrayList<Integer>();

		addPlayersToMatchStats();
	}

	public void resetMatchStats(){
		this.playerOneScore = 0;
		this.playerTwoScore = 0;
		this.playerThreeScore = 0;
		this.playerFourScore = 0;

		this.playerOneKills = 0;
		this.playerTwoKills = 0;
		this.playerThreeKills = 0;
		this.playerFourKills = 0;

		this.playerOneDeaths = 0;
		this.playerTwoDeaths = 0;
		this.playerThreeDeaths = 0;
		this.playerFourDeaths = 0;

	}


	/*
	 * This method receives a player and returns the index of that player in MatchStats
	 */
	public int indexOfPlayer(Player p){
		if(p.getPlayerName().equals("Player1")){
			return 0;
		}
		else if(p.getPlayerName().equals("Player2")){
			return 1;
		}
		else if(p.getPlayerName().equals("Player3")){
			return 2;
		}
		else{
			return 3;
		}
	}

	private void addPlayersToMatchStats(){

		this.playerScores.add(playerOneScore);
		this.playerScores.add(playerTwoScore);
		this.playerScores.add(playerThreeScore);
		this.playerScores.add(playerFourScore);
		this.playerKills.add(playerOneKills);
		this.playerKills.add(playerTwoKills);
		this.playerKills.add(playerThreeKills);
		this.playerKills.add(playerFourKills);
		this.playerDeaths.add(playerOneDeaths);
		this.playerDeaths.add(playerTwoDeaths);
		this.playerDeaths.add(playerThreeDeaths);
		this.playerDeaths.add(playerFourDeaths);
	}



	/*
	 * This method is called on when a player gets a kill
	 * 
	 * @param p the player that got the kill
	 */
	public void playerKills(Player p){
		
		this.playerScores.set(indexOfPlayer(p),this.playerScores.get(indexOfPlayer(p)) + this.killScore);
		this.playerKills.set(indexOfPlayer(p),this.playerKills.get(indexOfPlayer(p)) + 1);
		
	}
	/*
	 * This method is called on when a player gets a kill
	 * 
	 * @param i the index of the player that got the kill
	 */
	
public void playerKills(int i){
		
		this.playerScores.set(i,this.playerScores.get(i) + this.killScore);
		this.playerKills.set(i,this.playerKills.get(i) + 1);
		
	}
	/*
	 * This method is called on when a player gets killed
	 * 
	 * @param p the player that got killed
	 */
	public void playerKilled(Player p){
		this.playerDeaths.set(indexOfPlayer(p),this.playerDeaths.get(indexOfPlayer(p)) + 1);
	}
	/*
	 * This method is called on when a player gets killed
	 * 
	 * @param i index of the player that got killed
	 */
	public void playerKilled(int i){
		this.playerDeaths.set(i,this.playerDeaths.get(i) + 1);
	}
	/*
	 * @param i gets the score for player with index i
	 */
	public int getPlayerScore(int i){
		return this.playerScores.get(i);
	}
	/*
	 * @param i gets the killstats for player with index i
	 */
	public int getPlayerKills(int i){
		return this.playerKills.get(i);
	}
	/*
	 * @param i gets the death stats for player with index i
	 */
	public int getPlayerDeaths(int i){
		return this.playerDeaths.get(i);
	}

	public List<Integer> getActivePlayers(){
		return Options.getOptionsInstance().getActivePlayers();

	}

}

