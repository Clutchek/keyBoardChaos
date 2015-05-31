package edu.chl.KeyboardChaos.view.uiview.screen;



import com.badlogic.gdx.graphics.Color;

import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.view.uiview.component.TextButton;

/*
 * This class represents the start menu in the GUI of KeyboardChaos
 */

public class StartMenu extends Screen{

	private final TextButton playButton;
	private final TextButton exitButton;

	public StartMenu(){
		super();
		int width = KCConstants.GAME_WIDTH/3;
		int height = KCConstants.GAME_HEIGHT/6;
		int posX = (KCConstants.GAME_WIDTH/2) - width/2;
		int posY = KCConstants.GAME_HEIGHT/2;
		int space = KCConstants.GAME_HEIGHT/20;

		this.playButton = new TextButton("Play", posX, posY+height/2+space, width, height, Color.valueOf("969696"), new BusEvent("ControllerSettings"), false);
		this.exitButton = new TextButton("Exit", posX, posY-height/2-space, width, height, Color.valueOf("969696"), new BusEvent("exit"), false);
		loadComponentList();
	}

	private void loadComponentList(){
		super.getComponents().add(this.playButton);
		super.getComponents().add(this.exitButton);
	}

}


