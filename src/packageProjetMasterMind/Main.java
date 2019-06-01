package packageProjetMasterMind;

public class Main { 
	
	public static void main(String[] args) {
		
// 1 Entrée du mode, du nombre de pions, du nombre de coups,

		EntreesConfigJeu ecj = new EntreesConfigJeu();
		
// 2 Recherche +/- :
	
		// 2.1 Recherche +/- Mode 1 : 'Challenger' où vous devez trouver la combinaison secréte de l'ordinateur
		if ( EntreesConfigJeu.getModeJeu()  == 1) {
			RechercheMode1 rm1 = new RechercheMode1();
		}	
		// 2.2 Recherche +/- : mode 2 : A l'ordinateur de trouver votre combinaison secrète
		if ( EntreesConfigJeu.getModeJeu()  == 2) {
			RechercheMode2 rm2 = new RechercheMode2();
		}	
		// 2.3 Recherche +/- : mode 3
		if ( EntreesConfigJeu.getModeJeu()  == 3) {
			RechercheMode3 rm3 = new RechercheMode3();
		}	
	System.out.println("fin du jeu");
   }
	
}


