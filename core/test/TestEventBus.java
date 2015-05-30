import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;

import controller.eventbus.BusEvent;
import controller.eventbus.EventBusService;
import controller.eventbus.EventHandler;


public class TestEventBus implements EventHandler{
	
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
