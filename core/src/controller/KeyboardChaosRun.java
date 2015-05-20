package controller;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

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
	
	@Override
	public void dispose() {
		controller.playersettings.Options.getOptionsInstance().savePreferences();
	}

	
	
	
	
	
	
	
	
	
	
	
	//*****Unused stuff for now *****//
	@Override
	public void resize(int width, int height) {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}

}
