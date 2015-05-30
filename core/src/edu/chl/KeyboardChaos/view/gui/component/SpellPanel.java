package edu.chl.KeyboardChaos.view.gui.component;


import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import edu.chl.KeyboardChaos.model.spell.Spell;
import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.view.gui.Font;
import edu.chl.KeyboardChaos.view.gui.FontUtil;

/*
 * This class represents a panel that contains
 * two spell boxes, in which a player can iterate through
 * available spells and choose the desired spell
 */
public class SpellPanel extends Panel {
	
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
		
		this.panelColor = Color.valueOf("828282");
	}
	
	private void loadComponents() {
		components.add(this.spellBox1);
		components.add(this.spellBox2);
		components.add(this.label);
		super.addComponents(components);
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
	
	public Spell getSelectedSpell() {
		return getSelectedSpellBox().getSpell();
	}
	
	public Spell getSpell1() {
		return this.spellBox1.getSpell();
	}
	
	public Spell getSpell2() {
		return this.spellBox2.getSpell();
	}
	
	public int getPlayerNumber() {
		return this.playerNumber;
	}

	@Override
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer,
			FontUtil fontUtil) {
		// Draw the background rectangle
		shapeRenderer.begin();
		shapeRenderer.setColor(this.panelColor);
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.rect(this.getPosX(), this.getPosY(), this.WIDTH, this.HEIGHT);
		shapeRenderer.end();
		
		// Draw the text
		batch.begin();
		
		fontUtil.setFont(Font.INIKA_40);
		int playerNamePosX = fontUtil.getCenteredTextPos(this.getPlayerName(), this.getPosX(), this.WIDTH);
		//fontUtil.getFont().draw(batch, panel.getPlayerName(), playerNamePosX, panel.getHeight() + panel.getPosY() - 10);
		
		SpellBox spellBox1 = this.getSpellBox1();
		SpellBox spellBox2 = this.getSpellBox2();
		
		fontUtil.setFont(Font.ARIAL_20);
		int spellTextPosY = spellBox1.getPosY() + spellBox1.SIZE + fontUtil.getTextHeight(this.getSpell1().getName()) + 10;
		fontUtil.getFont().draw(batch, this.getSpell1().getName(), fontUtil.getCenteredTextPos(this.getSpell1().getName(), spellBox1.getPosX(), SpellBox.SIZE), spellTextPosY);
		fontUtil.getFont().draw(batch, this.getSpell2().getName(), fontUtil.getCenteredTextPos(this.getSpell2().getName(), spellBox2.getPosX(), SpellBox.SIZE), spellTextPosY);
		
		// TODO: Only wrap when new spell is selected
		fontUtil.getFont().draw(batch, fontUtil.wrapText(this.getSelectedSpell().getDescription(), (spellBox2.getPosX() + SpellBox.SIZE) - spellBox1.getPosX()), spellBox1.getPosX(), spellBox1.getPosY() - 20);
		batch.end();
		
		for (Component c : components) {
			c.render(batch, shapeRenderer, fontUtil);
		}
	}
}
