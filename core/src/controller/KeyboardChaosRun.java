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

	
	private float accumulator;
	
	private GameStateManager gameStateManager;
	
	@Override
	public void create() {
		
		gameStateManager = new GameStateManager();
	}

	@Override
	public void render() {
		gameStateManager.update();
		
		accumulator += Gdx.graphics.getDeltaTime();
		while(accumulator >= KCConstants.TIME_STEP){
			accumulator -= (KCConstants.TIME_STEP);
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
