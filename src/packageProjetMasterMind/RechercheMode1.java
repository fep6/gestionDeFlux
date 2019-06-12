package packageProjetMasterMind;

// Mode 1 "Challenger" : L'intelligence artificielle de l’ordinateur joue le rôle de défenseur. 
//			Elle définit une combinaison de X chiffres aléatoirement.

public class RechercheMode1 {
	

//Tableau 2d
	//Tableau pour la saisie d'entrée du joueur
	static int[][] tableauJeuMode1 = new int[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];	
	// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur
	static String[][] tableauReponseOrdi = new String[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];
	
//Tableau 1d
	//Combinaison de l'ordinateur
	static int combinaisonOrdi [] = new int [EntreesConfigJeu.getNPions()];
		
// Variables
	//Variable true si la partie est gagnée
	static boolean boleenSiGagneMode1;
	//Nombre de tour de jeu
	static int coupMode1 =0;
	//tour restant
	static int tourRestantMode1= EntreesConfigJeu.getNCoups();
	// Renvoie si la partie est gagnée ou non
	static String verdictMode1="";
	
	static	CombinaisonSecrete cso = new CombinaisonSecrete();
	static EntreesManuellesDuJeu emjMode1 = new EntreesManuellesDuJeu ();
	static ComparatifAffichageTest cat1 = new ComparatifAffichageTest();

	void jeuMode1(){
		
		//2.1  Entrée de la combinaison de l'ordi.:
		cso.setCombinaisonSecrete();
		combinaisonOrdi= cso.getCombinaisonSecreteOrdi();
		
		//2.2 recherche +/- et affichage
		
		while (!verdictMode1.equals("LE JOUEUR A GAGNE!") && !verdictMode1.equals("LE JOUEUR A PERDU!")) {
			boleenSiGagneMode1= true;
			
		    //2.2.1 entrées du joueur
			entreesJoueur(coupMode1, tableauJeuMode1);

	 		//2.2.2 Jeux
				//On renseigne le mode de jeu
 				ComparatifAffichageTest.pModeEnCours=1;
	 			cat1.setComparatifAffichageTest();
	 			verdictMode1=cat1.getVerdict();
	 			
	 			//Récapitulatif (Affichage)
	 			cat1.affichageRecapitulatif(tourRestantMode1, coupMode1);
	 			
			coupMode1++;
		}
		System.out.println("...Fin de la partie : "+ verdictMode1);
	}
	
	//entrées du joueur (var reponse)
	static void entreesJoueur(int coup, int[][] tableauJeuMode1) {
		System.out.println("----------------------------");
		System.out.println("PROPOSITION DU JOUEUR:");
		emjMode1.setEntreesManuellesDuJeu();
		// Rapatriement des données de l'instance tej dans la variable de classe tableauJeuMode1
		for ( int pion=0;pion<EntreesConfigJeu.getNPions();pion++) {				
			tableauJeuMode1[coup][pion]=emjMode1.getEntree(pion);	
		}
	}
	//Setters pour ComparatifAffichageTest.setMode1()
	static int getCoupMode1(){
		return coupMode1;
	}
	static boolean getBoleenSiGagneMode1(){
		return boleenSiGagneMode1;
	}
	static int getTourRestantMode1(){
		return tourRestantMode1;
	}
	static int getTableauJeuMode1(int coup, int pion){
		return tableauJeuMode1[coup][pion];
	}
	static int getCombinaisonOrdi(int pion){
		return combinaisonOrdi[pion];
	}
}

	

