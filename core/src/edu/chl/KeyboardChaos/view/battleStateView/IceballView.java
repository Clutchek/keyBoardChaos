package edu.chl.KeyboardChaos.view.battleStateView;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.chl.KeyboardChaos.model.spell.Iceball;


/*
 * This class renders the texture of a iceball that is fired during a battle in KeyboardChaos
 */
public class IceballView extends DynamicTextureView{
		
	private final SpriteBatch spriteBatch;

	private static final String path = "assets/Spells/Iceball/";


	public IceballView (SpriteBatch spriteBatch){
		
		super(path);
		this.spriteBatch = spriteBatch;
		
		
	}
	
	private void paintIceball(Iceball f){
		spriteBatch.draw(this.getTextureForVector(f.getVector()), f.getPosX() - f.getRadius(), f.getPosY() - f.getRadius(), f.getRadius()*2, f.getRadius()*2);
	}
	
	
	/**
	 * Method used to render the fireball's textures.
	 */
	public void render(Iceball f){
		paintIceball(f);
	}
	
	
	

}
