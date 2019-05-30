package packageProjetMasterMind;

//Mode 3 :Le joueur et l’intelligence artificielle de l’ordinateur jouent tour à tour. 
//		  Le premier à trouver la combinaison secrète de l'autre a gagné ! 

public class RechercheMode3 {
	
	//combinaison de la défense du joueur
	private int combinaisonJoueur[] = new int [Main.nPions];
	// Combinaison de l'ordinateur (mode1)
	private int combinaisonOrdi [];	// Recherche dichotomique 'vers le haut'
	private int[] dichoPlus = new int [Main.nPions] ;
	// Recherche dichotomique 'vers le bas'
	private int[] dichoMoins = new int [Main.nPions] ;	
	
	
	RechercheMode3(){
		
		//4.1 Entrées des combinaisons secrètes 
		CombinaisonSecrete csjo = new CombinaisonSecrete();
		//4.1.1 Entrées de la combinaison du joueur 
		combinaisonJoueur= csjo.getCombinaisonSecreteJoueur();
		//4.1.2  Entrée de la combinaison de l'ordi.:
		combinaisonOrdi= csjo.getcombinaisonSecreteOrdi();
		
		// Init variables dichotomiques
		RechercheMode2.initVariablesDicho();
		
	}

	
	
	
	
	
	
}
