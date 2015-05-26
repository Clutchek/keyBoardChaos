package model.gui.component;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import controller.eventbus.BusEvent;
import controller.eventbus.EventHandler;


public class PlayerSettingsPanel extends Component implements EventHandler {

	private final int height;
	private final int width;
	private final Color color;
	private final int buttonSize;
	private final int buttonSpace;
	
	private TextButton upButton;
	private TextButton downButton;
	private TextButton rightButton;
	private TextButton leftButton;
	private List<Component> components;


	/*
	 * Creates a playerSettingsPanel containing controller settings for the user
	 * @param posX determines the X-position of the button
	 * @param posY determines the Y-position of the button
	 */

	public PlayerSettingsPanel (int posX, int posY, BusEvent event){
		super(posX, posY, event);

		height = 600;
		width = 300;
		buttonSize = 60;
		buttonSpace = 10;
		components = new ArrayList<Component>();
		this.color = new Color(152,152,152);
		loadTextButtons();
		createListOfComponents();


	}
	/*
	 * this method creates one controllerSettingsButton
	 * @param posX determines the X-position of the button inside the PlayerSettingsPanel
	 * @param posY determines the Y-position of the button inside the PlayerSettingsPanel
	 */
	private TextButton createControllerSettingsButton(int posX, int posY, String startText){
		return new TextButton(startText, posX, posY, buttonSize, buttonSize, new Color(199, 100,50), null, true);
	}
	
	private void loadTextButtons(){
		upButton = createControllerSettingsButton(super.getPosX() + this.width/2 - buttonSize/2, super.getPosY() + this.height/2 + 150, "W");
		downButton = createControllerSettingsButton(this.upButton.getPosX(), this.upButton.getPosY() - (this.buttonSize + this.buttonSpace), "S");
		rightButton = createControllerSettingsButton(this.downButton.getPosX() + this.downButton.getWidth() + this.buttonSpace, this.downButton.getPosY(), "D");
		leftButton = createControllerSettingsButton(this.downButton.getPosX() - this.downButton.getWidth() - this.buttonSpace, this.downButton.getPosY(), "A");
	}
	
	public void createListOfComponents(){
		components.add(upButton);
		components.add(downButton);
		components.add(rightButton);
		components.add(leftButton);
	}
	
	public TextButton getUpButton(){
		return this.upButton;
	}
	public TextButton getDownButton(){
		return this.downButton;
	}
	public TextButton getLeftButton(){
		return this.leftButton;
	}
	public TextButton getRightButton(){
		return this.rightButton;
	}
	
	public String getUpButtonText(){
		return upButton.getText();
	}
	
	public String downUpButtonText(){
		return downButton.getText();
	}
	
	public String rightUpButtonText(){
		return rightButton.getText();
	}
	
	public String leftUpButtonText(){
		return leftButton.getText();
	}
	
	
	public List<Component> getComponents(){
		return this.components;
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
