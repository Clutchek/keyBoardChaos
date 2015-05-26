package view.gui;

import java.util.List;

import model.gui.Screen;
import model.gui.component.Component;
import model.gui.component.PlayerSettingsPanel;
import model.gui.component.TextButton;
import view.gui.component.PlayerSettingsPanelView;
import view.gui.component.TextButtonView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class UIView {
	
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont font;
	
	List<Component> components;
	
	TextButtonView textButtonView;
	PlayerSettingsPanelView pspView;
	
	public UIView (Screen startScreen) {
		this.batch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setAutoShapeType(true);
		this.font = new BitmapFont();
		this.components = startScreen.getComponents();
		
		this.textButtonView = new TextButtonView(batch, font, shapeRenderer);
		this.pspView = new PlayerSettingsPanelView(batch, font, shapeRenderer);
	}
	
	public void render() {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		for (Component c : this.components) {
			if (c instanceof TextButton) {
				textButtonView.render((TextButton)c);
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
