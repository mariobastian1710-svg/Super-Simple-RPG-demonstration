package rpg_aol_alt;

public class Battle {
	private Character a;
	private Character b;
	
	public Battle(Character a, Character b) {
		this.a = a;
		this.b = b;
	}
	
	private void turn(Character attacker, Character defender) {
		attacker.onTurnStart();
		if(!attacker.isAlive()) return; // attacker dies from DoT
		defender.onTurnStart();
		attacker.attack(defender);
	}
	
	public Character fight() {
		while(a.isAlive() && b.isAlive()) {
			turn(a, b);
			if(b.isAlive()) {
				turn(b, a);
			}
		}
		
		Character winner = a.isAlive() ? a : b;
		Character defeated = (winner == a) ? b : a;
		if(winner == a) {
			victory(winner, defeated);
		} else {
			defeat(a); // in case the player lost
		}
		return winner;
	}
	
	private void defeat(Character player) {
		System.out.println(player.getName() + " was defeated..");
		player.heal(player.getMaxHp());
	}
	
	public void victory(Character winner, Character defeated) {
		System.out.println(winner.getName() + " is victorious!");
		winner.levelUp();
		// enemies have empty level up logic, they shouldn't be able to level up
		
		if(defeated instanceof Enemy enemy) {
			for (Item drop : enemy.itemDrops()) {
				System.out.println(enemy.getName() + " dropped " + drop.getName());
				winner.addItem(drop);
			}
		}
	}
}