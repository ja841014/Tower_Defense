package data;

public class TowerMissile extends Tower {

	public TowerMissile(int id, int cost, int range, int damage, int maxAttackTime, int maxAttackDelay) {
		super(id, cost, range, damage, maxAttackTime, maxAttackDelay);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void towerAttack(int x, int y, EnemyMove enemy) {
		// TODO Auto-generated method stub
		for(int i = 0; i < Screen.missiles.length; i++) {
			if(Screen.missiles[i] == null) {
				Screen.missiles[i] = new Missile((int)(Screen.towerSize + x * Screen.towerSize), (int)(Screen.towerSize + y * Screen.towerSize), 10, 3 , enemy);
				break;
			}
			
		}
	}

}
