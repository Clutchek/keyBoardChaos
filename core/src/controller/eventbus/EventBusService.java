package controller.eventbus;

import java.util.ArrayList;
import java.util.List;

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
	
	public void subscribe(EventHandler handler){
		
	}
	
	public void unsubscribe(EventHandler handler){
		
	}
	
	public void publish(){
		
	}

}
