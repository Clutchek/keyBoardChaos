package edu.chl.KeyboardChaos;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

import edu.chl.KeyboardChaos.controll.gamestates.GameStateContext;
import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.KCConstants;


/*
 * Main class that creates and renders the game
 */

public class Main implements ApplicationListener{

	
	private float accumulator;
	private GameStateContext gameStateManager;
	
	@Override
	public void create() {
		
		gameStateManager = new GameStateContext();
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
		Options.getOptionsInstance().savePreferences();
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	//*****Unused stuff for now *****//
	@Override
	public void resize(int width, int height) {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}

}
