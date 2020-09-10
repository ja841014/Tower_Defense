package data;

public class EnemyAI {
	
	public static EnemyRoute route;
	
	public static EnemyAIMove moveAI;
	
	// destination
	public static int basePosX;
	public static int basePosY;
	
	
	public int id;
	
	// we will create a enemy AI eachtime when we load a new level
	public EnemyAI(Level level) {
		// caluculate the route
		route = new EnemyRoute(level);
		
		basePosX = route.base.xPos;
		basePosY = route.base.yPos;
		
		moveAI = new  EnemyAIMove(0);
	}
	
	public EnemyAI(int id) {
		this.id = id;
	}
	
	public EnemyRoute getRoute() {
		return route;
	}
}
