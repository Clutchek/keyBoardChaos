package edu.chl.KeyboardChaos;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

import edu.chl.KeyboardChaos.controll.gamestates.GameStateManager;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.playersettings.Options;




public class Main implements ApplicationListener{

	
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
