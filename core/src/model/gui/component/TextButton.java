package model.gui.component;

import java.awt.Color;

/**
 * A clickable button with text on it
 */
public class TextButton implements Component {

	private String text;
	private int posX, posY, width, height;
	private Color currentColor, backgroundColor, hoverColor, clickColor;
	private boolean selectableButton;
	
	/**
	 * Create a text button with a standard color of gray
	 * @param text Text to display on the button.
	 * @param posX X-position of the button.
	 * @param posY Y-position of the button.
	 * @param width Width of the button.
	 * @param height Height of the button.
	 * @param selectableButton if the button is selectable
	 */
	public TextButton(String text, int posX, int posY, int width, int height, boolean selectableButton) {
		this.text = text;
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.selectableButton = selectableButton;
		this.setColors(new Color(152,152,152), new Color(165,165,165), new Color(139,139,139));
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
	 * @param selectableButton if the button is selectable
	 */
	public TextButton(String text, int posX, int posY, int width, int height, Color backgroundColor, Color hoverColor, Color clickColor, boolean selectableButton) {
		this(text, posX, posY, width, height, selectableButton);
		this.setColors(backgroundColor, hoverColor, clickColor);
		this.selectableButton = selectableButton;
	}
	
	public TextButton(String text, int posX, int posY, int width, int height, Color color, boolean selectableButton) {
		this(text, posX, posY, width, height, selectableButton);
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		this.setColors(color, new Color(red + 10, green + 10, blue + 10), new Color(red - 10, green - 10, blue - 10));
		this.selectableButton = selectableButton;
	}
	
	/**
	 * Sets the colors of this button
	 * @param backgroundColor Normal color of the button.
	 * @param hoverColor Color of the button while hovered.
	 * @param clickColor Color of the button while clicked.
	 * @param selectableButton if the button is selectable
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
		boolean withinX = x >= posX && x <= posX + width;
		boolean withinY = y >= 480 - posY - height && y <= 480 - posY; // Mouse position is from upper left corner
		return withinX && withinY;
	}
	
	/**
	 * @return X-position of this button.
	 */
	public int getX() {
		return this.posX;
	}
	
	/**
	 * @return Y-position of this button.
	 */
	public int getY() {
		return this.posY;
	}
	
	/**
	 * @return Width of this button.
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * @return Height of this button.
	 */
	public int getHeight() {
		return this.height;
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
		
	}
	
	public boolean isSelectable(){
		return this.selectableButton;
	}
}