package view;

import model.player.Player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import controller.PlayerController;

public class PlayerView extends View{
	
	
	private SpriteBatch spriteBatch;
	
	private static String path;
	
	public PlayerView(){
		super(path);
		spriteBatch = new SpriteBatch();
		
	}
	/**
	 * Method that maps each vector with an icon.
	 * because we have no icons yet, the key is put to null
	 */
	
	
	private void paintPlayer(Player p){
		// TODO: May need adjustments when it's possible to draw things up
		spriteBatch.draw(this.getTextureForVector(p.getVector()), p.getPosX(), p.getPosY());
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
