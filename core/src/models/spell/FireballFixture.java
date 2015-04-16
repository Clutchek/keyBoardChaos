package models.spell;

import java.util.Timer;
import java.util.TimerTask;

import models.player.Player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class FireballFixture {
	
	protected int damage, projectileSpeed;
	
	protected FixtureDef fdef;
	protected BodyDef bdef;
	protected Body body;
	protected World world;
	protected Player originPlayer;
	protected Fixture fixture;
	private Timer timer;
	private TimerTask task;
	
	
	public FireballFixture(int damage, int projectileSpeed, Player originPlayer){
		this.damage = damage;
		this.projectileSpeed = projectileSpeed;
		this.originPlayer = originPlayer;
		timer = new Timer();
		shoot();
		task = new TimerTask(){
			public void run(){
				dispose();
			}
		};
		timer.schedule(task, 2000);
		
		
		
	}
	
	protected void setDamage(int dmg){
		this.damage = dmg;
	}
	
	protected void increaseDamage(){
		
	}
	
	public void shoot(){
		createFixture();
		applyForce(new Vector2(1,1)); //This needs to get a vector that says in which direction the player is facing
	}
	
	protected void dispose(){
		this.body.destroyFixture(fixture);
	}
	
	protected void createFixture(){
		bdef = new BodyDef();
		bdef.type = BodyType.DynamicBody;
		
		Vector2 v = originPlayer.body.getPosition();
		float x = v.x;
		float y = v.y;
		
		x+=20f / 100f;
		y+=20f / 100f ;
		
		v = new Vector2(x,y);
		
		bdef.position.set(v);
		world = control.KeyboardChaosControl.getWorld();
		body = world.createBody(bdef);
		body.setUserData("spell");
		
		fdef = new FixtureDef();
		
		CircleShape shape = new CircleShape();
		
		shape.setRadius(3f / 100f);
		fdef.shape = shape;
		fdef.isSensor = true;
		fixture = body.createFixture(fdef);
	}
	
	protected void applyForce(Vector2 vector){
		float x = vector.x;
		float y = vector.y;
		
		x*=projectileSpeed*100;			//		This math is most likely
		y*=projectileSpeed*100;			//		in big need to tweaking
		
		Vector2 v = new Vector2(x, y);
		
		this.body.applyForceToCenter(v, true);
	}

}
