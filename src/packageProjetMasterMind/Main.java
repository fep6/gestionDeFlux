package packageProjetMasterMind;

import java.util.Scanner;

public class Main {
	// Mode de jeu
	public static int modeJeu; 
	// Nombre de coups
	public static int nCoups; 
	// Nombre de pions
	public static int nPions;
	// Nombre de couleurs
	public static int nCouleurs;
	// Combinaison de l'ordinateur (mode1)
	static int combinaisonDefense [];
	
	static int CombinaisonAttaque [];
	
	static int reponse1 [];

	Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
// 1 Choix du jeu et du mode
		
	//1.1 Entrée du mode, du nombre de pions, nombre de couleurs, du nombre de coups,

		EntreesConfigJeu entrees = new EntreesConfigJeu();
		modeJeu = entrees.getModeJeu(); 
		nCoups = entrees.getNCoups(); 
		nPions = entrees.getNPions(); 
		nCouleurs = entrees.getNCouleurs();

	//1.2  Création Combinaison secrète de l'ordi. (pour modes 1 & 3):

		CombinaisonSecreteOrdi cso = new CombinaisonSecreteOrdi();
		combinaisonDefense= cso.getCombinaisonDefense();
		
	// 2 Recherche +/- : 
	
	// 2.1 Recherche +/- Mode 1 : 'Challenger' où vous devez trouver la combinaison secréte de l'ordinateur
	
		RechercheMode1 rm1 = new RechercheMode1();
			
			// 2.2 Recherche +/- : mode 2 : A l'ordinateur de trouver votre combinaison secrète

		RechercheMode2 rm2 = new RechercheMode2();
			
	
			// 2.3 Recherche +/- : mode 3
	
	if ( modeJeu == 3) {
		
	}
			
			
			

// System.out.println("jeu = "+ typeJeu + "modeJeu = "+modeJeu);	
System.out.println("fin du jeu");

   }
	
}


