package packageProjetMasterMind;

public class Main { 

static EntreesConfigJeu ecj = new EntreesConfigJeu();
	
	
	public static void main(String[] args) {
		
	ecj.setEntreesConfigJeu();
		
// 2 Recherche +/- :
	if ( EntreesConfigJeu.getModeJeu()  == 1) {
			RechercheMode1 j1 = new RechercheMode1();
		}
	else if ( EntreesConfigJeu.getModeJeu()  == 2) {
			RechercheMode2 j2 = new RechercheMode2();
		}	
		// 2.3 Recherche +/- : mode 3
	else if ( EntreesConfigJeu.getModeJeu()  == 3) {
			RechercheMode3 j3 = new RechercheMode3();
		}	
	System.out.println("fin du jeu");
   }
	
}


