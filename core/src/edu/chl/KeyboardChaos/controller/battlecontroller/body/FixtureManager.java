package edu.chl.KeyboardChaos.controller.battlecontroller.body;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

public class FixtureManager {

	private FixtureFactory fixtureFactory;
	private List<Body> bodiesToDelete;
	//private List<Fixture> fixtureList;
	private World world;
	
	public FixtureManager(World world){
		fixtureFactory = new FixtureFactory(world);
		bodiesToDelete = new ArrayList<Body>();
		//fixtureList = new ArrayList<Fixture>();
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
		System.out.println("Im in create Fixture");
		Body body = fixtureFactory.createBody(o);
		Fixture fixture = fixtureFactory.createFixture(body);
		
		//fixtureList.add(fixture);
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
		for(Body b : bodiesToDelete){
			System.out.println("add: " + b);
			
		}
		System.out.println("end");
	}
	
	/**
	 * This method <b>must be called between updates</b> in order to
	 * safely remove fixtures and their linked body.
	 * 
	 */
	public void deleteSelectedBodies(){
		while(!bodiesToDelete.isEmpty()){
			System.out.println(world.isLocked());
			Body body = bodiesToDelete.get(0);
			System.out.println("Removing: " + body);
			world.destroyBody(body);
			body.setUserData(null);
			body = null;
			bodiesToDelete.remove(0);
//			for(Body b : bodiesToDelete){
//				System.out.println("remove: " + b);
//				
//			}
//			System.out.println("end");
			}
//		System.out.println(bodiesToDelete);
//		System.out.println(world.getBodyCount());
	}
	
	public List<Body> getBodiesToDelete() {
		return this.bodiesToDelete;
	}
}
