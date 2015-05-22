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
}
