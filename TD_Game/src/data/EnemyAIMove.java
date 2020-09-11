package data;

public class EnemyAIMove extends EnemyAI{

	public EnemyAIMove(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public void move(EnemyMove enemy) {
//		System.out.println("ENEMYAIMOVE");
		// here have tower size!! careful
		// if it in the exacntly on the corner. this condition is corner case.
		if(enemy.xPos % (int)Screen.towerSize == 0 && enemy.yPos % (int)Screen.towerSize == 0 && enemy.routePosx == enemy.xPos/ (int)Screen.towerSize && enemy.routePosY == enemy.yPos/ (int)Screen.towerSize) {
			// behind the base
			if(enemy.routePosx == basePosX && enemy.routePosY == basePosY) {
				enemy.attack =true;
			}
			// on the road
			else {
				if(route.route[enemy.routePosx][enemy.routePosY] == route.UP) {
					enemy.routePosY--;
				}
				else if(route.route[enemy.routePosx][enemy.routePosY] == route.RIGHT) {
					enemy.routePosx++;
				}
				else if(route.route[enemy.routePosx][enemy.routePosY] == route.DOWN) {
					enemy.routePosY++;
				}
				else if(route.route[enemy.routePosx][enemy.routePosY] == route.LEFT) {
					enemy.routePosx--;
				}
				else {
					cantFindRoute();
				}
			}
		}
		else {
			// the Screen.towersize might dangerous
			double xPos = enemy.xPos / Screen.towerSize;
			double yPos = enemy.yPos / Screen.towerSize;
			if(xPos > enemy.routePosx) {
				enemy.xPos = enemy.xPos - (enemy.enemy.speed );
			}
			if(xPos < enemy.routePosx) {
				enemy.xPos = enemy.xPos + (enemy.enemy.speed  );
			}
			if(yPos > enemy.routePosY) {
				enemy.yPos = enemy.yPos - (enemy.enemy.speed );
			}
			if(yPos < enemy.routePosY) {
				enemy.yPos = enemy.yPos + (enemy.enemy.speed );
			}
		}
	}
	
	public void cantFindRoute() {
		System.out.println("[EnemyAIMove] Can't find next move!");
	}
	
}
