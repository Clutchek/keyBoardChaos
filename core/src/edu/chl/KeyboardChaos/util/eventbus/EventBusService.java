package edu.chl.KeyboardChaos.util.eventbus;

import java.util.ArrayList;
import java.util.List;
/*
 * A singleton class which other classes can subscribe to.
 * All subscribed classes will receive an event whenever an event i published by any class
 */
public class EventBusService {
	
	private static EventBusService ebs;
	private List<EventHandler> handlers;
	
	private EventBusService(){
		handlers = new ArrayList<EventHandler>();
		
	}
	
	public static EventBusService getInstance(){
		if(ebs == null){
			ebs = new EventBusService();
		}
		return ebs;
	}
	
	/**
	 * Adds an eventhandler to this service.
	 * @param handler
	 */
	public void subscribe(EventHandler handler){
		handlers.add(handler);
	}
	
	/**
	 * Removes an eventhandler from this service.
	 * @param handler the handler to be removed.
	 */
	public void unsubscribe(EventHandler handler){
		handlers.remove(handler);
	}
	
	/**
	 * 
	 */
	public void publish(BusEvent e){
		for(EventHandler handler: handlers){
			handler.onEvent(e);
		}
	}

}