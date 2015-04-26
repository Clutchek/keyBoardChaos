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

import controller.gamestates.GameStateManager;

public class KeyboardChaosRun implements ApplicationListener{

	private SpriteBatch spriteBatch;
	private float PPM = KCConstants.PPM;
	
	private float accumulator;
	
	private GameStateManager gameStateManager;

	private OrthographicCamera worldCam, hudCam, b2dCam;
	
	private World world;
	
	private TiledMap tileMap;
	private OrthogonalTiledMapRenderer mapRenderer;
	private Box2DDebugRenderer b2dRenderer;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		
		gameStateManager = new GameStateManager();
		
		Gdx.input.setInputProcessor(new KCInputProcessor());
		
	}

	@Override
	public void render() {
		gameStateManager.update();
		
		accumulator += Gdx.graphics.getDeltaTime();
		while(accumulator >= 1f / 60f){
			accumulator -= (1f / 60f);
			gameStateManager.render();
			
		}
		
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
