package view.gui;

import java.util.List;

import view.gui.component.TextButtonView;
import model.gui.Screen;
import model.gui.component.Component;
import model.gui.component.TextButton;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class UIView {
	
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont font;
	
	List<Component> components;
	
	TextButtonView textButtonView;
	
	public UIView (Screen startScreen) {
		this.batch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setAutoShapeType(true);
		this.font = new BitmapFont();
		this.components = startScreen.getComponents();
		
		this.textButtonView = new TextButtonView(batch, font, shapeRenderer);
	}
	
	public void render() {
		for (Component c : this.components) {
			if (c instanceof TextButton) {
				textButtonView.render((TextButton)c);
			}
		}
	}
	
	public void changeScreen(Screen screen) {
		this.components = screen.getComponents();
	}
}
