package edu.chl.KeyboardChaos.view.uiview.screen;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import edu.chl.KeyboardChaos.util.KCConstants;
import edu.chl.KeyboardChaos.view.uiview.FontUtil;
import edu.chl.KeyboardChaos.view.uiview.component.Component;
/*
 * This class renders all the visuals of
 * any screen in the GUI state of KeyboardChaos
 */
public class ScreenView {
	
	private final SpriteBatch batch;
	private final ShapeRenderer shapeRenderer;
	private final FontUtil fontUtil;
	
	private List<Component> components;
	
	private final OrthographicCamera uiCam;
	
	public ScreenView (Screen screen) {
		this.batch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setAutoShapeType(true);
		this.fontUtil = new FontUtil();
		
		this.components = screen.getComponents();
		
		uiCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		uiCam.translate(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		uiCam.update();
		batch.setProjectionMatrix(uiCam.combined);
		shapeRenderer.setProjectionMatrix(uiCam.combined);
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
