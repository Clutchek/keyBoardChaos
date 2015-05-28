package edu.chl.KeyboardChaos.util;

import java.io.Serializable;

public class DirectionVector implements Serializable{
	
	private float x;
	private float y;
	
	public DirectionVector(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public DirectionVector(DirectionVector vector) {
		this(vector.getX(), vector.getY());
	}
	
	public float getY(){
		return y;
	}
	
	public float getX(){
		return x;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DirectionVector)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		
		DirectionVector vector = (DirectionVector)obj;
		return vector.x == this.x && vector.y == this.y;
	}
	
	@Override
	public int hashCode() {
		// TODO: Maybe change float to int as it basically will only have x, y = 0 || 1.
		return (int)(17*x + 31*y);
	}
}
