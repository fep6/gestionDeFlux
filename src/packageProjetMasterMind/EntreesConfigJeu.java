package packageProjetMasterMind;

import java.util.Scanner;

public class EntreesConfigJeu {
	//Mode de jeu
	private static int modeJeu = 0;
	//Nombre de coups
	private static int nCoups = 0;
	//Nombre de pions
	private static int nPions =0;
	//Nombre de couleurs
	private static int nCouleurs = 0;
	//Entrees clavier
	private Scanner sc = new Scanner(System.in);

	// Entrées des données du jeu 
	EntreesConfigJeu () {
		
		// Entrées des données du jeu
		this.setModeJeu();
		// Nombre de pions
		this.setNPions();
		// Nombre de coups
		this.setNCoups();
		// Nombre de couleurs
		this.getNCouleurs();	
			
		// Recapitulatif
			
		System.out.println("\n RECAPTULATIF: \n Vous avez choisi le jeu:");
		System.out.println("Avec " + nPions + " pions avec " + nCouleurs + " couleurs, le tout à retrouver en " 
		+ nCoups +" coups maximum.");
		System.out.println("Enfin, vous avez choisi le mode:");
		if (modeJeu == 1) {
			System.out.println(" \' Challenger \' où vous devez trouver la combinaison secrète de l'ordinateur");
		}
		else if (modeJeu == 2) {
			System.out.println("  \' Défenseur \' où c'est à l'ordinateur de trouver votre combinaison secrète");
		}
		else if (modeJeu == 3) {
			System.out.println("  \' Duel \' o� l'ordinateur et vous jouez tour à tour,\n" + 
					"le premier à trouver la combinaison secr�te de l'autre a gagné");
		}
		
	}
	
	// setters
	void setModeJeu(){
		System.out.println("veuillez entrer le mode à choisir:\n"
				+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"
				+ "2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" 
				+ "3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
				+ "le premier à trouver la combinaison secréte de l'autre a gagné");
		modeJeu = sc.nextInt();
		while (modeJeu != 1 && modeJeu != 2 && modeJeu != 3) {
			System.out.println("VEUILLEZ SVP ENTRER UN CHOIX ENTRE 1, 2 OU 3 :"
				+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"
				+ "2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" 
				+ "3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
				+ "le premier à trouver la combinaison secréte de l'autre a gagné");
			modeJeu = sc.nextInt();
		}
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
	
	// Getters
	public int getModeJeu(){
		return modeJeu;
	}
	public int getNCoups(){
		return nCoups;
	}
	public int getNPions(){
		return nPions;
	}
	public int getNCouleurs(){
		return nCouleurs;
	}

}
