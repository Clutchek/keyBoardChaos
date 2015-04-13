package model.states;

import java.util.ArrayList;
import java.util.List;

import models.spell.Player;
import view.KCInput;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import control.GameStateManager;
import control.KCInputProcessor;

public class StandardMode extends GameState {
	
	
	
	BitmapFont font = new BitmapFont();
	private World world;
	private Box2DDebugRenderer b2dr;
	
	private OrthographicCamera b2dCam;
	
	private Body body;
	
	private int PPM = models.KCVars.PPM; //Adjusting pixerls per meter, otherwise forces will look unnatural
	
	private Player player;
	private Player player2;
	public static List<Player> players;
	

	public StandardMode(GameStateManager gsm){
		super(gsm);
		players = new ArrayList<Player>();
		/*
		 * Below needs a clean-up
		 */
		
		Gdx.input.setInputProcessor(new KCInputProcessor());
		world = gsm.getControl().getWorld();
		b2dr = new Box2DDebugRenderer();
		
		//Create player - TEST
		player = new Player(Keys.UP, Keys.DOWN, Keys.RIGHT, Keys.LEFT, 300f, 400f);
		players.add(player);
		
		player2 = new Player(Keys.W, Keys.S, Keys.D, Keys.A, 100f, 200f);
		players.add(player2);
		
		players.add(new Player(Keys.Y, Keys.H, Keys.J, Keys.G, 300f, 200f));
		
		
		
		b2dCam = gsm.getControl().getb2dCam();
		b2dCam.setToOrtho(false, models.KCVars.GAME_WIDTH / PPM, models.KCVars.GAME_HEIGHT / PPM);

		/*
		 * Test using hashmap to associate certain keys with a specific player
		 *   |
		 *   |
		 *   V
		 */
		
		
//		KCInput.addToKeysHashMap(Keys.W, "Spelare 1");
//		KCInput.addToKeysHashMap(Keys.UP, "Spelare 2");
//		KCInput.addToKeysHashMap(Keys.DOWN, "Spelare 3");
//		KCInput.addToKeysHashMap(Keys.Z, "Spelare 4");
//		KCInput.addToKeysHashMap(Keys.LEFT, "Spelare 1");
//		KCInput.addToKeysHashMap(Keys.H, "Spelare 2");
//		KCInput.addToKeysHashMap(Keys.SPACE, "Spelare 3");
//		KCInput.addToKeysHashMap(Keys.ENTER, "Spelare 4");
		
	}
	
	@Override
	public void handleInput() {
		
	
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
		
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		b2dr.render(world, b2dCam.combined);
//		sb.setProjectionMatrix(worldCam.combined);
//		sb.begin();
//		font.draw(sb, "Standard Mode", 50, 50);
//		sb.end();
	}

	@Override
	public void dispose() {
	
	}
}
