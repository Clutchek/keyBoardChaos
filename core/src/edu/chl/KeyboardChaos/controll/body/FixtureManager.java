package edu.chl.KeyboardChaos.controll.body;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

public class FixtureManager {

	private FixtureFactory fixtureFactory;
	private List<Fixture> fixtureToDelete;
	private List<Fixture> fixtureList;
	private World world;
	
	public FixtureManager(World world){
		fixtureFactory = new FixtureFactory(world);
		fixtureToDelete = new ArrayList<Fixture>();
		fixtureList = new ArrayList<Fixture>();
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
		
		fixtureList.add(fixture);
		return fixture;
	}

	
	/**
	 * Adds a fixture to a list of fixtures so they can be removed safely
	 * between updates.
	 * 
	 * @param f The fixture that should be removed 
	 */
	public void addToDisposeList(Fixture f){
		fixtureToDelete.add(f);
	}
	
	/**
	 * This method <b>must be called between updates</b> in order to
	 * safely remove fixtures and their linked body.
	 * 
	 */
	public void deleteSelectedBodies(){
		for(Fixture f : fixtureToDelete){
			Body body = f.getBody();
			body.destroyFixture(f);
			world.destroyBody(body);
			fixtureToDelete.remove(f);
		}
	}
}
