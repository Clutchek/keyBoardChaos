

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnit44Runner;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.physics.box2d.World;

import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.controller.battlecontroller.playercontroller.PlayerController;
import edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller.SpellControllerManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Spell.SpellEnum;
import edu.chl.KeyboardChaos.util.KCConstants;

@RunWith(MockitoJUnit44Runner.class)
public class PlayerControllerTest{
	@Mock static ApplicationListener fakeAppListener;
	
	@Before
	public void startLibrary(){
		MockitoAnnotations.initMocks(this);
		HeadlessApplication fakeApp = new HeadlessApplication(fakeAppListener);
		try{
			Thread.sleep(200);
		}catch(Exception e){
			
		}
	}

	@Test
	public void test() {
		World world = world = new World(KCConstants.GRAVITY, true);
		FixtureManager fixtureManager = new FixtureManager(world);
		SpellControllerManager spellControllerManager = new SpellControllerManager(fixtureManager);
		Player player1 = new Player("Player1", 100f,100f, SpellEnum.FIREBALL, SpellEnum.FIREBALL);
		PlayerController player1Controller = new PlayerController(player1, fixtureManager, spellControllerManager);
		
		player1Controller.setRight(true);
		world.step(KCConstants.TIME_STEP, 6, 2);
		player1Controller.updateBody();
		player1Controller.updatePlayer();
		assertTrue(player1.getPosX() == 100f);
		
	}

}
