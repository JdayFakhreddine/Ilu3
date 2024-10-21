package testFonctionnels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import carte.Carte;
import carte.JeuDeCarte;
import Utils.GestionCartes;

public class TestGestionCartes {

    public static void main(String[] args) {
        // Initialisation du jeu de cartes
        JeuDeCarte jeu = new JeuDeCarte();
        
        // Création d'une liste de cartes non mélangées à partir du jeu
        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(carte);
        }

        // Test du mélange : mélanger sans détruire la liste originale
        List<Carte> listeCartesMelangee = new ArrayList<>(listeCarteNonMelangee);
        listeCartesMelangee = GestionCartes.melanger(listeCartesMelangee);
        System.out.println("Liste mélangée : ");
        System.out.println(listeCartesMelangee);
        
        // Vérification du mélange : le nombre d'occurrences de chaque carte doit être identique
        boolean melangeOk = true;
        for (Carte carte : listeCarteNonMelangee) {
            if (Collections.frequency(listeCarteNonMelangee, carte) != Collections.frequency(listeCartesMelangee, carte)) {
                melangeOk = false;
                break;
            }
        }
        System.out.println("Liste mélangée sans erreur ? " + melangeOk);

        // Test de la méthode rassembler() et verifierRassemblement()
        listeCartesMelangee = GestionCartes.rassembler(listeCartesMelangee);
        System.out.println("Liste rassemblée : ");
        System.out.println(listeCartesMelangee);
        System.out.println("Liste rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(listeCartesMelangee));

        // Test avec des listes spécifiques
        List<Integer> listeTest1 = new ArrayList<>();
        Collections.addAll(listeTest1, 1, 1, 2, 1, 3);
        System.out.println("Liste de test [1,1,2,1,3] : " + listeTest1);
        List<Integer> listeTestRassemblee1 = GestionCartes.rassembler(listeTest1);
        System.out.println("Liste rassemblée [1,1,2,1,3] : " + listeTestRassemblee1);
        System.out.println("Liste rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(listeTestRassemblee1));

        List<Integer> listeTest2 = new ArrayList<>();
        Collections.addAll(listeTest2, 1, 4, 3, 2);
        System.out.println("Liste de test [1,4,3,2] : " + listeTest2);
        List<Integer> listeTestRassemblee2 = GestionCartes.rassembler(listeTest2);
        System.out.println("Liste rassemblée [1,4,3,2] : " + listeTestRassemblee2);
        System.out.println("Liste rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(listeTestRassemblee2));
    }
}
