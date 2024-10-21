package testFonctionnels;

import carte.Attaque;
import carte.Borne;
import carte.Carte;
import carte.Parade;
import carte.Type;

public class TestMethodeEquals {
    public static void main(String[] args) {
        // Comparaison de cartes de 25km
        Carte carte25Bornes1 = new Borne(25);
        Carte carte25Bornes2 = new Borne(25);
        Carte carte50Bornes = new Borne(50);
        
        // Test d'égalité pour deux cartes de 25 km
        System.out.println("Deux cartes de 25km sont identiques ? " + carte25Bornes1.equals(carte25Bornes2));  // true
        System.out.println("Une carte de 25km et une carte de 50km sont identiques ? " + carte25Bornes1.equals(carte50Bornes));  // false
        
        // Comparaison de deux cartes Feu Rouge (Attaque)
        Carte carteFeuxRouge1 = new Attaque(Type.FEU);
        Carte carteFeuxRouge2 = new Attaque(Type.FEU);
        System.out.println("Deux cartes de feux rouge sont identiques ? " + carteFeuxRouge1.equals(carteFeuxRouge2));  // true
        
        // Comparaison entre Feu Rouge et Feu Vert (Attaque et Parade)
        Carte carteFeuxVert = new Parade(Type.FEU);
        System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + carteFeuxRouge1.equals(carteFeuxVert));  // false

        // Test réflexivité (une carte est égale à elle-même)
        System.out.println("Une carte est égale à elle-même ? " + carte25Bornes1.equals(carte25Bornes1));  // true
        
        // Test symétrie (si A égale B, alors B égale A)
        System.out.println("Symétrie : carteFeuxRouge1.equals(carteFeuxRouge2) == carteFeuxRouge2.equals(carteFeuxRouge1) ? "
                           + (carteFeuxRouge1.equals(carteFeuxRouge2) == carteFeuxRouge2.equals(carteFeuxRouge1)));  // true
    }
}
