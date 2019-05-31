package packageProjetMasterMind;

public class ComparatifAffichageTest {
	
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
	static void comparatifCombinaisonSecrete(int pPion, int pCoup,int pTableauJeu[][],int pCombinaison[], String tableauReponse[][], boolean pboleenSiGagne){
		for (pPion=0; pPion<Main.nPions; pPion++) {
			if ( pTableauJeu[pCoup][pPion]==pCombinaison[pPion] ) {
				tableauReponse[pCoup][pPion]="=";
			}
			if ( pTableauJeu[pCoup][pPion]<pCombinaison[pPion] ) {
				tableauReponse[pCoup][pPion]="+";
				pboleenSiGagne = false;
			}
			if ( pTableauJeu[pCoup][pPion]>pCombinaison[pPion] ) {
				tableauReponse[pCoup][pPion]="-";
				pboleenSiGagne = false;
			}
		}
	}

	//Affichage & tests
	static void affichageEtTest(int pPion, int pCoup, String pTableauReponse[][], int pTourRestant, boolean pBoleenSiGagne, String pVerdict){
		System.out.print("preponse: ");
		for (pPion=0; pPion<Main.nPions; pPion++) {
			System.out.print(pTableauReponse[pCoup][pPion]);
		}
		//2.1.1.4 test
		if (pTourRestant == 0 && !pBoleenSiGagne ) {
			pVerdict = "PERDU!";
		}
		else if (pBoleenSiGagne==true) {
			pVerdict = "GAGNE!";
		}
		pTourRestant = Main.nCoups - pCoup;
		System.out.println(" -> Il vous reste: "+ pTourRestant + " coups!");
	}	
	
}

