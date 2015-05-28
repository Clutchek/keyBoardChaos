package edu.chl.KeyboardChaos.view.gui.component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.model.spell.Spell.SpellEnum;
import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;




public class SpellPanel extends Component {
	
	private final Color panelColor;
	private final SpellBox spellBox1, spellBox2;
	private final Label label;
	private String playerName;
	private int playerNumber;
	
	public final static int WIDTH = 300;
	public final static int HEIGHT = 600;
	
	private final List<Component> components;
	
	public SpellPanel(int posX, int posY, BusEvent event, int playerNumber) {
		super(posX, posY, event);
		
		Options options = Options.getOptionsInstance();
		
		this.playerNumber = playerNumber;
		this.playerName = "PLAYER " + this.playerNumber; // TODO: Options should contain a player name
		
		// Create components
		this.components = new ArrayList<Component>();
		this.spellBox1 = new SpellBox(posX + 10, posY + 300, options.getFirstSpell(playerNumber));
		this.spellBox2 = new SpellBox(posX + WIDTH - SpellBox.SIZE - 10, posY + 300, options.getSecondSpell(playerNumber));
		this.label = new Label(playerName, this.getPosX() + this.WIDTH/2, this.getPosY() + this.HEIGHT - 20, null);
		loadComponents();
		

		this.spellBox1.toggleSelected();
		
		this.panelColor = new Color(130, 130, 130);
	}
	
	private void loadComponents() {
		components.add(this.spellBox1);
		components.add(this.spellBox2);
		components.add(this.label); 
	}
	
	public List<Component> getComponents() {
		return this.components;
	}
	
	public SpellBox getSpellBox1() {
		return this.spellBox1;
	}
	
	public SpellBox getSpellBox2() {
		return this.spellBox2;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void toggleSelectedSpellBox() {
		this.spellBox1.toggleSelected();
		this.spellBox2.toggleSelected();
	}
	
	public void nextSpell() {
		getSelectedSpellBox().nextSpell();
	}
	
	public void previousSpell() {
		getSelectedSpellBox().previousSpell();
	}
	
	private SpellBox getSelectedSpellBox() {
		return spellBox1.isSelected() ? spellBox1 : spellBox2;
	}
	
	public SpellEnum getSelectedSpell() {
		return getSelectedSpellBox().getSpell();
	}
	
	public SpellEnum getSpell1() {
		return this.spellBox1.getSpell();
	}
	
	public SpellEnum getSpell2() {
		return this.spellBox2.getSpell();
	}
	
	public int getPlayerNumber() {
		return this.playerNumber;
	}
}
