package edu.chl.KeyboardChaos.controller.battlecontroller.body;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

public class FixtureManager {

	private FixtureFactory fixtureFactory;
	private final List<Body> bodiesToDelete;
	private World world;
	
	public FixtureManager(World world){
		fixtureFactory = new FixtureFactory(world);
		bodiesToDelete = new ArrayList<Body>();
		this.world = world;
		
	}
	
	/**
	 * Creates and returns a libGDX Fixture with pre-determined values depending on what object
	 * that is being used as a parameter. This object can later be retrieved by calling the 
	 * returned Fixture's method <b>getUserData()</b>.
	 * 
	 * @param o The object that needs a libGDX component added to the world.
	 * @return the newly created fixture, with a reference to the object parameter
	 * in the fixtures method <b>getUserData()</b>
	 */
	public Fixture createFixture(Object o){
		Body body = fixtureFactory.createBody(o);
		Fixture fixture = fixtureFactory.createFixture(body);
		return fixture;
	}

	
	/**
	 * Adds a fixture to a list of fixtures so they can be removed safely
	 * between updates.
	 * 
	 * @param f The fixture that should be removed 
	 */
	public void addToDisposeList(Body body){
		if(body != null && !bodiesToDelete.contains(body)){	
			bodiesToDelete.add(body);
		}
	}
	
	/**
	 * This method <b>must be called between updates</b> in order to
	 * safely remove fixtures and their linked body.
	 * 
	 */
	public void deleteSelectedBodies(){
		while(!bodiesToDelete.isEmpty()){
			Body body = bodiesToDelete.get(0);
			world.destroyBody(body);
			body.setUserData(null);
			body = null;
			bodiesToDelete.remove(0);
			}
	}
	
	public List<Body> getBodiesToDelete() {
		return this.bodiesToDelete;
	}
}
