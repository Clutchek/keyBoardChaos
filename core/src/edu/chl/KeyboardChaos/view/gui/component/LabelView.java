package edu.chl.KeyboardChaos.view.gui.component;



import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.chl.KeyboardChaos.model.gui.component.Label;
import edu.chl.KeyboardChaos.view.Font;
import edu.chl.KeyboardChaos.view.FontUtil;

public class LabelView {
	private final SpriteBatch batch;
	private final FontUtil fontUtil;
	
	public LabelView(SpriteBatch batch, FontUtil fontUtil) {
		this.batch = batch;
		this.fontUtil = fontUtil;
	}
	
	public void render(Label label) {
		batch.begin();
		fontUtil.setFont(Font.INIKA_40);
		fontUtil.getFont().draw(batch, label.getText(), label.getPosX() - fontUtil.getTextWidth(label.getText())/2, label.getPosY());
		batch.end();
	}
}
