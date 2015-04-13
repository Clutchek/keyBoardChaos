package view;

import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;

public class KCInput {
	
	public static boolean goUp = false;
	public static boolean goDown = false;
	public static boolean goLeft = false;
	public static boolean goRight = false;
	

	

	
	private static HashMap<Integer, String> keysHM = new HashMap<Integer, String>();
	
	
	public static String getWhoMadeInput(int key){
		return keysHM.get(key);
			
	}
	
	public static void addToKeysHashMap(Integer key, String playerName){
		keysHM.put(key, playerName);
	}
	
	public static void setUp(boolean boo){
		goUp = boo;
	}
	
	public static void setDown(boolean boo){
		goDown = boo;
	}
	
	public static void setRight(boolean boo){
		goRight = boo;
	}
	
	public static void setLeft(boolean boo){
		goLeft = boo;
	}
	
	
	/*
	 * Possibly a useless class, but stays for now
	 * 
	 * 
	 */
	
	
}
