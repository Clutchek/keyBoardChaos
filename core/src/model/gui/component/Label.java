package model.gui.component;

import controller.eventbus.BusEvent;

public class Label extends Component {

	String text;
	
	public Label(String text, int posX, int posY, int width, int height, BusEvent event) {
		super(posX, posY, width, height, event);
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
