package edu.chl.KeyboardChaos.view.gui;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import edu.chl.KeyboardChaos.view.gui.component.Component;
import edu.chl.KeyboardChaos.view.gui.screen.Screen;
/*
 * This class renders all the visuals of
 * any screen in the GUI state of KeyboardChaos
 */
public class UIView {
	
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont font;
	FontUtil fontUtil;
	
	List<Component> components;
	
	public UIView (Screen screen) {
		this.batch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setAutoShapeType(true);
		this.fontUtil = new FontUtil();
		this.font = fontUtil.getFont();
		
		this.components = screen.getComponents();
	}
	
	public void render() {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		for (Component c : this.components) {
			c.render(batch, shapeRenderer, fontUtil);
		}
	}
	
	public void changeScreen(Screen screen) {
		this.components = screen.getComponents();
	}
}
