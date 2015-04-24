package old.control.states;

import old.control.GameStateManager;
import old.control.KeyboardChaosControl;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameState {
	
	private GameStateManager gsm;
	private KeyboardChaosControl kcc;
	
	private SpriteBatch sb;
	private OrthographicCamera worldCam;
	private OrthographicCamera hudCam;
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		kcc = gsm.getControl();
		sb = kcc.getSpriteBatch();
		worldCam = kcc.getWorldCam();
		hudCam = kcc.getHudCam();
		
	}
	
	public GameStateManager getGameStageManager(){
		return gsm;
	}
	
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();
	
}
