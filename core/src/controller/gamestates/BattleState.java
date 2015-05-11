package controller.gamestates;

import java.util.ArrayList;
import java.util.List;

import model.main.KeyboardChaosModel;
import model.player.Player;
import model.spell.SpellFactory;
import view.BattleView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import controller.KCConstants;
import controller.KCContactListener;
import controller.KCInputProcessor;
import controller.MapBodyManager;
import controller.PlayerController;
import controller.body.FixtureManager;

public class BattleState implements GameState {

	private InputAdapter inputProcessor;
	private World world;
	private TiledMap tileMap;
	private BattleView battleView;
	private Array<Fixture> mapFixtures;
	private FixtureManager fixtureManager;
	private KeyboardChaosModel model;
	private List<Player> playerList;
	private List<PlayerController> playerControllerList;
	private SpellControllerFactory spellControllerFactory;
	private SpellControllerManager spellControllerManager;
	
	public BattleState() {
		//model stuff
		model = new KeyboardChaosModel();
		
		//World
		world = new World(KCConstants.GRAVITY, true);
		world.setContactListener(new KCContactListener());
		
		//Map stuff
		tileMap = new TmxMapLoader().load("assets/maps/betatest.tmx");
		MapBodyManager mbm = new MapBodyManager(world, controller.KCConstants.PPM, null, 0);
		mbm.createPhysics(tileMap, "lavahurts");
		refreshFixtureList();
		battleView = new BattleView(mapFixtures);
		
		//Body stuff
		fixtureManager = new FixtureManager(world);
		
		//Player stuff
		playerList = model.getPlayerList();
		playerControllerList = new ArrayList<PlayerController>();
		
		//Spell stuff
		spellControllerFactory = new SpellControllerFactory(fixtureManager);
		spellControllerManager = new SpellControllerManager(spellControllerFactory);
		
		
		for(Player p : playerList){
			playerControllerList.add(new PlayerController(p, spellControllerManager));
		}
		
		Gdx.input.setInputProcessor(new KCInputProcessor(playerControllerList));
		
	}
	
	@Override
	public void update() {
		handleInput();
		world.step(controller.KCConstants.TIME_STEP, 6, 2);
		refreshFixtureList();
		for(PlayerController PC : playerControllerList){
			PC.update();
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

	/*
	 * Might use the initialize-method to create a new world (override the old one?), 
	 * as we might want different worlds depending on the game state (bodies from 
	 * UI world will stay in gameplay world if not desposed otherwise, and such).
	 */
}
