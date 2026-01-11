package rpg_aol_alt;

public interface StatusEffect {
	void apply(Character target);
	
	void onTurnStart(Character target);
	
	void onExpire(Character target);
	
	boolean isExpired();
}