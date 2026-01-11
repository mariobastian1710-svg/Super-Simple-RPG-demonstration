package rpg_aol_alt;
import java.util.ArrayList;

public class SkeletonCaptain extends Enemy {
	private static final long serialVersionUID = 1L;
	
	SkeletonCaptain() {
		super("Skeleton Captain", 80, 3, new MeleeAttack());
	}
	
	@Override
	public ArrayList<Item> itemDrops() {
		ArrayList<Item> drops = new ArrayList<>();
		
		if(Math.random() < 0.6) {
			drops.add(new HealthPotion());
		}
		
		return drops;
	}

	@Override
	protected void restoreBehavior() {
		setAttackStrategy(new MeleeAttack());
	}
}