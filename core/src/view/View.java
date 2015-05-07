package view;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class View {
	
	private Map<Vector2, Texture> map;
	private ArrayList<Texture> textureList;
	
	private File textureDirectory;
	
	public View(File textureDirectory){
		
		map = new HashMap<Vector2, Texture>();
		this.textureDirectory = textureDirectory;
		
	}
	
	

	public void fillMapWithIcons(ArrayList<Texture> t){
		map.put(new Vector2(0, 1), t.get(0));
		map.put(new Vector2(1, 1), t.get(1));
		map.put(new Vector2(1, 0), t.get(2));
		map.put(new Vector2(1, -1), t.get(3));
		map.put(new Vector2(0, -1), t.get(4));
		map.put(new Vector2(-1, -1), t.get(5));
		map.put(new Vector2(-1, 0), t.get(6));
		map.put(new Vector2(1, -1), t.get(7));
	}
	
	
	protected ArrayList<Texture> getTextureList(){
		return textureList;
	}
	
	protected void loadListWithTextures(){
		for(int i = 0; i < textureDirectory.list().length; i++){
			textureList.add(i, new Texture(textureDirectory.list()));
		}
	}
	
	
	
}
