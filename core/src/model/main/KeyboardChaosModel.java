package model.main;

import java.util.ArrayList;
import java.util.List;

import model.player.Player;
import model.spell.Spell;


public class KeyboardChaosModel {
	
	
	private List<Player> playerList;


	
	public KeyboardChaosModel(){
		playerList = new ArrayList<Player>();
	}
	
	/**
	 * Creates a player and stores it in a playerList, which can be retrieved from <b>getPlayerList</b>
	 * 
	 * @return
	 */
	public void createPlayer(){
		playerList.add(new Player());
	}
	
	/**
	 * @return The list of all player objects
	 */
	public List<Player> getPlayerList(){
		return this.playerList;
	}
	
	/**
	 * When a collision/contact is registered in contact listener and
	 * determined to be a player being in contact with lava, this method
	 * will be called upon and will make sure the player takes the correct
	 * damage.
	 * 
	 * @param player The player that was determined to be in lava
	 */
	public void playerLavaCollision(Player player){
		//code to damage the player
	}
	
	
	/**
	 * Called upon when a contact is registered between a player fixture
	 * and a spell fixture. This method will deal the appropriate amount
	 * of damage to the player.
	 * 
	 * @param player
	 * @param spell
	 */
	/*
	 * QUESTION:
	 * Borde denna metod ta bort ett spellobject, eller räcker det att controllern
	 * ser till (själv eller via view) att fixturen tas bort?
	 */
	public void playerSpellCollision(Player player, Spell spell){
		//Do something to hurt the player
	}
	
	
	/**
	 * Two spells has been registered being in contact, and thus is this method called upon.
	 * 
	 * @param spell1 One of the spells that's colliding
	 * @param spell2 The other one in the collision
	 */

	public void spellSpellCollision(Spell spell1, Spell spell2){
		//this should tell the view to remove the two spells.
	}
	
	
	/**
	 * Called upon when a spell is about to go out-of-bounds and no
	 * longer have any chance of doing anything of value in the game
	 * and therefore rightfully gets removed
	 * 
	 * @param spell The spell that should be removed
	 */
	public void spellWorldWallCollision(Spell spell){
		//Tell the view to remove this spell
	}
	
	
	
	
	
	
	
	
	
}
