package edu.chl.KeyboardChaos.view.uiview.screen;

import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.EventHandler;
import edu.chl.KeyboardChaos.view.uiview.component.Label;
import edu.chl.KeyboardChaos.view.uiview.component.SpellPanel;
import edu.chl.KeyboardChaos.view.uiview.component.TextButton;

/*
 * This class represents the spell menu in the GUI of KeyboardChaos
 */

public class SpellMenu extends Screen implements EventHandler {
	
	private final SpellPanel spellPanel1, spellPanel2, spellPanel3, spellPanel4;
	private final Label label;
	private final TextButton back, play;
	private final List<SpellPanel> spellPanels;
	
	public SpellMenu() {
		super();
		int halfOfScreen = KCConstants.GAME_WIDTH/2;
		int space = 20;
		
		label = new Label("Choose your spells", KCConstants.GAME_WIDTH/2, KCConstants.GAME_HEIGHT - 25);
		spellPanel1 = new SpellPanel(halfOfScreen - space*3 - SpellPanel.WIDTH*2, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 1);
		spellPanel2 = new SpellPanel(halfOfScreen - space - SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 2);
		spellPanel3 = new SpellPanel(halfOfScreen + space, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 3);
		spellPanel4 = new SpellPanel(halfOfScreen + space*3 + SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 4);
		
		
		spellPanels = new ArrayList<SpellPanel>();
		spellPanels.add(spellPanel1);
		spellPanels.add(spellPanel2);
		
		this.back = new TextButton("Back", 20, 20, 80, 50, new BusEvent("ControllerSettings"), false);
		this.play = new TextButton("Start Match", KCConstants.GAME_WIDTH - 150, 20, 130, 50, new BusEvent("play"), false);
		
		loadComponentList();
		EventBusService.getInstance().subscribe(this);;
	}
	
	private void loadComponentList(){
		super.getComponents().add(this.spellPanel1);
		super.getComponents().add(this.spellPanel2);
		super.getComponents().add(this.spellPanel3);
		super.getComponents().add(this.spellPanel4);
		super.getComponents().add(this.back);
		super.getComponents().add(this.play);
		super.getComponents().add(this.label);
	}

	@Override
	public void onEvent(BusEvent e) {
		// Save all players' spells
		if (e != null && e.getBusCommand().equals("play")) {
			Options options = Options.getOptionsInstance();
			for (SpellPanel panel : spellPanels) {
				options.setSpells(spellPanels.indexOf(panel)+1, panel.getSpell1(), panel.getSpell2());
			}
			options.savePreferences();
		}
	}
}