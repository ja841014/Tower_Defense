package data;

public class EnemyRoute {
	
	Level level;
	
	int[][] route = new int[22][13];
	
	int RIGHT = 1;
	int DOWN = 2;
	int LEFT = 3;
	int UP = 4;
	
	int lastPos = -1;
	
	int xPos; 
	int yPos;
	
	
	
	int baseBlock = 3;
	Base base;
	// when we call the enemy route
	// we set the position they born
	// then we calculate the route
	public EnemyRoute(Level level) {
		this.level = level;
		
		
		this.xPos = this.level.spawnPoint.getX();
		this.yPos = this.level.spawnPoint.getY();
		
		calculateRoute();
	}

	private void calculateRoute() {
		// TODO Auto-generated method stub
		System.out.println("enemyRoute caculate route");
		while(base == null) {
			calculateNextPos();
		}
	}

	private void calculateNextPos() {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < 5; i++) {
			if(i != lastPos) {
				if(yPos > 0 && i == UP) {
					if(level.map[xPos][yPos - 1] == 1) {
						lastPos = DOWN;
						route[xPos][yPos] = UP;
						
						yPos = yPos - 1;
						break;
					}
					else if(level.map[xPos][yPos - 1] == baseBlock) {
						base = new Base(xPos, yPos);
						break;
					}
				}
				//
				if(xPos < 21 && i == RIGHT) {
					if(level.map[xPos + 1][yPos] == 1) {
						lastPos = LEFT;
						route[xPos][yPos] = RIGHT;
						
						xPos = xPos + 1;
						break;
					}
					else if(level.map[xPos + 1][yPos] == baseBlock) {
						base = new Base(xPos, yPos);
						break;
					}
				}
				//
				if(xPos > 0 && i == LEFT) {
					if(level.map[xPos - 1][yPos] == 1) {
						lastPos = RIGHT;
						route[xPos][yPos] = LEFT;
						
						xPos = xPos - 1;
						break;
					}
					else if(level.map[xPos - 1][yPos] == baseBlock) {
						base = new Base(xPos, yPos);
						break;
					}
				}
				//
				if(yPos < 12 && i == DOWN) {
					if(level.map[xPos][yPos + 1] == 1) {
						lastPos = UP;
						route[xPos][yPos] = DOWN;
						
						yPos = yPos + 1;
						break;
					}
					else if(level.map[xPos][yPos + 1] == baseBlock) {
						base = new Base(xPos, yPos);
						break;
					}
				}
			}
		}
	}
	
}
