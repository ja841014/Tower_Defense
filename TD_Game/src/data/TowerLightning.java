package data;

public class TowerLightning extends Tower{

	public TowerLightning(int id, int cost, int range, int damage, int maxAttackTime, int maxAttackDelay) {
		super(id, cost, range, damage, maxAttackTime, maxAttackDelay);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void towerAttack(int x, int y, EnemyMove enemy) {
		// TODO Auto-generated method stub
		enemy.health -= this.damage;

	}
	
	
}