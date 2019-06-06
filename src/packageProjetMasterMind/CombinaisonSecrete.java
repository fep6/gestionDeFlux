package packageProjetMasterMind;

public class CombinaisonSecrete {

//1.2  Création Combinaison secrète de l'ordi.(pour modes 1 & 3)
int combinaisonSecreteOrdi [] = new int[EntreesConfigJeu.getNPions()];	
int combinaisonSecreteJoueur [] = new int[EntreesConfigJeu.getNPions()];
	
	CombinaisonSecrete(){
		if ( EntreesConfigJeu.getModeJeu()  == 1 ) {
			setCombinaisonSecreteOrdi();
		}
		if ( EntreesConfigJeu.getModeJeu()  == 2) {
			setCombinaisonSecreteJoueur();
		}
		if ( EntreesConfigJeu.getModeJeu()  == 3) {
			setCombinaisonSecreteOrdi();
			setCombinaisonSecreteJoueur();
		}
	}
	
	//Setters
	//Mode1
	void setCombinaisonSecreteOrdi() {
		//1.2.1 Combinaison secrète généré par l'ordi.
		System.out.println("L'ordinateur entre sa combinaison secrète...");
		for (int i=0 ; i<combinaisonSecreteOrdi.length; i++) {
			combinaisonSecreteOrdi[i]=(int) (Math.random()*10);
		}
		// 1.2.2 Triche
		System.out.println("\n \n-------------------------------------");
		System.out.println("TRICHE : combinaisonSecreteOrdi= ");
		for (int i=0 ; i<combinaisonSecreteOrdi.length; i++) {
			System.out.print((int)combinaisonSecreteOrdi[i]);
		}
		System.out.println("\n-------------------------------------");		
	}
	//Mode2
	void setCombinaisonSecreteJoueur(){
		EntreesManuellesDuJeu edjMode2 = new EntreesManuellesDuJeu ();
		System.out.println("Veuillez entrer votre combinaison secrète: ");

		// ..Et on va chercher le retour
		for (int pion = 0 ; pion < EntreesConfigJeu.getNPions(); pion++) {
			combinaisonSecreteJoueur [pion]= edjMode2.getEntree(pion);
		}
		System.out.print("\n ---------------------"+"\nLa proposition est donc: ");
		for (int i = 0 ; i < EntreesConfigJeu.getNPions(); i++) {
			System.out.print(combinaisonSecreteJoueur [i]);
		}
		System.out.print("\n ---------------------");
	}
	
	//Getters
	//Mode1
	int[] getCombinaisonSecreteOrdi() {
		return combinaisonSecreteOrdi;
	}
	//Mode2
	int[] getCombinaisonSecreteJoueur() {
		return combinaisonSecreteJoueur;
	}
	
}
