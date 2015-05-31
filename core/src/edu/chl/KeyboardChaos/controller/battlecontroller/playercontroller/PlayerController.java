package edu.chl.KeyboardChaos.controller.battlecontroller.playercontroller;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellControllerManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.util.DirectionVector;
import edu.chl.KeyboardChaos.util.KCConstants;


/*
 * Class that handles the controlling of a player during a battle
 * It handles the positioning of the players body, and withholds information of what spells the player has
 */
public class PlayerController {

	private final Player player;
	private boolean movingRight, movingLeft, movingUp, movingDown, isGettingInput;
	private Vector2 direction;
	private Body body;
	private SpellControllerManager spellControllerManager;
	private FixtureManager fixtureManager;
	private final Timer diagonalHelpTimer;
	public final static int TIMER_DELAY = 50;
	
	public PlayerController(Player p, FixtureManager fixtureManager, SpellControllerManager spellControllerManager){
		this.player = p;
		//setPlayerSettings(settings);
		this.spellControllerManager = spellControllerManager;
		this.fixtureManager = fixtureManager;
		createBody();
		direction = new Vector2(0,1);
		diagonalHelpTimer = new Timer();
		setInputStatus();
	}
	
	/*public void update(){
		setInputStatus();
		applyForce();
		updatePlayerPosition();
		updatePlayerDirection();
	}*/
	
	public void updateBody(){
		updateBodyPosition();
		applyForce();
	}

	public void updatePlayer(){
		updatePlayerPosition();
		if(player.isPlayerInLava()){
			player.takeDamage(1f / 60f);
		}
	}
	
	public void updateBodyPosition(){
		body.setTransform(player.getPosX() / (float)KCConstants.PPM, player.getPosY() / (float)KCConstants.PPM, 0);
	}
	
	/**
	 * Updates the player models position accordingly to the one in the box2d world.
	 */
	private void updatePlayerPosition(){
		Vector2 position = body.getPosition();
		player.setPosX(position.x * edu.chl.KeyboardChaos.util.KCConstants.PPM);
		player.setPosY(position.y * edu.chl.KeyboardChaos.util.KCConstants.PPM);
	}
	
	/**
	 * Updates the player model's direction accordingly to the keys that are held down.
	 */
	private void updatePlayerDirection(){
		DirectionVector vector = new DirectionVector(direction.x, direction.y);
		player.setVector(vector);
	}
	
	/**
	 * Applies force to the player's body if the player is getting input
	 */
	private void applyForce() {
		if (isGettingInput)
			body.applyForceToCenter(direction, true);
	}
	
	/**
	 * Sets whether this player is moving upwards or not
	 * @param b boolean describing if player should move upwards or not
	 */
	public void setUp(boolean b){
		Vector2 vector = new Vector2(direction.x, direction.y);
		movingUp = b;
		setInputStatus();
	}
	
	/**
	 * Sets whether this player is moving downwards or not
	 * @param b boolean describing if player should move downwards or not
	 */
	public void setDown(boolean b){
		Vector2 vector = new Vector2(direction.x, direction.y);
		movingDown = b;
		setInputStatus();
	}
	
	/**
	 * Sets whether this player is moving to the right or not
	 * @param b boolean describing if player should move to the right or not
	 */
	public void setRight(boolean b){
		Vector2 vector = new Vector2(direction.x, direction.y);
		movingRight = b;
		setInputStatus();
	}
	
	/**
	 * Sets whether this player is moving to the left or not
	 * @param b boolean describing if player should move to the left or not
	 */
	public void setLeft(boolean b){
		Vector2 vector = new Vector2(direction.x, direction.y);
		movingLeft = b;
		setInputStatus();
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
		updatePlayerDirection();
	}
	
	/**
	 * @return the direction this player is facing
	 */
	public Vector2 getVector(){
		return direction;
	}
	
	private void createBody(){
		body = fixtureManager.createFixture(player).getBody();
	}
	
	/*public void setPlayerPos(float x, float y){
		this.bDef.position.set(x /  KCConstants.PPM, y / KCConstants.PPM);
	}*/
	
	public Body getBody(){
		return body;
	}
	
//	public PlayerSettings getPlayerSettings(){
//		return settings;
//	}
	
	
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
		//System.out.println(direction);
		updatePlayerDirection();
	}
	
	public void useFirstSpell(){
		spellControllerManager.createSpellController(player.getFirstSpell(), player);
	}
	
	public void useSecondSpell(){
		spellControllerManager.createSpellController(player.getSecondSpell(), player);
	}
	
	/**
	 * The player that this controller has
	 * @return
	 */
	public Player getPlayer(){
		return this.player;
	}
}
