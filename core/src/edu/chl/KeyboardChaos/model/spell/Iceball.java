package edu.chl.KeyboardChaos.model.spell;
/**
 * A class that represents an ice spell in the keyBoardChaos game.
*/
public class Iceball extends OffensiveSpell{
	
	private static final long serialVersionUID = -7105427562354348157L;
	private final float radius;
	
	public final static String DESCRIPTION = "This is a description of an iceball.";
	public final static String NAME = "Iceball";

	public Iceball(int playerNumber){
		super(10f, 3f, 10f, 2f, 1.5f, playerNumber);
		//this.originPlayer = originPlayer;
		radius = 10f;
	}
	
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
