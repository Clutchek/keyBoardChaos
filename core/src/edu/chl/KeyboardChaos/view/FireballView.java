package edu.chl.KeyboardChaos.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.chl.KeyboardChaos.model.spell.Fireball;



public class FireballView extends View{
		
	private SpriteBatch spriteBatch;

	private static String path = "assets/playerTextures/";


	public FireballView (SpriteBatch spriteBatch){
		
		super(path);
		this.spriteBatch = spriteBatch;
		
		
	}
	
	private void paintFireball(Fireball f){
		// TODO: May need adjustments when it's possible to draw things up
		spriteBatch.draw(this.getTextureForVector(f.getVector()), f.getPosX() - f.getFireballRadius(), f.getPosY() - f.getFireballRadius(), f.getFireballRadius()*2, f.getFireballRadius()*2);
	}
	
	
	/**
	 * Method used to render the fireball's textures.
	 */
	public void render(Fireball f){
		paintFireball(f);
	}
	
	
	

}
