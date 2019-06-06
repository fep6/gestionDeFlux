package packageProjetMasterMind;

//Mode 3 :Le joueur et l’intelligence artificielle de l’ordinateur jouent tour à tour. 
//		  Le premier à trouver la combinaison secrète de l'autre a gagné ! 

public class RechercheMode3 {
	
	//combinaison de la défense du joueur
	private int combinaisonJoueur[] = new int [EntreesConfigJeu.getNPions()];
	// Combinaison de l'ordinateur (mode1)
	private int combinaisonOrdi [];
	// condition de sortie du while
	private boolean boleenSiGagne;
	//Comptage de coup (n° de coup à l'instant t)
	private static int coupMode3=0;	
	// Verdict du jeu
	private String verdictMode3;
	
	
	RechercheMode3(){
		
		//4.1 Entrées des combinaisons secrètes 
		CombinaisonSecrete cs = new CombinaisonSecrete();
			//4.1.1 Retour de la combinaison de l'ordi.(mode1):
			combinaisonOrdi= cs.getCombinaisonSecreteOrdi();
			//4.1.2 Retour de la combinaison du joueur  mode(2)
			combinaisonJoueur= cs.getCombinaisonSecreteJoueur();

		
		//4.2 Entrées / Comparatif / test

			//4.2.1 Initialisation des bornes de recherche dichotomiques pour le mode 2
			RechercheMode2.initVariablesDicho();
			
			//4.2.2 Recherche +/- et affichage	
			while (verdictMode3 != "LE JOUEUR A GAGNE!" && verdictMode3 != "LE JOUEUR A PERDU!" &&verdictMode3 != "L'ORDINATEUR A GAGNE!" && verdictMode3 != "L'ORDINATEUR A PERDU!" ) {
				boleenSiGagne= true;
				System.out.println("\n Nous sommes au tour N° :" + coupMode3+1);
				
				//4.2.2.1 Entrées
				RechercheMode1.entreesJoueur();
				RechercheMode2.entreesJeuOrdi();
				
		 		//4.2.2.2 Jeux 
				//(Mode1)
 				ComparatifAffichageTest.pModeEnCours=1;
	 			ComparatifAffichageTest cat1 = new ComparatifAffichageTest();
	 			verdictMode3=cat1.getVerdict();
				
				//(Mode2)
 				ComparatifAffichageTest.pModeEnCours=2;
	 			ComparatifAffichageTest cat2 = new ComparatifAffichageTest();
	 			verdictMode3=cat2.getVerdict();
				
				coupMode3++;
				}				
			System.out.println("verdict = " + verdictMode3);
		}	
}

	
	
	
	
	
	

