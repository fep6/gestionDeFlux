package packageProjetMasterMind;

public class ComparatifAffichageTest {
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
	static void comparatifCombinaisonSecrete(int pPion, int pCoup,int pTableauJeu[][],
			int pCombinaison[], String pTableauReponse[][], boolean pBoleenSiGagne){
		for (pPion=0; pPion<EntreesConfigJeu.getNPions(); pPion++) {
			if ( pTableauJeu[pCoup][pPion]==pCombinaison[pPion] ) {
				pTableauReponse[pCoup][pPion]="=";
			}
			if ( pTableauJeu[pCoup][pPion]<pCombinaison[pPion] ) {
				pTableauReponse[pCoup][pPion]="+";
				pBoleenSiGagne = false;
			}
			if ( pTableauJeu[pCoup][pPion]>pCombinaison[pPion] ) {
				pTableauReponse[pCoup][pPion]="-";
				pBoleenSiGagne = false;
			}
		}
	}

	//Affichage & tests
	static void affichageEtTest(int pPion, int pCoup, String pTableauReponse[][], 
			int pTourRestant, boolean pBoleenSiGagne, String pVerdict){
		//Affichage réponse
		System.out.print("Reponse: ");
		for (pPion=0; pPion<EntreesConfigJeu.getNPions(); pPion++) {
			System.out.print(pTableauReponse[pCoup][pPion]);
		}
		System.out.println("");
		// test
		if (pTourRestant == 0 && !pBoleenSiGagne ) {
			pVerdict = "PERDU!";
		}
		else if (pBoleenSiGagne==true) {
			pVerdict = "GAGNE!";
		}
		pTourRestant = EntreesConfigJeu.getNCoups() - pCoup;
		System.out.println(" -> Il vous reste: "+ pTourRestant + " coups!");
	}

}
