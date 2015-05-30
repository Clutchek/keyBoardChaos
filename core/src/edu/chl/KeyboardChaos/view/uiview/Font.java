package edu.chl.KeyboardChaos.view.uiview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
/*
 * A font and a size for a text
 */
public class Font {
	public final static BitmapFont EUPHEMIA_21 = new Font("assets/Euphemia.ttf", 21).getFont();
	public final static BitmapFont SLABO_43 = new Font("assets/Slabo.ttf", 43).getFont();
	public final static BitmapFont LATO_20 = new Font("assets/Lato.ttf", 20).getFont();
	
	private final BitmapFont font;
	
	public Font(String path, int size) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(path));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = size;
		this.font = generator.generateFont(parameter);
	}
	
	private BitmapFont getFont() {
		return this.font;
	}
}
