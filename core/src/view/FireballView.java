package view;

import model.main.KeyboardChaosModel;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

public class FireballView implements Disposable {
		
	private SpriteBatch spriteBatch;

	private World world;
	private BattleView battleView;
	
	private BodyDef bDef;
	private Body body;
	private FixtureDef fDef;
	private Fixture fixture;

	

	public FireballView (BodyDef bDef, Body body, int xPos, int yPos){
		this.bDef = bDef;
		this.body = body;
		
		this.bDef.type = BodyType.KinematicBody;
		this.bDef.position.set(xPos, yPos);
		
		fDef = new FixtureDef();
		
		
	}
	
	@Override
	public void dispose() {
		
	}

}
