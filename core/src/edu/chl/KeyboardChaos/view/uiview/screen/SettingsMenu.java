package edu.chl.KeyboardChaos.view.uiview.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input;

import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.EventHandler;
import edu.chl.KeyboardChaos.view.uiview.component.Label;
import edu.chl.KeyboardChaos.view.uiview.component.PlayerSettingsPanel;
import edu.chl.KeyboardChaos.view.uiview.component.SpellPanel;
import edu.chl.KeyboardChaos.view.uiview.component.TextButton;

/*
 * This class represents the settings menu in the GUI of KeyboardChaos
 */

public class SettingsMenu extends Screen implements EventHandler {
	private PlayerSettingsPanel psp1, psp2, psp3, psp4;
	private TextButton backButton, nextButton;
	private Label label;
	private List<PlayerSettingsPanel> pspList;

	int halfOfScreen = KCConstants.GAME_WIDTH/2;
	int space = 20;

	public SettingsMenu(){

		psp1 = new PlayerSettingsPanel(halfOfScreen - space*3 - SpellPanel.WIDTH*2, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 1, null);
		psp2 = new PlayerSettingsPanel(halfOfScreen - space - SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 2, null);
		psp3 = new PlayerSettingsPanel(halfOfScreen + space, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 3, null);
		psp4 = new PlayerSettingsPanel(halfOfScreen + space*3 + SpellPanel.WIDTH, KCConstants.GAME_HEIGHT - SpellPanel.HEIGHT - 100, 4, null);

		this.backButton = new TextButton("Back", 20, 20, 80, 50, new BusEvent("StartMenu"), false);
		this.nextButton = new TextButton("Next", KCConstants.GAME_WIDTH - 100, 20, 80, 50, new BusEvent("SpellSettings"), false);
		this.label = new Label("Join and choose your controller settings!", KCConstants.GAME_WIDTH/2, KCConstants.GAME_HEIGHT - 25, null);
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
		super.getComponents().add(this.psp2);
		super.getComponents().add(this.psp3);
		super.getComponents().add(this.psp4);
		super.getComponents().add(backButton);
		super.getComponents().add(nextButton);
		super.getComponents().add(label);
	}

	private void savePlayerKeys(){
		Options options = Options.getOptionsInstance();
		for(PlayerSettingsPanel p : pspList){
			int playerIndex = pspList.indexOf(p) + 1;
			options.setUpButtonForPlayer(playerIndex,Input.Keys.valueOf(p.getUpButton().getText()));
			options.setDownButtonForPlayer(playerIndex,Input.Keys.valueOf(p.getDownButton().getText()));
			options.setRightButtonForPlayer(playerIndex,Input.Keys.valueOf(p.getRightButton().getText()));
			options.setLeftButtonForPlayer(playerIndex,Input.Keys.valueOf(p.getLeftButton().getText()));
			options.setFirstSpellButtonForPlayer(playerIndex, Input.Keys.valueOf(p.getFirstSpellButton().getText()));
			options.setSecondSpellButtonForPlayer(playerIndex, Input.Keys.valueOf(p.getSecondSpellButton().getText()));
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
