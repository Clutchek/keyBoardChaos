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

public class PlayerView implements Disposable{
	
	private List<Player> players;
	private World world;
	private SpriteBatch spriteBatch;
	private boolean assetsLoaded;
	
	private Map<Vector2, Texture> map;
	/**
	 * 
	 * @param model represents the model of the game containing the world and the players.
	 */
	public PlayerView(KeyboardChaosModel model){
		this.world = model.getWorld();
		players = model.getPlayerList();
		
		assetsLoaded = false;
		
		spriteBatch = new SpriteBatch();
		
		map = new HashMap<Vector2, Texture>();
		fillMapWithIcons();
		
		
	}
	/**
	 * Method that maps each vector with an icon.
	 * because we have no icons yet, the key is put to null
	 */
	private void fillMapWithIcons(){
		map.put(new Vector2(1, 0), null);
		map.put(new Vector2(1, 1), null);
		map.put(new Vector2(0, 1), null);
		map.put(new Vector2(-1, 1), null);
		map.put(new Vector2(-1, 0), null);
		map.put(new Vector2(-1, -1), null);
		map.put(new Vector2(0, -1), null);
		map.put(new Vector2(1, -1), null);
	}
	
	private void paintPlayer(PlayerController p){
		// TODO: May need adjustments when it's possible to draw things up
		spriteBatch.draw(map.get(p.getVector()), p.getBody().getPosition().x, p.getBody().getPosition().y);
	}
	
	
	/**
	 * Method used to load the resources for the Player.
	 */
	private void loadAssets(){
		
	}
	
	/**
	 * Method used to render the Player's textures.
	 */
	public void render(){
		if(!assetsLoaded){
			loadAssets();
		}
		spriteBatch.begin();
		drawActors();
		spriteBatch.end();
	}
	
	/**
	 * Method used to 
	 */
	public void drawActors(){
		//spriteBatch.draw();
	}

	@Override
	public void dispose() {
		
	}
	
	/*
	 * Some kind of changeDirection method called from outside to tell the view that the player has changed
	 * direction, instead of fetching the same image from the Hashmap over and over again?
	 */
}
