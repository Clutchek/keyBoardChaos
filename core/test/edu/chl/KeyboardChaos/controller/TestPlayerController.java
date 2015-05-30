package edu.chl.KeyboardChaos.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnit44Runner;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import edu.chl.KeyboardChaos.controller.MatchStats;
import edu.chl.KeyboardChaos.controller.battlecontroller.KCContactListener;
import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.controller.battlecontroller.playercontroller.PlayerController;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellControllerManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.util.KCConstants;

@RunWith(MockitoJUnit44Runner.class)
public class TestPlayerController{
	@Mock
	static ApplicationListener fakeAppListener;
	
	@Mock
	static MatchStats fakeMatchStats;

	
	World world;
	FixtureManager fixtureManager;
	SpellControllerManager spellControllerManager;
	Player player1;
	PlayerController player1Controller;
	
	@BeforeClass
	public static void startLibrary(){
		//MockitoAnnotations.initMocks(this);
		HeadlessApplication fakeApp = new HeadlessApplication(fakeAppListener);
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
		world.setContactListener(new KCContactListener(fixtureManager, fakeMatchStats));
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
		KCContactListener contactListener = new KCContactListener(fixtureManager, fakeMatchStats);
		world.setContactListener(contactListener);
		Contact fakeLavaContact = new Contact(world, 1337){
			@Override
			public Fixture getFixtureA(){
				return player1Controller.getBody().getFixtureList().get(0);
			}
			
			@Override
			public Fixture getFixtureB(){
				BodyDef bodyDef = new BodyDef();
				Body body;
				bodyDef.type = BodyType.DynamicBody;
				body = world.createBody(bodyDef);
				FixtureDef fixtureDef = new FixtureDef();
				CircleShape cshape = new CircleShape();
				fixtureDef.shape = cshape;
				Fixture fixture = body.createFixture(fixtureDef);
				fixture.setUserData("lava");
				return fixture;
			}
		};
		contactListener.beginContact(fakeLavaContact);
		world.step(10, 6, 2);
		assertTrue(player1.getHealthPoints() < 100);
		
	}

}
