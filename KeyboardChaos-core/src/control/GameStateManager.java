package control;

import java.util.Stack;

import model.states.GameState;
import model.states.StandardMode;

public class GameStateManager {

	private KeyboardChaosControl kcc;
	
	private Stack<GameState> gameStates;
	public static final int STANDARD_MODE = models.KCVars.STANDARD_MODE;
	
	public GameStateManager(KeyboardChaosControl kcc){
		this.kcc = kcc;
		this.gameStates = new Stack<GameState>();
		pushState(STANDARD_MODE);
		
	}
	
	
	public KeyboardChaosControl getControl(){
		return this.kcc;
		
	}
	
	public void update(float dt){
		gameStates.peek().update(dt);
	}
	
	public void render(){
		gameStates.peek().render();
	}
	
	private GameState getState(int state){
		if(state == STANDARD_MODE) return new model.states.StandardMode(this);
		return null;
	}
	
	public void setState(int state){
		popState();
		pushState(state);
	}
	
	public void pushState(int state){
		gameStates.push(getState(state));
	}
	
	public void popState(){
		GameState g = gameStates.pop();
		g.dispose();
		
	}
	
}
