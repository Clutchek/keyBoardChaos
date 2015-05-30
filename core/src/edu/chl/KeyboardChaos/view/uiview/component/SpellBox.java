package edu.chl.KeyboardChaos.view.uiview.component;



import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import edu.chl.KeyboardChaos.model.spell.Spell;
import edu.chl.KeyboardChaos.model.spell.Spell.SpellEnum;
import edu.chl.KeyboardChaos.view.uiview.FontUtil;

/*
 * This class represents a box in which a player can
 * iterate through all available spells and choose 
 * the spell that the player desires
 */
public class SpellBox extends Component {
	
	public final static int SIZE = 135;
	private final Color backgroundColor, highlightColor;
	private SpellEnum spell;
	private boolean isSelected;
	private Label spellLabel;

	private final Map<SpellEnum, Texture> textureMap;
	
	public SpellBox(int posX, int posY, Spell spell) {
		super(posX, posY, null);
		this.spell = SpellEnum.getSpellEnum(spell);
		this.isSelected = false;
		this.backgroundColor = Color.valueOf("282828");
		this.highlightColor = Color.valueOf("ff8900");
		
		textureMap = new HashMap<SpellEnum, Texture>();
		loadTextures();
	}
	
	private void loadTextures() {
		this.textureMap.put(SpellEnum.FIREBALL, createTexture("assets/Fireball.png"));
		this.textureMap.put(SpellEnum.ICE, createTexture("assets/Water.png"));
	}
	
	private Texture createTexture(String path) {
		return new Texture(Gdx.files.internal(path));
	}
	
	public Spell getSpell() {
		return this.spell.getSpell();
	}
	
	public boolean isSelected() {
		return this.isSelected;
	}
	
	public void toggleSelected() {
		this.isSelected = !isSelected;
	}
	
	public void nextSpell() {
		this.spell = spell.next();
	}
	
	public void previousSpell() {
		this.spell = spell.previous();
	}
	
	public Color getBackgroundColor() {
		return this.backgroundColor;
	}
	
	public Color getHighlightColor() {
		return this.highlightColor;
	}

	@Override
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer,
			FontUtil fontUtil) {
		// Draw background 
		shapeRenderer.begin();
		// TODO: Color coverter
		shapeRenderer.setColor(this.backgroundColor);
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.rect(this.getPosX(), this.getPosY(), this.SIZE, this.SIZE);
		if (this.isSelected()) {
			shapeRenderer.setColor(this.highlightColor);
			Gdx.gl20.glLineWidth(2);
			shapeRenderer.set(ShapeType.Line);
			shapeRenderer.rect(this.getPosX() + 1, this.getPosY() - 1, this.SIZE - 1, this.SIZE + 1);
		}
		shapeRenderer.end();
		Gdx.gl20.glLineWidth(1);

		// Draw the texture of selected spell
		batch.begin();
		Texture texture = this.textureMap.get(this.spell);
		batch.draw(texture, this.getPosX(), this.getPosY(), this.SIZE, this.SIZE);
		batch.end();
	}
}
