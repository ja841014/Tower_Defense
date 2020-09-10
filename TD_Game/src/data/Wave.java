package data;

public class Wave {
	Screen screen;
	
	int waveNumber = 0;
	int enemiesThisRound = 0;
	int enemiesperRound = 10;
	
	
	boolean waveSpawning;
	
	public Wave(Screen screen) {
		this.screen = screen;
	}
	
	// reset because next round is coming
	public void nextWave() {
		this.waveNumber++;
		this.enemiesThisRound = 0;
		this.waveSpawning = true;
		
		System.out.println("[Wave] wave" + this.waveNumber + "incoming!");
		// make sure 0 enemy
		for(int i = 0; i < this.screen.enemyMap.length; i++) {
			this.screen.enemyMap[i] = null;
		}
	}
	
	private int currentDelay = 0;
	private int spawnRate = 1000; // per frame
	
	// screen class will call this spawnEnemies as long as waveSpawnung == true
	public void spawnEnemies() {
		if(this.enemiesThisRound < this.waveNumber * this.enemiesperRound) {
			if(currentDelay < spawnRate) {
				currentDelay++;
			}
			else {
				currentDelay = 0;
				
				System.out.println("Wave Enemy Spawned");
				this.enemiesThisRound++;
				this.screen.spawnEnemy();
			}
		}
		else {
			this.waveSpawning = false;
		}
	}
	
}
