package rpg_aol_alt;

class Mage extends Character {
	private static final long serialVersionUID = 1L;
	
	Mage(String name) {
		super(name, 80, 1, new BasicSpellAttack());
	}
	
	@Override
	protected void onLevelUp() {
		increaseMaxHp(10);
		addAtkBonus(4);
	}

	@Override
	protected void restoreBehavior() {
		setAttackStrategy(new BasicSpellAttack());
	}
}