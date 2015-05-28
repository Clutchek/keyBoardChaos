package edu.chl.KeyboardChaos.view.gui.component;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;



public class Label extends Component {

	String text;
	
	public Label(String text, int posX, int posY, BusEvent event) {
		super(posX, posY, event);
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
