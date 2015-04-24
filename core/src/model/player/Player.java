package model.player;

import model.spell.Spell;

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
	
	public Player(){
		
	}
	


	/**
	 * Decreases the players health points by a certains amount
	 * 
	 * @param dmg the amount of damage the players health should decrease by
	 */
	public void takeDamage(int dmg){
		healthPoints -= dmg;
	}
	
	 //Setters and getters
	
	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Spell getSpell1() {
		return spell1;
	}

	public void setSpell1(Spell spell1) {
		this.spell1 = spell1;
	}

	public Spell getSpell2() {
		return spell2;
	}

	public void setSpell2(Spell spell2) {
		this.spell2 = spell2;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getMoveUpKey() {
		return moveUpKey;
	}

	public void setMoveUpKey(int moveUp) {
		this.moveUpKey = moveUp;
	}

	public int getMoveDownKey() {
		return moveDownKey;
	}

	public void setMoveDownKey(int moveDown) {
		this.moveDownKey = moveDown;
	}

	public int getMoveRightKey() {
		return moveRightKey;
	}

	public void setMoveRightKey(int moveRight) {
		this.moveRightKey = moveRight;
	}

	public int getMoveLeftKey() {
		return moveLeftKey;
	}

	public void setMoveLeftKey(int moveLeft) {
		this.moveLeftKey = moveLeft;
	}

	/**
	 * 
	 * @return
	 */
	public int getUseSpell1Key() {
		return useSpell1Key;
	}

	/**
	 * Set the key for the Player that 
	 * @param fireSpell1
	 */
	public void setUseSpell1Key(int fireSpell1) {
		this.useSpell1Key = fireSpell1;
	}

	/**
	 * 
	 * @return the Key that responds letting the Player use his second Spell.
	 */
	public int getUseSpell2() {
		return useSpell2Key;
	}
	
	/**
	 * 
	 * @param fireSpell2 represents the Players second spell
	 */
	public void setFireSpell2Key(int fireSpell2) {
		this.useSpell2Key = fireSpell2;
	}
}
