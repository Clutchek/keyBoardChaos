package edu.chl.KeyboardChaos.util.eventbus;

import java.util.ArrayList;
import java.util.List;

public class EventBusService {
	
	private static EventBusService ebs;
	private static List<EventHandler> handlers;
	
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
	public static void subscribe(EventHandler handler){
		handlers.add(handler);
	}
	
	/**
	 * Removes an eventhandler from this service.
	 * @param handler the handler to be removed.
	 */
	public static void unsubscribe(EventHandler handler){
		handlers.remove(handler);
	}
	
	/**
	 * 
	 */
	public static void publish(BusEvent e){
		for(EventHandler handler: handlers){
			handler.onEvent(e);
		}
	}

}