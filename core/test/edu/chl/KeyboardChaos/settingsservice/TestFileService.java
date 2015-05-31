package edu.chl.KeyboardChaos.settingsservice;

import static org.junit.Assert.*;
import edu.chl.KeyboardChaos.settingsservice.PlayerSettings;
import org.junit.Test;


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
	public void testReadSettingsForFirstPlayer(){
		FileService fileService = new FileService();
		assertTrue(fileService.readPlayerSettings(1) instanceof PlayerSettings);
	}
	/*
	@Test
	public void testReadSettingsForSecondPlayer(){
		FileService fileService = new FileService();
		assertTrue(fileService.readPlayerSettings(2) instanceof PlayerSettings);
	}
	@Test
	public void testReadSettingsForThirdPlayer(){
		FileService fileService = new FileService();
		assertTrue(fileService.readPlayerSettings(3) instanceof PlayerSettings);
	}
	@Test
	public void testReadSettingsForFourthPlayer(){
		FileService fileService = new FileService();
		assertTrue(fileService.readPlayerSettings(4) instanceof PlayerSettings);
	}*/

}
