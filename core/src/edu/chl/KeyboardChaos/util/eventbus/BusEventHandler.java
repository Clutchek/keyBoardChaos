package edu.chl.KeyboardChaos.util.eventbus;

/*
 * Interface for all classes that will receive events
 */
public interface BusEventHandler {
	
	public void onEvent(BusEvent e);

}