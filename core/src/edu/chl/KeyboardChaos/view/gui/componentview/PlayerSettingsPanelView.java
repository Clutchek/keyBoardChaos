package edu.chl.KeyboardChaos.view.gui.componentview;




import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import edu.chl.KeyboardChaos.view.gui.component.PlayerSettingsPanel;
/*
 * This class is used to render a player settings panel
 */
public class PlayerSettingsPanelView {

	private ShapeRenderer shapeRenderer;
	private BitmapFont font;
	private SpriteBatch batch;
	private GlyphLayout layout;
	
	public PlayerSettingsPanelView(SpriteBatch batch, BitmapFont font, ShapeRenderer shapeRenderer){
		this.shapeRenderer = shapeRenderer;
		this.font = font;
		this.batch = batch;
		this.layout = new GlyphLayout();
	}
	
	public void render(PlayerSettingsPanel psp){
		Color color = new Color(psp.getPanelColor().getRed()/255f, psp.getPanelColor().getGreen()/255f, psp.getPanelColor().getBlue()/255f, psp.getPanelColor().getAlpha());
		shapeRenderer.begin();
		shapeRenderer.setColor(color);
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.rect(psp.getPosX(), psp.getPosY(), psp.getWidth(), psp.getHeight());
		shapeRenderer.end();
		batch.begin();
		batch.end();
	}
	
	
	
}
