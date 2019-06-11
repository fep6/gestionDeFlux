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
	// Définit quel mode a la main 
	static int pModeEnCours;

	void setComparatifAffichageTest () {
		if (pModeEnCours==1) {
			setMode1();
		}
		if (pModeEnCours==2) {
			setMode2();	
		}
		if (EntreesConfigJeu.modeJeu==3) {
			setMode3();
		}

		comparatifCombinaisonSecrete();
		affichageEtTest();
	}
	
	static void comparatifCombinaisonSecrete(){
		//test
		System.out.println("------\n TEST");
		System.out.println("Mode de jeu en cours ="+pModeEnCours);
		//fin test
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
		if (pModeEnCours==1) {
			System.out.print("Reponse à la proposition du joueur (mode1)");
		} else if (pModeEnCours==2) {
			System.out.print("Reponse à la combinaison de l'ordinateur (Mode2): ");
		} else {
			System.out.print("Erreur dans la donnée de ComparatifAffichageTest.pModeEnCours!!! ");
		}
		for (int pion=0; pion<EntreesConfigJeu.getNPions(); pion++) {
			System.out.print(pTableauReponse[pCoup][pion]);
		}
		System.out.println("");
		if (pTourRestant == 0 && !pBooleenSiGagne && pModeEnCours==1) {
			pVerdict = "LE JOUEUR A PERDU!";
		}
		else if (pBooleenSiGagne==true && pModeEnCours==1) {
			pVerdict = "LE JOUEUR A GAGNE!";
		}
		else if (pTourRestant == 0 && !pBooleenSiGagne && pModeEnCours==2) {
			pVerdict = "L'ORDINATEUR A PERDU!";
		}
		else if (pBooleenSiGagne==true && pModeEnCours==2) {
			pVerdict = "L'ORDINATEUR A GAGNE!";
		} else { 
			pVerdict = "LE JEU EST EN COURS";
		}
	}
// Divers affichage
	void affichageRecapitulatif(int tourRestant, int coup){
			tourRestant = EntreesConfigJeu.getNCoups() - (int)(coup-1);
			System.out.println(" ______________________________________");
			System.out.println(" -> Il reste: "+ (int)(tourRestant-1) + " coups!");
			System.out.println(" ______________________________________");
	}
//Setters
	void setMode1() {
		pCoup=RechercheMode1.getCoupMode1();
		pBooleenSiGagne=RechercheMode1.getBoleenSiGagneMode1();
		pTourRestant=RechercheMode1.getTourRestantMode1();
		pModeEnCours=1;
		for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
		pTableauJeu[pCoup][pion]= RechercheMode1.getTableauJeuMode1(pCoup, pion);
		pCombinaison[pion]= RechercheMode1.getCombinaisonOrdi(pion);
		}
	}
	void setMode2() {
		pCoup=RechercheMode2.coupMode2;
		pBooleenSiGagne=RechercheMode2.boleenSiGagneMode2;
		pTourRestant=RechercheMode2.tourRestantMode2;
		pModeEnCours=2;
		
		for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
		pTableauJeu[pCoup][pion]= RechercheMode2.tableauJeuMode2 [pCoup][pion];
		pCombinaison[pion]= RechercheMode2.combinaisonJoueur [pion];
		}
	}
	void setMode3() {
		pCoup=RechercheMode3.getCoupMode3();
		pBooleenSiGagne=RechercheMode3.getBoleenSiGagneMode3();
		pTourRestant=RechercheMode3.getTourRestantMode3();
		
		if (pModeEnCours==1) {
			for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
				pTableauJeu[pCoup][pion]= RechercheMode3.getTableauJeuMode1 (pCoup,pion);
				pCombinaison[pion]= RechercheMode3.getCombinaisonOrdi(pion);
			}	
		}		
		if (pModeEnCours==2) {
			for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
				pTableauJeu[pCoup][pion]= RechercheMode3.tableauJeuMode2 [pCoup][pion];
				pCombinaison[pion]= RechercheMode3.getCombinaisonJoueur(pion);
			}	
		}			
	}
	
//Getter
	static String getTableauReponse(int coup,int pion) {
		return pTableauReponse [coup][pion];
	}
	String getVerdict (){
		return pVerdict;
	}

}

