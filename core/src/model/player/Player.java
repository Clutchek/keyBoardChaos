package model.player;

public class Player {
	
	private int healthPoints;
	private int size; //Radius? Diameter?
	private int posX, posY;
	
	private String playerName;
	
	private Spell spell1, spell2;

	private int moveUp, moveDown, moveRight, moveLeft, fireSpell1, fireSpell2;
	
	/*
	 * Questions:
	 * 
	 * Should Player take care of it's own movement, therefore needing a movement method?
	 * Or should the world/some manager take care of movement of all bodies?
	 */
	
	public Player(){
		
	}
	


	/**
	 * Decreases the players health points by a certains amount
	 * 
	 * @param dmg the amount of damage the players health should decrease by
	 */
	
	public void takeDamage(int dmg){
		healthPoints -= dmg;
	}
	
	/*
	 * Setters and getters
	 */
	
	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Spell getSpell1() {
		return spell1;
	}

	public void setSpell1(Spell spell1) {
		this.spell1 = spell1;
	}

	public Spell getSpell2() {
		return spell2;
	}

	public void setSpell2(Spell spell2) {
		this.spell2 = spell2;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getMoveUp() {
		return moveUp;
	}

	public void setMoveUp(int moveUp) {
		this.moveUp = moveUp;
	}

	public int getMoveDown() {
		return moveDown;
	}

	public void setMoveDown(int moveDown) {
		this.moveDown = moveDown;
	}

	public int getMoveRight() {
		return moveRight;
	}

	public void setMoveRight(int moveRight) {
		this.moveRight = moveRight;
	}

	public int getMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(int moveLeft) {
		this.moveLeft = moveLeft;
	}

	public int getFireSpell1() {
		return fireSpell1;
	}

	public void setFireSpell1(int fireSpell1) {
		this.fireSpell1 = fireSpell1;
	}

	public int getFireSpell2() {
		return fireSpell2;
	}

	public void setFireSpell2(int fireSpell2) {
		this.fireSpell2 = fireSpell2;
	}
}
