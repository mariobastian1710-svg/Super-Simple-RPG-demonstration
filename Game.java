package rpg_aol_alt;
import java.util.*;

public class Game {
	Character player;
	Scanner sc = new Scanner(System.in);
	
	public void startGame() {
		mainMenu();
	}
	
	private void mainMenu() {
		while (true) {
			System.out.println("MAIN MENU");
			System.out.println("1. New Game");
			System.out.println("2. Load Game");
			System.out.println("3. Exit Game");
			
			if(!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("That's not a number");
				continue;
			}
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				newGame();
				break;
			case 2:
				player = GameSaveManager.load();
				if(player != null) {
					inGameMenu();
				}
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("That choice is invalid");
				continue;
			}
		}
	}
	
	private void newGame() {
		System.out.print("Enter your character's name: ");
		String name = sc.nextLine();
		if(name.isBlank()) {
			name = "Player";
		}
		
		System.out.println("Choose a class:");
		System.out.println("1. Warrior");
		System.out.println("2. Mage");
		System.out.println("3. Archer");
		
		if(!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("That's not a number");
			return;
		}
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
			case 1:
				player = new Warrior(name);
				break;
			case 2:
				player = new Mage(name);
				break;
			case 3:
				player = new Archer(name);
				break;
			default:
				System.out.println("That's not a choice");
				return;
		}
		
		inGameMenu();
	}
	
	private Enemy enemySpawner() {
		Random rng = new Random();
		int roll = rng.nextInt(6) + 1;
		
		if(roll <= 3) {
			return new Skeleton();
		} else if (roll <= 5) {
			return new SkeletonCaptain();
		} else {
			return new Dragon();
		}
	}
	
	private void itemMenu() {
		List<Item> items = player.viewInventory();
		if(!player.hasItems()) {
			System.out.println("Your inventory is empty");
			return;
		}
		
		for(int i = 0; i < items.size(); i++) {
			System.out.println((i + 1) + ". " + items.get(i).getName());
		}
		
		if(!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("That's not a number");
			return;
		}
		int choice = sc.nextInt() - 1;
		sc.nextLine();
		if(choice < 0 || choice >= items.size()) {
			System.out.println("That choice is invalid");
			return;
		}
		
		Item chosen = items.get(choice);
		System.out.println("Used a " + chosen.getName());
		player.useItem(items.get(choice), player);
	}
	
	private void inGameMenu() {
		while(player.isAlive()) {
			System.out.println("GAME MENU");
			System.out.println("1. Fight an enemy");
			System.out.println("2. Use an item");
			System.out.println("3. Save game");
			System.out.println("4. View your character");
			System.out.println("5. Return to Main Menu");
			
			if(!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("That's not a number");
				continue;
			}
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				Enemy enemy = enemySpawner();
				System.out.println("You've encountered a " + enemy.getName());
				
				Battle battle = new Battle(player, enemy);
				battle.fight();
				break;
			case 2:
				itemMenu();
				break;
			case 3:
				GameSaveManager.save(player);
				break;
			case 4:
				System.out.println(player);
				break;
			case 5:
				return;
			default:
				System.out.println("An invalid choice");
				return;
			}
		}
		System.out.println("Game's over");
	}
}