package carte;

public enum Type {
	FEU ("Feu Rouge", "Feu Vert", "Vehicule Prioritaire"), 
	ESSENCE("Panne d'essence", "Essence", "Citerne d'essence"), 
	CREVAISON("Crevaison", "Roue de secours", "Increvable"), 
	ACCIDENT("Accident","Reparation", "As du Volant");
	
	private String parade  = "";
	private String botte = "";
	private String attaque = "";
	
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}

	public String getAttaque() {
		return attaque;
	}
}
	
	

