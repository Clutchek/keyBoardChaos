package edu.chl.KeyboardChaos.view.uiview.component;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import edu.chl.KeyboardChaos.controller.MatchStats;

public class MatchStatsView {

	private int posX;
	private int posY;
	private int width;
	private int height;

	private BitmapFont font;
	private ShapeRenderer sr;
	private MatchStats matchStats;

	public MatchStatsView(ShapeRenderer sr, MatchStats matchStats, int posX, int posY){

		this.posX = posX;
		this.posY = posY;
		this.width = 200;
		this.height = 200;
		this.matchStats = matchStats;
		this.font = new BitmapFont();
		this.sr = sr;
		this.sr = new ShapeRenderer();
		this.sr.setAutoShapeType(true);;

	}

	public void render(SpriteBatch sb){
		renderBlackBox();
		renderMatchStats(sb);
	}

	private void renderBlackBox(){
		sr.begin();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		sr.setColor(new Color(0, 0, 0, 0.5f));
		sr.set(ShapeType.Filled);
		sr.rect(posX, posY - 200, this.width, this.height);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		sr.end();
	}


	private void renderMatchStats(SpriteBatch sb){

		sb.begin();
		font.draw(sb, "Player   Kills Deaths Score", this.posX + 20, this.posY - 20);

		int tmp = 1;

		for(int i = 0; i < this.matchStats.getActivePlayers().size(); i++){

			font.draw(sb, "Player" + this.matchStats.getActivePlayers().get(i) + "     " + this.matchStats.getPlayerKills(matchStats.getActivePlayers().get(i)-1)
					+ "       " + this.matchStats.getPlayerDeaths(matchStats.getActivePlayers().get(i)-1)
					+ "        " + this.matchStats.getPlayerScore(matchStats.getActivePlayers().get(i)-1),
					this.posX + 20, this.posY - 20 - (20 * tmp));
			tmp++;
		}
		sb.end();
	}

	public int getWidth(){
		return this.width;
	}

	public int getHeight(){
		return this.height;
	}
}