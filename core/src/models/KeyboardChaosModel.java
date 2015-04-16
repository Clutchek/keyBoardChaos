package models;

import java.util.ArrayList;
import java.util.List;

import models.player.Player;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.physics.box2d.World;

import control.KeyboardChaosControl;


public class KeyboardChaosModel {

	private World world;
	private KeyboardChaosControl kcc;
	private List<Player> players;
	
	public KeyboardChaosModel(KeyboardChaosControl kcc){

		this.kcc = kcc;
		players = new ArrayList<Player>();
		world = new World(models.KCVars.GRAVITY, true);
	
		//Create player - TEST

		players.add(new Player(Keys.UP, Keys.DOWN, Keys.RIGHT, Keys.LEFT, 300f, 400f));	

		players.add(new Player(Keys.W, Keys.S, Keys.D, Keys.A, 100f, 200f));
		
		players.add(new Player(Keys.Y, Keys.H, Keys.J, Keys.G, 300f, 200f));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public World getWorld(){ return this.world;}
	public List<Player> getPlayerList(){ return this.players;}

}
