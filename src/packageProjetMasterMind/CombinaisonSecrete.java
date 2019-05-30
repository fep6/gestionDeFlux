package packageProjetMasterMind;

public class CombinaisonSecrete {

//1.2  Création Combinaison secrète de l'ordi.(pour modes 1 & 3)
int combinaisonSecreteOrdi [] = new int[Main.nPions];	
int combinaisonSecreteJoueur [] = new int[Main.nPions];
	
	CombinaisonSecrete(){
		if ( Main.modeJeu == 1 ) {
			setCombinaisonSecreteOrdi();
		}
		if (Main.modeJeu == 2) {
			setCombinaisonSecreteJoueur();
		}
		if (Main.modeJeu == 3) {
			setCombinaisonSecreteOrdi();
			setCombinaisonSecreteJoueur();
		}
	}
	
	//Setters
	void setCombinaisonSecreteOrdi() {
		//1.2.1 Combinaison secrète généré par l'ordi.
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
	void setCombinaisonSecreteJoueur(){
		EntreesManuellesDuJeu emjMode2 = new EntreesManuellesDuJeu ();
		System.out.println("veuillez entrer la combinaison: ");

		// ..Et on va chercher le retour
		for (int i = 0 ; i < Main.nPions; i++) {
			combinaisonSecreteJoueur [i]= emjMode2.getEntree(i);
		}
		System.out.print("\n ---------------------"+"\nLa proposition est donc: ");
		for (int i = 0 ; i < Main.nPions; i++) {
			System.out.print(combinaisonSecreteJoueur [i]);
		}
		System.out.print("\n ---------------------");
	}
	
	//Getters
	int[] getcombinaisonSecreteOrdi() {
		return combinaisonSecreteOrdi;
	}	//Getters
	int[] getCombinaisonSecreteJoueur() {
		return combinaisonSecreteJoueur;
	}
	
}
