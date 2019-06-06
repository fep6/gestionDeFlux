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
	// Mode3 : Définit quel mode a la main 
	static int pModeEnCours;

	ComparatifAffichageTest () {	
	//On rapatrie les données du mode concerné
		if (pModeEnCours==1) {
			setMode1();
		}
		if (pModeEnCours==2) {
			setMode2();	
		}	
		//Pour Mode 3 (prioritaire)
		if (EntreesConfigJeu.modeJeu==3) {
			setMode3();
		}

		
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="
		comparatifCombinaisonSecrete();
	//Affichage & tests
		affichageEtTest();
	}
	
	
	//Méthodes communes aux mode 1,2,3
	
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
			//Test
			
			System.out.println("pTableauJeu["+pCoup+"]["+pion+"] = "+pTableauJeu[pCoup][pion]);
			System.out.println("pCombinaison["+pion+"] = "+pCombinaison[pion]);
			System.out.println("pTableauReponse["+pion+"] = "+pTableauReponse[pCoup][pion]);
			//Fin test	
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
		
		// test
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
		pTourRestant = EntreesConfigJeu.getNCoups() - pCoup;
		System.out.println(" ______________________________________");
		System.out.println(" -> Il reste: "+ (int)(pTourRestant-1) + " coups!");
		System.out.println(" ______________________________________");
	}
	
//Setters
	// On remplit les données de l'instance selon le N° de coup
	void setMode1() {
		pCoup=RechercheMode1.coupMode1;
		pBooleenSiGagne=RechercheMode1.boleenSiGagneMode1;
		pModeEnCours=1;
		
		for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
		pTableauJeu[pCoup][pion]= RechercheMode1.tableauJeuMode1 [pCoup][pion];
		pCombinaison[pion]= RechercheMode1.combinaisonOrdi [pion];
		}
	}
	void setMode2() {
		pCoup=RechercheMode2.coupMode2;
		pBooleenSiGagne=RechercheMode2.boleenSiGagneMode2;
		pModeEnCours=2;
		
		for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
		pTableauJeu[pCoup][pion]= RechercheMode2.tableauJeuMode2 [pCoup][pion];
		pCombinaison[pion]= RechercheMode2.combinaisonJoueur [pion];
		}
	}
	void setMode3() {
		pCoup=RechercheMode3.getCoupMode3();
		pBooleenSiGagne=RechercheMode3.getBoleenSiGagneMode3();
		
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

