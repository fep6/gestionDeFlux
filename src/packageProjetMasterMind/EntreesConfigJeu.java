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
	// private Scanner sc = new Scanner(System.in);
	// Variable de test
	private boolean testEntier;


	// Entrées des données du jeu 
	EntreesConfigJeu () {
		
		// Entrées des données du jeu
		this.setModeJeu();
		// Nombre de coups
		this.setNCoups();
		// Nombre de pions
		this.setNPions();
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

		// Détermination du mode de jeu (Entier,  0<nCoups<4)
		// modeJeu = 0;
		testEntier = false;
			

		do {
			System.out.println("veuillez entrer le mode à choisir:\n"
			+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"
			+ "2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" 
			+ "3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
			+ "le premier à trouver la combinaison secréte de l'autre a gagné");
			
			
			// Test si entier
			setTest(modeJeu);
			
			
			// Factorisation de la gestion d'exeption
//			GestionExeptionEntreesConfigJeu test = new GestionExeptionEntreesConfigJeu(modeJeu);
//			modeJeu = test.getResultatGestionExeptionEntreesConfigJeu();
//			testEntier=test.getTestEntierGestionExeptionEntreesConfigJeu();
			
			// Gestion d'exeption		
//			String str;
// 			str = sc.nextLine();
//			try {
//				modeJeu = Integer.parseInt(str);
//				testEntier = true;
//			} catch (NumberFormatException e){
//				System.out.println(modeJeu);
//				System.out.println(" : Cette valeur n'est pas une entrée valide!");
//			}
		} while (testEntier != true || modeJeu < 1 || modeJeu > 3 );

	}
	
	
	void setNCoups() {
		// Détermination du nombre de coups (Entier, 0<nCoups<20)
		testEntier = false;
			
		do {
			System.out.println("Veuillez entrer le nombre de coups souhaités (entre 1 & 20): ");

			// Test si entier
			setTest(nCoups);
			
			
//			String str;
//			str = sc.nextLine();
//			try {
//				nCoups = Integer.parseInt(str);
//				testEntier = true;
//			} catch (NumberFormatException e){
//				System.out.println(nCoups);
//				System.out.println(" : Cette valeur n'est pas une entrée valide!");
//			}
		} while (testEntier != true || nCoups < 1 || nCoups > 20 );
	}
	
	void setNPions() {
		// Détermination du nombre pions (Entier, 1<nPions<4)
		testEntier = false;
			
		do {
			System.out.println("Veuillez entrer le nombre de pions: ");
		
			// Test si entier
			setTest(nPions);
			
//			String str;
//			str = sc.nextLine();
//			try {
//				nPions = Integer.parseInt(str);
//				testEntier = true;
//			} catch (NumberFormatException e){
//				System.out.println(nPions);
//				System.out.println(" : Cette valeur n'est pas une entrée valide!");
//			}
		} while (testEntier != true || nPions < 1 || nPions > 4 );
	}
	
	void setNCouleurs() {		
		
		// Détermination du nombre de couleurs (Entier, 1<nPions<4)
		testEntier = false;
			
		do {
			System.out.println("Veuillez entrer le nombre de couleurs souhaitées (entre 1 & 4): ");
			
			// Test si entier
			setTest(nCouleurs);
			
//			String str;
//			str = sc.nextLine();
//			try {
//				nCouleurs = Integer.parseInt(str);
//				testEntier = true;
//			} catch (NumberFormatException e){
//				System.out.println(nPions);
//				System.out.println(" : Cette valeur n'est pas une entrée valide!");
//			}
		} while (testEntier != true || nCouleurs < 1 || nCouleurs > 4 );
	}
	
	void setTest(int test) {
		GestionExeptionEntreesConfigJeu t = new GestionExeptionEntreesConfigJeu(test);
		modeJeu = t.getResultatGestionExeptionEntreesConfigJeu();
		testEntier=t.getTestEntierGestionExeptionEntreesConfigJeu();
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
