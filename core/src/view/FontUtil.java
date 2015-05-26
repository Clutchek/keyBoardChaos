package view;
import model.gui.component.Component;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;


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
	
	public int getCenteredTextPos(String string, Component component) {
		int centerPoint = component.getPosX() + component.getWidth()/2;
		int textPos = centerPoint - this.getCenterOfText(string);
		return textPos;
	}
	
	public String wrapText(String string, int lineLength) {
		String newLine = "";
		String line = "";
		int startChar = 0;
		
		int i = 0;
		while (i < string.length()) {
			line = string.substring(startChar, i+1);
			this.glyphLayout.setText(font, line);
			if (this.glyphLayout.width > lineLength) {
				String s = string.substring(startChar, i);
				if (string.charAt(i) != ' ') {
					int lastSpace = s.lastIndexOf(' ');
					newLine += s.substring(0, lastSpace) + "\n";
					i = newLine.length();
				}
				
				startChar = i;
			} else if (i == string.length() - 1) {
				newLine += string.substring(startChar);
			}
			i++;
		}
		/*
		for (int i = 0; i < string.length(); i++) {
			line = string.substring(startChar, i+1);
			this.glyphLayout.setText(font, line);
			System.out.println("i: " + i + "; string.length(): " + string.length());
			if (this.glyphLayout.width > lineLength) {
				newLine += string.substring(startChar, i).trim() + "\n";
				startChar = i;
			} else if (i == string.length() - 1) {
				newLine += string.substring(startChar).trim();
			}
		}
		*/
		return newLine;
	}
}
