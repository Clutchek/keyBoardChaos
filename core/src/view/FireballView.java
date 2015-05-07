package view;

import java.util.ArrayList;
import java.util.Map;

import model.spell.Fireball;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import controller.gamestates.BattleState;

public class FireballView extends View{
		
	private SpriteBatch spriteBatch;

	
	private Map<Vector2, Texture> map;

	

	public FireballView (){
		
		
		
		
	}
	
	/**
	 * Method used to render the fireball's textures.
	 */
	public void render(){
		
	}
	

}
