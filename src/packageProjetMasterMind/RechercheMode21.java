package packageProjetMasterMind;

import java.util.Scanner;

public class RechercheMode21 {

// Renvoie si la partie est gagnée ou non	 
private String verdict = new String();
// Création tableau 2d réponse (/joueur) j->position pion, k->N coup.
private String tableauReponseJoueur [][]=new String [Main.nPions][Main.nCoups];
// Création tableau 2d (/ordi)  i->position pion, j->N coup.
private int tableauJeu [][] = new int [Main.nPions][Main.nCoups];
//Entrée clavier
Scanner sc = new Scanner(System.in);
//Nombre de tour de jeu
private int tour = 0;
private int tourRestant = Main.nCoups;
// Variable de gain de partie
private boolean boleenSiGagne; 
	
RechercheMode21(){
		
	// 2.2.1 Entrées du joueur (var combinaisonDefense)
		for (int i = 0 ; i < Main.nPions; i++) {
			if (i==0) {
				System.out.println("veuillez entrer le chiffre du " + (i+1) + " er pion: ");
			}
			else {
				System.out.println("veuillez entrer le chiffre du " + (i+1) + " eme pion: ");
			}
			Main.combinaisonDefense [i]= sc.nextInt();
		}
		System.out.print("\n ---------------------"+"\nLa proposition est donc: ");
		for (int i = 0 ; i < Main.nPions; i++) {
			System.out.print(Main.combinaisonDefense [i]);
		}
		System.out.print("\n ---------------------");
		
	// 2.2.2 Recherche et affichage de l'ordi.	
	
		// Recherche par l'ordi.
		while (verdict != "GAGNE!" && verdict != "PERDU!") {
			for (int j=0;j<(Main.nCoups-1);j++) {
				tour++;
				System.out.println("\n Nous sommes au tour :" + tour);
				// 1er coup: On donne une couleur aléatoire differente à chaque pion
				if (tour==1) {
					for (int i=0;i<Main.nPions;i++) {
//					tableauJeu[i][0]=(int)(Math.random()*Main.nCouleurs);
					tableauJeu[i][0]=(int)(Math.random()*9);
					System.out.println("Pion "+ i + " : " + tableauJeu[i][0]);
					}
				// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant (dichotomie)
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
				// 2.2.3 Entrée de la réponse du joueur (var tableauReponseJoueur) et test
				for (int i=0;i<Main.nPions;i++) {
					boleenSiGagne = false;
					if (i==0) {
						System.out.println("Veuillez entrer la réponse du " + (i+1) + " er pion.");
					}
					if (i>0) {
						System.out.println("Veuillez entrer la réponse du " + (i+1) + " eme pion.");
					}
					tableauReponseJoueur[i][j]=sc.nextLine();
				
				
					//test
					if (tourRestant == 0 && !boleenSiGagne ) {
						verdict = "PERDU!";
					}
					else if (boleenSiGagne==true) {
						verdict = "GAGNE!";
					}
					tourRestant = Main.nCoups - tour;
					System.out.println(" -> Il vous reste: "+ tourRestant + " coups!");
				}
			}
		System.out.println("...Mais c'est "+verdict);
		}
	}
}	
	
