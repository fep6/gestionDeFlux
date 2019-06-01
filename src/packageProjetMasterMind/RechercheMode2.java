package packageProjetMasterMind;

// Mode 2 "Défenseur": L'ordinateur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.

public class RechercheMode2 {

	
	
//Tableau 2d
	//Tableau pour la saisie de l'ordinateur, avec son historique
	private static int[][] tableauJeuMode2 = new int[Main.nCoups][Main.nPions];	
	// Tableau de réponse du joueur, avec son historique
	private static String  tableauReponseJoueur [][] = new String[Main.nCoups] [Main.nPions];

// Tableau 1d
	//combinaison de la défense du joueur
	private static int combinaisonJoueur[] = new int [Main.nPions];

// variables
	//Variable true si la partie est gagnée
	private static boolean boleenSiGagneMode2;
	//Boucles de coup (n° de coup à l'instant t)
	static int coupMode2=0;	
	//Nombre de tour de jeu
	private static int tourRestantMode2 = Main.nCoups;
	//Numero de pion
	static int pionMode2;
	// Renvoie si la partie est gagnée ou non
	private static String verdictMode2 = "";

// Variables pour recherche dichotomique
	//Valeur max du nombre limite
	private static int Max = 10;
	//Recherche 'vers le haut'
	private static int[] dichoPlus = new int [Main.nPions] ;
	//Recherche  'vers le bas'
	private static int[] dichoMoins = new int [Main.nPions] ;

	
	
	RechercheMode2(){
		//Initialisation du bornage dichotomique
		initVariablesDicho();
		
		//3.1 Entrées de la combinaison du joueur 
		CombinaisonSecrete csj = new CombinaisonSecrete();
		combinaisonJoueur= csj.getCombinaisonSecreteJoueur();
		
		// 3.2. recherche +/- et affichage
		while (!verdictMode2.equals("GAGNE!") && !verdictMode2.equals("PERDU!")) {
			boleenSiGagneMode2= true;
			coupMode2++;
				System.out.println("\n Nous sommes au tour N° :" + coupMode2);
				
					//3.2.1 Entrées de l'ordi(var tableauJeuMode2[][]) et recherche dichotomique :
					entreesJeuOrdi();
					
					
					//Après factorisation
					// ComparatifAffichageTestMode2();
					
					
					// Avant factorisation
					//3.2.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
					comparatifCombinaisonSecreteMode2();
					//3.1.3 Affichage & tests
					affichageEtTestMode2();
			
		} 
		System.out.println("...Fin de la partie : L'ordinateur a "+ verdictMode2);			

	}
	
	//3.2.1.1 Entrées de l'ordi 
	// tableauJeuMode2 [j][i] : j -> coup, i -> pion 
	static void entreesJeuOrdi(){
		
		// 1er coup: On donne la valeur 5 au début
		if (coupMode2==1) {
			for (pionMode2=0;pionMode2<Main.nPions;pionMode2++) {	
				tableauJeuMode2[0][pionMode2]=(int) (Max/2);
			System.out.println("Pion "+ pionMode2 + " : " + tableauJeuMode2[0][pionMode2]);
			}
		// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant (dichotomie)
		} else {
			for (pionMode2=0;pionMode2<Main.nPions;pionMode2++) {
				if (tableauReponseJoueur[coupMode2-1][pionMode2].equals("=")) {
					tableauJeuMode2[coupMode2][pionMode2]=tableauJeuMode2[coupMode2-1][pionMode2];
					}	
				else if (tableauReponseJoueur[coupMode2-1][pionMode2].equals("+")) {
					// Si c'est "+", la borne inférieure prend la valeur du coup d'avant
					dichoMoins [pionMode2] = tableauJeuMode2[coupMode2-1][pionMode2];			
					}
				// (tableauReponseJoueur[coup-1][i].equals("-"))
				else  {
					// La recherche se fera vers le '-', on divise dichoPlus par 2
					dichoPlus [pionMode2]= tableauJeuMode2[coupMode2-1][pionMode2];
				}
				// On fait la moyenne des deux bornes
				tableauJeuMode2[coupMode2][pionMode2]=(dichoPlus[pionMode2] + dichoMoins[pionMode2])/2;
				System.out.println("Pion "+ pionMode2 + " : " + tableauJeuMode2[coupMode2][pionMode2]);
			}
		}
	}
	
	static void initVariablesDicho() {
		for (pionMode2 =0; pionMode2<Main.nPions; pionMode2++) {
			dichoPlus[pionMode2]=Max;
			dichoMoins[pionMode2]=0;
		}
	}
	

		
	// Après factorisation dans ComparatifAffichageTest (méthode pour retour pour le mode 3)
	
	static void ComparatifAffichageTestMode2(){
		ComparatifAffichageTest.comparatifCombinaisonSecrete(pionMode2, coupMode2,tableauJeuMode2,combinaisonJoueur, tableauReponseJoueur, boleenSiGagneMode2);
		ComparatifAffichageTest.affichageEtTest(pionMode2, coupMode2, tableauReponseJoueur, tourRestantMode2, boleenSiGagneMode2, verdictMode2);
	}
	

	// Avant factorisation
	
	//3.1.1.2 comparatif combinaison secrète / entrée 
	static void comparatifCombinaisonSecreteMode2() {
		for (pionMode2=0; pionMode2<Main.nPions; pionMode2++) {
			if ( tableauJeuMode2[coupMode2][pionMode2]==combinaisonJoueur[pionMode2] ) {
				tableauReponseJoueur[coupMode2][pionMode2]="=";
			}
			if ( tableauJeuMode2[coupMode2][pionMode2]<combinaisonJoueur[pionMode2] ) {
				tableauReponseJoueur[coupMode2][pionMode2]="+";
				boleenSiGagneMode2 = false;
			}
			if ( tableauJeuMode2[coupMode2][pionMode2]>combinaisonJoueur[pionMode2] ) {
				tableauReponseJoueur[coupMode2][pionMode2]="-";
				boleenSiGagneMode2 = false;
			}
		}		
	}
	//3.1.1.3 Affichage & tests
	static void affichageEtTestMode2(){
		//Affichage réponse
		System.out.print("REPONSE: ");
		for (pionMode2=0; pionMode2<Main.nPions; pionMode2++) {
			System.out.print(tableauReponseJoueur[coupMode2][pionMode2]);
		}
		System.out.println("");
		
		//test
		tourRestantMode2 = Main.nCoups - coupMode2;
		System.out.println(" -> Il vous reste: "+ tourRestantMode2 + " coups!");
		
		if (tourRestantMode2 == 0 && !boleenSiGagneMode2 ) {
			verdictMode2 = "PERDU!";
		}
		else if (boleenSiGagneMode2==true) {
			verdictMode2 = "GAGNE!";
		}
	}	
	
}



