package carte;

public class Parade extends Bataille {

	public Parade(Type type){
		super (type);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
	    return getType().getParade(); // Renvoie le nom de la parade
	}


	@Override
	public boolean equals(Object object) {
	    if (this == object) {
	        return true;
	    }
	    if (object == null || getClass() != object.getClass()) {
	        return false;
	    }
	    Parade parade = (Parade) object;
	    return getType().getParade().equals(parade.getType().getParade());
	}

	
}
