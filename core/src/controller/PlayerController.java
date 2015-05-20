package controller;

import model.main.DirectionVector;
import model.player.Player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import controller.body.FixtureManager;
import controller.playersettings.PlayerSettings;
import controller.spellcontroller.SpellControllerManager;

public class PlayerController {

	private Player player;
	private boolean movingRight, movingLeft, movingUp, movingDown, isGettingInput;
	private Vector2 direction;
	private Body body;
	private PlayerSettings settings;
	private SpellControllerManager spellControllerManager;
	private FixtureManager fixtureManager;
	
	public PlayerController(Player p, FixtureManager fixtureManager, SpellControllerManager spellControllerManager){
		this.player = p;
		//setPlayerSettings(settings);
		this.spellControllerManager = spellControllerManager;
		this.fixtureManager = fixtureManager;
		createBody();
		direction = new Vector2();
		
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
		setInputStatus();
		applyForce();
	}

	public void updatePlayer(){
		updatePlayerPosition();
		updatePlayerDirection();
	}
	
	public void updateBodyPosition(){
		Vector2 position = body.getPosition();
		position.x = player.getPosX();
		position.y = player.getPosY();	
	}
	
	
	
	/**
	 * Updates the player models position accordingly to the one in the box2d world.
	 */
	private void updatePlayerPosition(){
		Vector2 position = body.getPosition();
		player.setPosX(position.x * KCConstants.PPM);
		player.setPosY(position.y * KCConstants.PPM);
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
	
	public void setPlayerSettings(PlayerSettings settings){
		this.settings = settings;
		player.setFirstSpell(settings.getFirstSpell());
		player.setSecondSpell(settings.getSecondSpell());
		player.setPlayerName(settings.getPlayerName());
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
	
	protected void useFirstSpell(){
		spellControllerManager.createSpellController(player.getFirstSpell(), player);
	}
	
	protected void useSecondSpell(){
		spellControllerManager.createSpellController(player.getSecondSpell(), player);
	}
}
