package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import control.KeyboardChaosControl;

public class KeyboardChaosView {

	private KeyboardChaosControl control;
	private float timeCheck;

	
	public KeyboardChaosView(KeyboardChaosControl control){
		this.control = control;
	}
	
	public void render () {
		
		//Clears Screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		/*
		 * Updates at our chosen rate, simple logic. timeCheck gets the 
		 * value of the time that has passed, when this time exceeds
		 * the time we've chosen for every update it subtracts the 
		 * delta time. Rinse and repeat
		 */
		timeCheck += Gdx.graphics.getDeltaTime();
		while(timeCheck >= models.KCVars.TIME_STEP){
			timeCheck -= models.KCVars.TIME_STEP;
			control.getGSM().update(models.KCVars.TIME_STEP);
			
		}
		
		//Renders the map
		control.getMapRenderer().setView(control.getWorldCam());
		control.getMapRenderer().render();
		
		//Renders our box2d units
		control.getB2dr().render(control.getWorld(), control.getb2dCam().combined);
		
	}
}
