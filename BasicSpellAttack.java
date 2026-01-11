package rpg_aol_alt;

public class BasicSpellAttack implements AttackStrategy {
	@Override
	public int calculateDamage(Character attacker) { // design expansion: if characters have def, spells ignore it
		return 8 + attacker.getAtkPower() * 2;
	}
}