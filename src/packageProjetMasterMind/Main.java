package packageProjetMasterMind;

public class Main {
	// Mode de jeu
	public static int modeJeu; 
	// Nombre de coups
	public static int nCoups; 
	// Nombre de pions
	public static int nPions;
	
	public static void main(String[] args) {
		
// 1 Entrée du mode, du nombre de pions, du nombre de coups,

		EntreesConfigJeu ecj = new EntreesConfigJeu();
		modeJeu = ecj.getModeJeu(); 
		nCoups = ecj.getNCoups(); 
		nPions = ecj.getNPions(); 
		
// 2 Recherche +/- : 
	
		// 2.1 Recherche +/- Mode 1 : 'Challenger' où vous devez trouver la combinaison secréte de l'ordinateur
		if ( modeJeu == 1) {
			RechercheMode1 rm1 = new RechercheMode1();
		}	
		// 2.2 Recherche +/- : mode 2 : A l'ordinateur de trouver votre combinaison secrète
		if ( modeJeu == 2) {
			RechercheMode2 rm2 = new RechercheMode2();
		}	
		// 2.3 Recherche +/- : mode 3
		if ( modeJeu == 3) {
			RechercheMode3 rm3 = new RechercheMode3();
		}	
	System.out.println("fin du jeu");
   }
	
}


