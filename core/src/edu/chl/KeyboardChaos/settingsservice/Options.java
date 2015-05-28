package edu.chl.KeyboardChaos.settingsservice;

import edu.chl.KeyboardChaos.model.spell.Spell.SpellEnum;



/**
 * A singleton class which holds information about how many players that should
 * be created, which controls they have and which spells they have selected.
 * 
 * @author Kristoffer
 *
 */
public class Options {

	private static Options options;
	private int nbrOfPlayers;
	private PlayerSettings playerOneSettings;
	private PlayerSettings playerTwoSettings;
	private PlayerSettings playerThreeSettings;
	private PlayerSettings playerFourSettings;
	private SettingsService settingsService;
	
	
	private Options(){
		settingsService = new SettingsService();
		playerOneSettings = settingsService.getPlayerSettings(1);
		playerTwoSettings = settingsService.getPlayerSettings(2);
		playerThreeSettings = settingsService.getPlayerSettings(3);
		playerFourSettings = settingsService.getPlayerSettings(4);
		
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
	 * Set the amount of players that will play
	 * 
	 * @param nbrOfPlayers
	 */
	public void setNbrOfPlayers(int nbrOfPlayers){
		this.nbrOfPlayers = nbrOfPlayers;
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
	 * @return The amount of players that has been selected to play
	 */
	public int getNbrOfPlayers(){
		return nbrOfPlayers;
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
	public SpellEnum getFirstSpell(int playerNbr){
		return getPlayerSettingsForPlayer(playerNbr).getFirstSpell();
	}
	
	/**
	 * Getter for the second spell of a chosen player
	 * 
	 * @param playerNbr the index of the player which second spell you want
	 * @return the selected players second spell
	 */
	public SpellEnum getSecondSpell(int playerNbr){
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
	public void setFirstSpell(int playerNbr, SpellEnum firstSpell){
		getPlayerSettingsForPlayer(playerNbr).setFirstSpell(firstSpell);
	}
	
	/**
	 * 
	 * @param playerNbr
	 * @param secondSpell
	 */
	public void setSecondSpell(int playerNbr, SpellEnum secondSpell){
		getPlayerSettingsForPlayer(playerNbr).setSecondSpell(secondSpell);
	}
	
	public void setSpells(int playerNbr, SpellEnum firstSpell, SpellEnum secondSpell) {
		this.setFirstSpell(playerNbr, firstSpell);
		this.setSecondSpell(playerNbr, secondSpell);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * This gets called upon before exiting the program, saves all the current player settings.
	 */
	public void savePreferences(){
		for(int i = 1 ; i<=4 ; i++){
			settingsService.writePlayerSettings(i, getPlayerSettingsForPlayer(i));
	
		}
	}
	
	
}