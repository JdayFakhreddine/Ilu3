package testFonctionnels;

import carte.JeuDeCarte;



public class TestJeuDeCartes {

    public static void main(String[] args) {
        testAffichageJeuDeCartes();
    }

    // Test pour vérifier l'affichage correct du jeu de cartes
    public static void testAffichageJeuDeCartes() {
        // Création d'un jeu de cartes
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        
        // Affichage du jeu
        System.out.println("Affichage du jeu de cartes :");
        jeuDeCarte.affichageJeu();
    }
}
