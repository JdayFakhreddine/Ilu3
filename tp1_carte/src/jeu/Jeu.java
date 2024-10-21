package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import carte.Carte;
import carte.JeuDeCarte;
import Utils.GestionCartes;

public class Jeu {
	private Sabot sabot;

	protected Jeu() {
		JeuDeCarte jeu = new JeuDeCarte();
		Carte[] cartes = jeu.donnerCartes();
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, cartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		Carte[] cartesMelangees = (Carte[]) listeCartes.toArray();
		this.sabot = new Sabot(cartesMelangees);
	}
	
	

}