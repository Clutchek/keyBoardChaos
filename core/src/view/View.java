package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class View {
	
	private Map<Vector2, Texture> map;
	private ArrayList<Texture> textureList;
	
	public View(){
		
		map = new HashMap<Vector2, Texture>();
		
	}
	
	

	public void fillMapWithIcons(){
		map.put(new Vector2(1, 0), null);
		map.put(new Vector2(1, 1), null);
		map.put(new Vector2(0, 1), null);
		map.put(new Vector2(-1, 1), null);
		map.put(new Vector2(-1, 0), null);
		map.put(new Vector2(-1, -1), null);
		map.put(new Vector2(0, -1), null);
		map.put(new Vector2(1, -1), null);
	}
	
	
	
}
