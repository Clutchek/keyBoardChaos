package view.gui.component;

import view.Font;
import view.FontUtil;
import model.gui.component.SpellPanel;
import model.gui.component.SpellBox;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class SpellPanelView {

	private final SpriteBatch batch;
	BitmapFont font;
	private final ShapeRenderer shapeRenderer;
	private final FontUtil fontUtil;
	
	public SpellPanelView(SpriteBatch batch, BitmapFont font, ShapeRenderer shapeRenderer, FontUtil fontUtil) {
		this.batch = batch;
		this.font = font;
		this.shapeRenderer = shapeRenderer;
		this.fontUtil = fontUtil;
	}
	
	public void render(SpellPanel panel) {
		// Draw the background rectangle
		shapeRenderer.begin();
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.rect(panel.getPosX(), panel.getPosY(), panel.WIDTH, panel.HEIGHT);
		shapeRenderer.end();
		
		// Draw the text
		batch.begin();
		
		fontUtil.setFont(Font.INIKA_40);
		int playerNamePosX = fontUtil.getCenteredTextPos(panel.getPlayerName(), panel.getPosX(), panel.WIDTH);
		//fontUtil.getFont().draw(batch, panel.getPlayerName(), playerNamePosX, panel.getHeight() + panel.getPosY() - 10);
		
		SpellBox spellBox1 = panel.getSpellBox1();
		SpellBox spellBox2 = panel.getSpellBox2();
		
		fontUtil.setFont(Font.ARIAL_20);
		int spellTextPosY = spellBox1.getPosY() + spellBox1.SIZE + fontUtil.getTextHeight(panel.getSpell1().getName()) + 10;
		fontUtil.getFont().draw(batch, panel.getSpell1().getName(), fontUtil.getCenteredTextPos(panel.getSpell1().getName(), spellBox1.getPosX(), SpellBox.SIZE), spellTextPosY);
		fontUtil.getFont().draw(batch, panel.getSpell2().getName(), fontUtil.getCenteredTextPos(panel.getSpell2().getName(), spellBox2.getPosX(), SpellBox.SIZE), spellTextPosY);
		
		// TODO: Only wrap when new spell is selected
		fontUtil.getFont().draw(batch, fontUtil.wrapText(panel.getSelectedSpell().getDescription(), (spellBox2.getPosX() + SpellBox.SIZE) - spellBox1.getPosX()), spellBox1.getPosX(), spellBox1.getPosY() - 20);
		batch.end();
	}
}
