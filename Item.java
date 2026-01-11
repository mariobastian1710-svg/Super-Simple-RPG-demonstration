package rpg_aol_alt;
import java.io.Serializable;

public abstract class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public abstract String getName();
	public abstract void use(Character target);
}