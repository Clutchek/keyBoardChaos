package view;

import model.player.Player;
import model.spell.Fireball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.utils.Array;

import controller.KCConstants;
import controller.PlayerController;
import controller.gamestates.BattleState;
import controller.spellcontroller.FireballController;

public class BattleView {
	private SpriteBatch spriteBatch;
	private OrthographicCamera worldCam, hudCam, box2DCam;
	private Box2DDebugRenderer debugRenderer;
	
	private BattleState battleState;
	
	private OrthogonalTiledMapRenderer mapRenderer;
	
	private PlayerView playerView;
	private FireballView fireballView;
	
	private Array<Fixture> fixtures;
	
	public BattleView(Array<Fixture> fixtures) {
		this.fixtures = fixtures;
		
		spriteBatch = new SpriteBatch();
		debugRenderer = new Box2DDebugRenderer();
		mapRenderer = new OrthogonalTiledMapRenderer(battleState.getTiledMap());
		
		playerView = new PlayerView();
		fireballView = new FireballView();
		
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
		box2DCam.setToOrtho(false, KCConstants.GAME_WIDTH / KCConstants.PPM, KCConstants.GAME_HEIGHT / KCConstants.PPM);
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
		
		debugRenderer.render(battleState.getWorld(), box2DCam.combined);
	}
	
	public void setFixtureArray(Array<Fixture> fixtures) {
		this.fixtures = fixtures;
	}
}