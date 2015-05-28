package edu.chl.KeyboardChaos.view.battleStateView;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.chl.KeyboardChaos.model.main.DirectionVector;
import edu.chl.KeyboardChaos.model.player.Player;



public class PlayerView extends View{
	
	
	private SpriteBatch spriteBatch;
	
	private static String path = "assets/playerTextures/";
	
	public PlayerView(SpriteBatch spriteBatch){
		super(path);
		this.spriteBatch = spriteBatch;
	}
	/**
	 * Method that maps each vector with an icon.
	 * because we have no icons yet, the key is put to null
	 */
	
	
	private void paintPlayer(Player p){
		// TODO: May need adjustments when it's possible to draw things up
		if(!p.getVector().equals(new DirectionVector(0, 0)))
			spriteBatch.draw(this.getTextureForVector(p.getVector()), p.getPosX() - p.getSize(), p.getPosY() - p.getSize(), p.getSize()*2, p.getSize()*2);
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
