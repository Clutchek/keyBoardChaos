package edu.chl.KeyboardChaos.view.gui.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input;

import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.EventHandler;
import edu.chl.KeyboardChaos.view.gui.component.PlayerSettingsPanel;
import edu.chl.KeyboardChaos.view.gui.component.SpellPanel;
import edu.chl.KeyboardChaos.view.gui.component.TextButton;

/*
 * This class represents the settings menu in the GUI of KeyboardChaos
 */

public class SettingsMenu extends Screen implements EventHandler {
	private PlayerSettingsPanel psp1, psp2, psp3, psp4;
	private TextButton backButton, nextButton;
	private List<PlayerSettingsPanel> pspList;

	int halfOfScreen = KCConstants.GAME_WIDTH/2;
	int space = 20;

	public SettingsMenu(){

		psp1 = new PlayerSettingsPanel(halfOfScreen - space*3 - SpellPanel.WIDTH*2, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 1, null);
		psp2 = new PlayerSettingsPanel(halfOfScreen - space - SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 2, null);
		psp3 = new PlayerSettingsPanel(halfOfScreen + space, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 3, null);
		psp4 = new PlayerSettingsPanel(halfOfScreen + space*3 + SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 4, null);

		this.backButton = new TextButton("Back", 10, 10, 100, 100, new BusEvent("StartMenu"), false);
		this.nextButton = new TextButton("Next", KCConstants.GAME_WIDTH - 100 - 10, 10, 100, 100, new BusEvent("SpellSettings"), false);
		loadPspList();
		loadComponentList();
		
		EventBusService.getInstance().subscribe(this);
	}

	private List<PlayerSettingsPanel> getPlayerSettingsPanels(){
		return pspList;
	}

	private void loadPspList(){
		pspList = new ArrayList();
		pspList.add(psp1);
		pspList.add(psp2);
		pspList.add(psp3);
		pspList.add(psp4);
	}

	private void loadComponentList(){
		super.getComponents().add(this.psp1);
		super.getComponents().addAll(this.psp1.getComponents());
		super.getComponents().add(this.psp2);
		super.getComponents().addAll(this.psp2.getComponents());
		super.getComponents().add(this.psp3);
		super.getComponents().addAll(this.psp3.getComponents());
		super.getComponents().add(this.psp4);
		super.getComponents().addAll(this.psp4.getComponents());
		super.getComponents().add(backButton);
		super.getComponents().add(nextButton);
	}

	private void savePlayerKeys(){
		Options options = Options.getOptionsInstance();
		for(PlayerSettingsPanel p : pspList){
			options.setUpButtonForPlayer(pspList.indexOf(p) + 1,Input.Keys.valueOf(p.getUpButton().getText()));
			options.setDownButtonForPlayer(pspList.indexOf(p) + 1,Input.Keys.valueOf(p.getDownButton().getText()));
			options.setRightButtonForPlayer(pspList.indexOf(p) + 1,Input.Keys.valueOf(p.getRightButton().getText()));
			options.setLeftButtonForPlayer(pspList.indexOf(p) + 1,Input.Keys.valueOf(p.getLeftButton().getText()));


		}
		options.savePreferences();
	}

	@Override
	public void onEvent(BusEvent e) {
		if (e != null) {
			if (e.getBusCommand().equals("SpellSettings")){
				savePlayerKeys();	
			}
		}
	}


}
