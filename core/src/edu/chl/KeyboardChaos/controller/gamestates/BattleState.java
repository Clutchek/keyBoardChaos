package edu.chl.KeyboardChaos.controller.gamestates;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import edu.chl.KeyboardChaos.controller.MatchStats;
import edu.chl.KeyboardChaos.controller.battlecontroller.KCContactListener;
import edu.chl.KeyboardChaos.controller.battlecontroller.KCInputProcessor;
import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.controller.battlecontroller.body.MapBodyManager;
import edu.chl.KeyboardChaos.controller.battlecontroller.playercontroller.PlayerController;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellController;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellControllerFactory;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellControllerManager;
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
	private MatchStats matchStats;
	
	public BattleState() {
		//model stuff
		model = new KeyboardChaos();
		
		//match stats
		this.matchStats = new MatchStats();
		
		//World
		world = new World(KCConstants.GRAVITY, true);
		fixtureManager = new FixtureManager(world);
		world.setContactListener(new KCContactListener(fixtureManager, this.matchStats));
		
		//Map stuff
		tileMap = new TmxMapLoader().load("assets/maps/map1.tmx");
		MapBodyManager mbm = new MapBodyManager(world, KCConstants.PPM, null, 0);
		mbm.createPhysics(tileMap, "lava");
		
		mapFixtures = new Array<Fixture>();
		battleView = new BattleView(mapFixtures, world, tileMap, this.matchStats);
		refreshFixtureList();
		
		//Player stuff
		playerControllerList = new ArrayList<PlayerController>();
		
		//Spell stuff
		spellControllerManager = new SpellControllerManager(fixtureManager);
		
		this.inputProcessor = new KCInputProcessor(playerControllerList);
	}
	
	@Override
	public synchronized void update() {
		removeObjects();
		handleInput();
		for(PlayerController PC : playerControllerList){

			PC.updateBody();

			PC.updatePlayer();

		}
		refreshFixtureList();
		
		spellControllerManager.update();
		
		
		world.step(KCConstants.TIME_STEP, 6, 2);

		/*for(PlayerController PC : playerControllerList){

			PC.updatePlayer();

		}*/

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
	
	public void loadPlayers() {
		model.createPlayers();
		for(Player p : model.getPlayerList()){
			playerControllerList.add(new PlayerController(p,fixtureManager, spellControllerManager));
		}
	}
	
	private void removeObjects() {
		List<SpellController> spellsToDelete = new ArrayList<SpellController>();
		for (Body b : fixtureManager.getBodiesToDelete()) {
			for (SpellController sc : spellControllerManager.getSpellControllers()) {
				if (sc.getBody() == b) {
					spellControllerManager.addControllerToRemove(sc);
				}
			}
		}
		spellControllerManager.removeControllers();
		fixtureManager.deleteSelectedBodies();
	}

	/*
	 * Might use the initialize-method to create a new world (override the old one?), 
	 * as we might want different worlds depending on the game state (bodies from 
	 * UI world will stay in gameplay world if not desposed otherwise, and such).
	 */
}
