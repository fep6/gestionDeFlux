package packageProjetMasterMind;

public class ComparatifAffichageTest {
	
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
	static void comparatifCombinaisonSecrete(int ppion, int preponse[],int pcombinaisonOrdi[], String pcorrectif [], boolean pboleenSiGagne){
		for (ppion=0; ppion<Main.nPions; ppion++) {
			if ( preponse[ppion]==pcombinaisonOrdi[ppion] ) {
				pcorrectif[ppion]="=";
			}
			if ( preponse[ppion]<pcombinaisonOrdi[ppion] ) {
				pcorrectif[ppion]="+";
				pboleenSiGagne = false;
			}
			if ( preponse[ppion]>pcombinaisonOrdi[ppion] ) {
				pcorrectif[ppion]="-";
				pboleenSiGagne = false;
			}
		}
	}
	
	//Affichage & tests
	static void affichageEtTest(int ppion, String pcorrectif [], int ptourRestant, boolean pboleenSiGagne, String pverdict, int coup){
		System.out.print("preponse: ");
		for (ppion=0; ppion<Main.nPions; ppion++) {
			System.out.print(pcorrectif[ppion]);
		}
		//2.1.1.4 test
		if (ptourRestant == 0 && !pboleenSiGagne ) {
			pverdict = "PERDU!";
		}
		else if (pboleenSiGagne==true) {
			pverdict = "GAGNE!";
		}
		ptourRestant = Main.nCoups - coup;
		System.out.println(" -> Il vous reste: "+ ptourRestant + " coups!");
	}	
	
}

