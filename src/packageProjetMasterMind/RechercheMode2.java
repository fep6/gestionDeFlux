package packageProjetMasterMind;

import java.util.Scanner;

public class RechercheMode2 {

// Renvoie si la partie est gagnée ou non	 
String verdict = new String();
// Nombre de tours
int tour = 0;
// Création tableau 2d réponse (/joueur) j->position pion, k->N coup.
String tableauReponseJoueur [][]=new String [Main.nPions][Main.nCoups];
// Création tableau 2d (/ordi)  i->position pion, j->N coup.
int tableauJeu [][] = new int [Main.nPions][Main.nCoups];
//Entrée clavier
Scanner sc = new Scanner(System.in);
	
RechercheMode2(){
	
	if (Main.modeJeu == 2) {
		
	// 2.2.1 Entrées du joueur (var combinaisonDefense)
		for (int i = 0 ; i < Main.nPions; i++) {
			System.out.println("veuillez entrer la couleur du " + (i+1) + " eme pion: ");
			Main.combinaisonDefense [i]= sc.nextInt();
		}
		System.out.print("\n ---------------------"+"\nLa proposition est donc: ");
		for (int i = 0 ; i < Main.nPions; i++) {
			System.out.print(Main.combinaisonDefense [i]);
		}
		System.out.print("\n ---------------------");
		
	// 2.2.2 Recherche et affichage de l'ordi.	
	
		// Recherche par l'ordi.
		while (verdict != "GAGNE!" || verdict != "PERDU!") {
			for (int j=0;j<Main.nCoups;j++) {
				tour++;
				System.out.println("Nous sommes au tour :" + tour);
				// 1er coup: On donne une couleur aléatoire differente à chaque pion
				if (tour==1) {
					for (int i=0;i<Main.nPions;i++) {
//					tableauJeu[i][0]=(int)(Math.random()*Main.nCouleurs);
					tableauJeu[i][0]=(int)(Math.random()*9);
					System.out.println("Pion "+ i + " : " + tableauJeu[i][0]);
					}
				// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant
			} else {
				for (int i=0;i<Main.nPions;i++) {	
					if (tableauReponseJoueur[i][j-1]=="=") {
						tableauJeu[i][j]=tableauJeu[i][j-1];
						System.out.println("Pion "+ i + " : " + tableauJeu[i][j]);
						continue;
						}			
					if (tableauReponseJoueur[i][j-1]=="+") {
//						tableauJeu[i][j]=(tableauJeu[i][j-1]+Main.nCouleurs)/2;
						tableauJeu[i][j]=(tableauJeu[i][j-1]+9)/2;
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
				for (int i=0;i<Main.nPions;i++) {
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
	}
}