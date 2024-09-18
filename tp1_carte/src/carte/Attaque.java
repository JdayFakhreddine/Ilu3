package carte;

public class Attaque extends Bataille{

	public Attaque() {
	super (type); }

	@Override
	public String toString() {
		return getType().getAttaque();
	}

	
}
