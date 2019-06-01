package packageProjetMasterMind;

// Mode 1 "Challenger" : L'intelligence artificielle de l’ordinateur joue le rôle de défenseur. 
//			Elle définit une combinaison de X chiffres aléatoirement.

public class RechercheMode1 {
	

//Tableau 2d
	//Tableau pour la saisie d'entrée du joueur
	static int[][] tableauJeuMode1 = new int[Main.nCoups][Main.nPions];	
	// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur
	static String tableauReponseOrdi [][]= new String[Main.nCoups][Main.nPions];
	
//Tableau 1d
	//Combinaison de l'ordinateur
	static int combinaisonOrdi [] = new int [Main.nPions];
	
	
// Variables
	//Variable true si la partie est gagnée
	static boolean boleenSiGagneMode1;
	//Nombre de tour de jeu
	static int coupMode1 =0;
	//tour restant
	static int tourRestantMode1= Main.nCoups;
	//N° de pionMode1
	static int pionMode1;
	// Renvoie si la partie est gagnée ou non
	private static String verdictMode1="";
 


	RechercheMode1(){
		
		//2.1  Entrée de la combinaison de l'ordi.:
		CombinaisonSecrete cso = new CombinaisonSecrete();
		combinaisonOrdi= cso.getCombinaisonSecreteOrdi();
		
		//2.2 recherche +/- et affichage	
		while (verdictMode1 != "GAGNE!" && verdictMode1 != "PERDU!") {
			coupMode1++;
			boleenSiGagneMode1= true;
			
			    //2.2.1 entrées du joueur (var reponse)
				entreesJoueur();
				//2.2.2 Jeux

				 		//Avec instanciation  ComparatifAffichageTest2
				 			ComparatifAffichageTest2 cat = new ComparatifAffichageTest2();
				 			verdictMode1=cat.getVerdict();
				
		}
		System.out.println("...Mais c'est "+verdictMode1);
	}
	
	//entrées du joueur (var reponse)
	static void entreesJoueur() {
		System.out.print("Veuillez entrer votre code: ");
		EntreesManuellesDuJeu tejMode1 = new EntreesManuellesDuJeu ();
		// Rapatriement des données de l'instance tej dans la variable de classe tableauJeuMode1
		for (pionMode1=0;pionMode1<Main.nPions;pionMode1++) {				
			tableauJeuMode1[coupMode1][pionMode1]=tejMode1.getEntree(pionMode1);	
		}
	}
}

	

