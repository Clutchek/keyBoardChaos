package control;

import models.KCVars;

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
			if((fa.getUserData().equals("lava") || fb.getUserData().equals("lava"))
				&&
				(fa.getUserData().equals("player") || fb.getUserData().equals("player"))){
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

	

}
