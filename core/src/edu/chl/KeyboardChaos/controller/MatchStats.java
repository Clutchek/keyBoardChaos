package edu.chl.KeyboardChaos.controller;

import edu.chl.KeyboardChaos.model.player.Player;
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
	
	private int[] playerScores;
	private int[] playerKills;
	private int[] playerDeaths;
	
	
	
	public MatchStats(){
		this.killScore = 10;
		this.resetMatchStats();
		
		int []playerScores = {playerOneScore, playerTwoScore, playerThreeScore, playerFourScore};
		int []playerKills = {playerOneKills, playerTwoKills, playerThreeKills, playerFourKills};
		int []playerDeaths = {playerOneDeaths, playerTwoDeaths, playerThreeDeaths, playerFourDeaths};
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
	public int IndexOfPlayer(Player p){
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
	/*
	 * This method is called on when a player gets a kill
	 * 
	 * @param p the player that got the kill
	 */
	public void playerKills(Player p){
		playerScores[IndexOfPlayer(p)] = playerScores[IndexOfPlayer(p)] + this.killScore;
		playerKills[IndexOfPlayer(p)] = playerKills[IndexOfPlayer(p)] + 1;
	}
	/*
	 * This method is called on when a player gets killed
	 * 
	 * @param p the player that got killed
	 */
	public void playerKilled(Player p){
		playerDeaths[IndexOfPlayer(p)] = playerDeaths[IndexOfPlayer(p)] + 1;
	}
	
	public int getPlayerScore(Player p){
		return playerScores[IndexOfPlayer(p)];
	}
	
	public int getPlayerKills(Player p){
		return playerKills[IndexOfPlayer(p)];
	}
	
	public int getPlayerDeaths(Player p){
		return playerDeaths[IndexOfPlayer(p)];
	}
	
}
