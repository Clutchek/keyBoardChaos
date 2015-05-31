package edu.chl.KeyboardChaos.view.battleStateView;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.chl.KeyboardChaos.model.spell.Fireball;


/*
 * This class renders the texture of a fireball that is fired during a battle in KeyboardChaos
 */
public class FireballView extends View{
		
	private final SpriteBatch spriteBatch;

	private static final String path = "assets/Spells/Fireball/";


	public FireballView (SpriteBatch spriteBatch){
		
		super(path);
		this.spriteBatch = spriteBatch;
		
		
	}
	
	private void paintFireball(Fireball f){
		spriteBatch.draw(this.getTextureForVector(f.getVector()), f.getPosX() - f.getRadius(), f.getPosY() - f.getRadius(), f.getRadius()*2, f.getRadius()*2);
	}
	
	
	/**
	 * Method used to render the fireball's textures.
	 */
	public void render(Fireball f){
		paintFireball(f);
	}
	
	
	

}
