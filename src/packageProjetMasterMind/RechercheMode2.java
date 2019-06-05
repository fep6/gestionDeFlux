package packageProjetMasterMind;

// Mode 2 "Défenseur": L'ordinateur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.

public class RechercheMode2 {

	
	
//Tableau 2d
	//Tableau pour la saisie de l'ordinateur, avec son historique
	static int[][] tableauJeuMode2 = new int[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];	
	// Tableau de réponse du joueur, avec son historique
	static String  tableauReponseJoueur [][] = new String[EntreesConfigJeu.getNCoups()] [EntreesConfigJeu.getNPions()];

// Tableau 1d
	//combinaison de la défense du joueur
	static int combinaisonJoueur[] = new int [EntreesConfigJeu.getNPions()];

// variables
	//Variable true si la partie est gagnée
	static boolean boleenSiGagneMode2;
	//Boucles de coup (n° de coup à l'instant t)
	static int coupMode2=0;	
	//Nombre de tour de jeu
	static int tourRestantMode2 = EntreesConfigJeu.getNCoups();
	// Renvoie si la partie est gagnée ou non
	private static String verdictMode2 = "";
	

	//Numero de pion
	//static int pionMode2;

// Variables pour recherche dichotomique
	//Valeur max du nombre limite
	private static int Max = 10;
	//Recherche 'vers le haut'
	private static int[] dichoPlus = new int [EntreesConfigJeu.getNPions()] ;
	//Recherche  'vers le bas'
	private static int[] dichoMoins = new int [EntreesConfigJeu.getNPions()] ;

	
	
	RechercheMode2(){
		//Initialisation du bornage dichotomique
		initVariablesDicho();
		
		//3.1 Entrées de la combinaison du joueur 
		CombinaisonSecrete csj = new CombinaisonSecrete();
		combinaisonJoueur= csj.getCombinaisonSecreteJoueur();
		
		// 3.2. recherche +/- et affichage
		while (!verdictMode2.equals("GAGNE!") && !verdictMode2.equals("PERDU!")) {
			boleenSiGagneMode2= true;
			System.out.println("\n Nous sommes au tour N° :" + coupMode2);
				
					//3.2.1 Entrées de l'ordi(var tableauJeuMode2[][]) et recherche dichotomique :
					entreesJeuOrdi();
					
					//test
					System.out.println("entreesJeuOrdi() exécutée!");
					
					//Après factorisation
						//Par appel aux méthodes de ComparatifAffichageTest
						//ComparatifAffichageTestMode2();
				 		//Par instanciation  ComparatifAffichageTest
			 			 ComparatifAffichageTest cat2 = new ComparatifAffichageTest();
			 			 verdictMode2=cat2.getVerdict();
					
					// Avant factorisation
						//3.2.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
						//comparatifCombinaisonSecreteMode2();
						//3.1.3 Affichage & tests
						//affichageEtTestMode2();

			coupMode2++;
		} 
		System.out.println("...Fin de la partie : L'ordinateur a "+ verdictMode2);
	}
	
	//3.2.1.1 Entrées de l'ordi
	static void entreesJeuOrdi(){

		
		//test
		System.out .println("TEST : coupMode2 = "+coupMode2);
		
		// 1er coup: On donne la valeur 5 au début
		if (coupMode2==0) {
			for (int pion=0;pion<EntreesConfigJeu.getNPions();pion++) {	
				tableauJeuMode2[0][pion]=(int) (Max/2);
			System.out.println("Pion "+ pion + " : " + tableauJeuMode2[0][pion]);
			}
		// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant (dichotomie)
		} else {
			for (int pion=0;pion<EntreesConfigJeu.getNPions();pion++) {
				
				//Factorisation : On rapatrie la valeur du coup d'avant pour la tester
				tableauReponseJoueur[coupMode2-1][pion]= ComparatifAffichageTest.getTableauReponse(coupMode2-1,pion);
				
				
				//tests
				//System.out.println("TEST tableauJeuMode2["+(int)(coupMode2-1)+"]["+pion+"] = "+ tableauJeuMode2[coupMode2-1][pion]);
				System.out.println("TEST tableauReponseJoueur["+(int)(coupMode2-1)+"]["+pion+"] = " + tableauReponseJoueur[coupMode2-1][pion]);
				// fin tests
				
				
				if (tableauReponseJoueur[coupMode2-1][pion].equals("=")) {
					tableauJeuMode2[coupMode2][pion]=tableauJeuMode2[coupMode2-1][pion];
					}	
				else if (tableauReponseJoueur[coupMode2-1][pion].equals("+")) {
					
					// Si c'est "+", la borne inférieure prend la valeur du coup d'avant
					dichoMoins [pion] = tableauJeuMode2[coupMode2-1][pion];			
					}
				else  {
					// La recherche se fera vers le '-', on divise dichoPlus par 2
					dichoPlus [pion]=  tableauJeuMode2[coupMode2-1][pion]/2;
				}
				// On fait la moyenne des deux bornes
				tableauJeuMode2[coupMode2][pion]=(dichoPlus[pion] + dichoMoins[pion])/2;
				System.out.println("Pion "+ pion + " : " + tableauJeuMode2[coupMode2][pion]);
			}
		}
		
		//test
		System.out.println("\n Sortie de entreesJeuOrdi() \n");
	}
	
	static void initVariablesDicho() {
		for (int pion =0; pion<EntreesConfigJeu.getNPions(); pion++) {
			dichoPlus[pion]=Max;
			dichoMoins[pion]=0;
		}
	}
	

		
// Après factorisation dans ComparatifAffichageTest (méthode pour retour pour le mode 3)
	
	static void ComparatifAffichageTestMode2(){
		 ComparatifAffichageTest.comparatifCombinaisonSecrete();
		 ComparatifAffichageTest.affichageEtTest();
	}
	

// Avant factorisation
	
	//Comparatif combinaison secrète / entrée 
	static void comparatifCombinaisonSecreteMode2() {
		for (int pion=0; pion<EntreesConfigJeu.getNPions(); pion++) {
			if ( tableauJeuMode2[coupMode2][pion]==combinaisonJoueur[pion] ) {
				tableauReponseJoueur[coupMode2][pion]="=";
			}
			if ( tableauJeuMode2[coupMode2][pion]<combinaisonJoueur[pion] ) {
				tableauReponseJoueur[coupMode2][pion]="+";
				boleenSiGagneMode2 = false;
			}
			if ( tableauJeuMode2[coupMode2][pion]>combinaisonJoueur[pion] ) {
				tableauReponseJoueur[coupMode2][pion]="-";
				boleenSiGagneMode2 = false;
			}
		}		
	}
	//Affichage & tests
	static void affichageEtTestMode2(){
		//Affichage réponse
		System.out.print("REPONSE: ");
		for (int pion=0; pion<EntreesConfigJeu.getNPions(); pion++) {
			System.out.print(tableauReponseJoueur[coupMode2][pion]);
		}
		System.out.println("");
		//test
		tourRestantMode2 = EntreesConfigJeu.getNCoups() - coupMode2;
		System.out.println(" -> Il vous reste: "+ tourRestantMode2 + " coups!");
		
		if (tourRestantMode2 == 0 && !boleenSiGagneMode2 ) {
			verdictMode2 = "PERDU!";
		}
		else if (boleenSiGagneMode2==true) {
			verdictMode2 = "GAGNE!";
		}
	}	
	
}



