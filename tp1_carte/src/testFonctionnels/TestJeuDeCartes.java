package testFonctionnels;


import carte.JeuDeCarte;
import carte.Carte;

public class TestJeuDeCartes {

    public static void main(String[] args) {
        testDonnerCartes();
    }

    // Test pour vérifier la méthode donnerCartes()
    public static void testDonnerCartes() {
        // Création d'un jeu de cartes
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        
        // Récupérer toutes les cartes avec leurs exemplaires
        Carte[] toutesLesCartes = jeuDeCarte.donnerCartes();

        // Affichage du nombre total de cartes
        System.out.println("Nombre total de cartes : " + toutesLesCartes.length);

        // Affichage de chaque carte
        for (Carte carte : toutesLesCartes) {
            System.out.println(carte);
        }
    }
}
