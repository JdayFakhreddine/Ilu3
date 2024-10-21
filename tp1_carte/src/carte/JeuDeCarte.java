package carte;

public class JeuDeCarte {

    // Tableau des configurations de cartes
    private Configuration[] configuration = {
        new Configuration(new Borne(25), 10), 
        new Configuration(new Borne(50), 10),
        new Configuration(new Borne(75), 10),
        new Configuration(new Borne(100), 12),
        new Configuration(new Borne(200), 4),
        new Configuration(new Parade(Type.FEU), 14),
        new Configuration(new Parade(Type.ESSENCE), 6),
        new Configuration(new Parade(Type.CREVAISON), 6),
        new Configuration(new Parade(Type.ACCIDENT), 6),
        new Configuration(new Attaque(Type.FEU), 5),
        new Configuration(new Attaque(Type.ESSENCE), 3),
        new Configuration(new Attaque(Type.CREVAISON), 3),
        new Configuration(new Attaque(Type.ACCIDENT), 3),
        new Configuration(new Botte(Type.FEU), 1),
        new Configuration(new Botte(Type.ESSENCE), 1),
        new Configuration(new Botte(Type.CREVAISON), 1),
        new Configuration(new Botte(Type.ACCIDENT), 1)
    };

    // Méthode pour afficher le jeu de cartes avec leur nombre d'exemplaires
    public void affichageJeu() {
        for (Configuration config : configuration) {  // Utilisation de for-each pour simplifier
            Carte carte = config.getCarte();
            System.out.println(config.getNbExemplaires() + " " + carte);
        }
    }

    // Méthode pour donner toutes les cartes répliquées selon les exemplaires
    public Carte[] donnerCartes() {
        // Calculer la taille totale du tableau final
        int totalCartes = 0;
        for (Configuration config : configuration) {
            totalCartes += config.getNbExemplaires();
        }

        // Créer un tableau pour stocker toutes les cartes répliquées
        Carte[] toutesLesCartes = new Carte[totalCartes];
        int index = 0;

        // Remplir le tableau avec les cartes répliquées selon le nombre d'exemplaires
        for (Configuration config : configuration) {
            for (int i = 0; i < config.getNbExemplaires(); i++) {
                toutesLesCartes[index++] = config.getCarte();
            }
        }

        return toutesLesCartes;
    }

    // Classe interne Configuration pour représenter une carte et son nombre d'exemplaires
    private static class Configuration {

        private int nbExemplaires;
        private Carte carte;

        // Constructor
        public Configuration(Carte carte, int nbExemplaires) {
            this.carte = carte;
            this.nbExemplaires = nbExemplaires;
        }

        // Getters
        public int getNbExemplaires() {
            return nbExemplaires;
        }

        public Carte getCarte() {
            return carte;
        }
    } 
   private int count ( Carte carte , Carte[] cartes) {
	   int compteurCarte = 0;
	   for (Carte c_carte : cartes) {
		   if (c_carte.equals(carte))
			   compteurCarte ++;
	   }
		return compteurCarte;
   }
   public boolean checkCount () {
		boolean diffTableau = true;
		Carte[] cartes = donnerCartes();
		for(Configuration config : configuration) {
			if(count(config.carte, cartes) != config.getNbExemplaires()) {
				System.out.println(config.getCarte().toString() + config.getNbExemplaires() + count(config.carte, cartes));
				diffTableau = false;
			}
		}
		return diffTableau;
	}
   }
    

