package control;

import models.KCVars;
import models.player.Player;
import models.spell.Spell;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class KCContactListener implements ContactListener {

	/*
	 * This is a help class that, when implemented, will check 
	 * when two entities are in contact, and take the appropriate
	 * action.
	 */
	
	
	@Override
	public void beginContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		if(fa.getUserData() != null && fb.getUserData() != null){
			System.out.println("fa: " + fa.getUserData().toString());
			System.out.println("fb: " + fb.getUserData().toString());
			if(){
				KCVars.playerIsInLava = true;
			}else if((fa.getUserData().equals("spell") || fb.getUserData().equals("spell"))
					&&
					(fa.getUserData().equals("player") || fb.getUserData().equals("player"))){
				System.out.println("Hit!");	
				
			}
			
			System.out.println("Boop");
		}
		
	}

	@Override
	public void endContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();

		if(fa.getUserData() != null && fb.getUserData() != null){
			if((fa.getUserData().equals("lava") || fb.getUserData().equals("lava"))
				&&
				(fa.getUserData().equals("player") || fb.getUserData().equals("player"))){
				KCVars.playerIsInLava = false;
			}else if((fa.getUserData().equals("spell") || fb.getUserData().equals("spell"))
					&&
					(fa.getUserData().equals("player") || fb.getUserData().equals("player"))){
				System.out.println("Hit!");	

			}
		}
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}

	public static KCInput getInstance(){
		if(kc == null){
			kc = new KCInput();
		}
		return kc;
	}
	
	private boolean isPlayerSpellCollision(Fixture fa, Fixture fb){
		Object oa = fa.getUserData();
		Object ob = fb.getUserData();
		
		if((oa instanceof Player && ob instanceof Spell)
				||
			(oa instanceof Spell && ob instanceof Player)){
			return true;
		}else return false;
	}
	
	private boolean isPlayerLavaCollision(Fixture fa, Fixture fb){
		Object oa = fa.getUserData();
		Object ob = fb.getUserData();
		
		if(oa.equals("lava")){
			return ob instanceof Player; 
		}else if(ob.equals("lava")){
			return oa instanceof Player;
		}else return false;
	}
	private boolean isSpellWorldWallCollision(Fixture fa, Fixture fb){
		Object oa = fa.getUserData();
		Object ob = fb.getUserData();
		
		if(oa.equals("world wall")){ //Unsure what this should be equals to, since it's not yet created
			return ob instanceof Spell;
		}else if(ob.equals("world wall")){
			return oa instanceof Player;
		}else return false;
	}
	
	private boolean isSpellObstacleCollsion(Fixture fa, Fixture fb){
		Object oa = fa.getUserData();
		Object ob = fb.getUserData();
		
		if(oa.equals("obstacle")){ //Same goes here, this might end up as an object
			return ob instanceof Spell;
		}else if(ob.equals("obstale")){
			return oa instanceof Spell;
		}else return false;
		
		
	}
	
	
	
	
	

}
