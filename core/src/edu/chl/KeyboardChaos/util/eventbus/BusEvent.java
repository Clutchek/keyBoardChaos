package edu.chl.KeyboardChaos.util.eventbus;

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