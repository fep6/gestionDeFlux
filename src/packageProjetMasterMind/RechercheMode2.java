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
		while (!verdictMode2.equals("L'ORDINATEUR A GAGNE!") && !verdictMode2.equals("L'ORDINATEUR A PERDU!")) {
			boleenSiGagneMode2= true;
			System.out.println("\n Nous sommes au tour N° :" + coupMode2);
				
					//3.2.1 Entrées de l'ordi(var tableauJeuMode2[][]) et recherche dichotomique :
					entreesJeuOrdi();

			 		//Instanciation  ComparatifAffichageTest
	 				ComparatifAffichageTest.pModeEnCours=2;
		 			ComparatifAffichageTest cat2 = new ComparatifAffichageTest();
		 			verdictMode2=cat2.getVerdict();

			coupMode2++;
		} 
		System.out.println("...Fin de la partie : "+ verdictMode2);
	}
	
	//3.2.1.1 Entrées de l'ordi
	static void entreesJeuOrdi(){
		
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

				
				if (tableauReponseJoueur[coupMode2-1][pion].equals("=")) {
					tableauJeuMode2[coupMode2][pion]=tableauJeuMode2[coupMode2-1][pion];
					}	
				else if (tableauReponseJoueur[coupMode2-1][pion].equals("+")) {
					
					// Si c'est "+", la borne inférieure prend la valeur du coup d'avant
					dichoMoins [pion] = tableauJeuMode2[coupMode2-1][pion];			
					}
				else if (tableauReponseJoueur[coupMode2-1][pion].equals("-")) {
					// La recherche se fera vers le '-', la borne superieure prend la valeur du coup d'avant
					dichoPlus [pion]=  tableauJeuMode2[coupMode2-1][pion];
				}
				// On fait la moyenne des deux bornes
				tableauJeuMode2[coupMode2][pion]=(dichoPlus[pion] + dichoMoins[pion])/2;
				
				System.out.println("Pion "+ pion + " : " + tableauJeuMode2[coupMode2][pion]);
			}
		}
	}
	
	static void initVariablesDicho() {
		for (int pion =0; pion<EntreesConfigJeu.getNPions(); pion++) {
			dichoPlus[pion]=Max;
			dichoMoins[pion]=0;
		}
	}
	//Getters
	String getVerdictMode2(){
		return verdictMode2;
	}	
}



