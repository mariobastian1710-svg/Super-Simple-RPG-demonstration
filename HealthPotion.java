package rpg_aol_alt;

public class HealthPotion extends Item {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getName() {
		return "Health Potion";
	}
	
	@Override
	public void use(Character target) {
		if(target.getHp() == target.getMaxHp()) {
			System.out.println("Health is already full");
			return;
		}
		target.heal(25);
	}
}