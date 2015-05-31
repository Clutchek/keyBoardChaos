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
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.OffensiveSpellController;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellController;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellControllerManager;
import edu.chl.KeyboardChaos.model.KeyboardChaos;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.OffensiveSpell;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.view.battleStateView.BattleView;
import edu.chl.KeyboardChaos.view.uiview.component.MatchStatsView;

/**
 * This class takes care of everything related to the game rounds where players fight.
 * It creates a world and different managers creating bodies in the world and makes sure
 * everything updates as it should (both models and the world). It also calls for render
 * in BattleStateView so that everything is visible on screen.
 */

public class BattleState implements GameState {

	private final InputProcessor inputProcessor;
	private World world;
	private TiledMap tileMap;
	private BattleView battleView;
	private Array<Fixture> mapFixtures;
	private FixtureManager fixtureManager;
	private final KeyboardChaos model;
	private final List<PlayerController> playerControllerList;
	private SpellControllerManager spellControllerManager;
	private MatchStats matchStats;
	private MatchStatsView msv;
	private boolean roundIsOver;
	
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
		tileMap = new TmxMapLoader().load("assets/maps/squaremap.tmx");
		MapBodyManager mbm = new MapBodyManager(world, KCConstants.PPM, null, 0);
		mbm.createPhysics(tileMap, "lava");
		
		mapFixtures = new Array<Fixture>();
		playerControllerList = new ArrayList<PlayerController>();
		
		//reset();
		
		this.inputProcessor = new KCInputProcessor(playerControllerList);
	}
	
	@Override
	public void update() {
			// Removes fixtures and bodies from the world that has been marked for removal.
							// Read SDD for info about safe removal.
							// With the bodies destroyed, below makes sure that the last reference to the body
							// is removed so it never can be called upon again - which would cause a crash.
		for(PlayerController PC : playerControllerList){
			PC.updateBody();
			if(!PC.getPlayer().isAlive() && PC.getPlayer().isPlayerInLava()){
				System.out.println("kollar bajs");
					matchStats.playerKilled(PC.getPlayer());
					matchStats.playerKills(PC.getPlayer().getEnemyAggrssor() - 1);
				
			}
		}
		removeObjects();
		
		refreshFixtureList();
		spellControllerManager.update();
		
		if (playerControllerList.size() <= 1) {
			roundOver();
		}
		
		world.step(KCConstants.TIME_STEP, 6, 2);

		for(PlayerController PC : playerControllerList){
			PC.updatePlayer();
		}

		// Destroy fixtures here?
	}
	
	private void refreshFixtureList() {
		mapFixtures.clear();
		world.getFixtures(mapFixtures);
		battleView.setFixtureArray(mapFixtures);
	}

	@Override
	public void handleInput() {
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
			playerControllerList.add(new PlayerController(p, fixtureManager, spellControllerManager));
		}
	}
	
	private void removeObjects() {
		removePlayerControllers();
		removeSpellControllers();
		
		fixtureManager.deleteSelectedBodies();
	}
	
	private void removeSpellControllers() {
		for (Body b : fixtureManager.getBodiesToDelete()) {
			for (SpellController sc : spellControllerManager.getSpellControllers()) {
				if(sc instanceof OffensiveSpellController){
					OffensiveSpellController offensiveSC = (OffensiveSpellController)sc;
					if (offensiveSC.getBody() == b) {
						spellControllerManager.addControllerToRemove(sc);
					}
				}
			}
		}
		spellControllerManager.removeControllers();
	}
	
	private void removePlayerControllers() {
		// Perhaps somehow directly add to controllersToRemove when isAlive = false
		List<PlayerController> controllersToRemove = new ArrayList<PlayerController>();
		for (PlayerController pc : playerControllerList) {
			if (!pc.getPlayer().isAlive()) {
				controllersToRemove.add(pc);
				fixtureManager.addToDisposeList(pc.getBody());
			}
		}
		this.playerControllerList.removeAll(controllersToRemove);
	}

	@Override
	public void reset() {
		this.roundIsOver = false;
		//World
		if (world != null)
			world.dispose();
		world = new World(KCConstants.GRAVITY, true);
		fixtureManager = new FixtureManager(world);
		world.setContactListener(new KCContactListener(fixtureManager, this.matchStats));
		
		//Map stuff
		tileMap = new TmxMapLoader().load("assets/maps/squaremap.tmx");
		MapBodyManager mbm = new MapBodyManager(world, KCConstants.PPM, null, 0);
		mbm.createPhysics(tileMap, "lava");
		
		mapFixtures.clear();
		battleView = new BattleView(mapFixtures, world, tileMap, this.matchStats);
		refreshFixtureList();
		
		//Player stuff
		playerControllerList.clear();
		
		//Spell stuff
		spellControllerManager = new SpellControllerManager(fixtureManager);
		
		loadPlayers();
	}
	
	private void roundOver() {
		if (roundIsOver == false) {
			roundIsOver = true;
			EventBusService.getInstance().publish(new BusEvent("round over"));
		}
	}

	/*
	 * Might use the initialize-method to create a new world (override the old one?), 
	 * as we might want different worlds depending on the game state (bodies from 
	 * UI world will stay in gameplay world if not desposed otherwise, and such).
	 */
}
