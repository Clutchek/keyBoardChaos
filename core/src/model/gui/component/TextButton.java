package model.gui.component;

import java.awt.Color;

/**
 * A clickable button with text on it
 */
public class TextButton {

	private String text;
	private int posX, posY, width, height;
	private Color currentColor, backgroundColor, hoverColor, clickColor;
	
	/**
	 * Create a text button with a standard color of gray
	 * @param text Text to display on the button.
	 * @param posX X-position of the button.
	 * @param posY Y-position of the button.
	 * @param width Width of the button.
	 * @param height Height of the button.
	 */
	public TextButton(String text, int posX, int posY, int width, int height) {
		this.text = text;
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
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
	 */
	public TextButton(String text, int posX, int posY, int width, int height, Color backgroundColor, Color hoverColor, Color clickColor) {
		this(text, posX, posY, width, height);
		this.setColors(backgroundColor, hoverColor, clickColor);
	}
	
	public TextButton(String text, int posX, int posY, int width, int height, Color color) {
		this(text, posX, posY, width, height);
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		this.setColors(color, new Color(red + 10, green + 10, blue + 10), new Color(red - 10, green - 10, blue - 10));
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
	public void click() {
		this.currentColor = clickColor;
	}
}