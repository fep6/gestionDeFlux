package packageProjetMasterMind;

//Mode 3 :Le joueur et l’intelligence artificielle de l’ordinateur jouent tour à tour. 
//		  Le premier à trouver la combinaison secrète de l'autre a gagné ! 

public class RechercheMode3 {
	//Tableau 2d 
		// Tableau pour la saisie d'entrée du joueur (Mode 1)
		static int[][] tableauJeuMode1 = new int[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];	
		// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur (Mode 1)
		static String[][] tableauReponseOrdi = new String[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];
		// Tableau pour la saisie de l'ordinateur, avec son historique (Mode2)
		static int[][] tableauJeuMode2 = new int[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];	
		// Tableau de réponse du joueur, avec son historique (Mode2)
		static String[][] tableauReponseJoueur  = new String[EntreesConfigJeu.getNCoups()] [EntreesConfigJeu.getNPions()];
		
	//Tableau 1d
		//combinaison de la défense du joueur (mode2)
		private static int combinaisonJoueur[] = new int [EntreesConfigJeu.getNPions()];
		// Combinaison de l'ordinateur (mode1)
		private static int combinaisonOrdi [] = new int [EntreesConfigJeu.getNPions()];
		// condition de sortie du while
		
	//Autres variables		
		private static boolean boleenSiGagneMode3;
		// Comptage de coup (n° de coup à l'instant t)
		private static int coupMode3 = 0;	
		// Nombre de tour de jeu
		static int tourRestantMode3 = EntreesConfigJeu.getNCoups();
		// Verdict du jeu
		private String verdictMode3;
		
	//Recherche dichotomique mode 2
		int[] dichoPlus= new int[EntreesConfigJeu.getNPions()];
		int[] dichoMoins= new int[EntreesConfigJeu.getNPions()];
		int Max = 10;
	
	
	RechercheMode3(){
		
		//4.1 Entrées des combinaisons secrètes (ordinateur et joueur)
		CombinaisonSecrete cs = new CombinaisonSecrete();
			//4.1.1 Retour de la combinaison de l'ordi.(mode1):
			combinaisonOrdi= cs.getCombinaisonSecreteOrdi();
			//4.1.2 Retour de la combinaison du joueur  (mode2):
			combinaisonJoueur= cs.getCombinaisonSecreteJoueur();

		
		//4.2 Entrées / Comparatif / test

			//4.2.1 Initialisation des bornes de recherche dichotomiques pour le mode 2
						//RechercheMode2.initVariablesDicho(dichoPlus, dichoMoins, Max);
			for (int pion =0; pion<EntreesConfigJeu.getNPions(); pion++) {
				dichoPlus[pion]=Max;
				dichoMoins[pion]=0;
			}
						//4.2.2 Recherche +/- et affichage	
			while (verdictMode3 != "LE JOUEUR A GAGNE!" && verdictMode3 != "LE JOUEUR A PERDU!" 
					&& verdictMode3 != "L'ORDINATEUR A GAGNE!" && verdictMode3 != "L'ORDINATEUR A PERDU!" ) {
				boleenSiGagneMode3= true;
				System.out.println("\n Nous sommes au tour N° :" + (int)(coupMode3+1));
				
				//4.2.2.1 Entrées
				RechercheMode1.entreesJoueur(coupMode3, tableauJeuMode1 );
				RechercheMode2.entreesJeuOrdi(coupMode3, tableauJeuMode2,tableauReponseJoueur,dichoPlus, dichoMoins,Max );

				
		 		//4.2.2.2 Jeux 
				//(Mode1)
	 				ComparatifAffichageTest.pModeEnCours=1;
		 			ComparatifAffichageTest cat1 = new ComparatifAffichageTest();
		 			//On rapatrie les données
		 			verdictMode3=cat1.getVerdict();
				//(Mode2)
	 				ComparatifAffichageTest.pModeEnCours=2;
		 			ComparatifAffichageTest cat2 = new ComparatifAffichageTest();
		 			verdictMode3=cat2.getVerdict();	
	 			
	 			//Récapitulatif
		 			ComparatifAffichageTest.affichageRecapitulatif(tourRestantMode3, coupMode3);
	 			
				coupMode3++;
			}				
			System.out.println("verdict = " + verdictMode3);
		}
	//Getters (pour ComparatifAffichageTest.setMode3)
	static int getTableauJeuMode1(int coup,int pion) {
		return tableauJeuMode1 [coup][pion];
	}
	static int getTableauJeuMode2(int coup,int pion) {
		return tableauJeuMode2 [coup][pion];
	}
	static int getCombinaisonOrdi(int pion) {
		return combinaisonOrdi[pion];
	}
	static int getCombinaisonJoueur(int pion) {
		return combinaisonJoueur[pion];
	}	
	static int getCoupMode3(){
		return coupMode3;
	}	
	static int getTourRestantMode3(){
		return tourRestantMode3;
	}
	static boolean getBoleenSiGagneMode3(){
		return boleenSiGagneMode3;
	}
}

	
	
	
	
	
	

