package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import old.models.KeyboardChaosModel;
import old.models.player.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import controller.PlayerController;

public class PlayerView extends View{
	
	
	private SpriteBatch spriteBatch;
	
	private static String path;
	/**
	 * 
	 * @param model represents the model of the game containing the world and the players.
	 */
	public PlayerView(){
		super(path);
		spriteBatch = new SpriteBatch();
		
	}
	/**
	 * Method that maps each vector with an icon.
	 * because we have no icons yet, the key is put to null
	 */
	
	
	private void paintPlayer(PlayerController p){
		// TODO: May need adjustments when it's possible to draw things up
		spriteBatch.draw(this.getTextureForVector(p.getVector()), p.getBody().getPosition().x, p.getBody().getPosition().y);
	}
	
	
	/**
	 * Method used to render the Player's textures.
	 */
	public void render(){
		
	}

	
	/*
	 * Some kind of changeDirection method called from outside to tell the view that the player has changed
	 * direction, instead of fetching the same image from the Hashmap over and over again?
	 */
}
