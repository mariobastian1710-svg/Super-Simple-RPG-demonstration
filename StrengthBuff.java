package rpg_aol_alt;
import java.io.Serializable;

public class StrengthBuff implements StatusEffect, Serializable {
	private static final long serialVersionUID = 1L;
	
	private int turns;
	private int bonusAtk;
	
	public StrengthBuff(int duration, int bonus) {
		this.turns = duration;
		this.bonusAtk = bonus;
	}
	
	@Override
	public void apply(Character target) {
		target.addAtkBonus(bonusAtk);
	}
	
	@Override
	public void onTurnStart(Character target) {
		turns--;
	}
	
	@Override
	public void onExpire(Character target) {
		target.removeAtkBonus(bonusAtk);
	}
	
	@Override
	public boolean isExpired() {
		return turns <= 0;
	}
}