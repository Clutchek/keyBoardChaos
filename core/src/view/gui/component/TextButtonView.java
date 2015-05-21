package view.gui.component;

import java.util.List;

import model.gui.component.TextButton;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class TextButtonView {
	private ShapeRenderer shapeRenderer;
	private BitmapFont font;
	private SpriteBatch batch;
	private GlyphLayout layout;
	
	public TextButtonView(SpriteBatch batch, BitmapFont font, ShapeRenderer shapeRenderer) {
		this.shapeRenderer = shapeRenderer;
		this.font = font;
		this.batch = batch;
		this.layout = new GlyphLayout();
	}
	
	public void render(TextButton button) {
		Color color = new Color(button.getCurrentColor().getRed()/255f, button.getCurrentColor().getGreen()/255f, button.getCurrentColor().getBlue()/255f, button.getCurrentColor().getAlpha());
		shapeRenderer.begin();
		shapeRenderer.setColor(color);
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.rect(button.getX(), button.getY(), button.getWidth(), button.getHeight());
		shapeRenderer.end();
		layout.setText(font, button.getText());
		int fontPosX = button.getX() + (int)(button.getWidth() - layout.width)/2;
		int fontPosY = button.getY() + (int)(button.getHeight() + layout.height)/2;
		batch.begin();
		font.draw(batch, button.getText(), fontPosX, fontPosY);
		batch.end();
	}
}