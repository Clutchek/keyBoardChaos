package controller.gamestates;

import java.util.Stack;

public class GameStateManager {
	
	/*private Stack<GameState> gameStates;
	private static final int PLAY_STATE = KCConstants.PLAY_STATE;*/
	
	GameState uiState;
	GameState battleState;
	GameState roundOverState;
	GameState currentState;
	
	public GameStateManager(){
		uiState = new UIState();
		battleState = new BattleState();
		roundOverState = new RoundOverState();
		currentState = uiState;
	}
	
	//public void changeState...

	public void update() {
		currentState.update();
		
	}

	public void handleInput() {
		currentState.handleInput();
		
	}
	
	public void render() {
		currentState.render();
		
	}
	
	
	
}
