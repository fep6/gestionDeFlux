package packageProjetMasterMind;

import java.util.Scanner;

public class EntreesConfigJeu {
	//Mode de jeu
	private int modeJeu;
	//Nombre de coups
	private int nCoups;
	//Nombre de pions
	private int nPions;
	//Nombre de couleurs
//	private int nCouleurs;
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
//		// Nombre de couleurs
//		this.setNCouleurs();	
			
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
	
	// setters
	void setModeJeu(){

		// Détermination du mode de jeu (Entier, 0<nCoups<4)
		// modeJeu = 0;
		testEntier = false;
			

		do {
			System.out.println("veuillez entrer le mode à choisir:\n"
			+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"
			+ "2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" 
			+ "3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
			+ "le premier à trouver la combinaison secréte de l'autre a gagné");
			
			
			// factorisation
//			setTest(modeJeu);
						
			// Semi-factorisation
			GestionExeptionEntreesConfigJeu test = new GestionExeptionEntreesConfigJeu(modeJeu);
			modeJeu = test.getResultatGestionExeptionEntreesConfigJeu();
			testEntier=test.getTestEntierGestionExeptionEntreesConfigJeu();
			
			// Avant factorisation
//			Scanner sc = new Scanner(System.in);
//			String str;
// 			str = sc.nextLine();
//			try {
//				modeJeu = Integer.parseInt(str);
//				testEntier = true;
//			} catch (NumberFormatException e){
//				System.out.println(modeJeu);
//				System.out.println(" : Cette valeur n'est pas une entrée valide!");
//			}
			
			// System.out.println("testEntier= "+testEntier);
			
		} while (testEntier == false || modeJeu < 1 || modeJeu > 3 );

	}
	
	
	void setNCoups() {
		// Détermination du nombre de coups (Entier, 0<nCoups<20)
		testEntier = false;
			
		do {
			System.out.println("Veuillez entrer le nombre de coups souhaités (entre 1 & 20): ");

			// Factorisation
//			 setTest(nCoups);
			
			// Semi-factorisation
			GestionExeptionEntreesConfigJeu test = new GestionExeptionEntreesConfigJeu(nCoups);
			nCoups = test.getResultatGestionExeptionEntreesConfigJeu();
			testEntier=test.getTestEntierGestionExeptionEntreesConfigJeu();
			
			//Avant factorisation
//			Scanner sc = new Scanner(System.in);
//			String str;
//			str = sc.nextLine();
//			try {
//				nCoups = Integer.parseInt(str);
//				testEntier = true;
//			} catch (NumberFormatException e){
//				System.out.println("Nombre de coups :"+nCoups);
//				System.out.println(" : Cette valeur n'est pas une entrée valide!");
//			}
			
			// System.out.println("testEntier= "+testEntier);
			
		} while (testEntier == false || nCoups < 1 || nCoups > 20 );
	}
	
	void setNPions() {
		// Détermination du nombre pions (Entier, 1<nPions<4)
		testEntier = false;
			
		do {
			System.out.println("Veuillez entrer le nombre de pions: ");
		
			// factorisation
//			setTest(nPions);
			
			// Semi factorisation
			GestionExeptionEntreesConfigJeu test = new GestionExeptionEntreesConfigJeu(nPions);
			nPions = test.getResultatGestionExeptionEntreesConfigJeu();
			testEntier=test.getTestEntierGestionExeptionEntreesConfigJeu();
			
			// Avant factorisation
//			Scanner sc = new Scanner(System.in);
//			String str;
//			str = sc.nextLine();
//			try {
//				nPions = Integer.parseInt(str);
//				testEntier = true;
//			} catch (NumberFormatException e){
//				System.out.println("Nombre de pions: "+nPions);
//				System.out.println(" : Cette valeur n'est pas une entrée valide!");	
//			}
			
			// System.out.println("testEntier= "+testEntier);
			
		} while (testEntier == false || nPions < 1 || nPions > 20 );
	}
	

	
	//Méthode pour factorisation
	void setTest(int test) {
		GestionExeptionEntreesConfigJeu t = new GestionExeptionEntreesConfigJeu(test);
		modeJeu = t.getResultatGestionExeptionEntreesConfigJeu();
		testEntier=t.getTestEntierGestionExeptionEntreesConfigJeu();
		
		//test
		System.out.println("test: mode de jeu =" + modeJeu);
		System.out.println("test: testEntier =" + testEntier);
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

}
