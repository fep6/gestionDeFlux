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


	ComparatifAffichageTest2 () {
		
	//On rapatrie les données du mode concerné
		if (EntreesConfigJeu.getModeJeu()==1) {
			setMode1();
		}
		if (EntreesConfigJeu.getModeJeu()==2) {
			setMode2();
		}
		
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="
		comparatifCombinaisonSecrete();
	//Affichage & tests
		affichageEtTest();
	}
	
	
	//Méthodes
	
	void comparatifCombinaisonSecrete(){
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
	}
	
	void affichageEtTest() {
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
	
//Setters
	// On remplit les données de l'instance selon le N° de coup
	void setMode1() {
		pPion=RechercheMode1.pionMode1;
		pCoup=RechercheMode1.coupMode1;
		pBoleenSiGagne=RechercheMode1.boleenSiGagneMode1;
		pTourRestant=RechercheMode1.tourRestantMode1;
		
		for (int pion=0; pion<Main.nPions;pion++) {
		// test : bug
		pTableauJeu[pCoup][pion]= RechercheMode1.tableauJeuMode1 [pCoup][pion];
		//test : ok
		pCombinaison[pion]= RechercheMode1.combinaisonOrdi [pion];
		pTableauReponse[pCoup][pion]= RechercheMode1.tableauReponseOrdi [pCoup][pion];
		}
		
	}
	
	void setMode2() {
		pPion=RechercheMode2.pionMode2;
		pCoup=RechercheMode2.coupMode2;
		pBoleenSiGagne=RechercheMode2.boleenSiGagneMode2;
		pTourRestant=RechercheMode2.tourRestantMode2;
		
		for (int pion=0; pion<Main.nPions;pion++) {
		pTableauJeu[pCoup][pion]= RechercheMode2.tableauJeuMode2 [pCoup][pion];
		pCombinaison[pion]= RechercheMode2.combinaisonJoueur [pion];
		pTableauReponse[pCoup][pion]= RechercheMode2.tableauReponseJoueur [pCoup][pion];
		}
	}
	
//Getter
	String getVerdict (){
		return pVerdict;
	}
	
}

