package packageProjetMasterMind;

// Mode 1 "Challenger" : L'intelligence artificielle de l’ordinateur joue le rôle de défenseur. 
//			Elle définit une combinaison de X chiffres aléatoirement.

public class RechercheMode1 {
	

//Tableau 2d
	//Tableau pour la saisie d'entrée du joueur
	static int[][] tableauJeuMode1 = new int[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];	
	// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur
	static String tableauReponseOrdi [][]= new String[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];
	
//Tableau 1d
	//Combinaison de l'ordinateur
	static int combinaisonOrdi [] = new int [EntreesConfigJeu.getNPions()];
		
// Variables
	//Variable true si la partie est gagnée
	static boolean boleenSiGagneMode1;
	//Nombre de tour de jeu
	static int coupMode1 =0;
	//tour restant
	static int tourRestantMode1= EntreesConfigJeu.getNCoups();
	// Renvoie si la partie est gagnée ou non
	private static String verdictMode1="";

	RechercheMode1(){
		
		//2.1  Entrée de la combinaison de l'ordi.:
		CombinaisonSecrete cso = new CombinaisonSecrete();
		combinaisonOrdi= cso.getCombinaisonSecreteOrdi();
		
		//2.2 recherche +/- et affichage	
		while (verdictMode1 != "GAGNE!" && verdictMode1 != "PERDU!") {
			boleenSiGagneMode1= true;
			
		    //2.2.1 entrées du joueur
			entreesJoueur();

	 		//2.2.2 Jeux
 			ComparatifAffichageTest cat1 = new ComparatifAffichageTest();
 			verdictMode1=cat1.getVerdict();

			coupMode1++;
		}
		System.out.println("...Mais c'est "+verdictMode1);
	}
	
	//entrées du joueur (var reponse)
	static void entreesJoueur() {
		System.out.print("Veuillez entrer votre code: ");
		EntreesDuJeu tejMode1 = new EntreesDuJeu ();
		// Rapatriement des données de l'instance tej dans la variable de classe tableauJeuMode1
		for (int pion=0;pion<EntreesConfigJeu.getNPions();pion++) {				
			tableauJeuMode1[coupMode1][pion]=tejMode1.getEntree(pion);	
		}
	}
}

	

