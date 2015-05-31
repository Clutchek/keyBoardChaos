package edu.chl.KeyboardChaos.view.uiview.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.view.uiview.FontUtil;

/**
 * GUI component containing an event.
 */
public abstract class EventComponent extends Component {

	private final BusEvent event;
	
	public EventComponent(int posX, int posY, BusEvent event) {
		super(posX, posY);
		this.event = event;
	}

	@Override
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer,
			FontUtil fontUtil) {
		
	}

	/**
	 * @return The BusEvent of this component.
	 */
	public BusEvent getEvent() {
		return this.event;
	}
}
