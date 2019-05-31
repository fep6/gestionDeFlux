package packageProjetMasterMind;

// Mode 2 "Défenseur": Le joueur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.

public class RechercheMode2 {

//combinaison de la défense du joueur
private static int combinaisonJoueur[] = new int [Main.nPions];
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
private static String verdict; 
// Nombre de tour de jeu
private static int tourRestantMode2 = Main.nCoups;
// Variable true si la partie est gagnée
private static boolean boleenSiGagne;

//Boucles de coup (n° de coup à l'instant t)
static int coup;
//Numero de pion
static int pion;

	
	
	RechercheMode2(){
		//Initialisation du bornage dichotomique
		initVariablesDicho();
		
		//3.1 Entrées de la combinaison du joueur 
		CombinaisonSecrete csj = new CombinaisonSecrete();
		combinaisonJoueur= csj.getCombinaisonSecreteJoueur();
		
		// 3.2. recherche +/- et affichage
		while (!verdict.equals("GAGNE!") && !verdict.equals("PERDU!")) {
				boleenSiGagne= true;
				coup++;
				System.out.println("\n Nous sommes au tour N° :" + coup);
				
					//3.2.1 Entrées de l'ordi(var tableauJeu[][]) et recherche dichotomique :
					entreesJeuOrdi();
					//3.2.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
					comparatifCombinaisonSecreteMode2();
					//3.1.3 Affichage & tests
					affichageEtTestMode2();
			
		} 
		System.out.println("...Fin de la partie : L'ordinateur a "+ verdict);			

	}
	
	//3.2.1.1 Entrées de l'ordi 
	// tableauJeu [j][i] : j -> coup, i -> pion 
	static void entreesJeuOrdi(){
		
		// 1er coup: On donne la valeur 5 au début
		if (coup==1) {
			for (pion=0;pion<Main.nPions;pion++) {	
				tableauJeu[0][pion]=(int) (Max/2);
			System.out.println("Pion "+ pion + " : " + tableauJeu[0][pion]);
			}
		// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant (dichotomie)
		} else {
			for (pion=0;pion<Main.nPions;pion++) {
				if (tableauReponseJoueur[coup-1][pion].equals("=")) {
					tableauJeu[coup][pion]=tableauJeu[coup-1][pion];
					}	
				else if (tableauReponseJoueur[coup-1][pion].equals("+")) {
					// Si c'est "+", la borne inférieure prend la valeur du coup d'avant
					dichoMoins [pion] = tableauJeu[coup-1][pion];			
					}
				// (tableauReponseJoueur[coup-1][i].equals("-"))
				else  {
					// La recherche se fera vers le '-', on divise dichoPlus par 2
					dichoPlus [pion]= tableauJeu[coup-1][pion];
				}
				// On fait la moyenne des deux bornes
				tableauJeu[coup][pion]=(dichoPlus[pion] + dichoMoins[pion])/2;
				System.out.println("Pion "+ pion + " : " + tableauJeu[coup][pion]);
			}
		}
	}
	
	static void initVariablesDicho() {
		for (pion =0; pion<Main.nPions; pion++) {
			dichoPlus[pion]=Max;
			dichoMoins[pion]=0;
		}
	}
	
	
	
	
	
	
//	//3.1.1.2 comparatif combinaison secrète / entrée 
//	static void comparatifCombinaisonSecreteMode2() {
//		for (pion=0; pion<Main.nPions; pion++) {
//			if ( tableauJeu[coup][pion]==combinaisonJoueur[pion] ) {
//				tableauReponseJoueur[coup][pion]="=";
//			}
//			if ( tableauJeu[coup][pion]<combinaisonJoueur[pion] ) {
//				tableauReponseJoueur[coup][pion]="+";
//				boleenSiGagne = false;
//			}
//			if ( tableauJeu[coup][pion]>combinaisonJoueur[pion] ) {
//				tableauReponseJoueur[coup][pion]="-";
//				boleenSiGagne = false;
//			}
//		}		
//	}
//
//	//3.1.1.3 Affichage & tests
//	static void affichageEtTestMode2(){
//		//Affichage réponse
//		System.out.print("REPONSE: ");
//		for (pion=0; pion<Main.nPions; pion++) {
//			System.out.print(tableauReponseJoueur[coup][pion]);
//		}
//		System.out.println("");
//		
//		//test
//		tourRestantMode2 = Main.nCoups - coup;
//		System.out.println(" -> Il vous reste: "+ tourRestantMode2 + " coups!");
//		
//		if (tourRestantMode2 == 0 && !boleenSiGagne ) {
//			verdict = "PERDU!";
//		}
//		else if (boleenSiGagne==true) {
//			verdict = "GAGNE!";
//		}
//	}	
	
}



