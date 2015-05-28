package edu.chl.KeyboardChaos.view.gui.component;

import java.awt.Color;

import edu.chl.KeyboardChaos.model.spell.Spell.SpellEnum;


public class SpellBox extends Component {
	
	public final static int SIZE = 135;
	private final Color backgroundColor, highlightColor;
	private SpellEnum spell;
	private boolean isSelected;
	private Label spellLabel;
	
	public SpellBox(int posX, int posY, SpellEnum spell) {
		super(posX, posY, null);
		this.spell = spell;
		this.isSelected = false;
		this.backgroundColor = new Color(40, 40, 40);
		this.highlightColor = new Color(255, 137, 0);
	}
	
	public SpellEnum getSpell() {
		return this.spell;
	}
	
	public boolean isSelected() {
		return this.isSelected;
	}
	
	public void toggleSelected() {
		this.isSelected = !isSelected;
	}
	
	public void nextSpell() {
		this.spell = spell.next();
	}
	
	public void previousSpell() {
		this.spell = spell.previous();
	}
	
	public Color getBackgroundColor() {
		return this.backgroundColor;
	}
	
	public Color getHighlightColor() {
		return this.highlightColor;
	}
}
