package models;

import view.KeyboardChaosView;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import control.KeyboardChaosControl;

public class KeyboardChaosModel {

	private KeyboardChaosView view;
	private KeyboardChaosControl control;
	private World world;
	
	
	public KeyboardChaosModel(KeyboardChaosControl control){
		this.control = control;
		
	}

}
