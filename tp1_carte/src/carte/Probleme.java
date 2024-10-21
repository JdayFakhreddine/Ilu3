package carte;

public abstract class Probleme extends Carte{
	private Type type;
	
	protected  Probleme(Type type) {
		super();
		this.type = type ;
	}

		public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Probleme [type=" + type + "]";
	}
	
	@Override
	public boolean equals(Object object) {
	    if (this == object) {
	        return true;
	    }
	    if (object == null || getClass() != object.getClass()) {
	        return false;
	    }
	    Probleme problem = (Probleme) object;
	    return getType().equals(problem.getType());
	}


}
