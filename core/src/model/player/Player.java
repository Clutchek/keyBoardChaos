package model.player;

import model.spell.Spell;
/**
 * A class that represents a player in the keyBoardChaos game.
 */
public class Player {
	
	private int healthPoints;
	private int size;
	private float posX, posY;
	private int radius;
	
	private String playerName;
	
	private Spell spell1, spell2;
	
	/**
	 * Constructor for the Player class.
	 */
	public Player(){
		
	}
	
	public int getRadius(){
		return radius;
	}

	/**
	 * Decreases the players health points by a certain amount.
	 * @param dmg the amount of damage the Player's health should decrease by.
	 */
	public void takeDamage(int dmg){
		healthPoints -= dmg;
	}
	
	//Setters and getters
	
	/**
	 * Method used to get the Player's current amount of health points.
	 * @return an integer representation of the Player's health.
	 */
	public int getHealthPoints() {
		return healthPoints;
	}

	/**
	 * Method used to set the Player's current amount of health points.
	 * @param healthPoints an integer that will represent the Player's health.
	 */
	public void setHealthPoints(int healthPoints) {
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

	/**
	 * Method used to get the Player's name
	 * @return the name of the Player.
	 */
	public String getPlayerName() {
		return playerName;
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
	public Spell getSpell1() {
		return spell1;
	}

	/**
	 * Method used to set the Player's first spell.
	 * @param spell1 represents the spell that will be Player's first spell.
	 */
	public void setSpell1(Spell spell1) {
		this.spell1 = spell1;
	}

	/**
	 * Method used to return the Player's second spell.
	 * @return the second spell of the Player.
	 */
	public Spell getSpell2() {
		return spell2;
	}

	/**
	 * Method used to set the Player's second spell.
	 * @param spell2 represents the spell that will be Player's second spell.
	 */
	public void setSpell2(Spell spell2) {
		this.spell2 = spell2;
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
