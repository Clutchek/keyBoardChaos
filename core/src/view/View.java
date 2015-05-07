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
		textureList = new ArrayList<Texture>();
		this.textureDirectory = textureDirectory;
		this.loadListWithTextures();
		this.fillMapWithIcons();
		
		
	}
	
	

	public void fillMapWithIcons(){
		map.put(new Vector2(0, 1), textureList.get(0));
		map.put(new Vector2(1, 1), textureList.get(1));
		map.put(new Vector2(1, 0), textureList.get(2));
		map.put(new Vector2(1, -1), textureList.get(3));
		map.put(new Vector2(0, -1), textureList.get(4));
		map.put(new Vector2(-1, -1), textureList.get(5));
		map.put(new Vector2(-1, 0), textureList.get(6));
		map.put(new Vector2(1, -1), textureList.get(7));
	}
	
	
	protected ArrayList<Texture> getTextureList(){
		return textureList;
	}
	
	protected void loadListWithTextures(){
		for(String s : textureDirectory.list()){
			textureList.add(new Texture(textureDirectory.getPath() + s));
		}
	}
	
	
	
}
