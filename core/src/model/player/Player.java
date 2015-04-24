package model.player;

import model.spell.Spell;
/**
 * A class that represents a player in the keyBoardChaos game.
 */
public class Player {
	
	private int healthPoints;
	private int size; //Radius? Diameter?
	private int posX, posY;
	
	private String playerName;
	
	private Spell spell1, spell2;

	private int moveUpKey, moveDownKey, moveRightKey, moveLeftKey, useSpell1Key, useSpell2Key;
	
	/*
	 * Questions:
	 * 
	 * Should Player take care of it's own movement, therefore needing a movement method?
	 * Or should the world/some manager take care of movement of all bodies?
	 */
	
	/**
	 * Constructor for the Player class.
	 */
	public Player(){
		
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
	public int getPosX() {
		return posX;
	}
	
	/**
	 * Method used to set the X-value of the Player's current position.
	 * @param posY represents the X-value of the Player's position.
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Method used to return the Y-value of the Player's position.
	 * @return the Y-value of the Player's position.
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Method used to set the Y-value of the Player's current position.
	 * @param posY represents the Y-value of the Player's position.
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**
	 * Method used to get the key that is used to move the Player up.
	 * @return the numeric value of the key that responds to moving the Player up.
	 */
	public int getMoveUpKey() {
		return moveUpKey;
	}
	
	/**
	 * Method used to set a key that is used to move the Player up.
	 * @param moveLeft the numeric value of the key responds to moving the Player up.
	 */
	public void setMoveUpKey(int moveUp) {
		this.moveUpKey = moveUp;
	}
	
	/**
	 * Method used to get the key that is used to move the Player down.
	 * @return the numeric value of the key that responds to moving the Player down.
	 */
	public int getMoveDownKey() {
		return moveDownKey;
	}
	/**
	 * Method used to set a key that is used to move the Player down.
	 * @param moveLeft the numeric value of the key that responds to moving the Player down.
	 */
	public void setMoveDownKey(int moveDown) {
		this.moveDownKey = moveDown;
	}
	
	/**
	 * Method used to get the key that is used to move the Player right.
	 * @return the numeric value of the key that responds to moving the Player right.
	 */
	public int getMoveRightKey() {
		return moveRightKey;
	}
	/**
	 * Method used to set a key that is used to move the Player right.
	 * @param moveLeft the numeric value of the key that responds to moving the Player right.
	 */
	public void setMoveRightKey(int moveRight) {
		this.moveRightKey = moveRight;
	}
	
	/**
	 * Method used to get the key that is used to move the Player left.
	 * @return the numeric value of the key that responds to moving the Player left.
	 */
	public int getMoveLeftKey() {
		return moveLeftKey;
	}
	/**
	 * Method used to set a key that is used to move the Player left.
	 * @param moveLeft the numeric value of the key that responds to moving the Player left.
	 */
	public void setMoveLeftKey(int moveLeft) {
		this.moveLeftKey = moveLeft;
	}

	/**
	 * Method used to get the key that is used for the Player's first spell.
	 * @return the numeric value of the key that responds to letting the Player use his first Spell.
	 */
	public int getUseSpell1Key() {
		return useSpell1Key;
	}

	/**
	 * Method used to set a key for the Player's first spell.
	 * @param fireSpell1 represents the numeric value of the key that will be used for the Player's first spell.
	 */
	public void setUseSpell1Key(int fireSpell1) {
		this.useSpell1Key = fireSpell1;
	}

	/**
	 * Method used to get the key that is used for the Player's second spell.
	 * @return the numeric value of the key that responds to letting the Player use his second Spell.
	 */
	public int getUseSpell2() {
		return useSpell2Key;
	}
	
	/**
	 * Method used to set a key for the Player's second spell.
	 * @param fireSpell2 represents the numeric value of the key that will be used for the Player's second spell.
	 */
	public void setFireSpell2Key(int fireSpell2) {
		this.useSpell2Key = fireSpell2;
	}
}
