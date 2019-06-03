package packageProjetMasterMind;

public class ComparatifAffichageTest {
	
	//static int pPion;
	static private int pTableauJeu[][]= new int [EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];
	static private int pCoup;
	static private int pCombinaison[]= new int [EntreesConfigJeu.getNPions()];
	static private String pTableauReponse[][]= new String[EntreesConfigJeu.getNCoups()][EntreesConfigJeu.getNPions()];
	static private boolean pBooleenSiGagne;
	static private int pTourRestant;
	static private String pVerdict = new String();


	ComparatifAffichageTest () {
		
	//On rapatrie les données du mode concerné
		if (EntreesConfigJeu.getModeJeu()==1) {
			setMode1();
		}
		if (EntreesConfigJeu.getModeJeu()==2) {
			// On charge les variables simples
			setVariableEntreeMode2();
		}
		
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="
		comparatifCombinaisonSecrete();
	//Affichage & tests
		affichageEtTest();
	}
	
	
	//Méthodes communes aux mode 1 & 2
	
	static void comparatifCombinaisonSecrete(){
		for (int pion=0; pion<EntreesConfigJeu.getNPions(); pion++) {
			if ( pTableauJeu[pCoup][pion]==pCombinaison[pion] ) {
				pTableauReponse[pCoup][pion]="=";
			}
			if ( pTableauJeu[pCoup][pion]<pCombinaison[pion] ) {
				pTableauReponse[pCoup][pion]="+";
				pBooleenSiGagne = false;
			}
			if ( pTableauJeu[pCoup][pion]>pCombinaison[pion] ) {
				pTableauReponse[pCoup][pion]="-";
				pBooleenSiGagne = false;
			}
		}
	}
	
	public static void affichageEtTest() {
		System.out.print("Reponse: ");
		for (int pion=0; pion<EntreesConfigJeu.getNPions(); pion++) {
			System.out.print(pTableauReponse[pCoup][pion]);
		}
		System.out.println("");
		// test
		if (pTourRestant == 0 && !pBooleenSiGagne ) {
			pVerdict = "PERDU!";
		}
		else if (pBooleenSiGagne==true) {
			pVerdict = "GAGNE!";
		}
		pTourRestant = EntreesConfigJeu.getNCoups() - pCoup;
		System.out.println(" -> Il vous reste: "+ pTourRestant + " coups!");
	}
	
//Setters
	// On remplit les données de l'instance selon le N° de coup
	void setMode1() {
		// pPion=RechercheMode1.pionMode1;
		pCoup=RechercheMode1.coupMode1;
		pBooleenSiGagne=RechercheMode1.boleenSiGagneMode1;
		pTourRestant=RechercheMode1.tourRestantMode1;
		
		for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
		pTableauJeu[pCoup][pion]= RechercheMode1.tableauJeuMode1 [pCoup][pion];
		pCombinaison[pion]= RechercheMode1.combinaisonOrdi [pion];
		}
		
	}
	
	void setVariableEntreeMode2() {
		
		
		//test
		System.out.println("\n Entree dans entreesJeuOrdi() ");
		
		// pPion=RechercheMode2.pionMode2;
		pCoup=RechercheMode2.coupMode2;
		pBooleenSiGagne=RechercheMode2.boleenSiGagneMode2;
		pTourRestant=RechercheMode2.tourRestantMode2;
		
		for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
		// On charge le tableau de travail avec les valeurs du coup d'avant
		pTableauJeu[pCoup][pion]= RechercheMode2.tableauJeuMode2 [pCoup-1][pion];
		pCombinaison[pion]= RechercheMode2.combinaisonJoueur [pion];
		}

		//test
		System.out.println("Sortie de entreesJeuOrdi() \n");
	}
	

	
//Getter
	String getVerdict (){
		return pVerdict;
	}



	
}

