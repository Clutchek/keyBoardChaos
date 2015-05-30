package edu.chl.KeyboardChaos.view.uiview.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import edu.chl.KeyboardChaos.util.eventbus.BusEvent;
import edu.chl.KeyboardChaos.view.uiview.Font;
import edu.chl.KeyboardChaos.view.uiview.FontUtil;


/*
 * This class represents a text label
 */
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

	@Override
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer,
			FontUtil fontUtil) {
		batch.begin();
		fontUtil.setFont(Font.SLABO_43);
		fontUtil.getFont().draw(batch, this.getText(), this.getPosX() - fontUtil.getTextWidth(this.getText())/2, this.getPosY());
		batch.end();
	}
}
