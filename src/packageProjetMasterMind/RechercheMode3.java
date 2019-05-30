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
	private int tourMode3;
	// condition de sortie du while
	private boolean boleenSiGagne;
	
	
	RechercheMode3(){
		
		//4.1 Entrées des combinaisons secrètes 
		CombinaisonSecrete csjo = new CombinaisonSecrete();
			//4.1.1 Entrées de la combinaison du joueur 
			combinaisonJoueur= csjo.getCombinaisonSecreteJoueur();
			//4.1.2  Entrée de la combinaison de l'ordi.:
			combinaisonOrdi= csjo.getcombinaisonSecreteOrdi();

		
		//4.2 Entrées / Comparatif / test

			//4.2.1 Init variables dichotomiques pour le mode 2
			RechercheMode2.initVariablesDicho();
			
			//4.2.2 recherche +/- et affichage	
			while (verdict != "GAGNE!" && verdict != "PERDU!") {
				tourMode3++;
				boleenSiGagne= true;
			    //2.2.1.1 entrées du joueur (var reponse)
				RechercheMode1.entreesJoueur();
				//2.2.1.2 Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
				RechercheMode1.comparatifCombinaisonSecreteMode1();
				//2.2.1.3 Affichage & tests
				RechercheMode1.affichageEtTest();
			}
			System.out.println("...Mais c'est "+verdict);
		
	}

	
	
	
	
	
	
}
