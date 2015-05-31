package edu.chl.KeyboardChaos.settingsservice;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input.Keys;

import edu.chl.KeyboardChaos.model.spell.Fireball;
import edu.chl.KeyboardChaos.model.spell.Spell;



/**
 * A singleton class which holds information about how many players that should
 * be created, which controls they have and which spells they have selected.
 * 
 * @author Kristoffer
 *
 */
public class Options {

	private static Options options;
	private PlayerSettings playerOneSettings;
	private PlayerSettings playerTwoSettings;
	private PlayerSettings playerThreeSettings;
	private PlayerSettings playerFourSettings;
	private final FileService fileService;
	
	private final List<Integer> activePlayers;
	
	private Options(){
		fileService = new FileService();
		playerOneSettings = getPlayerSettings(1);
		playerTwoSettings = getPlayerSettings(2);
		playerThreeSettings = getPlayerSettings(3);
		playerFourSettings = getPlayerSettings(4);
		
		this.activePlayers = new ArrayList<Integer>();
	}
	
	
	/**
	 * A getter for the options singleton
	 * 
	 * @return the signleton instance Options.
	 */
	public synchronized static Options getOptionsInstance(){
		if(options == null){
			options = new Options();
		}
		return options;
	}
	
	
	/**
	 * Set a player as active by its number
	 * 
	 * @param playerNumber
	 */
	public void addPlayer(int playerNumber){
		this.activePlayers.add(playerNumber);
	}
	
	private PlayerSettings getPlayerSettingsForPlayer(int playerIndex){
		switch(playerIndex){
			case 1 : return playerOneSettings;
			case 2 : return playerTwoSettings;
			case 3 : return playerThreeSettings;
			case 4 : return playerFourSettings;
			default : return null;
		}
	}
	
	/**
	 * @return The active players' number
	 */
	public List<Integer> getActivePlayers(){
		return activePlayers;
	}
	/**
	 * 
	 * @param playerNbr
	 * @return
	 */
	public int getLeftButtonForPlayer(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getMoveLeftKey();
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @return
	 */
	public int getRightButtonForPlayer(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getMoveRightKey();
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @return
	 */
	public int getUpButtonForPlayer(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getMoveUpKey();
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @return
	 */
	public int getDownButtonForPlayer(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getMoveDownKey();
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @return
	 */
	public int getFirstSpellButtonForPlayer(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getfirstSpellKey();
	}
	
	/**
	 * Getter for 
	 * 
	 * @param playerNbr
	 * @return
	 */
	public int getSecondSpellButtonForPlayer(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getSecondSpellKey();
	}
	
	/**
	 * Getter for the first spell of a chosen player
	 * 
	 * @param playerNbr the index of the player which first spell you want
	 * @return the selected players first spell
	 */
	public Spell getFirstSpell(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getFirstSpell();
	}
	
	/**
	 * Getter for the second spell of a chosen player
	 * 
	 * @param playerNbr the index of the player which second spell you want
	 * @return the selected players second spell
	 */
	public Spell getSecondSpell(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getSecondSpell();
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * @param playerNbr
	 * @param key
	 */
	public void setLeftButtonForPlayer(int playerNbr, int key){
		getPlayerSettingsForPlayer(playerNbr).setMoveLeftKey(key);
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @param key
	 */
	public void setRightButtonForPlayer(int playerNbr, int key){
		getPlayerSettingsForPlayer(playerNbr).setMoveRightKey(key);
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @param key
	 */
	public void setUpButtonForPlayer(int playerNbr, int key){
		getPlayerSettingsForPlayer(playerNbr).setMoveUpKey(key);
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @param key
	 */
	public void setDownButtonForPlayer(int playerNbr, int key){
		getPlayerSettingsForPlayer(playerNbr).setMoveDownKey(key);
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @param key
	 */
	public void setFirstSpellButtonForPlayer(int playerNbr, int key){
		getPlayerSettingsForPlayer(playerNbr).setfirstSpellKey(key);
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @param key
	 */
	public void setSecondSpellButtonForPlayer(int playerNbr, int key){
		getPlayerSettingsForPlayer(playerNbr).setSecondSpellKey(key);
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @param firstSpell
	 */
	public void setFirstSpell(int playerNbr, Spell firstSpell){
		getPlayerSettingsForPlayer(playerNbr).setFirstSpell(firstSpell);
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @param secondSpell
	 */
	public void setSecondSpell(int playerNbr, Spell secondSpell){
		getPlayerSettingsForPlayer(playerNbr).setSecondSpell(secondSpell);
	}
	
	public void setSpells(int playerNbr, Spell firstSpell, Spell secondSpell) {
		this.setFirstSpell(playerNbr, firstSpell);
		this.setSecondSpell(playerNbr, secondSpell);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	private PlayerSettings getPlayerSettings(int playerNumber){
		Object o = fileService.readPlayerSettings(playerNumber);
		PlayerSettings playerSettings;
		if(o == null || !(o instanceof PlayerSettings)){
			playerSettings = getDefaultPlayerSettings(playerNumber);
			fileService.writePlayerSettings(playerNumber, playerSettings);
		}else{
			playerSettings = (PlayerSettings)o;
		}
		return playerSettings;
	}
	
	private PlayerSettings getDefaultPlayerSettings(int playerNumber){
		switch(playerNumber){
		case 1: return new PlayerSettings(Keys.W,Keys.S,Keys.A,Keys.D,Keys.Q,Keys.E, new Fireball(), new Fireball(), "Player1");
		
		case 2: return new PlayerSettings(Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN, new Fireball(), new Fireball(), "Player2");
			
		case 3: return new PlayerSettings(Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN, new Fireball(), new Fireball(), "Player3");
			
		case 4: return new PlayerSettings(Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN,Keys.UNKNOWN, new Fireball(), new Fireball(), "Player4");
		
		default: throw new IllegalArgumentException("Number must be 1-4");
			
		}
	}
	
	/**
	 * This gets called upon before exiting the program, saves all the current player settings.
	 */
	public void savePreferences(){
		for(int i = 1 ; i<=4 ; i++){
			fileService.writePlayerSettings(i, getPlayerSettingsForPlayer(i));
	
		}
	}
	
	
}