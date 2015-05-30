package edu.chl.KeyboardChaos.model.spell;

import java.io.Serializable;
/**
 * An interface for all spells
 */
public interface Spell extends Serializable{
	
	public enum SpellEnum{
		FIREBALL(new Fireball()),
		ICE(new Ice());
		
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
		
		public Spell getSpell() {
			try {
				return (Spell)spell.getClass().newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public SpellEnum next() {
			return VALUES[(this.ordinal()+1) % VALUES.length];
		}
		
		public SpellEnum previous() {
			return VALUES[(this.ordinal() + VALUES.length - 1) % VALUES.length];
		}
		
		public static SpellEnum getSpellEnum(Spell spell) {
			for (SpellEnum v : VALUES) {
				if (v.getSpell().getName() == spell.getName()) {
					return v;
				}
			}
			return null;
		}
	}
	
	public String getDescription();
	public String getName();
}
