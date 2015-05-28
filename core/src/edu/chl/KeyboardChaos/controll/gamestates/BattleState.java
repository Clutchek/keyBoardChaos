package edu.chl.KeyboardChaos.controll.gamestates;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import edu.chl.KeyboardChaos.controll.KCContactListener;
import edu.chl.KeyboardChaos.controll.KCInputProcessor;
import edu.chl.KeyboardChaos.controll.body.FixtureManager;
import edu.chl.KeyboardChaos.controll.body.MapBodyManager;
import edu.chl.KeyboardChaos.controll.playercontroller.PlayerController;
import edu.chl.KeyboardChaos.controll.spellcontroller.SpellControllerFactory;
import edu.chl.KeyboardChaos.controll.spellcontroller.SpellControllerManager;
import edu.chl.KeyboardChaos.model.KeyboardChaos;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.view.battleStateView.BattleView;



public class BattleState implements GameState {

	private InputProcessor inputProcessor;
	private World world;
	private TiledMap tileMap;
	private BattleView battleView;
	private Array<Fixture> mapFixtures;
	private FixtureManager fixtureManager;
	private KeyboardChaos model;
	private List<Player> playerList;
	private List<PlayerController> playerControllerList;
	private SpellControllerFactory spellControllerFactory;
	private SpellControllerManager spellControllerManager;
	
	public BattleState() {
		//model stuff
		model = new KeyboardChaos();
		
		//World
		world = new World(KCConstants.GRAVITY, true);
		world.setContactListener(new KCContactListener(fixtureManager));
		
		//Map stuff
		tileMap = new TmxMapLoader().load("assets/maps/map1.tmx");
		MapBodyManager mbm = new MapBodyManager(world, KCConstants.PPM, null, 0);
		mbm.createPhysics(tileMap, "lava");
		
		mapFixtures = new Array<Fixture>();
		battleView = new BattleView(mapFixtures, world, tileMap);
		refreshFixtureList();
		
		//Body stuff
		fixtureManager = new FixtureManager(world);
		
		//Player stuff
		playerList = model.getPlayerList();
		playerControllerList = new ArrayList<PlayerController>();
		
		//Spell stuff
		spellControllerManager = new SpellControllerManager(fixtureManager);
		
		
		for(Player p : playerList){
			playerControllerList.add(new PlayerController(p,fixtureManager, spellControllerManager));
		}
		
		this.inputProcessor = new KCInputProcessor(playerControllerList);
	}
	
	@Override
	public void update() {
		handleInput();
		for(PlayerController PC : playerControllerList){

			PC.updateBody();

			PC.updatePlayer();

		}

		world.step(KCConstants.TIME_STEP, 6, 2);

		/*for(PlayerController PC : playerControllerList){

			PC.updatePlayer();

		}*/
		refreshFixtureList();
		
		spellControllerManager.update();
		// Destroy fixtures here?
	}
	
	private void refreshFixtureList() {
		mapFixtures.clear();
		world.getFixtures(mapFixtures);
		battleView.setFixtureArray(mapFixtures);
	}

	@Override
	public void handleInput() {
		// Shit is handled in input processor. Might be other stuff to add here.
	}

	@Override
	public void render() {
		battleView.render();
	}
	
	public World getWorld(){
		return this.world;
	}
	
	public TiledMap getTiledMap(){ return this.tileMap;}
	
	public InputProcessor getInputProcessor() {
		return this.inputProcessor;
	}

	/*
	 * Might use the initialize-method to create a new world (override the old one?), 
	 * as we might want different worlds depending on the game state (bodies from 
	 * UI world will stay in gameplay world if not desposed otherwise, and such).
	 */
}
