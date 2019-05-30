package packageProjetMasterMind;

//Mode 3 :Le joueur et l’intelligence artificielle de l’ordinateur jouent tour à tour. 
//		  Le premier à trouver la combinaison secrète de l'autre a gagné ! 

public class RechercheMode3 {
	
	//combinaison de la défense du joueur
	private int combinaisonJoueur[] = new int [Main.nPions];
	// Combinaison de l'ordinateur (mode1)
	private int combinaisonOrdi [];	
	// Recherche dichotomique 'vers le haut'
	private int[] dichoPlus = new int [Main.nPions] ;
	// Recherche dichotomique 'vers le bas'
	private int[] dichoMoins = new int [Main.nPions] ;	
	// Verdict du jeu
	private String verdict;
	// Comptage de tour
	private static int tourMode3 = 0;
	// condition de sortie du while
	private boolean boleenSiGagne;
	
	//Boucles de coup (n° de coup à l'instant t)
	private int coup;
	
	
	RechercheMode3(){
		
		//4.1 Entrées des combinaisons secrètes 
		CombinaisonSecrete cs = new CombinaisonSecrete();
			//4.1.1 Entrées de la combinaison du joueur 
			combinaisonJoueur= cs.getCombinaisonSecreteJoueur();
			//4.1.2  Entrée de la combinaison de l'ordi.:
			combinaisonOrdi= cs.getcombinaisonSecreteOrdi();

		
		//4.2 Entrées / Comparatif / test

			//4.2.1 Init des bornes de recherche dichotomiques pour le mode 2
			RechercheMode2.initVariablesDicho();
			
			//4.2.2 recherche +/- et affichage	
			while (verdict != "GAGNE!" && verdict != "PERDU!") {
				//tourMode3++;
				boleenSiGagne= true;
			    //4.2.1.1 entrées du joueur (var reponse)
				RechercheMode1.entreesJoueur();					
				//3.2.1.1 Entrées de l'ordi(var tableauJeu[][]) et recherche dichotomique :
				RechercheMode2.entreesJeuOrdi();
				//4.2.1.2 Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
				RechercheMode1.comparatifCombinaisonSecreteMode1();						
				//3.1.1.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
				RechercheMode2.comparatifCombinaisonSecreteMode2();
				//4.2.1.3 Affichage & tests
				RechercheMode1.affichageEtTest();						
				//3.1.1.3 Affichage & tests
					
				}
		}	
}

	
	
	
	
	
	

