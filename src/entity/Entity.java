package entity;

import logic.Sprite;
import logic.Updatable;

public class Entity extends Sprite implements Updatable{
	private String name;
	private int hp;
	private int type;
	private int damage;
	private boolean isDead;
	
	public Entity(String name, int hp) {
		super(positionX,positionY,width,height);
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
