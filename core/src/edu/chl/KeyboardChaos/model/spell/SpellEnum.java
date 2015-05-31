package edu.chl.KeyboardChaos.model.spell;


/**
 * Enum representing a spell. This makes it possible to go through a list of all available spells.
 */
public enum SpellEnum {

	FIREBALL(new Fireball(0)),
	ICE(new Iceball(0));
	
	private final String description;
	private final String name;
	private final Spell spell;
	private final static SpellEnum[] VALUES = values();
	
	SpellEnum(Spell spell) {
		this.spell = spell;
		this.description = spell.getDescription();
		this.name = spell.getName();
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getName() {
		return this.name;
	}
	
	// TODO: This could probably be done better, clone or something
	public Spell getSpell() {
		return spell.clone();
	}
	
	public SpellEnum next() {
		return VALUES[(this.ordinal()+1) % VALUES.length];
	}
	
	public SpellEnum previous() {
		return VALUES[(this.ordinal() + VALUES.length - 1) % VALUES.length];
	}
	
	public static SpellEnum getSpellEnum(Spell spell) {
		for (SpellEnum v : VALUES) {
			if (v.getSpell().getName().equals(spell.getName())) {
				return v;
			}
		}
		return null;
	}
}
