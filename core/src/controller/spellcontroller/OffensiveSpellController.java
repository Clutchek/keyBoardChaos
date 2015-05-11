package controller.spellcontroller;

import model.main.DirectionVector;
import model.spell.OffensiveSpell;

import com.badlogic.gdx.math.Vector2;

public abstract class OffensiveSpellController implements SpellController{

	private Vector2 vector;
	private OffensiveSpell offensiveSpell;
	
	public OffensiveSpellController(OffensiveSpell s){
		this.offensiveSpell = s;
		vector.set((s.getVector().getX()), s.getVector().getY());
	}
	
	public Vector2 getVector(){
		return this.vector;
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
