package edu.chl.KeyboardChaos.view.uiview.component;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.view.uiview.Font;
import edu.chl.KeyboardChaos.view.uiview.FontUtil;



/**
 * A clickable button with text on it
 */
public class TextButton extends EventComponent {

	private String text;
	private Color currentColor, backgroundColor, hoverColor, clickColor;
	private final int width, height;
	private final boolean selectableButton;
	private boolean selected;
	
	/**
	 * Create a text button with a standard color of gray
	 * @param text Text to display on the button.
	 * @param posX X-position of the button.
	 * @param posY Y-position of the button.
	 * @param width Width of the button.
	 * @param height Height of the button.
	 */
	public TextButton(String text, int posX, int posY, int width, int height, BusEvent event, boolean selectableButton) {
		super(posX, posY, event);
		this.width = width;
		this.height = height;
		this.text = text;
		this.selectableButton = selectableButton;
		this.selected = false;
		this.setColors(Color.valueOf("989898"), Color.valueOf("a5a5a5"), Color.valueOf("8b8b8b"));
	}
	
	/**
	 * Create a text button with specific colors
	 * @param text Text to display on the button.
	 * @param posX X-position of the button.
	 * @param posY Y-position of the button.
	 * @param width Width of the button.
	 * @param height Height of the button.
	 * @param backgroundColor Normal color of the button.
	 * @param hoverColor Color of the button while hovered.
	 * @param clickColor Color of the button while clicked.
	 */
	public TextButton(String text, int posX, int posY, int width, int height, Color backgroundColor, Color hoverColor, Color clickColor, BusEvent event, boolean selectableButton) {
		this(text, posX, posY, width, height, event, selectableButton);
		this.setColors(backgroundColor, hoverColor, clickColor);
	}
	
	public TextButton(String text, int posX, int posY, int width, int height, Color color, BusEvent event, boolean selectableButton) {
		this(text, posX, posY, width, height, event, selectableButton);
		float red = color.r;
		float green = color.g;
		float blue = color.b;
		this.setColors(color, new Color(red + 10/255f, green + 10/255f, blue + 10/255f, 0), new Color(red - 10/255f, green - 10/255f, blue - 10/255f, 0));
	}
	
	/**
	 * Sets the colors of this button
	 * @param backgroundColor Normal color of the button.
	 * @param hoverColor Color of the button while hovered.
	 * @param clickColor Color of the button while clicked.
	 */
	private void setColors(Color backgroundColor, Color hoverColor, Color clickColor) {
		this.backgroundColor = backgroundColor;
		this.hoverColor = hoverColor;
		this.clickColor = clickColor;
		this.currentColor = backgroundColor;
	}
	
	/**
	 * Checks whether the mouse is hovering over this button or not.
	 * @param x X-position of the mouse.
	 * @param y Y-position of the mouse.
	 * @return True if mouse is over button, otherwise false.
	 */
	public boolean isMouseOver(int x, int y) {
		boolean withinX = x >= super.getPosX() && x <= super.getPosX() + getWidth();
		boolean withinY = y >= KCConstants.GAME_HEIGHT - super.getPosY() - getHeight() && y <= KCConstants.GAME_HEIGHT - super.getPosY(); // Mouse position is from upper left corner
		return withinX && withinY;
	}
	
	/**
	 * @return Text on this button.
	 */
	
	public void setText(String s){
		this.text = s;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * @return Current color of this button.
	 */
	public Color getCurrentColor() {
		return this.currentColor;
	}
	
	/**
	 * Change color of this button to the hover color.
	 */
	public void hover() {
		this.currentColor = this.hoverColor;
	}
	
	/**
	 * Change color of this button to the normal color.
	 */
	public void noHover() {
		this.currentColor = this.backgroundColor;
	}
	
	/**
	 * Change color of this button to the click color.
	 */
	public void buttonPressEvent() {
		this.currentColor = clickColor;
	}
	
	public void buttonReleaseEvent(){
		EventBusService.getInstance().publish(super.getEvent());
	}
	
	public void toggleSelect(){
		this.selected = !this.selected;
	}
	
	public boolean isSelected(){
		return this.selected;
	}
	
	public boolean isSelectable(){
		return this.selectableButton;
	}

	@Override
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer,
			FontUtil fontUtil) {
		// Background
		shapeRenderer.begin();
		shapeRenderer.setColor(this.currentColor);
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.rect(this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
		shapeRenderer.end();
		batch.begin();
		// Text
		fontUtil.setFont(Font.LATO_20);
		int fontPosX = fontUtil.getCenteredTextPos(this.getText(), this.getPosX(), this.width);
		int fontPosY = this.getPosY() + (int)(this.getHeight() + fontUtil.getTextHeight(this.text))/2;
		fontUtil.getFont().draw(batch, this.getText(), fontPosX, fontPosY);
		batch.end();
	}
}