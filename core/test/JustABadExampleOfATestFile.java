/*
 * --- BASIC STUFF ---
 * To create a test class, right click on the class you want to test:
 * 		New > JUnit Test Case
 * Change source folder to "KeyboardChaos-core/test". Keep everything else as it is (I guess).
 * 
 * For a list of assert statements, check the API:
 * http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * 
 * Other interesting stuff about JUnit (such as how to use annotations) are found here:
 * http://junit.sourceforge.net/javadoc/org/junit/package-summary.html
 */

import static org.junit.Assert.*;
import model.player.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JustABadExampleOfATestFile {

	Player player;
	
	// Method ran once before all tests (must be static!)
	@BeforeClass
	public static void beforeClass() {
		
	}
	
	// Method ran before each test method
	@Before
	public void before() {
		//player = new Player();
	}
	
	// Method ran after each test method
	@After
	public void after() {
		
	}

	@Test
	public void testThis() {
		assertNull(player.getFirstSpell());
	}
	
	@Test (expected = NullPointerException.class)
	public void testThat() {
		player = null;
		player.getPlayerName();
	}
}
