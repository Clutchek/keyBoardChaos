package edu.chl.KeyboardChaos.view.gui.screen;

import java.util.ArrayList;
import java.util.List;

import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.EventHandler;
import edu.chl.KeyboardChaos.view.gui.component.Label;
import edu.chl.KeyboardChaos.view.gui.component.SpellPanel;
import edu.chl.KeyboardChaos.view.gui.component.TextButton;



public class SpellMenu extends Screen implements EventHandler {
	
	private final SpellPanel spellPanel1, spellPanel2, spellPanel3, spellPanel4;
	private final Label label;
	private final TextButton back, play;
	private final List<SpellPanel> spellPanels;
	
	public SpellMenu() {
		super();
		int halfOfScreen = KCConstants.GAME_WIDTH/2;
		int space = 20;
		
		label = new Label("Choose you spells, mofos", KCConstants.GAME_WIDTH/2, KCConstants.GAME_HEIGHT - 10, null);
		spellPanel1 = new SpellPanel(halfOfScreen - space*3 - SpellPanel.WIDTH*2, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null, 1);
		spellPanel2 = new SpellPanel(halfOfScreen - space - SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null, 2);
		spellPanel3 = new SpellPanel(halfOfScreen + space, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null, 3);
		spellPanel4 = new SpellPanel(halfOfScreen + space*3 + SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, null, 4);
		
		
		spellPanels = new ArrayList<SpellPanel>();
		spellPanels.add(spellPanel1);
		spellPanels.add(spellPanel2);
		
		this.back = new TextButton("Back", 20, 20, 50, 25, new BusEvent("ControllerSettings"), false);
		this.play = new TextButton("Start Match", KCConstants.GAME_WIDTH - 120, 20, 100, 25, new BusEvent("play"), false);
		
		loadComponentList();
		EventBusService.getInstance().subscribe(this);;
	}
	
	private void loadComponentList(){
		super.getComponents().add(this.spellPanel1);
		super.getComponents().addAll(this.spellPanel1.getComponents());
		super.getComponents().add(this.spellPanel2);
		super.getComponents().addAll(this.spellPanel2.getComponents());
		super.getComponents().add(this.spellPanel3);
		super.getComponents().addAll(this.spellPanel3.getComponents());
		super.getComponents().add(this.spellPanel4);
		super.getComponents().addAll(this.spellPanel4.getComponents());
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