package carte;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getType().getBotte();

		}
	@Override
		public boolean equals(Object object) {
	    if (this == object) {
	        return true;
	    }
	    if (object == null || getClass() != object.getClass()) {
	        return false;
	    }
	    Botte botte = (Botte) object;
	    return getType().equals(botte.getType()); // Compare directement les types
	}


}
