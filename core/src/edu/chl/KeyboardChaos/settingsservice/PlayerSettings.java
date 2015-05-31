package edu.chl.KeyboardChaos.settingsservice;

import java.io.Serializable;

import edu.chl.KeyboardChaos.model.spell.Spell;

/*
 * A class that contains all the customizable settings of a player
 * That includes a players keyboard controllers, spells and the name of the player.
 */

public class PlayerSettings implements Serializable{
	private static final long serialVersionUID = 1553090381314916480L;
	private int moveUpKey, moveDownKey, moveLeftKey, moveRightKey, firstSpellKey, secondSpellKey;
	private Spell firstSpell, secondSpell;
	private String playerName;
	
	public PlayerSettings(int moveUpKey,int moveDownKey,int moveLeftKey,int moveRightKey,int firstSpellKey,int secondSpellKey, Spell firstSpell, Spell secondSpell, String playerName){
		this.moveUpKey = moveUpKey;
		this.moveDownKey = moveDownKey;
		this.moveLeftKey = moveLeftKey;
		this.moveRightKey = moveRightKey;
		this.firstSpellKey = firstSpellKey;
		this.secondSpellKey = secondSpellKey;
		this.firstSpell = firstSpell;
		this.secondSpell = secondSpell;
		this.playerName = playerName; 
		
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
	public int getfirstSpellKey() {
		return firstSpellKey;
	}

	/**
	 * Method used to set a key for the Player's first spell.
	 * @param spellKey represents the numeric value of the key that will be used for the Player's first spell.
	 */
	public void setfirstSpellKey(int spellKey) {
		this.firstSpellKey = spellKey;
	}

	/**
	 * Method used to set a key for the Player's second spell.
	 * @param spellKey represents the numeric value of the key that will be used for the Player's first spell.
	 */
	public void setSecondSpellKey(int spellKey) {
		this.secondSpellKey = spellKey;
	}
	
	/**
	 * Method used to get the key that is used for the Player's second spell.
	 * @return the numeric value of the key that responds to letting the Player use his second Spell.
	 */
	public int getSecondSpellKey() {
		return secondSpellKey;
	}
	
	/**
	 * Method used to set a key for the Player's second spell.
	 * @param spellKey represents the numeric value of the key that will be used for the Player's second spell.
	 */
	public void setFireSpell2Key(int spellKey) {
		this.secondSpellKey = spellKey;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	
	public Spell getFirstSpell(){
		return firstSpell;
	}
	
	public void setFirstSpell(Spell spell){
		this.firstSpell = spell;
	}
	
	public Spell getSecondSpell(){
		return secondSpell;
	}
	
	public void setSecondSpell(Spell spell){
		this.secondSpell = spell;
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o == null){
			return false;
		}
		if(o.getClass() != this.getClass()){
			return false;
		}
		PlayerSettings other = (PlayerSettings)o;
		return (moveUpKey == other.moveUpKey &&
				moveUpKey == other.moveUpKey &&
				moveDownKey == other.moveDownKey &&
				moveLeftKey == other.moveLeftKey &&
				moveRightKey == other.moveRightKey &&
				firstSpellKey == other.firstSpellKey &&
				secondSpellKey == other.secondSpellKey &&
				firstSpell.equals(other.firstSpell)&&
				secondSpell.equals(other.secondSpell)&&
				playerName.equals(other.playerName));
		
	}
	
	
}
