package model.player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.Fireball;


public class TestPlayer{
	

	
	@Test
	public void testTakeDamage() {
		Player player = new Player("Player", 10f, 10f, new Fireball(), new Fireball(),1);
		player.takeDamage(10);
		assertTrue(90 == player.getHealthPoints());
	}
	
	@Test
	public void testIsAlive(){
		Player player = new Player("Player", 10f, 10f, new Fireball(), new Fireball(),1);
		player.takeDamage(110);
		assertFalse(true == player.isAlive());
	}

}
