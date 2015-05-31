package edu.chl.KeyboardChaos.controller.battlecontroller.spellcontroller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import edu.chl.KeyboardChaos.controller.battlecontroller.body.FixtureManager;
import edu.chl.KeyboardChaos.model.player.Player;
import edu.chl.KeyboardChaos.model.spell.OffensiveSpell;
import edu.chl.KeyboardChaos.util.DirectionVector;
import edu.chl.KeyboardChaos.util.KCConstants;


/*
 * Abstract class for the handling of all attacking projectile spells 
 * It is used to keep a projectile spell on its correct position 
 */
public class OffensiveSpellController extends SpellController{

	private final OffensiveSpell offensiveSpell;
	private Vector2 vector;
	private FixtureManager fixtureManager;
	private Body body;
	
	public OffensiveSpellController(OffensiveSpell s,Player p, FixtureManager fixtureManager){
		super(s);
		this.offensiveSpell = s;
		offensiveSpell.setVector(new DirectionVector(p.getVector()));
		vector = new Vector2();
		this.fixtureManager = fixtureManager;
		createBody();
	}
	
	public void update(){
		super.update();
		if(body != null){
			body.setLinearVelocity(getVector().setLength(offensiveSpell.getProjectileSpeed()));
		}
		if(super.ticksActivated >= offensiveSpell.getDuration()*60){
			fixtureManager.addToDisposeList(getBody());
		}
		updatePosition();
	}
	
	private void updatePosition() {
		Vector2 position = body.getPosition();
		offensiveSpell.setPosX(position.x * KCConstants.PPM);
		offensiveSpell.setPosY(position.y * KCConstants.PPM);
	}
	
	public Vector2 getVector(){
		vector.x = offensiveSpell.getVector().getX();
		vector.y = offensiveSpell.getVector().getY();
		return vector;
	}
	
	public void setVector(float x, float y){
		this.vector.set(x, y);
		offensiveSpell.setVector(new DirectionVector(x, y));
	}
	
	public void setPosX(float x){
		offensiveSpell.setPosX(x);
	}
	
	public void setPosY(float y){
		offensiveSpell.setPosY(y);
	}
	
	public float getPosX(){
		return offensiveSpell.getPosX();
	}
	
	public float getPosY(){
		return offensiveSpell.getPosY();
	}
	
	private void createBody(){
		body = fixtureManager.createFixture(offensiveSpell).getBody();
		System.out.println("Creating");
	}
	
	public Body getBody(){
		return body;
	}
}
