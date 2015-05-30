package edu.chl.KeyboardChaos.controller.gamestates;

import com.badlogic.gdx.Gdx;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.EventHandler;

/*
 * Class that manages what state the game is in
 * When an input is recieved to change from one game state to another, the classes switches gamestate
 */

public class GameStateContext implements EventHandler{
	
	/*private Stack<GameState> gameStates;
	private static final int PLAY_STATE = KCConstants.PLAY_STATE;*/
	
	GameState uiState;
	GameState battleState;
	GameState roundOverState;
	GameState currentState;
	
	public GameStateContext(){
		uiState = new UIState();
		battleState = new BattleState();
		roundOverState = new RoundOverState();
		switchToUIState();
		EventBusService.getInstance().subscribe(this);
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
		Gdx.input.setInputProcessor(((UIState)uiState).getInputProcessor());
	}
	
	public void switchToRoundOverState(){
		currentState = roundOverState;
	}
	
	
	public void switchToBattleState(){
		currentState = battleState;
		((BattleState)battleState).loadPlayers();
		Gdx.input.setInputProcessor(((BattleState)battleState).getInputProcessor());
	}

	@Override
	public void onEvent(BusEvent e) {
		if (e != null) {
			String command = e.getBusCommand();
			if (command.equals("play")) {
				this.switchToBattleState();
			} else if (command.equals("exit")) {
				Gdx.app.exit();
			}
		}
	}
}
