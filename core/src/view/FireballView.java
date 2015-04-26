package view;

import java.util.ArrayList;

import model.spell.Fireball;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import controller.gamestates.BattleState;

public class FireballView implements Disposable {
		
	private SpriteBatch spriteBatch;

	private World world;
	private BattleView battleView;
	
	private BattleState battleState;
	
	private Fireball fireball;
	private ArrayList<Fireball> listOfFireBalls;
	
	private BodyDef bDef;
	private Body body;
	private FixtureDef fDef;
	private Fixture fixture;
	
	private boolean assetsLoaded = false;

	public FireballView (BattleState battleState){
		
		this.battleState = battleState;
		this.world = battleState.getWorld();
		
		this.bDef = new BodyDef();
		this.bDef.type = BodyType.DynamicBody;
		
		this.fDef = new FixtureDef();
		
		CircleShape shape = new CircleShape();
		shape.setRadius(fireball.getFireballRadius());
		fDef.shape = shape;
		
	}
	
	/**
	 * This method creates a fireball fixture.
	 * It should be called everytime a new fireball is shot. 
	 * 
	 * @param fireball, the new fireball that is shot
	 * @param body, the body in which the fixture will be created
	 */
	
	public void addFireBallToView(Fireball fireball, Body b){
		listOfFireBalls.add(fireball);
		
		this.body = world.createBody(this.bDef);
		this.body.createFixture(fDef);
		
	}
	
	/**
	 * Method used to render the fireball's textures.
	 */
	public void render(){
		if(!assetsLoaded){
			loadAssets();
		}
		
		
	}
	
	public void loadAssets(){
		
	}
	
	
	@Override
	public void dispose() {
		
	}

}
