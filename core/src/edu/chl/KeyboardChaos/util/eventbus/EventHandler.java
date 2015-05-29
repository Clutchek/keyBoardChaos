package edu.chl.KeyboardChaos.util.eventbus;
eventhandler
/*
 * Interface for all classes that will receive events
 */
public interface EventHandler {
	
	public void onEvent(BusEvent e);

}