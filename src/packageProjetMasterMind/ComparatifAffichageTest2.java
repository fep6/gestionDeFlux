package packageProjetMasterMind;

public class ComparatifAffichageTest2 {
	
	ComparatifAffichageTest2(int pPion, int pCoup,int pTableauJeu[][],int pCombinaison[], String tableauReponse[][], boolean pBoleenSiGagne,String pTableauReponse[][],int pTourRestant,String pVerdict){
	
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="//	static void comparatifCombinaisonSecrete(int pPion, int pCoup,int pTableauJeu[][],int pCombinaison[], String tableauReponse[][], boolean pBoleenSiGagne){
		for (pPion=0; pPion<Main.nPions; pPion++) {
			if ( pTableauJeu[pCoup][pPion]==pCombinaison[pPion] ) {
				tableauReponse[pCoup][pPion]="=";
			}
			if ( pTableauJeu[pCoup][pPion]<pCombinaison[pPion] ) {
				tableauReponse[pCoup][pPion]="+";
				pBoleenSiGagne = false;
			}
			if ( pTableauJeu[pCoup][pPion]>pCombinaison[pPion] ) {
				tableauReponse[pCoup][pPion]="-";
				pBoleenSiGagne = false;
			}
		}

	//Affichage & tests
		//Affichage réponse
		System.out.print("Reponse: ");
		for (pPion=0; pPion<Main.nPions; pPion++) {
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
		pTourRestant = Main.nCoups - pCoup;
		System.out.println(" -> Il vous reste: "+ pTourRestant + " coups!");
		
	}
	
}

