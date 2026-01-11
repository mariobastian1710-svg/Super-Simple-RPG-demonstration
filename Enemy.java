package rpg_aol_alt;
import java.util.ArrayList;

public abstract class Enemy extends Character {
	private static final long serialVersionUID = 1L;
	
	protected Enemy(String name, int hp, int lvl, AttackStrategy attackStrategy) {
		super(name, hp, lvl, attackStrategy);
	}
	
	public abstract ArrayList<Item> itemDrops();
	
	@Override
	protected boolean canLevelUp() {
		return false;
	}
}