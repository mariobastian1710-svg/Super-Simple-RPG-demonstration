package rpg_aol_alt;
import java.util.*;
import java.io.Serializable;

abstract class Character implements Serializable { // inherit from here
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private int maxHp; // instead of private, so it can be used for level up logic
	private int hp;
	private int lvl;
	protected final int MAX_LVL = 10;
	
	private int bonusAtk = 0; // atk will be modifiable via item
	protected transient AttackStrategy attackStrategy; // characters don't have unique attacks this way
	
	private ArrayList<Item> inv;
	private ArrayList<StatusEffect> statusEffects = new ArrayList<>();
	
	Character(String name, int hp, int lvl, AttackStrategy attackStrategy) {
		this.name = name;
		this.maxHp = hp;
		this.hp = hp;
		this.lvl = lvl;
		this.attackStrategy = attackStrategy;
		this.inv = new ArrayList<>();
	}
	
	protected void onLevelUp() { }
	// initially abstract for player classes, changed so enemy classes aren't forced to have this as well
	
	protected boolean canLevelUp() {
		return true;
	}
	
	public final void levelUp() {
		if(!canLevelUp()) return;
		if(lvl >= MAX_LVL) return;
		lvl++;
		onLevelUp();
		hp = maxHp;
	}
	
	public void increaseMaxHp(int amount) {
		maxHp += amount;
	}
	
	public void attack(Character target) {
		int damage = attackStrategy.calculateDamage(this);
		target.takeDamage(damage);
		System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage!");
	}
	
	public void takeDamage(int damage) {
		hp = Math.max(0, hp - damage);
	}
	
	public void heal(int healAmt) {
		hp = Math.min(maxHp, hp + healAmt);
	}
	
	public boolean isAlive() {
		return this.hp > 0;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean hasItems() {
		return !inv.isEmpty();
	}
	
	public List<Item> viewInventory() {
		return Collections.unmodifiableList(inv); // new thing, returns read-only
	}
	
	public void addItem(Item item) {
		inv.add(item);
	}
	
	public void useItem(Item item, Character target) {
		item.use(target);
		inv.remove(item);
	}
	
	public void addStatusEffect(StatusEffect effect) {
		effect.apply(this);
		statusEffects.add(effect);
	}
	
	public void onTurnStart() { // iterate through applied effects
		Iterator<StatusEffect> effectsList = statusEffects.iterator();
		while(effectsList.hasNext()) {
			StatusEffect effect = effectsList.next();
			effect.onTurnStart(this);
			if(effect.isExpired()) {
				effect.onExpire(this);
				effectsList.remove();
			}
		}
	}
	
	// for potions
	
	public int getAtkPower() {
		return lvl + bonusAtk;
	}
	
	public void addAtkBonus(int amount) { // will be used by both items and leveling
		bonusAtk += amount;
	}
	
	public void removeAtkBonus(int amount) {
		bonusAtk -= amount;
	}
	
	// for saving/loading
	
	protected void setAttackStrategy(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}
	
	abstract protected void restoreBehavior();

	public int getHp() {
		return hp;
	}

	public int getMaxHp() {
		return maxHp;
	}
	
	// for viewing character
	
	@Override
	public String toString() {
		return "Name: " + name +
				"\nLevel: " + lvl +
				"\nHP: " + hp + "/" + maxHp +
				"\nAttack Power: " + getAtkPower();
	}	
}