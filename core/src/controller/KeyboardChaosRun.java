package controller;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class KeyboardChaosRun implements ApplicationListener{

	private SpriteBatch spriteBatch;
	private float PPM = KCConstants.PPM;

	private OrthographicCamera worldCam, hudCam, b2dCam;
	
	private World world;
	
	private TiledMap tileMap;
	private OrthogonalTiledMapRenderer mapRenderer;
	private Box2DDebugRenderer b2dRenderer;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		
		Gdx.input.setInputProcessor(new KCInputProcessor());
		
		//Cameras
		worldCam = new OrthographicCamera(KCConstants.GAME_WIDTH, KCConstants.GAME_HEIGHT);
		worldCam.translate(KCConstants.GAME_WIDTH / 2, KCConstants.GAME_HEIGHT / 2);
		/*
		 * Translate is done since the cam before is centered at x = y = 0. 
		 * We can to move the cam so that the bottom left corner is at (0 0).
		 */
		worldCam.update();
		
		
		b2dCam = new OrthographicCamera();
		b2dCam.setToOrtho(false, KCConstants.GAME_WIDTH / PPM, KCConstants.GAME_HEIGHT / PPM);
		
		//World
		world = new World(KCConstants.GRAVITY, true);
		world.setContactListener(new KCContactListener());
		
		//Renderers
		b2dRenderer = new Box2DDebugRenderer();
		
		//Map stuff
		tileMap = new TmxMapLoader().load("assets/maps/betatest.tmx");
		MapBodyManager mbm = new MapBodyManager(world, PPM, null, 0);
		mbm.createPhysics(tileMap, "lavahurts");
		mapRenderer = new OrthogonalTiledMapRenderer(tileMap);
		
	}

	@Override
	public void render() {
		// Call view to render?
		
	}

	public void update(float dt){
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	//*****Unused stuff for now *****//
	@Override
	public void resize(int width, int height) {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void dispose() {}

}
