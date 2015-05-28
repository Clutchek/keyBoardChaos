package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Font {
	public final static BitmapFont ARIAL_20 = new Font("assets/Arial.ttf", 20).getFont();
	public final static BitmapFont INIKA_40 = new Font("assets/Inika-Regular.ttf", 40).getFont();
	public final static BitmapFont MYRIAD_60 = new Font("assets/Myriad.otf", 60).getFont();
	
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
