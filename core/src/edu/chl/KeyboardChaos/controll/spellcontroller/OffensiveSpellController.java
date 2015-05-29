package edu.chl.KeyboardChaos.controll.spellcontroller;

import com.badlogic.gdx.math.Vector2;

import edu.chl.KeyboardChaos.model.spell.OffensiveSpell;
import edu.chl.KeyboardChaos.util.DirectionVector;


/*
 * Abstract class for the handling of all attacking projectile spells 
 * It is used to keep a projectile spell on its correct position 
 */
public abstract class OffensiveSpellController implements SpellController{

	private OffensiveSpell offensiveSpell;
	private Vector2 vector;
	
	public OffensiveSpellController(OffensiveSpell s){
		this.offensiveSpell = s;
		vector = new Vector2();
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
	
	public abstract void update();
	
	public abstract boolean isActive();
}
