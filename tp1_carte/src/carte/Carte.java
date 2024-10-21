package carte;

public abstract class Carte {

	
	@Override 
	public boolean equals(Object object) {
		if(object instanceof Carte) {
			Carte carte = (Carte) object;
			return getClass().equals(carte.getClass());
		}
		return false;
		
	}
}