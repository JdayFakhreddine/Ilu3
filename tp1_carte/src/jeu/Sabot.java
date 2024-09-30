package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import carte.Carte;

public class Sabot implements Iterable<Carte> {
    
    private static final int CAPACITE_MAX = 106;  // Capacité maximale de cartes dans le sabot
    private int nbCartes;    
    private Carte pioche[];
    private int nbOperation = 0;  // Compte le nombre d'opérations pour vérifier la modification concurrente
    
    public Sabot(Carte cartes[]) {
        pioche = cartes;
        nbCartes = cartes.length;
    }
    
    // Vérifie si le sabot est vide
    public boolean estVide() {
        return nbCartes == 0;
    }
    
    // Ajoute une carte au sabot
    public void ajouterCarte(Carte carte) {
        if(nbCartes == CAPACITE_MAX) {
            throw new IllegalStateException("Le sabot est plein, impossible d'ajouter plus de cartes.");
        } else {
            pioche[nbCartes] = carte;
            nbCartes++;
            nbOperation++;  // Indique qu'une opération a été faite
        }
    }
    
    // Pioche une carte (retire la première carte du sabot)
    public Carte piocher() {
        if (estVide()) {
            throw new NoSuchElementException("Le sabot est vide, impossible de piocher.");
        }
        Carte cartePiochée = pioche[0];  // Prendre la première carte
        removePremiereCarte();  // Supprimer la première carte
        System.out.println(cartePiochée.toString());
        return cartePiochée;
    }
    
    // Supprime la première carte du sabot
    private void removePremiereCarte() {
        for (int i = 0; i < nbCartes - 1; i++) {
            pioche[i] = pioche[i + 1];
        }
        pioche[--nbCartes] = null;  // Décrémente le nombre de cartes et efface la dernière référence
        nbOperation++;  // Incrémente le compteur de modifications
    }

    // Retourne un itérateur sur les cartes du sabot
    @Override
    public Iterator<Carte> iterator() {
        return new Iterateur();
    }
    
    // Classe interne pour l'itérateur
    private class Iterateur implements Iterator<Carte> {
        private int nbOperationRef = nbOperation;
        private int indiceIterateur = 0;
        private boolean nextEffectue = false;  // Indique si `next()` a été appelé

        // Vérifie si le sabot a été modifié de façon concurrente
        private void verificationConcurrence() {
            if (nbOperation != nbOperationRef) {
                throw new ConcurrentModificationException("Modification concurrente détectée.");
            }
        }

        @Override
        public boolean hasNext() {
            return indiceIterateur < nbCartes;
        }

        @Override
        public Carte next() {
            verificationConcurrence();
            if (!hasNext()) {
                throw new NoSuchElementException("Il n'y a plus de cartes à parcourir.");
            }
            nextEffectue = true;
            return pioche[indiceIterateur++];
        }

        @Override
        public void remove() {
            verificationConcurrence();
            if (!nextEffectue) {
                throw new IllegalStateException("Vous devez appeler next() avant remove().");
            }
            // Décale les cartes après l'élément à supprimer
            for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
                pioche[i] = pioche[i + 1];
            }
            pioche[--nbCartes] = null;  // Supprime la dernière référence et décrémente le nombre de cartes
            nextEffectue = false;  // Réinitialise pour éviter plusieurs suppressions
            nbOperation++;  // Mise à jour des opérations pour éviter la concurrence
        }
    }
}
