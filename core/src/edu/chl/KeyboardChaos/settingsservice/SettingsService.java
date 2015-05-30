package edu.chl.KeyboardChaos.settingsservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input.Keys;

import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.model.spell.Spell.SpellEnum;

/*
 * This class saves and loads the playersettings to a file on a local directory on the computer
 */

public class SettingsService {
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	
	private List<String> settingsFileAddresses;
	
	public SettingsService(){
		settingsFileAddresses = new ArrayList<String>();
		for(int i = 1; i < 5; i++){
			settingsFileAddresses.add("./assets/player" + i + "settings.ser"); //H�r
		}
	}
	
	public void writePlayerSettings(int playerNumber, PlayerSettings playerSettings){
		try{
			fileOutputStream = new FileOutputStream(settingsFileAddresses.get(playerNumber-1), false);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(playerSettings);
			objectOutputStream.close();
		}catch(FileNotFoundException e){
			File tmp = new File(settingsFileAddresses.get(playerNumber-1));
			try{
				tmp.getParentFile().mkdirs(); //H�r

				boolean b = tmp.createNewFile();
				System.out.println(b);
			}catch(IOException ex){
				ex.printStackTrace();
			}
			//writePlayerSettings(playerNumber, playerSettings);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Object readPlayerSettings(int playerNumber){
		try{
			fileInputStream = new FileInputStream(settingsFileAddresses.get(playerNumber-1));
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object o = objectInputStream.readObject();
			objectInputStream.close();
			return o;
		}catch(Exception e){
			//e.printStackTrace();
			return null;
		}
		
		
	}
	
	public PlayerSettings getPlayerSettings(int playerNumber){
		Object o = readPlayerSettings(playerNumber);
		PlayerSettings playerSettings;
		if(o == null || !(o instanceof PlayerSettings)){
			playerSettings = getDefaultPlayerSettings(playerNumber);
			writePlayerSettings(playerNumber, playerSettings);
		}else{
			playerSettings = (PlayerSettings)o;
		}
		return playerSettings;
	}
	
	private PlayerSettings getDefaultPlayerSettings(int playerNumber){
		PlayerSettings playerSettings;
		switch(playerNumber){
		case 1: return playerSettings = new PlayerSettings(Keys.W,Keys.S,Keys.A,Keys.D,Keys.Q,Keys.E, new Fireball(), new Fireball(), "Player1");
		
		case 2: return playerSettings = new PlayerSettings(Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN, new Fireball(), new Fireball(), "Player2");
			
		case 3: return playerSettings = new PlayerSettings(Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN, new Fireball(), new Fireball(), "Player3");
			
		case 4: return playerSettings = new PlayerSettings(Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN, new Fireball(), new Fireball(), "Player4");
		
		default: throw new IllegalArgumentException("Number must be 1-4");
			
		}
	}
}
