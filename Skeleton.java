package rpg_aol_alt;
import java.util.ArrayList;

public class Skeleton extends Enemy {
	private static final long serialVersionUID = 1L;
	
	Skeleton() {
		super("Skeleton Soldier", 40, 1, new MeleeAttack());
	}
	
	@Override
	public ArrayList<Item> itemDrops() {
		ArrayList<Item> drops = new ArrayList<>();
		
		if(Math.random() < 0.3) {
			drops.add(new HealthPotion());
		}
		
		return drops;
	}

	@Override
	protected void restoreBehavior() {
		setAttackStrategy(new MeleeAttack());
	}
}