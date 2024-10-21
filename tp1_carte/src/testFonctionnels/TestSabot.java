package testFonctionnels;

import carte.JeuDeCarte;
import carte.Carte;
import jeu.Sabot;

public class TestSabot {

    public static void main(String[] args) {
        // Créer un jeu de cartes
        JeuDeCarte jeuDeCarte = new JeuDeCarte();

        // Récupérer toutes les cartes du jeu
        Carte[] cartes = jeuDeCarte.donnerCartes();

        // Créer le sabot avec les cartes du jeu
        Sabot sabot = new Sabot(cartes);

        // Vérifier que le sabot n'est pas vide au départ
        if (!sabot.estVide()) {
            System.out.println("Le sabot n'est pas vide au départ, prêt à piocher.");
        }

        // Piocher et afficher les cartes jusqu'à ce que le sabot soit vide
        while (!sabot.estVide()) {
            Carte cartePiochée = sabot.piocher();
            System.out.println("Je pioche " + cartePiochée);
        }

        // Vérifier que le sabot est bien vide à la fin
        if (sabot.estVide()) {
            System.out.println("Le sabot est maintenant vide.");
        }

        // Essayer de piocher dans un sabot vide (gestion des exceptions)
        try {
            sabot.piocher();  // Cela devrait lever une exception si le sabot est vide
        } catch (IllegalStateException e) {
            System.out.println("Exception capturée : Impossible de piocher, le sabot est vide.");
        }
    }
}
