package rpg_aol_alt;
import java.io.*;

public class GameSaveManager {
	private static final String SAVE_FOLDER = "saves";
	private static final String SAVE_FILE = SAVE_FOLDER + "/save.dat";
	
	public static void save(Character player) {
		File folder = new File(SAVE_FOLDER);
		if(!folder.exists()) {
			folder.mkdir();
		}
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
			out.writeObject(player);
			System.out.println("Game saved");
		} catch (IOException e) {
			System.out.println("Failed to save game");
		}
	}
	
	public static Character load() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
			Character player = (Character) in.readObject();
			player.restoreBehavior();
			System.out.println("Game loaded");
			return player;
		} catch (Exception e) {
			System.out.println("No save file found");
			return null;
		}
	}
}