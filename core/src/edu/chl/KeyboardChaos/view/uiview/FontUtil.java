package edu.chl.KeyboardChaos.view.uiview;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

/*
 * This class is used to make text strings
 * fit a surface regardless of its length
 * 
 */
public class FontUtil {
	private final GlyphLayout glyphLayout;
	private BitmapFont font;
	
	public FontUtil () {
		this.glyphLayout = new GlyphLayout();
		this.font = new BitmapFont();
	}
	
	public void setFont(BitmapFont font) {
		this.font = font;
	}
	
	public BitmapFont getFont() {
		return this.font;
	}
	
	public int getTextWidth(String string) {
		this.glyphLayout.setText(font, string);
		return (int)this.glyphLayout.width;
	}
	
	public int getTextHeight(String string) {
		this.glyphLayout.setText(font, string);
		return (int)glyphLayout.height;
	}
	
	public int getCenterOfText(String string) {
		return this.getTextWidth(string)/2;
	}
	
	public int getCenteredTextPos(String string, int posX, int width) {
		int centerPoint = posX + width/2;
		int textPos = centerPoint - this.getCenterOfText(string);
		return textPos;
	}
	
	public String wrapText(String string, int lineLength) {
		String newLine = "";
		String line = "";
		int startChar = 0;
		
		// Not the most optimal way to wrap
		int i = 0;
		while (i < string.length()) {
			line = string.substring(startChar, i+1); // Go through all characters one by one
			this.glyphLayout.setText(font, line);
			if (this.glyphLayout.width > lineLength) { // Check if the string with a specific font is longer than a specified length
				String s = string.substring(startChar, i);
				if (string.charAt(i) != ' ') { // Make new line where the last space is located
					int lastSpace = s.lastIndexOf(' ');
					newLine += s.substring(0, lastSpace) + "\n";
					i = newLine.length();
				}
				
				startChar = i;
			} else if (i == string.length() - 1) { // Add last bit
				newLine += string.substring(startChar);
			}
			i++;
		}
		return newLine;
	}
}
