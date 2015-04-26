package controller.gamestates;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import controller.KCConstants;
import controller.KCContactListener;
import controller.MapBodyManager;

public class BattleState implements GameState {

	private InputAdapter inputProcessor;
	private World world;
	private TiledMap tileMap;
	
	public BattleState() {
		//World
		world = new World(KCConstants.GRAVITY, true);
		world.setContactListener(new KCContactListener());
		
		//Map stuff
		tileMap = new TmxMapLoader().load("assets/maps/betatest.tmx");
		MapBodyManager mbm = new MapBodyManager(world, controller.KCConstants.PPM, null, 0);
		mbm.createPhysics(tileMap, "lavahurts");
		
		
//		THIS IS VIEW STUFF
//		mapRenderer = new OrthogonalTiledMapRenderer(tileMap);
//		
//		
//		//Cameras
//		worldCam = new OrthographicCamera(KCConstants.GAME_WIDTH, KCConstants.GAME_HEIGHT);
//		worldCam.translate(KCConstants.GAME_WIDTH / 2, KCConstants.GAME_HEIGHT / 2);
//		/*
//		 * Translate is done since the cam before is centered at x = y = 0. 
//		 * We can to move the cam so that the bottom left corner is at (0 0).
//		 */
//		worldCam.update();
//		
//		b2dRenderer = new Box2DDebugRenderer();
//		
//		b2dCam = new OrthographicCamera();
//		b2dCam.setToOrtho(false, KCConstants.GAME_WIDTH / PPM, KCConstants.GAME_HEIGHT / PPM);
//		
	}
	
	@Override
	public void update() {
		handleInput();
		// Destroy fixtures here?
	}

	@Override
	public void handleInput() {
		// Shit is handled in input processor. Might be other stuff to add here.
	}

	@Override
	public void render() {
		// Tell a specific class to render something? I dunno...
	}

	/*
	 * Might use the initialize-method to create a new world (override the old one?), 
	 * as we might want different worlds depending on the game state (bodies from 
	 * UI world will stay in gameplay world if not desposed otherwise, and such).
	 */
}
