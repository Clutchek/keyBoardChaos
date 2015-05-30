package edu.chl.KeyboardChaos.view.uiview.component;


import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import edu.chl.KeyboardChaos.settingsservice.Options;
import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventHandler;
import edu.chl.KeyboardChaos.view.uiview.FontUtil;

/*
 * This class represents a panel in which a player
 *  can configure his keyboard controller settings
 */
public class PlayerSettingsPanel extends Panel implements EventHandler {

	private final int height;
	private final int width;
	private final Color color;
	private final int buttonSize;
	private final int buttonSpace;
	
	private TextButton upButton;
	private TextButton downButton;
	private TextButton rightButton;
	private TextButton leftButton;
	private TextButton firstSpell;
	private TextButton secondSpell;
	private final int playerNbr;
	private List<Component> components;
	
	private boolean isActive;
	
	private Options options;


	/*
	 * Creates a playerSettingsPanel containing controller settings for the user
	 * @param posX determines the X-position of the button
	 * @param posY determines the Y-position of the button
	 * @param playerNbr determines what player this panel belongs to
	 */

	public PlayerSettingsPanel (int posX, int posY, int playerNbr, BusEvent event){
		super(posX, posY, event);

		this.playerNbr = playerNbr;
		
		height = 600;
		width = 300;
		buttonSize = 60;
		buttonSpace = 10;
		components = new ArrayList<Component>();
		this.color = Color.valueOf("989898");
		this.options = Options.getOptionsInstance();
		loadTextButtons();
		createListOfComponents();

		this.isActive = false;
	}
	/*
	 * this method creates one controllerSettingsButton
	 * @param posX determines the X-position of the button inside the PlayerSettingsPanel
	 * @param posY determines the Y-position of the button inside the PlayerSettingsPanel
	 */
	private TextButton createControllerSettingsButton(int posX, int posY, String startText){
		return new TextButton(startText, posX, posY, buttonSize, buttonSize, Color.valueOf("c76432"), null, true);
	}
	
	private void loadTextButtons(){
		upButton = createControllerSettingsButton(super.getPosX() + this.width/2 - buttonSize/2, super.getPosY() + this.height/2 + 150, Input.Keys.toString(options.getUpButtonForPlayer(this.playerNbr)));
		downButton = createControllerSettingsButton(this.upButton.getPosX(), this.upButton.getPosY() - (this.buttonSize + this.buttonSpace), Input.Keys.toString(options.getDownButtonForPlayer(this.playerNbr)));
		rightButton = createControllerSettingsButton(this.downButton.getPosX() + this.downButton.getWidth() + this.buttonSpace, this.downButton.getPosY(), Input.Keys.toString(options.getRightButtonForPlayer(this.playerNbr)));
		leftButton = createControllerSettingsButton(this.downButton.getPosX() - this.downButton.getWidth() - this.buttonSpace, this.downButton.getPosY(), Input.Keys.toString(options.getLeftButtonForPlayer(this.playerNbr)));
		firstSpell = createControllerSettingsButton(this.leftButton.getPosX() + 35, this.leftButton.getPosY() - 200, Input.Keys.toString(options.getFirstSpellButtonForPlayer(this.playerNbr)));
		secondSpell = createControllerSettingsButton(this.downButton.getPosX() + 35, this.downButton.getPosY() - 200, Input.Keys.toString(options.getSecondSpellButtonForPlayer(this.playerNbr)));
	}
	
	public void createListOfComponents(){
		components.add(upButton);
		components.add(downButton);
		components.add(rightButton);
		components.add(leftButton);
		components.add(firstSpell);
		components.add(secondSpell);
		super.addComponents(components);
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
	public TextButton getFirstSpellButton(){
		return this.firstSpell;
	}
	public TextButton getSecondSpellButton(){
		return this.secondSpell;
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
	
	public int getPlayerNumber() {
		return this.playerNbr;
	}
	
	public void toggleActive() {
		this.isActive = !this.isActive;
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	@Override
	public void onEvent(BusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer,
			FontUtil fontUtil) {
		shapeRenderer.begin();
		shapeRenderer.setColor(color);
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.rect(this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
		shapeRenderer.end();
		for (Component c : components) {
			c.render(batch, shapeRenderer, fontUtil);
		}
		
		if (!this.isActive()) {
			shapeRenderer.begin();
			shapeRenderer.setColor(new Color(0, 0 , 0 , 0.5f)); 
			Gdx.gl.glEnable(GL20.GL_BLEND);
		    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			shapeRenderer.set(ShapeType.Filled);
			shapeRenderer.rect(this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
			Gdx.gl.glEnable(GL20.GL_BLEND);
			shapeRenderer.end();
			
			batch.begin();
			fontUtil.getFont().draw(batch, "Click to join...", fontUtil.getCenteredTextPos("Click to join...", this.getPosX(), this.width), this.getHeight()/2);
			batch.end();
		}
	}
	
	public boolean isMouseOver(int x, int y) {
		boolean withinX = x >= this.getPosX() && x <= this.getPosX() + getWidth();
		boolean withinY = y >= KCConstants.GAME_HEIGHT - super.getPosY() - getHeight() && y <= KCConstants.GAME_HEIGHT - super.getPosY(); // Mouse position is from upper left corner
		return withinX && withinY;
	}
}
