package control;

import models.player.Player;
import models.spell.Spell;

import com.badlogic.gdx.physics.box2d.Fixture;


public class KCInput {
	
	 /*
	 * A help class for our input processor.
	 * Will decide what kind of bodies that is colliding
	 */
	private static KCInput kc;
	
//	public static boolean goUp = false;
//	public static boolean goDown = false;
//	public static boolean goLeft = false;
//	public static boolean goRight = false;
	
	public static KCInput getInstance(){
		if(kc == null){
			kc = new KCInput();
		}
		return kc;
	}
	
	public boolean isPlayerSpellCollision(Fixture fa, Fixture fb){
		Object oa = fa.getUserData();
		Object ob = fb.getUserData();
		
		if((oa instanceof Player && ob instanceof Spell)
				||
			(oa instanceof Spell && ob instanceof Player)){
			return true;
		}else return false;
	}
	
	public boolean isPlayerLavaCollision(Fixture fa, Fixture fb){
		Object oa = fa.getUserData();
		Object ob = fb.getUserData();
		
		if(oa.equals("lava")){
			return ob instanceof Player; 
		}else if(ob.equals("lava")){
			return oa instanceof Player;
		}else return false;
	}
	public boolean isSpellWorldWallCollision(Fixture fa, Fixture fb){
		Object oa = fa.getUserData();
		Object ob = fb.getUserData();
		
		if(oa.equals("world wall")){ //Unsure what this should be equals to, since it's not yet created
			return ob instanceof Spell;
		}else if(ob.equals("world wall")){
			return oa instanceof Player;
		}else return false;
	}
	
	public boolean isSpellObstacleCollsion(Fixture fa, Fixture fb){
		Object oa = fa.getUserData();
		Object ob = fb.getUserData();
		
		if(oa.equals("obstacle")){ //Same goes here, this might end up as an object
			return ob instanceof Spell;
		}else if(ob.equals("obstale")){
			return oa instanceof Spell;
		}else return false;
		
		
	}
	
	
	
	
	
}
