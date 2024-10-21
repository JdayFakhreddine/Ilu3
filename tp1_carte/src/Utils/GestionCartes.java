package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	
	private static Random seed = new Random();
	
	// Première version d'extraction : extraire un élément en le retirant directement de la liste
	public static <E> E extraire1(List<E> list) {
		return list.remove(seed.nextInt(list.size())); // Retire un élément aléatoirement
	}
	
	// Deuxième version d'extraction : extraire un élément en utilisant un ListIterator
	public static <E> E extraire2(List<E> list) {
		int index = seed.nextInt(list.size());
		ListIterator<E> iterator = list.listIterator();
		E element = null;
		
		for (; iterator.hasNext() && index >= 0; index--) {
			element = iterator.next();
		}
		
		iterator.remove(); // Retire l'élément via l'itérateur
		return element;
	}
	
	// Méthode pour mélanger les cartes
	public static <E> List<E> melanger(List<E> listNonMelangee) {
		Collections.shuffle(listNonMelangee, seed); // Utilisation du Random déjà défini
		return new ArrayList<>(listNonMelangee); // Retourne la liste mélangée
	}
	
	// Vérification que le mélange conserve les mêmes éléments avec les mêmes occurrences
	public static <E> boolean verifierMelange(List<E> list1, List<E> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}
		
		for (E element : list1) {
			if (Collections.frequency(list1, element) != Collections.frequency(list2, element)) {
				return false;
			}
		}
		return true;
	}
	
	// Méthode pour regrouper les éléments identiques consécutivement
	public static <E> List<E> rassembler(List<E> listMelange) {
	    List<E> listTriee = new ArrayList<>();
	    List<E> listTemp = new ArrayList<>(listMelange);

	    // Pour chaque élément dans la liste, on compte les occurrences et on les regroupe
	    while (!listTemp.isEmpty()) {
	        E element = listTemp.get(0); // Prend le premier élément
	        int nbOccurences = Collections.frequency(listTemp, element); // Compte les occurrences de cet élément
	        
	        // Ajoute cet élément nbOccurences fois dans la liste triée
	        for (int i = 0; i < nbOccurences; i++) {
	            listTriee.add(element);
	        }
	        
	        // Retire toutes les occurrences de cet élément de la liste temporaire
	        listTemp.removeAll(Collections.singleton(element));
	    }

	    return listTriee;
	}

	// Vérification que les éléments identiques sont bien regroupés
	public static <E> boolean verifierRassemblement(List<E> list) {
		if (list.isEmpty()) return true;

		E prev = list.get(0);  // Premier élément
		for (E current : list) {
			if (!current.equals(prev)) {
				prev = current;  // Met à jour la référence pour la comparaison
			}
		}
		return true;
	}

}
