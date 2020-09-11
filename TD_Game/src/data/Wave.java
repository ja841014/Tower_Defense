package data;

import java.util.Random;

public class Wave {
	Screen screen;
	
	int waveNumber = 0;
	int pointsThisRound;
	
	int currentpoints;

	
	
	boolean waveSpawning;
	
	public Wave(Screen screen) {
		this.screen = screen;
	}
	
	// reset because next round is coming
	public void nextWave() {
		this.waveNumber++;
		this.pointsThisRound = this.waveNumber * 10;
		this.currentpoints = 0;
		this.waveSpawning = true;
		
		System.out.println("[Wave] wave" + this.waveNumber + "incoming!");
		// make sure 0 enemy
		for(int i = 0; i < this.screen.enemyMap.length; i++) {
			this.screen.enemyMap[i] = null;
		}
	}
	
	private int currentDelay = 0;
	private int spawnRate = 75; // per frame
	
	// screen class will call this spawnEnemies as long as waveSpawnung == true
	public void spawnEnemies() {
		if(this.currentpoints < this.pointsThisRound) {
			if(currentDelay < spawnRate) {
				currentDelay++;
			}
			else {
				currentDelay = 0;
				
				int[] enemiesSpawnableID = new int[Enemy.enemyList.length];
				int enemiesSpawnableSoFar = 0;
				
				System.out.println("Wave Enemy Spawned");
				for(int i = 0; i < Enemy.enemyList.length; i++) {
					if(Enemy.enemyList[i] != null) {
						if(Enemy.enemyList[i].point + currentpoints <= this.pointsThisRound && Enemy.enemyList[i].point <= this.waveNumber) {
							
							enemiesSpawnableID[enemiesSpawnableSoFar] = Enemy.enemyList[i].id;
							enemiesSpawnableSoFar++;
						}
					}
				}
				
				int enemyID = new Random().nextInt(enemiesSpawnableSoFar);
				this.currentpoints += Enemy.enemyList[enemyID].point;
				this.screen.spawnEnemy(enemiesSpawnableID[enemyID]);
				
			}
		}
		else {
			this.waveSpawning = false;
		}
	}
	
}
