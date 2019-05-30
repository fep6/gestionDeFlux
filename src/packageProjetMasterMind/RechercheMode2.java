package packageProjetMasterMind;

// Mode 2 "Défenseur": Le joueur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.

public class RechercheMode2 {

	//combinaison de la défense du joueur
	private int combinaisonJoueur[] = new int [Main.nPions];
	// Tableau pour la saisie de l'ordinateur, avec son historique
	private int[][] tableauJeu = new int[Main.nCoups][Main.nPions];
	// Tableau de réponse du joueur, avec son historique
	private String  tableauReponseJoueur [][] = new String[Main.nCoups] [Main.nPions];
	
	// Valeur max du nombre limite
	private int Max = 10;
	// Recherche dichotomique 'vers le haut'
	private int[] dichoPlus = new int [Main.nPions] ;
	// Recherche dichotomique 'vers le bas'
	private int[] dichoMoins = new int [Main.nPions] ;
	
	// Renvoie si la partie est gagnée ou non
	private String verdict = new String(); 
	// Nombre de tour de jeu
	// private static int tourMode2 = 0;
	private int tourRestantMode2 = Main.nCoups;
	// Variable true si la partie est gagnée
	private boolean boleenSiGagne;
	
	//Boucles de coup (n° de coup à l'instant t)
	int coup;

	
	
	RechercheMode2(){
		
	//3.1 Entrées de la combinaison du joueur 
		CombinaisonSecrete csj = new CombinaisonSecrete();
		combinaisonJoueur= csj.getCombinaisonSecreteJoueur();
		
	// 3.2. Recherche et affichage de l'ordi.
	//3.2.1 Recherche +/-
		
		//Initialisation des variables dichotomiques
		initVariablesDicho();
		
		//Entrées de l'ordi et comparaison
		while (!verdict.equals("GAGNE!") && !verdict.equals("PERDU!")) {

			coup++;
				boleenSiGagne= true;
				// tourMode2++;
				System.out.println("\n Nous sommes au tour N° :" +(int) (coup) );
				
					//3.2.1.1 Entrées de l'ordi(var tableauJeu[][]) et recherche dichotomique :
					entreesJeuOrdi();
					//3.1.1.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
					comparatifCombinaisonSecreteMode2();
					//3.1.1.3 Affichage & tests
					affichageEtTest();

			System.out.println("verdict = " + verdict);
			
		} 
		System.out.println("...Fin de la partie : L'ordinateur a "+ verdict);			

	}
	
	//3.2.1.1 Entrées de l'ordi 
	// tableauJeu [j][i] : j -> coup, i -> pion 
	void entreesJeuOrdi(){
		
		// 1er coup: On donne la valeur 5 au début
		if (coup==1) {
			for (int i=0;i<Main.nPions;i++) {	
				tableauJeu[0][i]=(int) (Max/2);
			System.out.println("Pion "+ i + " : " + tableauJeu[0][i]);
			}
		// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant (dichotomie)
		} else {
			for (int i=0;i<Main.nPions;i++) {
				
				if (tableauReponseJoueur[coup-1][i].equals("=")) {
					tableauJeu[coup][i]=tableauJeu[coup-1][i];
					}
				
				else if (tableauReponseJoueur[coup-1][i].equals("+")) {
					// Si c'est "+", la borne inférieure prend la valeur du coup d'avant
					dichoMoins [i] = tableauJeu[coup-1][i];			
					}
				// (tableauReponseJoueur[coup-1][i].equals("-"))
				else  {
					// La recherche se fera vers le '-', on divise dichoPlus par 2
					dichoPlus [i]= tableauJeu[coup-1][i];
				}
				// On fait la moyenne des deux bornes
				tableauJeu[coup][i]=(dichoPlus[i] + dichoMoins[i])/2;
				System.out.println("Pion "+ i + " : " + tableauJeu[coup][i]);
				
			}
		}
	}
	
	//3.1.1.2 comparatif combinaison secrète / entrée 
	void comparatifCombinaisonSecreteMode2() {
		for (int i=0; i<Main.nPions; i++) {
			if ( tableauJeu[coup][i]==combinaisonJoueur[i] ) {
				tableauReponseJoueur[coup][i]="=";
			}
			if ( tableauJeu[coup][i]<combinaisonJoueur[i] ) {
				tableauReponseJoueur[coup][i]="+";
				boleenSiGagne = false;
			}
			if ( tableauJeu[coup][i]>combinaisonJoueur[i] ) {
				tableauReponseJoueur[coup][i]="-";
				boleenSiGagne = false;
			}
		}		
	}

	//3.1.1.3 Affichage & tests
	void affichageEtTest(){
		//Affichage réponse
		System.out.print("REPONSE: ");
		for (int i=0; i<Main.nPions; i++) {
			System.out.print(tableauReponseJoueur[coup][i]);
		}
		System.out.println("");
		
		//test
		tourRestantMode2 = Main.nCoups - coup;
		System.out.println(" -> Il vous reste: "+ (int)(tourRestantMode2) + " coups!");
		
		if (tourRestantMode2 == 0 && !boleenSiGagne ) {
			verdict = "PERDU!";
		}
		else if (boleenSiGagne==true) {
			verdict = "GAGNE!";
		}
	}
	
	
	void initVariablesDicho() {
		for (int i =0; i<Main.nPions; i++) {
			dichoPlus[i]=Max;
			dichoMoins[i]=0;
		}
		
	}
}
