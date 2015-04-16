package control;

import models.KCVars;
import models.KeyboardChaosModel;
//import models.KeyboardChaosModel;
import view.KeyboardChaosView;

import com.badlogic.gdx.ApplicationListener;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.physics.box2d.Body;
//import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class KeyboardChaosControl implements ApplicationListener {
	SpriteBatch batch;
	//Texture img;
	
	public static OrthographicCamera worldCam, hudCam, b2dCam; 
	public static World world;
	private KeyboardChaosView view;
	private KeyboardChaosModel model;
	//private BodyDef bdef;
//	private float PPM = KCVars.PPM;
	//private Body body;
	public GameStateManager gsm;
	public static float STEP = models.KCVars.TIME_STEP;
	public float timeCheck;
	
	@Override
	public void create() {
		
//		Gdx.input.setInputProcessor(new KCInputProcessor());
		
		
		batch = new SpriteBatch();
		
		//Create world camera, set it to it's correct size and move it so it's looking at the actual game.
		worldCam = new OrthographicCamera(KCVars.GAME_WIDTH, KCVars.GAME_HEIGHT);
		worldCam.translate(KCVars.GAME_WIDTH / 2, KCVars.GAME_HEIGHT / 2);
		worldCam.update();
		
		//Create Box2D camera
		b2dCam = new OrthographicCamera();

		model = new models.KeyboardChaosModel(this);
		
		world = model.getWorld();
		world.setContactListener(new models.KCContactListener());

		gsm = new GameStateManager(this);
		view = new view.KeyboardChaosView(this);

		
	}
	
	//Getters
	
	public SpriteBatch getSpriteBatch(){ return batch;}
	public OrthographicCamera getWorldCam(){ return worldCam;}
	public OrthographicCamera getb2dCam(){ return b2dCam;}
	public OrthographicCamera getHudCam(){ return hudCam;}
	public World getWorld(){ return world;}
	public KeyboardChaosModel getModel(){ return this.model;}
	

	public void render () {
		view.render();
	}
	
	public void handleInput(){

	}

	public void update(float dt){

	}

	public void dispose() {	
		
	}	
	
	
	
	public void resize(int width, int height) {}
	public void pause() {}
	public void resume() {}
	
	
}
