package edu.chl.KeyboardChaos.controller.gamestates;

/*
 * Interface for all the gamestates that the game contains
 */

public interface GameState {
	public void update();
	public void handleInput();
	public void render();
	// public void initialize(); // Run this after getting the GameState?
}