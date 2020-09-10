package data;

public class EnemyMove {
	
	Enemy enemy;
	
	double xPos;
	double yPos;
	
	boolean attack;
	
	int routePosx;
	int routePosY;
	
	int health;
	
	public EnemyMove(Enemy enemy, SpawnPoint spawnPoint ) {
		this.enemy = enemy;
		
		// grid position
		this.routePosx = spawnPoint.getX();
		this.routePosY = spawnPoint.getY();
		// pixal represent !! this tower size might be wrong ep.15 9: 10
		this.xPos = spawnPoint.getX() * (int)Screen.towerSize;
		this.yPos = spawnPoint.getY() * (int)Screen.towerSize;
		
		this.attack = false;
		this.health = enemy.health;
		
	}
	// when enemy call this update class, will take enemy call this update class
	public EnemyMove update() {
		EnemyMove currentEnemyMove = this; // this means this class
		
		if(currentEnemyMove.health <= 0) {
			return null;
		}
		return currentEnemyMove;
	}
	
}