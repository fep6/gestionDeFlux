package packageProjetMasterMind;

public class EntreesConfigJeu {
	//Mode de jeu
	static int modeJeu;
	//Nombre de coups
	private static int nCoups;
	//Nombre de pions
	static int nPions;

	GestionExeptionEntreesGlobales test = new GestionExeptionEntreesGlobales();
	
	// Entrées des données du jeu 
	void setEntreesConfigJeu () {
		
		this.setModeJeu();
		this.setNCoups();
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
	static int getModeJeu(){
		return modeJeu;
	}
	static int getNCoups(){
		return nCoups;
	}
	static int getNPions(){
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
						
			test.setGestionExeptionEntreesGlobales(modeJeu);
			modeJeu = test.getResultatGestionExeptionEntreesGlobales();			
		} while ( modeJeu < 1 || modeJeu > 3 );
	}

	void setNCoups() {
			
		do {
			System.out.println("Veuillez entrer le nombre de coups souhaités (entre 1 & 20): ");
		
			test.setGestionExeptionEntreesGlobales(nCoups);
			nCoups = test.getResultatGestionExeptionEntreesGlobales();		
		} while ( nCoups < 1 || nCoups > 20 );
	}
	
	void setNPions() {
		System.out.println("Veuillez entrer le nombre de pions: ");
		
		test.setGestionExeptionEntreesGlobales(nPions);
		nPions = test.getResultatGestionExeptionEntreesGlobales();	
		System.out.println("test: Nombre de pions =" + nPions);
	}

}
