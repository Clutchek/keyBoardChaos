package controller;

import model.player.Player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;

import controller.spellcontroller.SpellController;
import controller.spellcontroller.SpellControllerFactory;

public class PlayerController {

	private Player player;
	private SpellControllerFactory spellControllerFactory;
	private boolean movingRight, movingLeft, movingUp, movingDown, isGettingInput;
	private Vector2 direction;
	private BodyDef bDef;
	private Body body;
	
	public PlayerController(Player p, PlayerSettings){
		this.player = p;
		spellControllerFactory = new SpellControllerFactory();
		bDef = new BodyDef();
		setPlayerPos(p.getPosX(), p.getPosY());
		createBody();
		
		setInputStatus();
	}
	
	public void update(){
		setInputStatus();
		body.applyForceToCenter(direction, true);
		updatePlayerPosition();
		
	}
	
	/**
	 * Updates the player models position accordingly to the one in the box2d world.
	 */
	private void updatePlayerPosition(){
		Vector2 position = body.getPosition();
		player.setPosX(position.x);
		player.setPosY(position.y);
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
		bDef.type = BodyType.DynamicBody;
		body = old.control.KeyboardChaosControl.getWorld().createBody(bDef);
		CircleShape cshape = new CircleShape();
		cshape.setRadius(player.getRadius() / KCConstants.PPM);
		body.setUserData(player);
		body.setLinearDamping(0.5f);	
	}
	
	public void setPlayerPos(float x, float y){
		this.bDef.position.set(x /  KCConstants.PPM, y / KCConstants.PPM);
	}
	
	public Body getBody(){
		return body;
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
		SpellController spellController = spellControllerFactory.createSpellController(player.getFirstSpell(), this);
		spellController.castSpell();
	}
	
	protected void useSecondSpell(){
		SpellController spellController = spellControllerFactory.createSpellController(player.getSecondSpell(), this);
		spellController.castSpell();
	}
}
