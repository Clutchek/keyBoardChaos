package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import control.KeyboardChaosControl;

public class KeyboardChaosView {

	private KeyboardChaosControl control;
//	private SpriteBatch sb;
//	private Box2DDebugRenderer b2dr;
	
	public KeyboardChaosView(KeyboardChaosControl control){
		
		this.control = control;
//		this.sb = this.control.getSpriteBatch();
		
//		this.b2dr = new Box2DDebugRenderer();
		
	}
	
	
	public void render () {
		
		
		control.timeCheck += Gdx.graphics.getDeltaTime();
		while(control.timeCheck>= control.STEP){
			control.timeCheck -= control.STEP;
			control.gsm.update(control.STEP);
			control.gsm.render();
		}
	}
}
