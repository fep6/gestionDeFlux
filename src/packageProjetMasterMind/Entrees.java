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
		
		while (pModeJeu != 1 && pModeJeu != 2 && pModeJeu != 3) {
			setModeJeu();	
		}
		setModeJeu();
		 
		System.out.println("\n RECAPTULATIF: \n Vous avez choisi le jeu:");


		System.out.println("Avec " + pnPions + " pions avec " + pnCouleurs + " couleurs, le tout à retrouver en " 
		+ pnCoups +" coups maximum.");
		System.out.println("Enfin, vous avez choisi le mode:");
		if (pModeJeu == 1) {
			System.out.println(" \' Challenger \' où vous devez trouver la combinaison secrète de l'ordinateur");
		}
		if (pModeJeu == 2) {
			System.out.println("  \' Défenseur \' où c'est à l'ordinateur de trouver votre combinaison secrète");
		}
		if (pModeJeu == 3) {
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
	void setNCoups(int pNCoups) {
		nCoups = pNCoups;
	}
	void setNPions(int pNPions) {
		nPions = pNPions;
	}
	void setNCouleurs(int pNCouleurs) {
		nCouleurs = pNCouleurs;
	}
	void setModeJeu(){

		System.out.println("veuillez entrer le mode à choisir:\n"
				+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"+
				"2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" +
				"3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
				+ "le premier à trouver la combinaison secréte de l'autre a gagné");
		modeJeu = sc.nextInt();
	}
}
