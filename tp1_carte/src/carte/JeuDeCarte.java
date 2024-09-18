package carte;

public class JeuDeCarte {
	private Configurations [] typeDeCartes = new Configuration[19];

	public JeuDeCarte() {
		StringBuilder chaine = new StringBuilder();
		for (int i = 0 ; i < 19 ; i++) {
			chaine.append(typeDeCartes[i].getNbExemplaires() + " " typeDeCartes[i].getCarte()+ "\n");
		
		}
		return chaine.toString()
		// TODO Auto-generated constructor stub
	}
	private static class Configuration {
		
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte , int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}
	
	}

}
