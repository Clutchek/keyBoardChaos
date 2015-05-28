package view.gui;

import java.util.List;

import model.gui.Screen;
import model.gui.component.Component;
import model.gui.component.PlayerSettingsPanel;
import view.FontUtil;
import view.gui.component.LabelView;
import view.gui.component.SpellPanelView;
import view.gui.component.SpellBoxView;
import view.gui.component.TextButtonView;
import model.gui.component.Label;
import model.gui.component.SpellPanel;
import model.gui.component.SpellBox;
import model.gui.component.TextButton;
import view.gui.component.PlayerSettingsPanelView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class UIView {
	
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont font;
	FontUtil fontUtil;
	
	List<Component> components;
	
	TextButtonView textButtonView;
	PlayerSettingsPanelView pspView;
	SpellPanelView spellPanelView;
	SpellBoxView spellBoxView;
	LabelView labelView;
	
	public UIView (Screen screen) {
		this.batch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setAutoShapeType(true);
		this.fontUtil = new FontUtil();
		this.font = fontUtil.getFont();
		
		this.textButtonView = new TextButtonView(batch, font, shapeRenderer);
		this.pspView = new PlayerSettingsPanelView(batch, font, shapeRenderer);		
		this.spellPanelView = new SpellPanelView(batch, fontUtil.getFont(), shapeRenderer, fontUtil);
		this.spellBoxView = new SpellBoxView(batch, shapeRenderer);
		this.labelView = new LabelView(batch, fontUtil);
		
		this.components = screen.getComponents();
	}
	
	public void render() {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		for (Component c : this.components) {
			if (c instanceof TextButton) {
				textButtonView.render((TextButton)c);
			} else if (c instanceof SpellPanel) {
				spellPanelView.render((SpellPanel)c);
			} else if (c instanceof SpellBox) {
				spellBoxView.render((SpellBox)c);
			} else if (c instanceof Label) {
				labelView.render((Label)c);
			}
			if (c instanceof PlayerSettingsPanel){
				pspView.render((PlayerSettingsPanel)c);
			}
		}
	}
	
	public void changeScreen(Screen screen) {
		this.components = screen.getComponents();
	}
}
