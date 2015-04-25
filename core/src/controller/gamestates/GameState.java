package controller.gamestates;

public interface GameState {
	public void update();
	public void handleInput();
	public void render();
}