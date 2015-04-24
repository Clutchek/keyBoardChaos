package old.models.player;

import old.models.KCVars.Direction;
import old.models.spell.Spell;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Player {
	
	private int healthPoints;
	private int speed; // This needs to be a force in newtons, by itself or made to a force through methods
	private int moveUpKey, moveDownKey, moveLeftKey, moveRightKey, firstSpellKey, secondSpellKey;
	private boolean movingRight, movingLeft, movingUp, movingDown;
	private BodyDef bDef;
	private FixtureDef fDef;
	private Body body;
	private boolean isGettingInput;
	private Direction playerDirection;
	private Vector2 direction;
	private float radius;
	private String playerName;
	private Spell spell1, spell2;
	private Fixture fixture;
	
	
	public Player(int up, int down, int right, int left, int firstSpellKey, int secondSpellKey, float x, float y){
		healthPoints = 100;
		speed = 1;
		moveUpKey = up;
		moveDownKey = down;
		moveLeftKey = left;
		moveRightKey = right;
		this.firstSpellKey = firstSpellKey;
		this.secondSpellKey = secondSpellKey;
		
		radius = 10f;
		
		playerName = "";
		
		playerDirection = Direction.NAN;
		movingRight = false;
		movingLeft = false;
		movingUp = false;
		movingDown = false;

		
		bDef = new BodyDef();
		fDef = new FixtureDef();
		
		setPlayerPos(x, y);
		
		createPlayerInWorld();
		

	}
	
	/**
	 * Decreases the player's health by a certain amount
	 * @param dmg the amount player's health is to decrease
	 */
	public void takeDamage(int dmg){
		System.out.println(getPlayerName() + ": I now have " + healthPoints + " hp");
		healthPoints-=dmg;
		if(healthPoints <= 0){
			dispose();
		}
		System.out.println("Ouch");
		System.out.println(getPlayerName() + ": I now have " + healthPoints + " hp");
	}
	
	/**
	 * Destroys the fixture of this player
	 */
	private void dispose(){
		old.models.KCVars.fixturesToDestroy.put(this.body, this.fixture);
	}
	
	/**
	 * Creates this player
	 */
	private void createPlayerInWorld(){
	
		bDef.type = BodyType.DynamicBody;
		body = old.control.KeyboardChaosControl.getWorld().createBody(bDef);
		
		CircleShape cshape = new CircleShape();
		cshape.setRadius(radius / old.models.KCVars.PPM);
		
		fDef.shape = cshape;
		body.setUserData("player");
		fDef.filter.categoryBits = old.models.KCVars.BIT_PLAYER;
		fDef.filter.maskBits = old.models.KCVars.MASK_PLAYER;
		body.setLinearDamping(.5f);
		fixture = body.createFixture(fDef);
		fixture.setUserData(this);
	}
	
	/**
	 * Sets the player's name
	 * @param name name of this player
	 */
	public void setPlayerName(String name){
		playerName = name;
	}
	
	/**
	 * @return name of this player
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	/**
	 * @return body of this player
	 */
	public Body getBody(){
		return body;
	}
	
	/**
	 * Sets the player's first spell
	 * @param spell the spell that is to be assigned as first spell
	 */
	public void setFirstSpell(Spell spell){
		spell1 = spell;
	}
	
	/**
	 * @return this player's first assigned spell
	 */
	public Spell getFirstSpell(){
		return spell1;
	}
	
	/**
	 * Sets the player's second spell
	 * @param spell the spell that is to be assigned as second spell
	 */
	public void setSecondSpell(Spell spell) {
		spell2 = spell;
	}
	
	/**
	 * @return this player's second assigned spell
	 */
	public Spell getSecondSpell(){
		return spell2;
	}
	
	/**
	 * @return this player's key binded to cast its first spell
	 */
	public int getFirstSpellKey(){
		return this.firstSpellKey;
	}
	
	/**
	 * @return this player's key binded to cast its second spell
	 */
	public int getSecondSpellKey(){
		return this.secondSpellKey;
	}
	
	/**
	 * Increments the speed of this player
	 */
	protected void incrementSpeed(){
		speed*=1.1;
	}
	
	// TODO: Some gangstah method
	protected void setKey(int action, int newKey){
		
	}
	
	/**
	 * @return the key binded to move this player upwards
	 */
	public int getUpKey(){
		return moveUpKey;
	}
	
	/**
	 * @return the key binded to move this player downwards
	 */
	public int getDownKey(){
		return moveDownKey;
	}
	
	/**
	 * @return the key binded to move this player to the right
	 */
	public int getRightKey(){
		return moveRightKey;
	}
	
	/**
	 * @return the key binded to move this player to the left
	 */
	public int getLeftKey(){
		return moveLeftKey;
	}
	
	/**
	 * Sets the world position of this player
	 * @param x the new x position
	 * @param y the new y position
	 */
	public void setPlayerPos(float x, float y){
		this.bDef.position.set(x / old.models.KCVars.PPM, y / old.models.KCVars.PPM);
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
	 * @return the radius of this player's body
	 */
	public float getBodyRadius(){
		return radius;
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
	 * @return the direction this player is facing
	 */
	public Vector2 getDirection(){
		return direction;
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
	public Vector2 getVector(){ //TODO: Should use getDirection instead?
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
