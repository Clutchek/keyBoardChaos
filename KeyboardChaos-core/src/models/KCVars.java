package models;

import com.badlogic.gdx.math.Vector2;

public class KCVars {
	
	// Main window width and height
	public static final int GAME_WIDTH = 720, GAME_HEIGHT = 500;
	
	//Pixels per meter ratio
	public static final int PPM = 100;
	
	//Bits used to decide which bodies that will collide with what
	
	public static final short BIT_PLAYER = 1;
	public static final short BIT_SPELL = 2;
	public static final short BIT_OBSTACLE = 4;
	
	//Updates per second
	public static final float TIME_STEP = 1 / 60f;
	
	//Gravity of world - probably not gonna be used
	
	//public static final Vector2 GRAVITY = new Vector2(0f, -9.82f);
	public static final Vector2 GRAVITY = new Vector2(0f, 0);
	
	
	//Game mode ID numbers
	
	public static final int STANDARD_MODE = 6352354;
	
}
