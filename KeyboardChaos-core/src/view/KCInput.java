package view;

import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;

public class KCInput {
	
	public static final int GO_UP = 0;
	public static final int GO_DOWN = 1;
	public static final int GO_LEFT = 2;
	public static final int GO_RIGHT = 3;
	
	public static boolean doIt = false;
	
	private static HashMap<Integer, String> keysHM = new HashMap<Integer, String>();
	
	
	public static String getWhoMadeInput(int key){
		return keysHM.get(key);
			
	}
	
	public static void addToKeysHashMap(Integer key, String playerName){
		keysHM.put(key, playerName);
	}
	
	
	/*
	 * Slutade med att:
	 * 
	 * B�rja bygga metoder f�r att reagera p� input fr�n anv�ndare, avg�ra vilken spelare inputen g�ller, och sedan vidta passande �tg�rder.
	 * 
	 * Gissningsvis beh�vs det en metod som kollar input varje update, och de g�nger som hashmappen inneh�ller keyn som anv�nds, ska denna 
	 * returnera true och starta hela kedjan av anrop.
	 * 
	 * 
	 */
	
	
}
