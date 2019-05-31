package packageProjetMasterMind;

public class ComparatifAffichageTest {
	
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
	static void comparatifCombinaisonSecrete(int pion, int reponse[],int combinaisonOrdi[], String correctif [], boolean boleenSiGagne){
		for (pion=0; pion<Main.nPions; pion++) {
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
	
	//Affichage & tests
	static void affichageEtTest(int pion, String correctif [], int tourRestant, boolean boleenSiGagne, String verdict, int coup){
		System.out.print("REPONSE: ");
		for (pion=0; pion<Main.nPions; pion++) {
			System.out.print(correctif[pion]);
		}
		//2.1.1.4 test
		if (tourRestant == 0 && !boleenSiGagne ) {
			verdict = "PERDU!";
		}
		else if (boleenSiGagne==true) {
			verdict = "GAGNE!";
		}
		tourRestant = Main.nCoups - coup;
		System.out.println(" -> Il vous reste: "+ tourRestant + " coups!");
	}	
	
}

