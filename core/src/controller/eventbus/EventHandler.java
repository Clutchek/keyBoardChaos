package controller.eventbus;

public interface EventHandler {
	
	public void onEvent(BusEvent e);

}