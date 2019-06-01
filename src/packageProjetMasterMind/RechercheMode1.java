package packageProjetMasterMind;

// Mode 1 "Challenger" : L'intelligence artificielle de l’ordinateur joue le rôle de défenseur. 
//			Elle définit une combinaison de X chiffres aléatoirement.

public class RechercheMode1 {
	

//Tableau 2d
	//Tableau pour la saisie d'entrée du joueur
	private static int tableauJeuMode1 [][] = new int[Main.nCoups][Main.nPions];	
	// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur
	private static String tableauReponseOrdi [][]= new String[Main.nCoups][Main.nPions];
	
//Tableau 1d
	//Combinaison de l'ordinateur
	private static int combinaisonOrdi [] = new int [Main.nPions];
	
	
// Variables
	//Variable true si la partie est gagnée
	private static boolean boleenSiGagneMode1;
	//Nombre de tour de jeu
	private static int coupMode1 =0;
	//tour restant
	private static int tourRestantMode1= Main.nCoups;
	//N° de pionMode1
	private static int pionMode1;
	// Renvoie si la partie est gagnée ou non
	private static String verdictMode1;
 


	RechercheMode1(){
		
		//2.1  Entrée de la combinaison de l'ordi.:
		CombinaisonSecrete cso = new CombinaisonSecrete();
		combinaisonOrdi= cso.getcombinaisonSecreteOrdi();
		
		//2.2 recherche +/- et affichage	
		while (verdictMode1 != "GAGNE!" && verdictMode1 != "PERDU!") {
			coupMode1++;
			boleenSiGagneMode1= true;
			
			    //2.2.1 entrées du joueur (var reponse)
				entreesJoueur();
				//2.2.2 Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="	et affichage et test
					
					//Après factorisation dans ComparatifAffichageTest
				// ComparatifAffichageTestMode1();
				
					// Avant factorisation dans ComparatifAffichageTest: 
					comparatifCombinaisonSecreteMode1();
				//2.2.3 Affichage & tests
					// Avant factorisation dans ComparatifAffichageTest:
					affichageEtTestMode1();
				
		}
		System.out.println("...Mais c'est "+verdictMode1);
	}
	
	//entrées du joueur (var reponse)
	static void entreesJoueur() {
		System.out.print("Veuillez entrer votre code: ");
		EntreesManuellesDuJeu tejMode1 = new EntreesManuellesDuJeu ();
		// Rapatriement des données de l'instance tej dans la variable de classe tableauJeuMode1
		for (pionMode1=0;pionMode1<Main.nPions;pionMode1++) {				
			tableauJeuMode1[0][pionMode1]=tejMode1.getEntree(pionMode1);	
		}
	}


	
	// Après factorisation dans ComparatifAffichageTest (méthode pour retour pour le mode 3)
	
	static void ComparatifAffichageTestMode1(){
		ComparatifAffichageTest.comparatifCombinaisonSecrete(pionMode1, coupMode1,tableauJeuMode1,combinaisonOrdi, tableauReponseOrdi, boleenSiGagneMode1);
		ComparatifAffichageTest.affichageEtTest(pionMode1, coupMode1, tableauReponseOrdi, tourRestantMode1, boleenSiGagneMode1, verdictMode1);
	}
	
	
	// Avant factorisation
	
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
	static void comparatifCombinaisonSecreteMode1(){
		for (pionMode1=0; pionMode1<Main.nPions; pionMode1++) {
			if ( tableauJeuMode1[0][pionMode1]==combinaisonOrdi[pionMode1] ) {
				tableauReponseOrdi[0][pionMode1]="=";
			}
			if ( tableauJeuMode1[0][pionMode1]<combinaisonOrdi[pionMode1] ) {
				tableauReponseOrdi[0][pionMode1]="+";
				boleenSiGagneMode1 = false;
			}
			if ( tableauJeuMode1[0][pionMode1]>combinaisonOrdi[pionMode1] ) {
				tableauReponseOrdi[0][pionMode1]="-";
				boleenSiGagneMode1 = false;
			}
		}
	}
	//Affichage & tests
	static void affichageEtTestMode1(){
		System.out.print("REPONSE: ");
		for (pionMode1=0; pionMode1<Main.nPions; pionMode1++) {
			System.out.print(tableauReponseOrdi[0][pionMode1]);
		}
		//2.1.1.4 test
		if (tourRestantMode1 == 0 && !boleenSiGagneMode1 ) {
			verdictMode1 = "PERDU!";
		}
		else if (boleenSiGagneMode1==true) {
			verdictMode1 = "GAGNE!";
		}
		tourRestantMode1 = Main.nCoups - coupMode1;
		System.out.println(" -> Il vous reste: "+ tourRestantMode1 + " coups!");
	}
}
