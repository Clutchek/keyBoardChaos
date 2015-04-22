package models;

import java.util.ArrayList;
import java.util.List;

import models.player.Player;
import models.spell.Spell;
import models.spell.Fireball;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import control.KeyboardChaosControl;


public class KeyboardChaosModel {

	private World world;
	private KeyboardChaosControl kcc;
	private List<Player> players;
	private final float WALL_DISTANCE = 10f;
	
	public KeyboardChaosModel(KeyboardChaosControl kcc){

		this.kcc = kcc;
		players = new ArrayList<Player>();
		world = new World(models.KCVars.GRAVITY, true);
	

		
		
	}
	
	public void createSomePlayers(){
		players.add(new Player(Keys.UP, Keys.DOWN, Keys.RIGHT, Keys.LEFT, Keys.SPACE, Keys.UNKNOWN, 300f, 400f));	
		players.get(0).setFirstSpell(new Fireball(50,1, players.get(0)));
		players.get(0).setPlayerName("Player 1");

		players.add(new Player(Keys.W, Keys.S, Keys.D, Keys.A, Keys.BACKSPACE, Keys.UNKNOWN, 100f, 200f));
		players.get(1).setFirstSpell(new Fireball(50,1, players.get(1)));
		players.get(1).setPlayerName("Player 2");
		
		
		players.add(new Player(Keys.Y, Keys.H, Keys.J, Keys.G, Keys.UNKNOWN, Keys.UNKNOWN, 300f, 200f));
		players.get(2).setPlayerName("Player 3");
	}
	
	public void createWorldWall() { // Not sure if this should be created here
		BodyDef bDef = new BodyDef();
		bDef.type = BodyType.StaticBody;
		Body body = world.createBody(bDef);
		
		ChainShape shape = new ChainShape();
		Vector2 downLeft = new Vector2(-WALL_DISTANCE / KCVars.PPM, -WALL_DISTANCE / KCVars.PPM);
		Vector2 downRight = new Vector2((KCVars.GAME_WIDTH + WALL_DISTANCE) / KCVars.PPM, -WALL_DISTANCE / KCVars.PPM);
		Vector2 upRight = new Vector2((KCVars.GAME_WIDTH + WALL_DISTANCE) / KCVars.PPM, (KCVars.GAME_HEIGHT + WALL_DISTANCE) / KCVars.PPM);
		Vector2 upLeft = new Vector2(-WALL_DISTANCE / KCVars.PPM, (KCVars.GAME_HEIGHT + WALL_DISTANCE) / KCVars.PPM);
		shape.createChain(new Vector2[]{downLeft, downRight, upRight, upLeft, downLeft});
		
		FixtureDef fDef = new FixtureDef();
		fDef.shape = shape;
		fDef.filter.categoryBits = KCVars.BIT_INVISIBLE_WALL;
		fDef.filter.maskBits = KCVars.MASK_INVISIBLE_WALL;
		Fixture fixture = body.createFixture(fDef);
		fixture.setUserData("world wall");
	}
	
	public World getWorld(){ return this.world;}
	public List<Player> getPlayerList(){ return this.players;}

}
