package edu.chl.KeyboardChaos.util.eventbus;

import java.util.ArrayList;
import java.util.List;
/*
 * A singleton class which other classes can subscribe to.
 * All subscribed classes will receive an event whenever an event i published by any class
 */
public class EventBusService {
	
	private static EventBusService ebs;
	private List<BusEventHandler> handlers;
	
	private EventBusService(){
		handlers = new ArrayList<BusEventHandler>();
		
	}
	
	public static synchronized EventBusService getInstance(){
		if(ebs == null){
			ebs = new EventBusService();
		}
		return ebs;
	}
	
	/**
	 * Adds an eventhandler to this service.
	 * @param handler
	 */
	public void subscribe(BusEventHandler handler){
		handlers.add(handler);
	}
	
	/**
	 * Removes an eventhandler from this service.
	 * @param handler the handler to be removed.
	 */
	public void unsubscribe(BusEventHandler handler){
		handlers.remove(handler);
	}
	
	/**
	 * 
	 */
	public void publish(BusEvent e){
		// Copy handlers to a temporary list
		List<BusEventHandler> tmp = new ArrayList<BusEventHandler>();
		tmp.addAll(handlers);
		
		// Go through the temporary handlers
		for(BusEventHandler handler: tmp){
			handler.onEvent(e);
		}
	}

}