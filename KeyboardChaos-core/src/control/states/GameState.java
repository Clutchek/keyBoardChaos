package control.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import control.GameStateManager;
import control.KeyboardChaosControl;

public abstract class GameState {
	
	protected GameStateManager gsm;
	protected KeyboardChaosControl kcc;
	
	protected SpriteBatch sb;
	protected OrthographicCamera worldCam;
	protected OrthographicCamera hudCam;
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		kcc = gsm.getControl();
		sb = kcc.getSpriteBatch();
		worldCam = kcc.getWorldCam();
		hudCam = kcc.getHudCam();
		
	}
	
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();
	
}
