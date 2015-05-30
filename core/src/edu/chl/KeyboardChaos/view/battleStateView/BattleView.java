package edu.chl.KeyboardChaos.view.battleStateView;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import edu.chl.KeyboardChaos.controller.MatchStats;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.util.KCConstants;


/*
 * This class renders all the visual elements during a battle in KeyboardChaos
 */
public class BattleView {
	private SpriteBatch spriteBatch;
	private OrthographicCamera worldCam, hudCam, box2DCam;
	private Box2DDebugRenderer debugRenderer;
	
	private OrthogonalTiledMapRenderer mapRenderer;
	
	private World world;
	
	private PlayerView playerView;
	private FireballView fireballView;
	
	private Array<Fixture> fixtures;
	
	private MatchStats matchStats;
	
	public BattleView(Array<Fixture> fixtures, World world, TiledMap tileMap, MatchStats matchStats) {
		this.fixtures = fixtures;
		this.world = world;
		this.matchStats = matchStats;
		
		spriteBatch = new SpriteBatch();
		debugRenderer = new Box2DDebugRenderer();
		mapRenderer = new OrthogonalTiledMapRenderer(tileMap);
		
		playerView = new PlayerView(spriteBatch);
		fireballView = new FireballView(spriteBatch);
		
		// Cameras
		worldCam = new OrthographicCamera(KCConstants.GAME_WIDTH, KCConstants.GAME_HEIGHT);
		/*
		 * Translate is done since the camera before is centered at x = y = 0.
		 * We can move the camera so that the bottom left corner is at (0, 0).
		 */
		worldCam.translate(KCConstants.GAME_WIDTH / 2, KCConstants.GAME_HEIGHT / 2);
		worldCam.update();
		
		mapRenderer.setView(worldCam);
		
		debugRenderer = new Box2DDebugRenderer();
		
		box2DCam = new OrthographicCamera();
		box2DCam.setToOrtho(false, KCConstants.GAME_WIDTH, KCConstants.GAME_HEIGHT);
		box2DCam.combined.scale(KCConstants.PPM, KCConstants.PPM, 0);
	}
	
	public void render() {
		// Clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Render the map
		mapRenderer.render();
		
		// Render objects on map
		spriteBatch.begin();
		
		for (Fixture f : fixtures) {
			if (f != null) {
				if (f.getUserData() instanceof Player) {
					playerView.render((Player)f.getUserData());
				} else if (f.getUserData() instanceof Fireball) {
					fireballView.render((Fireball)f.getUserData());
				}
			}
		}
		
		spriteBatch.end();
		
		//debugRenderer.render(world, box2DCam.combined);
	}
	
	public void setFixtureArray(Array<Fixture> fixtures) {
		this.fixtures = fixtures;
	}
}