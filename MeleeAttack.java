package rpg_aol_alt;

public class MeleeAttack implements AttackStrategy {
	@Override
	public int calculateDamage(Character attacker) {
		return 5 + attacker.getAtkPower() * 3;
	}
}