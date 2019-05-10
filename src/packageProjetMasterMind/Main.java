package packageProjetMasterMind;

import java.util.Scanner;

public class Main {

	public static int modeJeu; 
	public static int nCoups; 
	public static int nPions; 
	public static int nCouleurs; 
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
// 1 Choix du jeu et du mode
		
	//1.1 Entrée du mode, du nombre de pions, nombre de couleurs, du nombre de coups,

		EntreesConfigJeu entrees = new EntreesConfigJeu();
		modeJeu = entrees.getModeJeu(); 
		nCoups = entrees.getNCoups(); 
		nPions = entrees.getNPions(); 
		nCouleurs = entrees.getNCouleurs();

	//1.2  Création Combinaison secrète de l'ordi., et entrées du joueur (pour modes 1 & 3):

		CombinaisonSecreteOrdiEntreesJoueur csoj = new CombinaisonSecreteOrdiEntreesJoueur();

	// 2 Recherche +/- : 
	
	// 2.1 Recherche +/- Mode 1 : 'Challenger' o� vous devez trouver la combinaison secréte de l'ordinateur
	if (modeJeu == 1) {
		String verdict = new String();
		// Variable réponse corrective de l'ordinateur
		String correctif []= new String[nPions];
		int tour = 0;
		int tourRestant = nCoups;
		boolean boleenSiGagne;
		
		//2.1.1 par tableau (combinaison1, reponse1)
		while (verdict != "GAGNE!" || verdict != "PERDU!") {
			
			//2.1.1.1 entrées du joueur (var reponse1)
			tour++;
			System.out.println("\n \n Veuillez entrer votre code:");
			
// Code de factorisation du test de l'entrée
			
			TestEntreesJeu entreesJeu = new TestEntreesJeu (csoj.reponse1,nCouleurs);
			
			//2.1.1.2 comparatif combinaison secrète / entrée => réponse ordinateur
			boleenSiGagne = true;
			
			for (int i=0; i<nPions; i++) {
				if ( csoj.reponse1[i]==csoj.combinaisonDefense[i] ) {
					correctif[i]="=";
				}
				if ( csoj.reponse1[i]<csoj.combinaisonDefense[i] ) {
					correctif[i]="-";
					boleenSiGagne = false;
				}
				if ( csoj.reponse1[i]>csoj.combinaisonDefense[i] ) {
					correctif[i]="+";
					boleenSiGagne = false;
				}
			}
			//2.1.1.3 Affichage & tests
			System.out.println("Réponse:");
			for (int i=0; i<nPions; i++) {
				System.out.print(correctif[i]);
			}
			
			//2.1.1.4 test
			tourRestant = nCoups - tour;
			System.out.println(" -> Il vous reste: "+ tourRestant + " coups!");
			System.out.println(" TRICHE 2 : reponse1 "+ csoj.reponse1 + " 1 combinaisonDefense "+ csoj.combinaisonDefense);
			if (tourRestant == 0 &&  !boleenSiGagne ) {
				verdict = "PERDU!";
			}
			else if (boleenSiGagne) {
				verdict = "GAGNE!";
			}
		}
		System.out.println(verdict);
	}
			
			// 2.2 Recherche +/- : mode 2 : A l'ordinateur de trouver votre combinaison secrète
	if (  modeJeu == 2) { 
		String verdict = new String();
		verdict = "";
		// Nombre de tours
		int tour = 0;
		// Création tableau 2d réponse (/joueur) j->position pion, k->N coup.
		String tableauReponseJoueur [][]=new String [nPions][nCoups];
		// Création tableau 3d (/ordi)  i->position pion, j->N coup.
		int tableauJeu [][] = new int [nPions][nCoups];	
		
		
	// 2.2.1 Entr�es du joueur (var combinaisonDefense)
		for (int i = 0 ; i < nPions; i++) {
			System.out.println("veuillez entrer la couleur du " + (i+1) + " eme pion: ");
			csoj.combinaisonDefense [i]= sc.nextInt();
		}
		System.out.print("\n ---------------------"+"\nLa proposition est donc: ");
		for (int i = 0 ; i < nPions; i++) {
			System.out.print(csoj.combinaisonDefense [i]);
		}
		System.out.print("\n ---------------------");
		
	// 2.2.2 Recherche et affichage de l'ordi.	
	
		// Recherche par l'ordi.
		while (verdict != "GAGNE!" || verdict != "PERDU!") {
			for (int j=0;j<nCoups;j++) {
				tour++;
				System.out.println("Nous sommes au tour :" + tour);
				// 1er coup: On donne une couleur aléatoire differente à chaque pion
				if (tour==1) {
					for (int i=0;i<nPions;i++) {
					tableauJeu[i][0]=(int)(Math.random()*nCouleurs);
					System.out.println("Pion "+ i + " : " + tableauJeu[i][0]);
					}
				// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant
			} else {
				for (int i=0;i<nPions;i++) {	
					if (tableauReponseJoueur[i][j-1]=="=") {
						tableauJeu[i][j]=tableauJeu[i][j-1];
						System.out.println("Pion "+ i + " : " + tableauJeu[i][j]);
						continue;
						}			
					if (tableauReponseJoueur[i][j-1]=="+") {
						tableauJeu[i][j]=(tableauJeu[i][j-1]+nCouleurs)/2;
						System.out.println("Pion "+ i + " : " + tableauJeu[i][j]);
						continue;
						}			
					if (tableauReponseJoueur[i][j-1]=="-") {
						tableauJeu[i][j]=(tableauJeu[i][j-1])/2;
						System.out.println("Pion "+ i + " : " + tableauJeu[i][j]);
						}
					}
				}
				// 2.2.3 Entrée de la réponse du joueur (var tableauReponseJoueur)
				for (int i=0;i<nPions;i++) {
				System.out.println("Veuillez entrer la r�ponse du " + (i+1) + " eme pion.");
				tableauReponseJoueur[i][j]=sc.nextLine();
				while (tableauReponseJoueur[i][j] != "=" && tableauReponseJoueur[i][j] != "+" 
						&& tableauReponseJoueur[i][j] != "-") {
					System.out.println("Merci d'entrer une valeur ad�quate: + ou - ou =");
					tableauReponseJoueur[i][j]=sc.nextLine();
					}
				}
			}
		}	
	}
			
	
			// 2.3 Recherche +/- : mode 3
	
	if ( modeJeu == 3) {
		
	}
			
			
			

// System.out.println("jeu = "+ typeJeu + "modeJeu = "+modeJeu);	
System.out.println("fin du jeu");

   }
	
}


