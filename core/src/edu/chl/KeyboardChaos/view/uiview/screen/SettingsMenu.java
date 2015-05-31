package edu.chl.KeyboardChaos.view.uiview.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.BusEventHandler;
import edu.chl.KeyboardChaos.view.uiview.component.Label;
import edu.chl.KeyboardChaos.view.uiview.component.PlayerSettingsPanel;
import edu.chl.KeyboardChaos.view.uiview.component.SpellPanel;
import edu.chl.KeyboardChaos.view.uiview.component.TextButton;

/*
 * This class represents the settings menu in the GUI of KeyboardChaos
 */

public class SettingsMenu extends Screen implements BusEventHandler {
	private final PlayerSettingsPanel psp1, psp2, psp3, psp4;
	private final TextButton backButton, nextButton;
	private final Label label;
	private List<PlayerSettingsPanel> pspList;

	private final int halfOfScreen = Gdx.graphics.getWidth()/2;
	private final int space = 20;

	public SettingsMenu(){

		psp1 = new PlayerSettingsPanel(halfOfScreen - space*3 - SpellPanel.WIDTH*2, Gdx.graphics.getHeight() - SpellPanel.HEIGHT - 100, 1);
		psp2 = new PlayerSettingsPanel(halfOfScreen - space - SpellPanel.WIDTH, Gdx.graphics.getHeight() - SpellPanel.HEIGHT - 100, 2);
		psp3 = new PlayerSettingsPanel(halfOfScreen + space, Gdx.graphics.getHeight() - SpellPanel.HEIGHT - 100, 3);
		psp4 = new PlayerSettingsPanel(halfOfScreen + space*3 + SpellPanel.WIDTH, Gdx.graphics.getHeight() - SpellPanel.HEIGHT - 100, 4);

		this.backButton = new TextButton("Back", 20, 20, 80, 50, new BusEvent("StartMenu"), false);
		this.nextButton = new TextButton("Next", Gdx.graphics.getWidth() - 100, 20, 80, 50, new BusEvent("SpellSettings"), false);
		this.label = new Label("Join and choose your controller settings!", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 25);
		loadPspList();
		loadComponentList();
		
		EventBusService.getInstance().subscribe(this);
	}

	private void loadPspList(){
		pspList = new ArrayList<PlayerSettingsPanel>();
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
