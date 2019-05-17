package packageProjetMasterMind;

import java.util.Scanner;

public class EntreesConfigJeu {
	//Mode de jeu
	private int modeJeu;
	//Nombre de coups
	private int nCoups;
	//Nombre de pions
	private int nPions;

	// Entrées des données du jeu 
	EntreesConfigJeu () {
		
		// Entrées des données du jeu
		this.setModeJeu();
		// Nombre de coups
		this.setNCoups();
		// Nombre de pions
		this.setNPions();	
			
		// Recapitulatif
		
		System.out.println("\n _____________________________________________ \n ");	
		System.out.println("\n RECAPTULATIF: \n Vous avez choisi le jeu:");
		System.out.println("Avec " + nPions + " pions, à retrouver en " 
		+ nCoups +" coups maximum.");
		System.out.println("Enfin, vous avez choisi le mode:");
		if (modeJeu == 1) {
			System.out.println(" \' Challenger \' où vous devez trouver la combinaison secrète de l'ordinateur");
		}
		else if (modeJeu == 2) {
			System.out.println("  \' Défenseur \' où c'est à l'ordinateur de trouver votre combinaison secrète");
		}
		else if (modeJeu == 3) {
			System.out.println("  \' Duel \' où l'ordinateur et vous jouez tour à tour,\n" + 
					"le premier à trouver la combinaison secr�te de l'autre a gagné");
		}
		System.out.println("\n _____________________________________________ \n ");	
	}
	
	// Getters 
	int getModeJeu(){
		return modeJeu;
	}
	int getNCoups(){
		return nCoups;
	}
	int getNPions(){
		return nPions;
	}
	
	// setters
	void setModeJeu(){	

		do {
			System.out.println("veuillez entrer le mode à choisir:\n"
			+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"
			+ "2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" 
			+ "3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
			+ "le premier à trouver la combinaison secréte de l'autre a gagné");
						
			// Semi-factorisation
			GestionExeptionEntreesGlobales test = new GestionExeptionEntreesGlobales(modeJeu);
			modeJeu = test.getResultatGestionExeptionEntreesGlobales();			
		} while ( modeJeu < 1 || modeJeu > 3 );
	}

	void setNCoups() {
			
		do {
			System.out.println("Veuillez entrer le nombre de coups souhaités (entre 1 & 20): ");
			// Semi-factorisation
			GestionExeptionEntreesGlobales test = new GestionExeptionEntreesGlobales(nCoups);
			nCoups = test.getResultatGestionExeptionEntreesGlobales();		
		} while ( nCoups < 1 || nCoups > 20 );
	}
	
	void setNPions() {
		System.out.println("Veuillez entrer le nombre de pions: ");
		// Semi factorisation
		GestionExeptionEntreesGlobales test = new GestionExeptionEntreesGlobales(nPions);
		nPions = test.getResultatGestionExeptionEntreesGlobales();	
		System.out.println("test: Nombre de pions =" + nPions);
	}
	
	//Setter pour factorisation
	void setTest(int test) {
		GestionExeptionEntreesGlobales t = new GestionExeptionEntreesGlobales(test);
		modeJeu = t.getResultatGestionExeptionEntreesGlobales();
		//test
		System.out.println("test: mode de jeu =" + modeJeu);
	}

}
