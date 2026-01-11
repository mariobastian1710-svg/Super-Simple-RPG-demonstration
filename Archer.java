package rpg_aol_alt;

class Archer extends Character {
	private static final long serialVersionUID = 1L;
	
	Archer(String name) {
		super(name, 80, 1, new RangedAttack(0.25)); // 25% crit chance
	}
	
	@Override
	protected void onLevelUp() {
		increaseMaxHp(10);
		addAtkBonus(3);
	}
	
	@Override
	protected void restoreBehavior() {
		setAttackStrategy(new RangedAttack(0.25));
	}
}