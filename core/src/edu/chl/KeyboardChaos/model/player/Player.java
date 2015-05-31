package edu.chl.KeyboardChaos.model.player;

import edu.chl.KeyboardChaos.model.spell.Spell;
import edu.chl.KeyboardChaos.util.DirectionVector;


/**
 * A class that represents a player in the keyBoardChaos game.
 */
public class Player {
	
	private float healthPoints;
	private int size;
	private float posX, posY;
	private final int radius;
	private DirectionVector vector;
	private final int playerNumber;
	
	private String playerName;
	private Spell firstSpell, secondSpell;
	
	/**
	 * Constructor for the Player class.
	 */
	public Player(String name, float posX, float posY, Spell firstSpell, Spell secondSpell, int playerNumber){
		this.playerName = name;
		healthPoints = 100;
		this.firstSpell = firstSpell;
		this.secondSpell = secondSpell;
		radius = 2;
		setSize(25);
		//position
		this.posX = posX;
		this.posY = posY;
		//the direction of the player when the game starts
		setVector(new DirectionVector(1, 0));
		
		this.playerNumber = playerNumber;
	}
	
	
	public boolean isAlive(){
		return (getHealthPoints() > 0);
	}

	/**
	 * Decreases the players health points by a certain amount.
	 * @param dmg the amount of damage the Player's health should decrease by.
	 */
	public void takeDamage(float dmg){
		healthPoints -= dmg;
	}
	
	//Setters and getters
	
	/**
	 * Method used to get the Player's current amount of health points.
	 * @return an integer representation of the Player's health.
	 */
	public float getHealthPoints() {
		return healthPoints;
	}

	/**
	 * Method used to set the Player's current amount of health points.
	 * @param healthPoints an integer that will represent the Player's health.
	 */
	public void setHealthPoints(float healthPoints) {
		this.healthPoints = healthPoints;
	}

	/**
	 * Method used to return the size of the Player.
	 * @return an integer representation of the Player's size.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method used to set the size of the Player.
	 * @param size the integer that will be set to represent the Player's size.
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public DirectionVector getVector(){
		return vector;
	}
	
	public void setVector(DirectionVector vector){
		this.vector = vector;
	}

	/**
	 * Method used to get the Player's name
	 * @return the name of the Player.
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	/**
	 * Method used to set the Player's name.
	 * @param playerName a String that will be the Player's new name.
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Method used to return the Player's first spell.
	 * @return the first spell of the Player.
	 */
	public Spell getFirstSpell() {
		return firstSpell;
	}

	/**
	 * Method used to set the Player's first spell.
	 * @param spell1 represents the spell that will be Player's first spell.
	 */
	public void setFirstSpell(Spell spell1) {
		this.firstSpell = spell1;
	}

	/**
	 * Method used to return the Player's second spell.
	 * @return the second spell of the Player.
	 */
	public Spell getSecondSpell() {
		return secondSpell;
	}

	/**
	 * Method used to set the Player's second spell.
	 * @param spell2 represents the spell that will be Player's second spell.
	 */
	public void setSecondSpell(Spell spell2) {
		this.secondSpell = spell2;
	}

	/**
	 * Method used to return the X-value of the Player's position.
	 * @return the X-value of the Player's position.
	 */
	public float getPosX() {
		return posX;
	}
	
	/**
	 * Method used to set the X-value of the Player's current position.
	 * @param posY represents the X-value of the Player's position.
	 */
	public void setPosX(float posX) {
		this.posX = posX;
	}

	/**
	 * Method used to return the Y-value of the Player's position.
	 * @return the Y-value of the Player's position.
	 */
	public float getPosY() {
		return posY;
	}

	/**
	 * Method used to set the Y-value of the Player's current position.
	 * @param posY represents the Y-value of the Player's position.
	 */
	public void setPosY(float posY) {
		this.posY = posY;
	}
	
}
