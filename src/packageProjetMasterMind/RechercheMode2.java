package packageProjetMasterMind;
import java.util.Scanner;

// Mode 2 : A l'ordinateur de trouver votre combinaison secrète

public class RechercheMode2 {

	//combinaison de la défense du joueur
	private int combinaisonDefense[] = new int [Main.nPions];
	// Tableau pour la saisie de l'ordinateur, avec son historique
	private int tableauJeu [][] = new int[Main.nPions][Main.nCoups];
	// Tableau de réponse du joueur, avec son historique
	private String  tableauReponseJoueur [][] = new String [Main.nPions][Main.nCoups];
	
	// Renvoie si la partie est gagnée ou non
	private String verdict = new String();
	// Variable réponse corrective du joueur en fonction du jeu de l'ordinateur
	// private String correctif []= new String[Main.nPions];
	// Nombre de tour de jeu
	private int tour = 0;
	private int tourRestant = Main.nCoups;
	// Variable true si la partie est gagnée
	private boolean boleenSiGagne;
	//Entrées clavier
	private Scanner sc = new Scanner(System.in);


	RechercheMode2(){
			
	//2.1 Entrées de la combinaison du joueur 
		// 2.1.1 Entrées de la combinaison secrète du joueur (var combinaisonDefense)
		for (int i = 0 ; i < Main.nPions; i++) {
			if (i==0) {
				System.out.println("veuillez entrer le chiffre du " + (i+1) + " er pion: ");
			}
			else {
				System.out.println("veuillez entrer le chiffre du " + (i+1) + " eme pion: ");
			}
			combinaisonDefense [i]= sc.nextInt();
		}
		System.out.print("\n ---------------------"+"\nLa proposition est donc: ");
		for (int i = 0 ; i < Main.nPions; i++) {
			System.out.print(combinaisonDefense [i]);
		}
		System.out.print("\n ---------------------");
		
	// 2.2. Recherche et affichage de l'ordi.
			
		//2.2.1 Recherche  (combinaison1, reponse2)
		while (verdict != "GAGNE!" && verdict != "PERDU!") {
			

		    //2.2.1.1 Entrées de l'ordinateur (var reponse2) et recherche dichotomique : 
			// reponse2 [j][i] : j -> Coup, i -> pion 
			for (int j=0;j<(Main.nCoups);j++) {
				
				boleenSiGagne= true;
				tour++;
				System.out.println("\n Nous sommes au tour N° :" + tour);
				
				
				// 1er coup: On donne un code aléatoire differente à chaque pion
				if (tour==1) {
					for (int i=0;i<Main.nPions;i++) {
						tableauJeu[0][i]=(int)(Math.random()*9);
					System.out.println("Pion "+ i + " : " + tableauJeu[0][i]);
					}
				// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant (dichotomie)
				} else {
					for (int i=0;i<Main.nPions;i++) {
						
						// 
						
						
						if (tableauReponseJoueur[j-1][i]=="=") {
							tableauJeu[j][i]=tableauJeu[j-1][i];
							System.out.println("Pion "+ i + " : " + tableauJeu[j][i]);
							continue;
							}			
						if (tableauReponseJoueur[j-1][i]=="+") {
							tableauJeu[j][i]=(tableauJeu[j-1][i])/2;
							System.out.println("Pion "+ i + " : " + tableauJeu[j][i]);
							continue;
							}			
						if (tableauReponseJoueur[j-1][i]=="-") {
							tableauJeu[j][i]=(tableauJeu[j-1][i]+9)/2;
							System.out.println("Pion "+ i + " : " + tableauJeu[j][i]);
							
							
						}
					}
				}
			
		
				
				//2.1.1.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			

				for (int i=0; i<Main.nPions; i++) {
					if ( tableauJeu[j][i]==combinaisonDefense[i] ) {
						tableauReponseJoueur[j][i]="=";
					}
					if ( tableauJeu[j][i]<combinaisonDefense[i] ) {
						tableauReponseJoueur[j][i]="-";
						boleenSiGagne = false;
					}
					if ( tableauJeu[j][i]>combinaisonDefense[i] ) {
						tableauReponseJoueur[j][i]="+";
						boleenSiGagne = false;
					}
				}
			//2.1.1.3 Affichage & tests
			System.out.print("REPONSE: ");
			for (int i=0; i<Main.nPions; i++) {
				System.out.print(tableauReponseJoueur[j][i]);
			}
			
			//2.1.1.4 test
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
