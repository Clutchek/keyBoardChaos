package view;

import java.util.List;
import models.KeyboardChaosModel;
import models.player.Player;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

public class PlayerView implements Disposable{
	
	private List<Player> players;
	private World world;
	private SpriteBatch spriteBatch;
	private boolean assetsLoaded;
	
	/**
	 * 
	 * @param model represents the model of the game containing the world and the players.
	 */
	public PlayerView(KeyboardChaosModel model){
		this.world = model.getWorld();
		players = model.getPlayerList();
		
		assetsLoaded = false;
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

}
