package edu.chl.KeyboardChaos.view.gui.componentview;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import edu.chl.KeyboardChaos.view.gui.component.TextButton;

public class TextButtonView {
	private ShapeRenderer shapeRenderer;
	private BitmapFont font;
	private SpriteBatch batch;
	private GlyphLayout layout;
	/*
	 * This class is used to render a button containing a text
	 */
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
		shapeRenderer.rect(button.getPosX(), button.getPosY(), button.getWidth(), button.getHeight());
		shapeRenderer.end();
		layout.setText(font, button.getText());
		int fontPosX = button.getPosX() + (int)(button.getWidth() - layout.width)/2;
		int fontPosY = button.getPosY() + (int)(button.getHeight() + layout.height)/2;
		batch.begin();
		font.draw(batch, button.getText(), fontPosX, fontPosY);
		batch.end();
	}
}