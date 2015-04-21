package models.player;

import models.KCVars.Direction;
import models.spell.Spell;

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
	private Spell spell1, spell2;
	private int moveUpKey, moveDownKey, moveLeftKey, moveRightKey, firstSpellKey, secondSpellKey;
	private boolean movingRight, movingLeft, movingUp, movingDown;
	private BodyDef bDef;
	private FixtureDef fDef;
	private Body body;
	private boolean isGettingInput;
	private Direction playerDirection;
	private Vector2 direction;
	private float fixtureRadius;
	
	public Player(int up, int down, int right, int left, int spell1, int spell2, float posX, float posY){
		healthPoints = 100;
		speed = 1;
		moveUpKey = up;
		moveDownKey = down;
		moveLeftKey = left;
		moveRightKey = right;
		firstSpellKey = spell1;
		secondSpellKey = spell2;
		
		playerDirection = Direction.NAN;
		movingRight = false;
		movingLeft = false;
		movingUp = false;
		movingDown = false;

		fixtureRadius = 10f;
		
		bDef = new BodyDef();
		fDef = new FixtureDef();
		
		setPlayerPos(posX, posY);
		
		createPlayerInWorld();
		

	}
	
	private void createPlayerInWorld(){
	
		bDef.type = BodyType.DynamicBody;
		body = control.KeyboardChaosControl.getWorld().createBody(bDef);
		
		CircleShape cshape = new CircleShape();
		cshape.setRadius(fixtureRadius / models.KCVars.PPM);
		
		fDef.shape = cshape;
		body.setUserData("player");
		fDef.filter.categoryBits = models.KCVars.BIT_PLAYER;
		fDef.filter.maskBits = models.KCVars.BIT_PLAYER | models.KCVars.BIT_SPELL | models.KCVars.BIT_OBSTACLE | models.KCVars.BIT_LAVA;
		body.setLinearDamping(.5f);
		Fixture f = body.createFixture(fDef);
		f.setUserData("player");
	}
	
	public Body getBody(){
		return body;
	}
	
	public void setFirstSpell(Spell spell){
		spell1 = spell;
	}
	
	public Spell getFirstSpell(){
		return spell1;
	}
	
	protected void setSecondsSpell(Spell spell){
		spell2 = spell;
	}
	
	public Spell getSecondSpell() {
		return spell2;
	}
	
	public int getFirstSpellKey() {
		return firstSpellKey;
	}
	
	public int getSecondSpellKey() {
		return secondSpellKey;
	}
	
	protected void incrementSpeed(){
		speed*=1.1;
	}
	
	protected void setKey(int action, int newKey){
		
	}
	
	public int getUpKey(){
		return moveUpKey;
	}
	
	public int getDownKey(){
		return moveDownKey;
	}
	
	public int getRightKey(){
		return moveRightKey;
	}
	
	public int getLeftKey(){
		return moveLeftKey;
	}
	
	public float getBodyRadius() {
		return fixtureRadius;
	}
	
	public void setPlayerPos(float x, float y){
		this.bDef.position.set(x / models.KCVars.PPM, y / models.KCVars.PPM);
	}
	
	public void setUp(boolean b){
		movingUp = b;
		setInputStatus();
		if(b){
			updateDirection();
		}
	}
	
	public void setDown(boolean b){
		movingDown = b;
		setInputStatus();
		if(b){
			updateDirection();
		}
	}
	
	public void setRight(boolean b){
		movingRight = b;
		setInputStatus();
		if(b){
			updateDirection();
		}
	}
	
	public void setLeft(boolean b){
		movingLeft = b;
		setInputStatus();
		if(b){
			updateDirection();
		}
	}
	
	public boolean isGettingInput(){
		return isGettingInput;
	}
	
	public boolean isMovingUp(){
		return movingUp;
	}
	public boolean isMovingDown(){
		return movingDown;
	}
	public boolean isMovingRight(){
		return movingRight;
	}
	public boolean isMovingLeft(){
		return movingLeft;
	}
	
	public Direction getDirection(){
		return playerDirection;
	}
	
	public void setDirection(Vector2 direction) {
		this.direction = direction;
	}
	
	public Vector2 getVector(){
		return direction;
	}
	
	private void setInputStatus(){
		isGettingInput = isMovingUp() || isMovingDown() || isMovingRight() || isMovingLeft();

		if(isGettingInput()){
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
	
	private void updateDirection(){
		/*if(isGettingInput()){
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
		}*/
	}
	
	/*private void setLatestDirection(){
		if(goUp && goLeft){
			System.out.println("");
		}
	}*/
	
	
	
	
	
	
	

	
}
