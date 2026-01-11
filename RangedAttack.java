package rpg_aol_alt;
import java.util.Random;

public class RangedAttack implements AttackStrategy {
	// to compensate for (physical) ranged attacks being this weak, it will have a critical chance determined by the character
	private double critChance;
	private int critMultiplier;
	private Random rng = new Random();
	
	public RangedAttack(double critChance) {
		this.critChance = critChance;
		this.critMultiplier = 2;
	}
	
	@Override
	public int calculateDamage(Character attacker) {
		int baseDamage = 5 + attacker.getAtkPower();
		if(rng.nextDouble() < critChance) {
			return baseDamage * critMultiplier;
		}
		return baseDamage;
	}
}