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
		System.out.println(" -> Il reste: "+ pTourRestant + " coups!");
	}
	
//Setters
	// On remplit les données de l'instance selon le N° de coup
	void setMode1() {
		pCoup=RechercheMode1.coupMode1;
		pBooleenSiGagne=RechercheMode1.boleenSiGagneMode1;
		pTourRestant=RechercheMode1.tourRestantMode1;
		pModeEnCours=1;
		
		for (int pion=0; pion<EntreesConfigJeu.getNPions();pion++) {
		pTableauJeu[pCoup][pion]= RechercheMode1.tableauJeuMode1 [pCoup][pion];
		pCombinaison[pion]= RechercheMode1.combinaisonOrdi [pion];
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
	
//Getter
	static String getTableauReponse(int coup,int pion) {
		return pTableauReponse [coup][pion];
	}
	String getVerdict (){
		return pVerdict;
	}

}

