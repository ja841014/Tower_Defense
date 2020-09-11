package data;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
public class Tower implements Cloneable{
	
	public String textureFile = "";
	public Image texture;
	
	// tower array;
	public static final Tower[] towerlist = new Tower[36];
	
	public static final Tower lightningTower = new TowerLightning(0, 10, 2, 4, 150, 15).getTextureFile("lightningtower");
	public static final Tower lightningTower2 = new TowerLightning(1, 25, 3, 6, 150, 15).getTextureFile("backup");
	public static final Tower lightningTower3 = new TowerLightning(2, 50, 4, 6, 150, 12).getTextureFile("magictower");
	public static final Tower lightningTower4 = new TowerLightning(3, 75, 5, 10, 210, 21).getTextureFile("magictower");

	
	public int id;
	public int cost;
	public int range;
	
	public int damage;
	
	public int attackTime; //(timer) How long do we want the laser to stay on?	
	public int attackDelay;// (timer) = cooldown Pause between each attack
	
	public int maxAttackTime;
	public int maxAttackDelay;
	
	public int FIRST = 1; /** Attack enemy the nearst base*/
	public int RANDOM = 2; /** Attack random enemy*/ 
	
	
	public int attackStrategy = RANDOM; // attack first? attack strong enemy?
	
	public EnemyMove target;
	
	public Tower(int id, int cost, int range, int damage, int maxAttackTime, int maxAttackDelay) {
		if(towerlist[id] != null) {
			System.out.println("Tower Initialization: Two tower with same ID: ID : " + id);
		}
		else {
			towerlist[id] = this;
			this.id = id;
			this.cost = cost;
			this.range = range;
			this.damage = damage;
			
			this.maxAttackTime = 0;
			this.attackDelay = 0;
		}
	}
	
	// find the enemy location
	/** 
	 * 
	 * @param what kinds of enemy
	 * @param tower x position
	 * @param tower y position
	 * */
	public EnemyMove calculateEnemy(EnemyMove[] enemies, int x, int y) {
		// which of the enemies given are in the our range?
		EnemyMove[] enemiesInRange = new EnemyMove[enemies.length];
		
		int towerX = x;
		int towerY = y;
		
		int towerRadius = this.range;
		int enemyRadius = 1;
		
		int enemyX;
		int enemyY;
		
		for(int i = 0; i < enemies.length; i++) {
			if(enemies[i] != null) {
				enemyX = (int) (enemies[i].xPos / Screen.towerSize);
				enemyY = (int) (enemies[i].yPos / Screen.towerSize);
				
				int dx = enemyX - towerX;
				int dy = enemyY - towerY;
				int dradius = towerRadius + enemyRadius;
				if(dx * dx + dy * dy < dradius) {
					// enemy is in the shooting area
					enemiesInRange[i] = enemies[i];
				}
			}
		}
		// count how many enemy in the range
		if(this.attackStrategy == RANDOM) {
			int totalEnemies = 0;
			for(int i = 0; i < enemiesInRange.length; i++) {
				if(enemiesInRange[i] != null) {
					totalEnemies++;
				}
				
			}
			if(totalEnemies > 0) {
				
				int enemy = new Random().nextInt(totalEnemies);
				int enemiesTaken = 0;
				int i = 0;
				
				while (true) {
					if(enemiesTaken == enemy && enemiesInRange[i] != null) {
						return enemiesInRange[i];

					}
					
					if(enemiesInRange[i] != null) {
						enemiesTaken++;
					}
					
					i++;
				}
			}
			
		}
		
		return null;
	}
	
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	// get image
	public Tower getTextureFile(String str) {
		this.textureFile = str;
		this.texture = new ImageIcon("res/Tower/" + this.textureFile + ".png").getImage();
		
		
		return null;
	}
}