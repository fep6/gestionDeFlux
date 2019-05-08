package packageProjetMasterMind;

import java.util.Scanner;

public class Entrees {
	private int nCoups; 
	private int nPions; 
	private int nCouleurs = 0; 
	private int modeJeu = 0;
	private Scanner sc = new Scanner(System.in);
	
	// Entrées des données du jeu 
	Entrees (int pnCoups, int pnPions, int pnCouleurs, int pModeJeu) {
		// Renseignement des variables de classe par les variables d'instance
		this.nCoups = pnCoups;
		this.nPions = pnPions;
		this.nCouleurs = pnCouleurs;
		this.modeJeu = pModeJeu;
		// Présentation du jeu

		System.out.println("veuillez entrer le mode à choisir:\n"
				+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"+
				"2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" +
				"3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
				+ "le premier à trouver la combinaison secréte de l'autre a gagné");
		
		// Mode du jeu
		while (pModeJeu != 1 && pModeJeu != 2 && pModeJeu != 3) {
			this.setModeJeu();	
		}
		this.setModeJeu();
		// Nombre de pions
		this.setNPions();
		// Nombre de coups
		this.setNCoups();
		// Nombre de couleurs
		this.getNCouleurs();
		
		System.out.println("\n RECAPTULATIF: \n Vous avez choisi le jeu:");
		System.out.println("Avec " + pnPions + " pions avec " + pnCouleurs + " couleurs, le tout à retrouver en " 
		+ pnCoups +" coups maximum.");
		System.out.println("Enfin, vous avez choisi le mode:");
		if (pModeJeu == 1) {
			System.out.println(" \' Challenger \' où vous devez trouver la combinaison secrète de l'ordinateur");
		}
		else if (pModeJeu == 2) {
			System.out.println("  \' Défenseur \' où c'est à l'ordinateur de trouver votre combinaison secrète");
		}
		else if (pModeJeu == 3) {
			System.out.println("  \' Duel \' o� l'ordinateur et vous jouez tour à tour,\n" + 
					"le premier à trouver la combinaison secr�te de l'autre a gagné");
		}
		
	}
	// Retourne le nombre de coups
	public int getNCoups(){
		return nCoups;
	}
	public int getNPions(){
		return nPions;
	}
	public int getNCouleurs(){
		return nCouleurs;
	}
	public int getModeJeu(){
		return modeJeu;
	}
	void setNCoups() {
		System.out.println("Veuillez entrer le nombre de coups souhaités: ");
		nCoups = sc.nextInt();
	}
	void setNPions() {
		System.out.println("Veuillez entrer le nombre de pions: ");
		nPions = sc.nextInt();
	}
	void setNCouleurs() {
		System.out.println("Veuillez entrer le nombre de couleurs souhaitées: ");
		nCouleurs = sc.nextInt();
	}
	void setModeJeu(){
		System.out.println("Veuillez entrer le mode de jeu souhaité: ");
		modeJeu = sc.nextInt();
	}
}
