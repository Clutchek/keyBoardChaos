package edu.chl.KeyboardChaos.controll.gamestates;

public interface GameState {
	public void update();
	public void handleInput();
	public void render();
	// public void initialize(); // Run this after getting the GameState?
}