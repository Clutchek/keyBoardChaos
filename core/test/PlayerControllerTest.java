

import model.player.Player;
import model.spell.Fireball;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.physics.box2d.World;

import controller.KCConstants;
import controller.PlayerController;
import controller.body.FixtureManager;
import controller.spellcontroller.SpellControllerManager;

public class PlayerControllerTest{

	@Test
	public void test() {
		World world = world = new World(KCConstants.GRAVITY, true);
		FixtureManager fixtureManager = new FixtureManager(world);
		SpellControllerManager spellControllerManager = new SpellControllerManager(fixtureManager);
		Player player1 = new Player("Player1", 100f,100f, new Fireball(),new Fireball());
		PlayerController player1Controller = new PlayerController(player1, fixtureManager, spellControllerManager);
		
		player1Controller.setRight(true);
		world.step(KCConstants.TIME_STEP, 6, 2);
		assertTrue(player1.getPosX() > 100f);
		
	}

}
