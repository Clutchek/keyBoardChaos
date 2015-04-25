package controller.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

import controller.KCInputProcessor;

public class BattleState implements GameState {

	private InputAdapter inputProcessor;
	
	public BattleState() {
		inputProcessor = new KCInputProcessor();
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
