package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import models.KCVars;
import models.KeyboardChaosModel;
//import models.KeyboardChaosModel;
import view.KeyboardChaosView;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
//import com.badlogic.gdx.physics.box2d.Body;
//import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class KeyboardChaosControl implements ApplicationListener {
	SpriteBatch batch;
	//Texture img;
	
	private static OrthographicCamera worldCam, hudCam, b2dCam; 
	private static World world;
	private KeyboardChaosView view;
	private KeyboardChaosModel model;
	private ConcurrentHashMap<Body, Fixture> fixturesToDestroy;
	
	private float PPM = KCVars.PPM;
	
	private GameStateManager gsm;
	
	private TiledMap tileMap;
	private OrthogonalTiledMapRenderer mapRenderer;
	private Box2DDebugRenderer b2dr;
	
	@Override
	public void create() {
				
		batch = new SpriteBatch();
		view = new view.KeyboardChaosView(this);
		model = new models.KeyboardChaosModel(this);
		
		//List of fixtures that needs to be destroyed
		fixturesToDestroy = models.KCVars.fixturesToDestroy;
		
		//Set our own input processor
		Gdx.input.setInputProcessor(new KCInputProcessor());
		
		//Create world camera, set it to it's correct size and move it so it's looking at the actual game.
		worldCam = new OrthographicCamera(KCVars.GAME_WIDTH, KCVars.GAME_HEIGHT);
		worldCam.translate(KCVars.GAME_WIDTH / 2, KCVars.GAME_HEIGHT / 2);
		worldCam.update();
		
		//Create Box2D camera
		b2dCam = new OrthographicCamera();
		b2dCam.setToOrtho(false, models.KCVars.GAME_WIDTH / PPM, models.KCVars.GAME_HEIGHT / PPM);
		
		b2dr = new Box2DDebugRenderer();

		world = model.getWorld();
		world.setContactListener(new control.KCContactListener());
		
		//Map stuff
		tileMap = new TmxMapLoader().load("assets/maps/betatest.tmx");
		control.MapBodyManager mbm = new control.MapBodyManager(world, PPM, null, 0);
		mbm.createPhysics(tileMap, "lavahurts");
		mapRenderer = new OrthogonalTiledMapRenderer(tileMap);
		

		model.createSomePlayers();
		
		gsm = new GameStateManager(this);
		

		
	}
	
	//Getters
	public GameStateManager getGSM(){ return this.gsm;}
	public OrthogonalTiledMapRenderer getMapRenderer(){ return mapRenderer;}
	public SpriteBatch getSpriteBatch(){ return batch;}
	public OrthographicCamera getWorldCam(){ return worldCam;}
	public OrthographicCamera getb2dCam(){ return b2dCam;}
	public OrthographicCamera getHudCam(){ return hudCam;}
	public static World getWorld(){ return world;}
	public KeyboardChaosModel getModel(){ return this.model;}
	public Box2DDebugRenderer getB2dr(){ return this.b2dr;}
	

	public void render () {
		view.render();
	}
	
	public void handleInput(){

	}

	public void update(float dt){
		
	}

	public void dispose() {	
		
	}	
	
	public synchronized void destroyThisFixtureLater(Body b, Fixture f){
		fixturesToDestroy.put(b, f);
	}
	
	public synchronized void destroyFixtures(){
		if(!fixturesToDestroy.isEmpty()){
			for(Body b : fixturesToDestroy.keySet()){
				b.destroyFixture(fixturesToDestroy.get(b));
				fixturesToDestroy.remove(b);
			}
		}
	}
	
	public void resize(int width, int height) {}
	public void pause() {}
	public void resume() {}
	
	
}
