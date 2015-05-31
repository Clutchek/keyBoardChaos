package edu.chl.KeyboardChaos.util.eventbus;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.util.eventbus.EventBusService;
import edu.chl.KeyboardChaos.util.eventbus.BusEventHandler;


public class TestEventBus implements BusEventHandler{
	
	private boolean test;
	
	@Before
	public void beforeTest(){
		test = false;
	}

	@Test
	public void testSubscribeAndPublish() {
		EventBusService bus = EventBusService.getInstance();
		bus.subscribe(this);
		bus.publish(new BusEvent("test"));
		assertTrue(test);
	}
	
	public void onEvent(BusEvent e){
		if(e.getBusCommand().equals("test"))
		test = true;
	}

}
