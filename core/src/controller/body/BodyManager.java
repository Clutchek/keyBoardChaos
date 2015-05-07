package controller.body;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

public class BodyManager {

	private FixtureFactory fixtureFactory;
	private List fixtureToDelete;
	
	public BodyManager(World world){
		fixtureFactory = new FixtureFactory(world);
		fixtureToDelete = new ArrayList<Fixture>();
	}
	
	/**
	 * Creates and returns a libGDX Fixture with pre-determined values depending on what object
	 * that is being used as a parameter. This object can later be retrieved by calling the 
	 * returned Fixture's method [b]getUserData()[/b].
	 * 
	 * @param o The object that needs a libGDX component added to the world.
	 * @return
	 */
	public Fixture createFixture(Object o){
		
	}

	
	/**
	 * 
	 * 
	 * @param f
	 */
	public void addToDisposeList(Fixture f){
		fixtureToDelete.add(f);
	}
	
	public void deleteSelectedBodies(){
		
	}
}
