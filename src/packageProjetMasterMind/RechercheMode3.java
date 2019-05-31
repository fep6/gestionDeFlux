package packageProjetMasterMind;

//Mode 3 :Le joueur et l’intelligence artificielle de l’ordinateur jouent tour à tour. 
//		  Le premier à trouver la combinaison secrète de l'autre a gagné ! 

public class RechercheMode3 {
	
	//combinaison de la défense du joueur
	private int combinaisonJoueur[] = new int [Main.nPions];
	// Combinaison de l'ordinateur (mode1)
	private int combinaisonOrdi [];	
	// Verdict du jeu
	private String verdict;
	// condition de sortie du while
	private boolean boleenSiGagne;
	//Comptage de coup (n° de coup à l'instant t)
	private static int coup=0;
	
	
	RechercheMode3(){
		
		//4.1 Entrées des combinaisons secrètes 
		CombinaisonSecrete cs = new CombinaisonSecrete();
			//4.1.1 Retour de la combinaison du joueur  mode(2)
			combinaisonJoueur= cs.getCombinaisonSecreteJoueur();
			//4.1.2 Retour de la combinaison de l'ordi.(mode1):
			combinaisonOrdi= cs.getcombinaisonSecreteOrdi();

		
		//4.2 Entrées / Comparatif / test

			//4.2.1 Initialisation des bornes de recherche dichotomiques pour le mode 2
			RechercheMode2.initVariablesDicho();
			
			//4.2.2 Recherche +/- et affichage	
			while (verdict != "GAGNE!" && verdict != "PERDU!") {
				boleenSiGagne= true;
				coup++;
				System.out.println("\n Nous sommes au tour N° :" + coup);
			    //Entrées du joueur
				RechercheMode1.entreesJoueur();					
				//Entrées de l'ordi
				RechercheMode2.entreesJeuOrdi();
				//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
				RechercheMode1.comparatifCombinaisonSecreteMode1();						
				//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
				RechercheMode2.comparatifCombinaisonSecreteMode2();
				//Affichage & tests
				RechercheMode1.affichageEtTestMode1();						
				//Affichage & tests
				RechercheMode2.affichageEtTestMode2();	
				}				
			System.out.println("verdict = " + verdict);
		}	
}

	
	
	
	
	
	

