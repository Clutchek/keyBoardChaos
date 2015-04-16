package models.player;

import models.spell.Spell;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Player {
	
	protected int healthPoints;
	protected int speed; // This needs to be a force in newtons, by itself or made to a force through methods
	public int moveUp, moveDown, moveLeft, moveRight;
	public boolean goUp, goDown, goRight, goLeft;
	public BodyDef bdef;
	public FixtureDef fdef;
	public Body body;
	public boolean isGettingInput;
	
	
	public Player(int up, int down, int right, int left, float x, float y){
		healthPoints = 100;
		speed = 1;
		moveUp = up;
		moveDown = down;
		moveLeft = left;
		moveRight = right;
		isGettingInput = goUp || goDown || goLeft || goRight;
		
		
		bdef = new BodyDef();
		fdef = new FixtureDef();
		
		
		
		bdef.position.set(x / models.KCVars.PPM, y / models.KCVars.PPM);		
		bdef.type = BodyType.DynamicBody;
		body = control.KeyboardChaosControl.world.createBody(bdef);
		
		CircleShape cshape = new CircleShape();
		cshape.setRadius(10f / models.KCVars.PPM);
		
		fdef.shape = cshape;
		body.setUserData("player");
		fdef.filter.categoryBits = models.KCVars.BIT_PLAYER;
		fdef.filter.maskBits = models.KCVars.BIT_PLAYER | models.KCVars.BIT_SPELL | models.KCVars.BIT_OBSTACLE | models.KCVars.BIT_LAVA;
		body.setLinearDamping(.5f);
		Fixture f = body.createFixture(fdef);
		f.setUserData("player");
	}
	
	
	
	
	protected Spell spell1, spell2;
	
	public void setFirstSpell(Spell spell){
		spell1 = spell;
	}
	
	public Spell getSpell(){
		return spell1;
	}
	
	protected void setSecondsSpell(Spell spell){
		spell2 = spell;
	}
	
	protected void incrementSpeed(){
		speed*=1.1;
	}
	
	protected void setKey(int action, int newKey){
		
	}
	
	public void setPlayerPos(float x, float y){
		
	}
	
	public void setUp(boolean boo){
		goUp = boo;
		setInputStatus();
	}
	
	public void setDown(boolean boo){
		goDown = boo;
		setInputStatus();
	}
	
	public void setRight(boolean boo){
		goRight = boo;
		setInputStatus();
	}
	
	public void setLeft(boolean boo){
		goLeft = boo;
		setInputStatus();
	}
	
	private void setInputStatus(){
		this.isGettingInput = goUp || goDown || goLeft || goRight;
	}
	
	
	
	
	
	
	

	
}
