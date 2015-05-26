package model.gui.component;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import controller.eventbus.BusEvent;
import controller.eventbus.EventHandler;


public class PlayerSettingsPanel extends Component implements EventHandler {

	private int posX, posY;
	private final int height;
	private final int width;
	private final Color color;
	
	private TextButton upButton;
	private TextButton downButton;
	private TextButton rightButton;
	private TextButton leftButton;
	private List<TextButton> components;


	/*
	 * Creates a playerSettingsPanel containing controller settings for the user
	 * @param posX determines the X-position of the button
	 * @param posY determines the Y-position of the button
	 */

	public PlayerSettingsPanel (int posX, int posY, BusEvent event){
		super(event);

		this.posX = posX;
		this.posY = posY;
		height = 600;
		width = 150;
		components = new ArrayList();
		createListOfComponents();
		this.color = new Color(152,152,152);
		loadTextButtons();

	}
	/*
	 * this method creates one controllerSettingsButton
	 * @param posX determines the X-position of the button inside the PlayerSettingsPanel
	 * @param posY determines the Y-position of the button inside the PlayerSettingsPanel
	 */
	private TextButton createControllerSettingsButton(int posX, int posY, String startText, BusEvent event){
		return new TextButton(startText, (this.posX + posX), (this.posY + posY), 30, 30, new Color(199, 100,50), event, true);
	}
	
	private void loadTextButtons(){
		upButton = createControllerSettingsButton(75, 100, "W", new BusEvent("chosenUpButton"));
		downButton = createControllerSettingsButton(75, 135, "S", new BusEvent("chosenDownButton"));
		rightButton = createControllerSettingsButton(110, 135, "D", new BusEvent("chosenRightButton"));
		leftButton = createControllerSettingsButton(40, 135, "A", new BusEvent("chosenLeftButton"));
	}
	
	public void createListOfComponents(){
		components.add(upButton);
		components.add(downButton);
		components.add(rightButton);
		components.add(leftButton);
	}
	
	public String getUpButton(){
		return upButton.getText();
	}
	
	public String downUpButton(){
		return downButton.getText();
	}
	
	public String rightUpButton(){
		return rightButton.getText();
	}
	
	public String leftUpButton(){
		return leftButton.getText();
	}
	
	
	public List<TextButton> getComponents(){
		return this.components;
	}

	public int getX(){
		return this.posX;	
	}

	public int getY(){
		return this.posY;	
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public Color getPanelColor(){
		return this.color;
	}
	@Override
	public void onEvent(BusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
