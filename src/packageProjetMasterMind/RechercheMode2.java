package packageProjetMasterMind;

// Mode 2 "Défenseur": Le joueur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.

public class RechercheMode2 {

	//combinaison de la défense du joueur
	private int combinaisonJoueur[] = new int [Main.nPions];
	// Tableau pour la saisie de l'ordinateur, avec son historique
	private static int[][] tableauJeu = new int[Main.nCoups][Main.nPions];
	// Tableau de réponse du joueur, avec son historique
	private static String  tableauReponseJoueur [][] = new String[Main.nCoups] [Main.nPions];
	
	// Valeur max du nombre limite
	private static int Max = 10;
	// Recherche dichotomique 'vers le haut'
	private static int[] dichoPlus = new int [Main.nPions] ;
	// Recherche dichotomique 'vers le bas'
	private static int[] dichoMoins = new int [Main.nPions] ;
	
	// Renvoie si la partie est gagnée ou non
	private String verdict = new String(); 
	// Nombre de tour de jeu
	private static int tourMode2 = 0;
	private int tourRestantMode2 = Main.nCoups;
	// Variable true si la partie est gagnée
	private boolean boleenSiGagne;
	
	//Boucles de coup
	static int j;

	
	
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

			for (j=0;j<(Main.nCoups);j++) {
				boleenSiGagne= true;
				tourMode2++;
				System.out.println("\n Nous sommes au tour N° :" + tourMode2);
				
					//3.2.1.1 Entrées de l'ordi(var tableauJeu[][]) et recherche dichotomique :
					entreesJeuOrdi();
					//3.1.1.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
					comparatifCombinaisonSecreteMode2();
					//3.1.1.3 Affichage & tests
					affichageEtTest();
	
				//tests: bug des conditions du while en modegagnat : Ne sort pas du while
				System.out.println("boleenSiGagne = " + boleenSiGagne);
				System.out.println("verdict dans while = " + verdict);
				
			}
			System.out.println("verdict = " + verdict);
			
		} 
		System.out.println("...Fin de la partie : L'ordinateur a "+ verdict);			

	}
	
	//3.2.1.1 Entrées de l'ordi 
	// tableauJeu [j][i] : j -> Coup, i -> pion 
	static void entreesJeuOrdi(){
		
		// 1er coup: On donne la valeur 5 au début
		if (tourMode2==1) {
			for (int i=0;i<Main.nPions;i++) {	
				tableauJeu[0][i]=(int) (Max/2);
			System.out.println("Pion "+ i + " : " + tableauJeu[0][i]);
			}
		// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant (dichotomie)
		} else {
			for (int i=0;i<Main.nPions;i++) {
				
				if (tableauReponseJoueur[j-1][i].equals("=")) {
					tableauJeu[j][i]=tableauJeu[j-1][i];
					}
				
				else if (tableauReponseJoueur[j-1][i].equals("+")) {
					// Si c'est "+", la borne inférieure prend la valeur du coup d'avant
					dichoMoins [i] = tableauJeu[j-1][i];			
					}
				// (tableauReponseJoueur[j-1][i].equals("-"))
				else  {
					// La recherche se fera vers le '-', on divise dichoPlus par 2
					dichoPlus [i]= tableauJeu[j-1][i];
				}
				// On fait la moyenne des deux bornes
				tableauJeu[j][i]=(dichoPlus[i] + dichoMoins[i])/2;
				System.out.println("Pion "+ i + " : " + tableauJeu[j][i]);
				
			}
		}
	}
	
	//3.1.1.2 comparatif combinaison secrète / entrée 
	void comparatifCombinaisonSecreteMode2() {
		for (int i=0; i<Main.nPions; i++) {
			if ( tableauJeu[j][i]==combinaisonJoueur[i] ) {
				tableauReponseJoueur[j][i]="=";
			}
			if ( tableauJeu[j][i]<combinaisonJoueur[i] ) {
				tableauReponseJoueur[j][i]="+";
				boleenSiGagne = false;
			}
			if ( tableauJeu[j][i]>combinaisonJoueur[i] ) {
				tableauReponseJoueur[j][i]="-";
				boleenSiGagne = false;
			}
		}		
	}

	//3.1.1.3 Affichage & tests
	void affichageEtTest(){
		//Affichage réponse
		System.out.print("REPONSE: ");
		for (int i=0; i<Main.nPions; i++) {
			System.out.print(tableauReponseJoueur[j][i]);
		}
		System.out.println("");
		
		//test
		tourRestantMode2 = Main.nCoups - tourMode2;
		System.out.println(" -> Il vous reste: "+ tourRestantMode2 + " coups!");
		
		if (tourRestantMode2 == 0 && !boleenSiGagne ) {
			verdict = "PERDU!";
		}
		else if (boleenSiGagne==true) {
			// Ne sort pas du while quand l'ordi gagne...(?)
			verdict = "GAGNE!";
		}
	}
	
	
	static void initVariablesDicho() {
		for (int i =0; i<Main.nPions; i++) {
			dichoPlus[i]=Max;
			dichoMoins[i]=0;
		}
		
	}
}
