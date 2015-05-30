package edu.chl.KeyboardChaos.util.eventbus;
/*
 * This class holds an event in the form of a text string.
 */

public class BusEvent {

	/*public BusEvent(){
		
	}*/
	
	//private Object o;
	private String command;
	
	public BusEvent(String command){
		this.command = command;
	}
	
	public String getBusCommand(){
		return command;
	}
	
	//public object get
}