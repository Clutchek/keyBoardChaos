package view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import controller.spellcontroller.FireballController;

public class FireballView extends View{
		
	private SpriteBatch spriteBatch;

	private static String path;


	public FireballView (){
		
		super(path);
		spriteBatch = new SpriteBatch();
		
		
	}
	
	private void paintFireball(FireballController f){
		// TODO: May need adjustments when it's possible to draw things up
		spriteBatch.draw(this.getTextureForVector(f.getVector()), f.getBody().getPosition().x, f.getBody().getPosition().y);
	}
	
	
	/**
	 * Method used to render the fireball's textures.
	 */
	public void render(FireballController f){
		paintFireball(f);
	}
	
	
	

}
