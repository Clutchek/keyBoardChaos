package controller.gamestates;

import java.util.Stack;

public class GameStateManager implements GameState{
	
	/*private Stack<GameState> gameStates;
	private static final int PLAY_STATE = KCConstants.PLAY_STATE;*/
	
	GameState uiState;
	GameState roundState;
	GameState keyBoardChaosState;
	GameState currentState;
	
	public GameStateManager(){
		uiState = new UIState();
		roundState = new RoundState();
		keyBoardChaosState = new KeyBoardChaosState();
		currentState = uiState;
	}
	
	//public void changeState...

	@Override
	public void update() {
		currentState.update();
		
	}

	@Override
	public void handleInput() {
		currentState.handleInput();
		
	}

	@Override
	public void render() {
		currentState.render();
		
	}
	
	
	
}
