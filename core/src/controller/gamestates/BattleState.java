package controller.gamestates;

import model.main.KeyboardChaosModel;
import view.BattleView;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import controller.KCConstants;
import controller.KCContactListener;
import controller.MapBodyManager;
import controller.body.FixtureManager;

public class BattleState implements GameState {

	private InputAdapter inputProcessor;
	private World world;
	private TiledMap tileMap;
	private BattleView battleView;
	private Array<Fixture> mapFixtures;
	private FixtureManager fixtureManager;
	private KeyboardChaosModel model;
	
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
		refreshMapFixtureList();
		battleView = new BattleView(mapFixtures);
		
		//Body stuff
		fixtureManager = new FixtureManager(world);
		
		
		
	}
	
	@Override
	public void update() {
		handleInput();
		world.step(controller.KCConstants.TIME_STEP, 6, 2);
		refreshMapFixtureList();
		// Destroy fixtures here?
	}
	
	private void refreshMapFixtureList() {
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
