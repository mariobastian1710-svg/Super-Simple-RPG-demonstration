package rpg_aol_alt;

public class StrengthPotion extends Item {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getName() {
		return "Strength Potion";
	}
	
	@Override
	public void use(Character target) {
		target.addStatusEffect(new StrengthBuff(2, 10));
	}
}