package rpg_aol_alt;
import java.util.ArrayList;

public class Dragon extends Enemy {
	private static final long serialVersionUID = 1L;
	
	Dragon() {
		super("Skeleton Dragon", 160, 5, new BasicSpellAttack());
	}
	
	@Override
	public ArrayList<Item> itemDrops() {
		ArrayList<Item> drops = new ArrayList<>();
		
		if(Math.random() < 0.8) {
			drops.add(new HealthPotion());
		}
		if(Math.random() < 0.4) {
			drops.add(new StrengthPotion());
		}
		
		return drops;
	}

	@Override
	protected void restoreBehavior() {
		setAttackStrategy(new BasicSpellAttack());
	}
}