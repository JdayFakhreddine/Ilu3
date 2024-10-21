package carte;

public class Attaque extends Bataille{

	public Attaque(Type type) {
	super (type); }

	@Override
	public String toString() {
		return getType().getAttaque();
	}
	@Override
	public boolean equals(Object object) {
		if (object instanceof Attaque) {
			Attaque attaque = (Attaque) object;
			return getType().getAttaque().equals(attaque.getType().getAttaque());
			
		}
		return false;
	}

	
}
