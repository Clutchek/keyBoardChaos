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
		currentState = battleState();
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
	
	public void switchToUIState(){
		currentState = uiState;
	}
	
	public void switchToRoundOverState(){
		currentState = roundOverState;
	}
	
	
	public void switchToToBattleState(){
		currentState = battleState;
	}
}
