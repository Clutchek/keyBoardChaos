package edu.chl.KeyboardChaos.model.spell;

/**
 * A class that represents a fireball in the keyBoardChaos game.
 */

public class Fireball extends OffensiveSpell{
	private static final long serialVersionUID = 8857635637656332791L;
	
	
	public final static String DESCRIPTION = "This is a description of a fireball.";

	public final static String NAME = "Fireball";
	

	public Fireball(int playerNumber){
		super(10f, 3f, 10f,2f,1.5f, playerNumber);
	}
	
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
