package edu.chl.KeyboardChaos.view.battleStateView;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.util.DirectionVector;


/*
 * This class renders the texture of an active player during a battle in KeyboardChaos
 */
public class PlayerView extends View{
	
	
	private final SpriteBatch spriteBatch;
	
	private static final String path = "assets/player1/";
	
	public PlayerView(SpriteBatch spriteBatch){
		super(path);
		this.spriteBatch = spriteBatch;
	}
	
	private void paintPlayer(Player p){
		// Give player a specific color based on the players' number
		if(!p.getVector().equals(new DirectionVector(0, 0)))
			switch (p.getPlayerNumber()) {
				case 1: 
					spriteBatch.setColor(Color.RED);
					break;
				case 2:
					spriteBatch.setColor(Color.BLUE);
					break;
				case 3:
					spriteBatch.setColor(Color.GREEN);
					break;
				case 4:
					spriteBatch.setColor(Color.YELLOW);
					break;
				default:
					spriteBatch.setColor(Color.CYAN);
					break;
			}
			spriteBatch.draw(this.getTextureForVector(p.getVector()), p.getPosX() - p.getSize(), p.getPosY() - p.getSize(), p.getSize()*2, p.getSize()*2);
			spriteBatch.setColor(Color.WHITE);
	}
	
	/**
	 * Method used to render the Player's textures.
	 */
	public void render(Player p){
		paintPlayer(p);
	}

	
	/*
	 * Some kind of changeDirection method called from outside to tell the view that the player has changed
	 * direction, instead of fetching the same image from the Hashmap over and over again?
	 */
}
