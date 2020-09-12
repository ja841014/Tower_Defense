package data;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {
	
	public double x;
	public double y;
	public int speed;// bullet speed
	
	public double direction;
	
	public int damage;
	
	public EnemyMove target;
	
	Image texture = new ImageIcon("res/Tower/bullets/missile.png").getImage();
	
	public Missile(double x, double y, int speed, int damage, EnemyMove target) {
		this.x = x;
		this.y = y;
		
		this.damage = damage;
		
		this.speed = speed;
		
		this.target = target;
		
		updateDirection();
		
		
	}
	public void update() {
		
		updateDirection();
		// our Direction is in radium
		this.x += speed * Math.cos(direction);
		this.y += speed * Math.sin(direction);
		
		checkTarget();
		
	}
	public void checkTarget() {
		int deltaX = (int)(Screen.towerSize * 2 + this.target.xPos - Screen.towerSize/2 - this.x - 10);
		int deltaY = (int)(Screen.towerSize * 2 + this.target.yPos - Screen.towerSize/2 - this.y - 10);
		
		int deltaRadius = 1 + 1;
		
		if(deltaX * deltaX + deltaY * deltaY <= deltaRadius * deltaRadius ) {
			this.target.health -= this.damage;
			this.target = null;
		}
		
	}
	
	
	public void updateDirection() {
		this.direction = Math.atan2(Screen.towerSize * 2 + this.target.yPos - Screen.towerSize/2 - this.y - 10, Screen.towerSize * 2 + this.target.xPos - Screen.towerSize/2 - this.x - 10);
	}
}
