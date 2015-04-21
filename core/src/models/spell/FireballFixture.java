package models.spell;

import java.util.Timer;
import java.util.TimerTask;

import models.KCVars;
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
	
	private int damage, projectileSpeed;
	
	private FixtureDef fDef;
	private BodyDef bDef;
	private Body body;
	private World world;
	private Player player;
	private Fixture fixture;
	private Timer timer;
	private TimerTask task;
	private float fixtureRadius;
	
	
	public FireballFixture(int damage, int projectileSpeed, Player originPlayer){
		this.damage = damage;
		this.projectileSpeed = projectileSpeed;
		this.player = originPlayer;
		this.fixtureRadius = 3f;
		timer = new Timer();
		shoot();
		task = new TimerTask(){
			public void run(){
				models.KCVars.fixturesToDestroy.put(body, fixture);
			}
		};
		timer.schedule(task, 2000);
		
		
		
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void shoot(){
		if(player.getVector() != null){
			createFixture();
			//p.body.applyForceToCenter(direction, true);
			//applyForce(new Vector2(1,1)); //This needs to get a vector that says in which direction the player is facing
			applyForce(player.getVector());
		}
	}
	

	
	protected void dispose(){
//		if(fixture != null){						// ******************** //
//			this.body.destroyFixture(fixture);		// *** CAUSES ERROR *** //
//		}											// ******************** //
		System.out.println("trolololol");

	}
	
	protected void createFixture(){
		bDef = new BodyDef();
		bDef.type = BodyType.DynamicBody;
		
		Vector2 playerPos = player.getBody().getPosition();
		Vector2 distanceFromPlayer = new Vector2(player.getVector()).setLength(player.getBodyRadius() + this.fixtureRadius);
		float x = playerPos.x;
		float y = playerPos.y;
		
		x+= distanceFromPlayer.x / KCVars.PPM;
		y+= distanceFromPlayer.y / KCVars.PPM;
		
		bDef.position.set(new Vector2(x, y));
		world = control.KeyboardChaosControl.getWorld();
		body = world.createBody(bDef);
		
		fDef = new FixtureDef();
		
		fDef.filter.categoryBits = models.KCVars.BIT_SPELL;
		fDef.filter.maskBits = models.KCVars.MASK_SPELL;
		
		CircleShape shape = new CircleShape();
		
		shape.setRadius(fixtureRadius / 100f);
		fDef.shape = shape;

		fixture = body.createFixture(fDef);
		fixture.setUserData(this);
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
