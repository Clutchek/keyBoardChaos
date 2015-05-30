package model.player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.spell.Fireball;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestPlayer{
	
	@BeforeClass
	public void startLibrary(){
		HeadlessApplicationConfiguration
		HeadlessApplication fakeApp = new HeadlessApplication();
	}
	
	@Test
	public void testTakeDamage() {
		Player player = new Player("Player", 10f, 10f, new Fireball(), new Fireball());
		player.takeDamage(10);
		assertTrue(90 == player.getHealthPoints());
	}
	
	@Test
	public void testIsAlive(){
		Player player = new Player("Player", 10f, 10f, new Fireball(), new Fireball());
		player.takeDamage(110);
		assertFalse(true == player.isAlive());
	}

}
