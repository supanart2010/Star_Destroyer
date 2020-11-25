package rocket;

import logic.Hitable;
import logic.Moveable;
import logic.Sprite;

public class Rocket extends Sprite implements Moveable,Hitable{
	private int hp;
	private String name;
	private double speedX;
	//private double speedY;
	
	//Constructor
	public Rocket() {
		
		
		
		
		
		
	}

	//getter,setter
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	
	
	

}
