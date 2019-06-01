package packageProjetMasterMind;

public class ComparatifAffichageTest2 {
	
	int pPion;
	int pTableauJeu[][]= new int [Main.nCoups][Main.nPions];
	int pCoup;
	int pCombinaison[]= new int [Main.nPions];
	String pTableauReponse[][]= new String[Main.nCoups][Main.nPions];
	boolean pBoleenSiGagne;
	int pTourRestant;
	String pVerdict = new String();
	
	ComparatifAffichageTest2 (pPion,pTableauJeu,pCoup,pCombinaison,pTableauReponse,
			pBoleenSiGagne,pTourRestant,pVerdict) {
	
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="//	static void comparatifCombinaisonSecrete(int pPion, int pCoup,int pTableauJeu[][],int pCombinaison[], String tableauReponse[][], boolean pBoleenSiGagne){
		for (pPion=0; pPion<Main.nPions; pPion++) {
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
	
	getComparatifAffichageTest2 (pPion,pTableauJeu,pCoup,pCombinaison,pTableauReponse,
			pBoleenSiGagne,pTourRestant,pVerdict){
		return pPion;
		return pTableauJeu;
		return pCoup;
		return pCombinaison;
		return pTableauReponse;
		return pBoleenSiGagne;
		return pTourRestant;
		return pVerdict;

	}
	


	}

