package packageProjetMasterMind;

public class ComparatifAffichageTest {
	//Comparatif Mode 1 combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
	static void comparatifCombinaisonSecreteMode1(){
		for (int pion=0; pion<Main.nPions; pion++) {
			if ( reponse[pion]==combinaisonOrdi[pion] ) {
				correctif[pion]="=";
			}
			if ( reponse[pion]<combinaisonOrdi[pion] ) {
				correctif[pion]="+";
				boleenSiGagne = false;
			}
			if ( reponse[pion]>combinaisonOrdi[pion] ) {
				correctif[pion]="-";
				boleenSiGagne = false;
			}
		}
	}
	}
	
	//3.1.1.2 comparatif combinaison secrète / entrée 
	static void comparatifCombinaisonSecreteMode2() {
		for (pion=0; pion<Main.nPions; pion++) {
			if ( tableauJeu[coup][pion]==combinaisonJoueur[pion] ) {
				tableauReponseJoueur[coup][pion]="=";
			}
			if ( tableauJeu[coup][pion]<combinaisonJoueur[pion] ) {
				tableauReponseJoueur[coup][pion]="+";
				boleenSiGagne = false;
			}
			if ( tableauJeu[coup][pion]>combinaisonJoueur[pion] ) {
				tableauReponseJoueur[coup][pion]="-";
				boleenSiGagne = false;
			}
		}		
	}
	
	//Affichage & tests Mode 1
	static void affichageEtTestMode1(){
		System.out.print("REPONSE: ");
		for (int pion=0; pion<Main.nPions; pion++) {
			System.out.print(correctif[pion]);
		}
		//2.1.1.4 test
		if (tourRestantMode1 == 0 && !boleenSiGagne ) {
			verdict = "PERDU!";
		}
		else if (boleenSiGagne==true) {
			verdict = "GAGNE!";
		}
		tourRestantMode1 = Main.nCoups - coup;
		System.out.println(" -> Il vous reste: "+ tourRestantMode1 + " coups!");

	//3.1.1.3 Affichage & tests
	static void affichageEtTestMode2(){
		//Affichage réponse
		System.out.print("REPONSE: ");
		for (pion=0; pion<Main.nPions; pion++) {
			System.out.print(tableauReponseJoueur[coup][pion]);
		}
		System.out.println("");
		
		//test
		tourRestantMode2 = Main.nCoups - coup;
		System.out.println(" -> Il vous reste: "+ tourRestantMode2 + " coups!");
		
		if (tourRestantMode2 == 0 && !boleenSiGagne ) {
			verdict = "PERDU!";
		}
		else if (boleenSiGagne==true) {
			verdict = "GAGNE!";
		}
	}

}
