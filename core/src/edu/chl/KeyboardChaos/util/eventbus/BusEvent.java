package edu.chl.KeyboardChaos.util.eventbus;
/*
 * This class holds an event in the form of a text string.
 */

public class BusEvent {

	/*public BusEvent(){
		
	}*/
	
	private Object object;
	private final String command;
	
	public BusEvent(String command){
		this.command = command;
		this.object = null;
	}
	
	public BusEvent(String command, Object o){
		this(command);
		object = o;
	}
	
	public String getBusCommand(){
		return command;
	}
	
	public Object getObject(){
		return object;
	}
}