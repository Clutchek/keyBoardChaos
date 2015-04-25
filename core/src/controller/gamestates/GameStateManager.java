package controller.gamestates;

import java.util.Stack;

public class GameStateManager {
	
	/*private Stack<GameState> gameStates;
	private static final int PLAY_STATE = KCConstants.PLAY_STATE;*/
	
	GameState uiState;
	GameState roundState;
	GameState keyBoardChaosState;
	
	public GameStateManager(){
		uiState = new UIState();
		roundState = new RoundState();
		keyBoardChaosState = new KeyBoardChaosState();
	}
	
	
	public GameState getGameState(String s){
		if(s.equals("UI")){
			return uiState;
		}else if(s.equals(" Round")){
			return roundState;
		}else if(s.equals("keyBoardChaos")){
			return keyBoardChaosState;
		}else{
			return null;
		}
		
	}
}
