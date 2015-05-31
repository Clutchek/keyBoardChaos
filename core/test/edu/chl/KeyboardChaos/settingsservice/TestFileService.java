package edu.chl.KeyboardChaos.settingsservice;

import static org.junit.Assert.*;
import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.settingsservice.PlayerSettings;

import org.junit.Test;

import com.badlogic.gdx.Input.Keys;


public class TestFileService {

	@Test(expected= IllegalArgumentException.class)
	public void testReadSettingsWithTooHighNumber() {
		FileService fileService = new FileService();
		fileService.readPlayerSettings(5);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testWriteSettingsWithTooLowNumber(){
		FileService fileService = new FileService();
		fileService.writePlayerSettings(0, new Object());
	}
	
	@Test
	public void testWriteAndRead(){
		PlayerSettings testObject = new PlayerSettings(Keys.W,Keys.S,Keys.A,Keys.D,Keys.Q,Keys.E, new Fireball(1), new Fireball(1), "Player1");
		FileService fileService = new FileService();
		fileService.writePlayerSettings(1, testObject);
		Object o = fileService.readPlayerSettings(1);
		PlayerSettings copyObject = (PlayerSettings)o;
		assertTrue(copyObject.equals(testObject));
	}

}
