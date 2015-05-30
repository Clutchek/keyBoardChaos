

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnit44Runner;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import edu.chl.KeyboardChaos.controller.battlecontroller.KCContactListener;
import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.controller.battlecontroller.body.MapBodyManager;
import edu.chl.KeyboardChaos.controller.battlecontroller.playercontroller.PlayerController;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellControllerManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.util.KCConstants;

@RunWith(MockitoJUnit44Runner.class)
public class TestPlayerController{
	@Mock
	static ApplicationListener fakeAppListener;

	
	World world;
	FixtureManager fixtureManager;
	SpellControllerManager spellControllerManager;
	Player player1;
	PlayerController player1Controller;
	
	@BeforeClass
	public static void startLibrary(){
		//MockitoAnnotations.initMocks(this);
		HeadlessApplication fakeApp = new HeadlessApplication(fakeAppListener);
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			
		}
	}
	
	@Before
	public void instantiateWorldAndPlayer(){
		world = world = new World(KCConstants.GRAVITY, true);
		fixtureManager = new FixtureManager(world);
		spellControllerManager = new SpellControllerManager(fixtureManager);
		player1 = new Player("Player1", 100f,100f, new Fireball(), new Fireball());
		player1Controller = new PlayerController(player1, fixtureManager, spellControllerManager);
	}

	@Test
	public void testMoveBodyToRightAndSyncPlayer() {
		player1Controller.setRight(true);
		player1Controller.updateBody();
		world.step(10, 6, 2);
		player1Controller.updatePlayer();
		assertTrue(player1.getPosX() > 100.0);
		
	}
	
	@Test
	public void testShootAnotherPlayerWithFireball(){
		world.setContactListener(new KCContactListener(fixtureManager));
		Player player2 = new Player("Player2", 110f, 100f, new Fireball(), new Fireball());
		PlayerController player2Controller = new PlayerController(player2, fixtureManager, spellControllerManager);
		
		Vector2 vector = new Vector2();
		vector.x = 1;
		vector.y = 0;
		player1Controller.setDirection(vector);
		player1Controller.useFirstSpell();
		world.step(10, 6, 2);
		assertTrue(player2.getHealthPoints() < 100);
	}
	
	@Test
	public void testPlayerInLava(){
		world.setContactListener(new KCContactListener(fixtureManager));
		TiledMap tileMap = new TmxMapLoader().load("assets/maps/lavamap.tmx");
		MapBodyManager mbm = new MapBodyManager(world, KCConstants.PPM, null, 0);
		mbm.createPhysics(tileMap, "lava");
		world.step(10, 6, 2);
		assertTrue(player1.getHealthPoints() < 100);
		
	}

}
