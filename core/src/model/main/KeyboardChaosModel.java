package model.main;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input;

import model.player.Player;
import model.spell.Fireball;
import model.spell.Spell.SpellEnum;;

//Klassen kanske borde innehålla score med.
public class KeyboardChaosModel {
	
	
	private List<Player> playerList;
	
	public KeyboardChaosModel(){
		playerList = new ArrayList<Player>();
		createPlayers();
	}
	
	/**
	 * Creates a player and stores it in a playerList, which can be retrieved from <b>getPlayerList</b>
	 * 
	 * @return
	 */
	public void createPlayers(){
		//Kolla settings antal aktiva spelare?
		
		//Skapa spelare utifrån settings
		playerList.add(new Player("Player1", 10f,10f, SpellEnum.FIREBALL, SpellEnum.FIREBALL)); 
		playerList.add(new Player("Player2", 20f,20f, SpellEnum.FIREBALL, SpellEnum.FIREBALL));
		playerList.add(new Player("Player3", 30f,30f, SpellEnum.FIREBALL, SpellEnum.FIREBALL));
		playerList.add(new Player("Player4", 40f,40f, SpellEnum.FIREBALL, SpellEnum.FIREBALL));
		System.out.println(Input.Keys.toString(Input.Keys.L));
	}
	
	/**
	 * @return The list of all player objects
	 */
	public List<Player> getPlayerList(){
		return this.playerList;
	}
	
	//Saker nedanför här ska flyttas.....
	
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
	public void playerSpellCollision(Player player, SpellEnum spell){
		//Do something to hurt the player
	}
	
	
	/**
	 * Two spells has been registered being in contact, and thus is this method called upon.
	 * 
	 * @param spell1 One of the spells that's colliding
	 * @param spell2 The other one in the collision
	 */

	public void spellSpellCollision(SpellEnum spell1, SpellEnum spell2){
		//this should tell the view to remove the two spells.
	}
	
	
	/**
	 * Called upon when a spell is about to go out-of-bounds and no
	 * longer have any chance of doing anything of value in the game
	 * and therefore rightfully gets removed
	 * 
	 * @param spell The spell that should be removed
	 */
	public void spellWorldWallCollision(SpellEnum spell){
		//Tell the view to remove this spell
	}
}
