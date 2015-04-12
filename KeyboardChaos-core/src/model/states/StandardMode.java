package model.states;

import view.KCInput;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import control.GameStateManager;

public class StandardMode extends GameState {
	
	
	
	BitmapFont font = new BitmapFont();
	private World world;
	private Box2DDebugRenderer b2dr;
	
	private OrthographicCamera b2dCam;
	
	private Body body;
	
	private int PPM = models.KCVars.PPM; //Adjusting pixerls per meter, otherwise forces will look unnatural
	

	public StandardMode(GameStateManager gsm){
		super(gsm);
		
		/*
		 * Below needs a clean-up
		 */
		
		
		world = gsm.getControl().getWorld();
		b2dr = new Box2DDebugRenderer();
		
		// Define body
		
		BodyDef bdef = new BodyDef();
		bdef.position.set(300f / PPM, 50f / PPM);
		bdef.type = BodyType.StaticBody;
		
		body = world.createBody(bdef);
		
		//Shape of fixture
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(100f / PPM, 10f / PPM);
		
		
		//Define fixture
		
		FixtureDef fdef = new FixtureDef();
		fdef.shape = shape;
		
		body.createFixture(fdef);
		
		
		//Create dynamic ball
		bdef.position.set(300f / PPM, 400f / PPM);		
		bdef.type = BodyType.DynamicBody;
		body = world.createBody(bdef);

		
		CircleShape cshape = new CircleShape();
		cshape.setRadius(10f / PPM);
		
		fdef.shape = cshape;
		body.setLinearDamping(1f);
		body.createFixture(fdef);
		
		
		b2dCam = gsm.getControl().getb2dCam();
		b2dCam.setToOrtho(false, models.KCVars.GAME_WIDTH / PPM, models.KCVars.GAME_HEIGHT / PPM);

		/*
		 * Test using hashmap to associate certain keys with a specific player
		 *   |
		 *   |
		 *   V
		 */
		
		
//		KCInput.addToKeysHashMap(Keys.W, "Spelare 1");
//		KCInput.addToKeysHashMap(Keys.UP, "Spelare 2");
//		KCInput.addToKeysHashMap(Keys.DOWN, "Spelare 3");
//		KCInput.addToKeysHashMap(Keys.Z, "Spelare 4");
//		KCInput.addToKeysHashMap(Keys.LEFT, "Spelare 1");
//		KCInput.addToKeysHashMap(Keys.H, "Spelare 2");
//		KCInput.addToKeysHashMap(Keys.SPACE, "Spelare 3");
//		KCInput.addToKeysHashMap(Keys.ENTER, "Spelare 4");
		
	}
	
	@Override
	public void handleInput() {
		
		
		
///*
// * Temporary test for inputs
// * 
// * Problem: Input does not record when two buttons are pressed at the same time. Need own processor
// * 
		if(Gdx.input.isKeyPressed(Keys.UP) && !Gdx.input.isKeyPressed(Keys.RIGHT)){
			body.applyForceToCenter(0, 1, true);
			System.out.println("up up up");
		}else if(Gdx.input.isKeyPressed(Keys.LEFT) && !Gdx.input.isKeyPressed(Keys.UP)){
			body.applyForceToCenter(-1, 0, true);
			System.out.println("left");
		}else if(Gdx.input.isKeyPressed(Keys.RIGHT) && !Gdx.input.isKeyPressed(Keys.DOWN)){
			body.applyForceToCenter(1, 0, true);
			System.out.println("right");
		}else if(Gdx.input.isKeyPressed(Keys.DOWN) && !Gdx.input.isKeyPressed(Keys.LEFT)){
			body.applyForceToCenter(0, -1, true);
			System.out.println("down");
		}else if(Gdx.input.isKeyPressed(Keys.DOWN) && Gdx.input.isKeyPressed(Keys.RIGHT)){
			body.applyForceToCenter(1, -1, true);
			System.out.println("down right");
		}else if(Gdx.input.isKeyPressed(Keys.DOWN) && Gdx.input.isKeyPressed(Keys.LEFT)){
			body.applyForceToCenter(-1, -1, true);
			System.out.println("down left");
		}else if(Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.RIGHT)){
			body.applyForceToCenter(1, 1, true);
			System.out.println("up right");
		}else if(Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.LEFT)){
			body.applyForceToCenter(-1, 1, true);
			System.out.println("up left");
		}
//*/
	}

	@Override
	public void update(float dt) {
		handleInput();
		
		
		
		world.step(dt, 6, 2);
	}

	@Override
	public void render() {
		
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		b2dr.render(world, b2dCam.combined);
//		sb.setProjectionMatrix(worldCam.combined);
//		sb.begin();
//		font.draw(sb, "Standard Mode", 50, 50);
//		sb.end();
	}

	@Override
	public void dispose() {
	
	}
}
