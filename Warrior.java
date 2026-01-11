package rpg_aol_alt;

class Warrior extends Character {
	private static final long serialVersionUID = 1L;
	
	Warrior(String name) {
		super(name, 120, 1, new MeleeAttack());
	}
	
	@Override
	protected void onLevelUp() {
		increaseMaxHp(12);
		addAtkBonus(3);
	}

	@Override
	protected void restoreBehavior() {
		setAttackStrategy(new MeleeAttack());
	}
}