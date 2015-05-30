

import java.util.Timer;
import java.util.TimerTask;

import model.player.Player;
import model.spell.Fireball;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import controller.KCConstants;
import controller.KCContactListener;
import controller.PlayerController;
import controller.body.FixtureManager;
import controller.spellcontroller.SpellControllerManager;


public class BodyAndPlayerTest {
	Player player2;
	
	@Test
	public void testFireballToPlayerContact(){
		World world = world = new World(KCConstants.GRAVITY, true);
		FixtureManager fixtureManager = new FixtureManager(world);
		world.setContactListener(new KCContactListener(fixtureManager));
		SpellControllerManager spellControllerManager = new SpellControllerManager(fixtureManager);
		Player player1 = new Player("Player1", 100f,100f, new Fireball(),new Fireball());
		player2 = new Player("Player2", 105f, 100f, new Fireball(), new Fireball());
		PlayerController player1Controller = new PlayerController(player1, fixtureManager, spellControllerManager);
		PlayerController player2Controller = new PlayerController(player2, fixtureManager, spellControllerManager);
		
		Vector2 vector = new Vector2();
		vector.x =1;
		vector.y = 0;
		player1Controller.setDirection(vector);
		player1Controller.useFirstSpell();
		world.step(10, 6, 2);
		System.out.println(player1);
		System.out.println(player2);
		assertTrue(player2.getHealthPoints() < 100);
		
	}
	
}
