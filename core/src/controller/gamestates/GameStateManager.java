package controller.gamestates;

import java.util.Stack;

import com.badlogic.gdx.Gdx;

import controller.MouseInputProcessor;
import controller.eventbus.BusEvent;
import controller.eventbus.EventBusService;
import controller.eventbus.EventHandler;

public class GameStateManager implements EventHandler{
	
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
