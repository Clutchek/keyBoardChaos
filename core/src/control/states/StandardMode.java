package control.states;

import java.util.ArrayList;
import java.util.List;

import models.player.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import control.GameStateManager;
import control.KCInputProcessor;

public class StandardMode extends GameState {
	
	
	
	BitmapFont font = new BitmapFont();
	private World world;
	private Box2DDebugRenderer b2dr;
	
	private OrthographicCamera b2dCam;
	
	private int PPM = models.KCVars.PPM; //Adjusting pixels per meter, otherwise forces will look unnatural

	private static List<Player> players;
	
	private TiledMap tileMap;
	private OrthogonalTiledMapRenderer mapRenderer;
	

	public StandardMode(GameStateManager gsm){
		super(gsm);
		players = gsm.getControl().getModel().getPlayerList();
		world = gsm.getControl().getWorld();

		
	}

	
	@Override
	public void handleInput() {
		if(models.KCVars.playerIsInLava){
			System.out.println("LAVA IT BURN OMG");
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
			players.get(0).getSpell().castSpell();
		}
	
		for(Player p : players){
			if(p.isGettingInput){
				if(p.goUp){
					p.body.applyForceToCenter(0, 1, true);
				}
				if(p.goRight){
					p.body.applyForceToCenter(1, 0, true);
				}
				if(p.goLeft){
					p.body.applyForceToCenter(-1, 0, true);
				}
				if(p.goDown){
					p.body.applyForceToCenter(0, -1, true);
				}
			}
		}		
	}

	@Override
	public void update(float dt) {
		handleInput();
		world.step(dt, 6, 2);
	}

	@Override
	public void render() {
	
		//Just a stub, nothing will happen here since, might be an unnecessary inheritance
	}

	@Override
	public void dispose() {
		//Just a stub, nothing will happen here since, might be an unnecessary inheritance
	}
	
	/**
	 * Returns a list of players in the world
	 * 
	 * @return Players that's currently in the world
	 */
	public static List<Player> getPlayerList(){ return players;}
	
}
