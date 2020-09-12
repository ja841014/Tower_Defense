package data;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	// maximum kinds of
	public static final Enemy[] enemyList = new Enemy[20];
	
	public static final Enemy SLIM_ENEMY = new EnemySlime(0, 5, 2, 200, 1, 1, 4).getTextureFile("EnemySlime.png");
	public static final Enemy ENEMY2 = new EnemySlime(1, 5, 5, 300, 2, 2, 7).getTextureFile("enemy2.png");
	public static final Enemy ENEMY3 = new EnemySlime(2, 5, 10, 400, 5, 3, 3).getTextureFile("enemy3.png");
	public static final Enemy ENEMY4 = new EnemySlime(3, 5, 20, 500, 10, 5, 2).getTextureFile("enemy4.png");

	public String textureFile = "";
	public Image texture = null;
	
	public int id;
	// moster price when kill
	public int price;
	public double speed;
	public double attackSpeed;
	public int damage;
	public int health;
	public int point; // how much this enemy worth? level must be over/[or at] the amount of points to spawn
	
	
	public Enemy(int id, int price, int damage, int health, int point, double speed, double attackSpeed) {
		if(enemyList[id] != null) {
			System.out.println("[Tower Initialization] Two enemies with same ID");
		}
		else {
			enemyList[id] = this;
			this.id = id;
			this.price = price;
			this.damage = damage;
			this.health = health;
			this.point = point;
			this.speed = speed;
			this.attackSpeed = attackSpeed;
		}
	}
	
	public Enemy getTextureFile(String str) {
		// we add some information to this enemy
		// and return to enemy
		this.textureFile = str;
		this.texture = new ImageIcon("res/Enemy/" + this.textureFile).getImage();
		
		return this;
	}
	
	
	public static void startup() {
		
	}
	
	
}