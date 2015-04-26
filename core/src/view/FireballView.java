package view;

import java.util.ArrayList;

import model.spell.Fireball;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import controller.gamestates.BattleState;

public class FireballView implements Disposable {
		
	private SpriteBatch spriteBatch;

	private World world;
	private BattleView battleView;
	
	private BattleState battleState;
	
	private ArrayList<Fireball> fireBalls;
	
	private BodyDef bDef;
	private Body body;
	private FixtureDef fDef;
	private Fixture fixture;

	public FireballView (BattleState battleState){
		
		this.battleState = battleState;
		
		this.bDef = new BodyDef();
		
		this.fDef = new FixtureDef();
		
		
	}
	
	public void AddFireBallToView(Fireball fireball, Body b){
		fireBalls.add(fireball);
		
		
		
	}
	
	
	@Override
	public void dispose() {
		
	}

}
