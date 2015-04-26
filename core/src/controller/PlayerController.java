package controller;

import java.io.File;

import old.models.spell.Spell;
import model.player.Player;

import com.badlogic.gdx.math.Vector2;

public class PlayerController {

	private Player player;
	private boolean movingRight, movingLeft, movingUp, movingDown, isGettingInput;
	private int moveUpKey, moveDownKey, moveLeftKey, moveRightKey, firstSpellKey, secondSpellKey;
	private Vector2 direction;
	
	public PlayerController(Player p,int moveUpKey,int moveDownKey,int moveLeftKey,int moveRightKey,int firstSpellKey,int secondSpellKey){
		this.player = p;
		this.moveUpKey = moveUpKey;
		this.moveDownKey = moveDownKey;
		this.moveLeftKey = moveLeftKey;
		this.moveRightKey = moveRightKey;
		this.firstSpellKey = firstSpellKey;
		this.secondSpellKey = secondSpellKey;
		
		updateDirection();
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
	
	/**
	 * Sets whether this player is moving upwards or not
	 * @param b boolean describing if player should move upwards or not
	 */
	public void setUp(boolean b){
		movingUp = b;
		setInputStatus();
		if(b){
			updateDirection();
		}
	}
	
	/**
	 * Sets whether this player is moving downwards or not
	 * @param b boolean describing if player should move downwards or not
	 */
	public void setDown(boolean b){
		movingDown = b;
		setInputStatus();
		if(b){
			updateDirection();
		}
	}
	
	/**
	 * Sets whether this player is moving to the right or not
	 * @param b boolean describing if player should move to the right or not
	 */
	public void setRight(boolean b){
		movingRight = b;
		setInputStatus();
		if(b){
			updateDirection();
		}
	}
	
	/**
	 * Sets whether this player is moving to the left or not
	 * @param b boolean describing if player should move to the left or not
	 */
	public void setLeft(boolean b){
		movingLeft = b;
		setInputStatus();
		if(b){
			updateDirection();
		}
	}
	
	/**
	 * Tells whether this player is getting directional input or not
	 * @return true if player is getting directional input, false otherwise
	 */
	public boolean isGettingInput(){
		return isGettingInput;
	}
	
	/**
	 * Tells whether this player is moving upwards or not
	 * @return true if player is moving upwards, false otherwise
	 */
	public boolean isMovingUp(){
		return movingUp;
	}
	
	/**
	 * Tells whether this player is moving downwards or not
	 * @return true if player is moving downwards, false otherwise
	 */
	public boolean isMovingDown(){
		return movingDown;
	}
	
	/**
	 * Tells whether this player is moving to the right or not
	 * @return true if player is moving to the right, false otherwise
	 */
	public boolean isMovingRight(){
		return movingRight;
	}
	
	/**
	 * Tells whether this player is moving to the left or not
	 * @return true if player is moving to the left, false otherwise
	 */
	public boolean isMovingLeft(){
		return movingLeft;
	}
	
	/**
	 * Sets the direction this player is facing
	 * @param direction the direction this player is to face
	 */
	public void setDirection(Vector2 direction) {
		this.direction = direction;
	}
	
	/**
	 * @return the direction this player is facing
	 */
	public Vector2 getVector(){
		return direction;
	}
	
	/**
	 * Sets the direction status of this player
	 */
	private void setInputStatus(){
		isGettingInput = isMovingUp() || isMovingDown() || isMovingRight() || isMovingLeft();

		if(isGettingInput()){
			updateDirection();
		}
	}
	
	/**
	 * Updates the vector in which the player is facing.
	 */
	private void updateDirection(){
		direction = new Vector2(0,0);
		
		if(isMovingUp()){
			direction.y = 1;
			}
		if(isMovingRight()){
			direction.x = 1;
			}
		if(isMovingLeft()){
			direction.x = -1;
		}
		if(isMovingDown()){
			direction.y = -1;
		}
	}
}
