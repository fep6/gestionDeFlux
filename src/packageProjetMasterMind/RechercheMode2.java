package packageProjetMasterMind;

// Mode 2 "Défenseur": Le joueur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.

public class RechercheMode2 {

	//combinaison de la défense du joueur
	private int combinaisonDefense[] = new int [Main.nPions];
	// Tableau pour la saisie de l'ordinateur, avec son historique
	private int tableauJeu [][] = new int[Main.nCoups][Main.nPions];
	// Tableau de réponse du joueur, avec son historique
	private String  tableauReponseJoueur [][] = new String[Main.nCoups] [Main.nPions];
	// Valeur max du chiffre limite
	private int chiffreMax = 10;
	// Recherche dichotomique 'vers le haut'
	private int dichoPlus = chiffreMax;
	
	// Renvoie si la partie est gagnée ou non
	private String verdict = new String();
	// Nombre de tour de jeu
	private int tour = 0;
	private int tourRestant = Main.nCoups;
	// Variable true si la partie est gagnée
	private boolean boleenSiGagne;
	
	//Boucles
	// Pions
	int i;
	// Coups
	int j;
	// while
	
	boolean while1;
	
	RechercheMode2(){
		
	//2.1 Entrées de la combinaison du joueur 
		entreesJoueur();
		
	// 2.2. Recherche et affichage de l'ordi.
		
		rechercheAffichageOrdi();			

	}
	
	void entreesJoueur(){
	// 2.1.1 Entrées de la combinaison secrète du joueur (var combinaisonDefense)
		//on instancie les entrées de la combinaison du joueur ...
		EntreesManuellesDuJeu tejMode2 = new EntreesManuellesDuJeu ();
		
		System.out.println("veuillez entrer la combinaison: ");

		// ..Et on va chercher le retour
		for (i = 0 ; i < Main.nPions; i++) {
			combinaisonDefense [i]= tejMode2.getEntree(i);
		}
		System.out.print("\n ---------------------"+"\nLa proposition est donc: ");
		for (i = 0 ; i < Main.nPions; i++) {
			System.out.print(combinaisonDefense [i]);
		}
		System.out.print("\n ---------------------");
	}
	
	void rechercheAffichageOrdi(){
	//2.2.1 Recherche 
		do {
		    //2.2.1.1 Entrées de l'ordinateur (var tableauJeu[][]) et recherche dichotomique : 
			// tableauJeu [j][i] : j -> Coup, i -> pion 
			for (j=0;j<(Main.nCoups);j++) {
				
				boleenSiGagne= true;
				tour++;
				System.out.println("\n Nous sommes au tour N° :" + tour);
				
				// 1er coup: On donne la valeur 5 au début
				if (tour==1) {
					for (i=0;i<Main.nPions;i++) {	
						tableauJeu[0][i]=(int) (chiffreMax/2);
					System.out.println("Pion "+ i + " : " + tableauJeu[0][i]);
					}
				// Sinon, l'ordi. tient compte de ce qu'a dit le joueur au coup d'avant (dichotomie)
				} else {
					for (i=0;i<Main.nPions;i++) {
						
						if (tableauReponseJoueur[j-1][i]=="=") {
							tableauJeu[j][i]=tableauJeu[j-1][i];
							System.out.println("Pion "+ i + " : " + tableauJeu[j][i]);
							}			
						else if (tableauReponseJoueur[j-1][i]=="+") {
							// Si c'est "+", au deuxième tour on tend la recherche vers dichoPlus
								
							//recherche dichotomique 'vers le haut')
								tableauJeu[j][i]=((tableauJeu[j-1][i] +dichoPlus)/2);
								System.out.println("Pion "+ i + " : " + tableauJeu[j][i]);
											
							}			
						else if (tableauReponseJoueur[j-1][i]=="-") {
							// La recherche se fera vers le '-', tableauJeu[j-1][i] deviendra donc la borne supérieure de la recherche dichotomique
							// dichoPlus = dichoPlus/2;
							dichoPlus = tableauJeu[j-1][i];
							
							// Si c'est "-", on divise par 2
							tableauJeu[j][i]=(tableauJeu[j-1][i])/2;
							System.out.println("Pion "+ i + " : " + tableauJeu[j][i]);
						}
					}
				}
				//2.1.1.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
				for (i=0; i<Main.nPions; i++) {
					if ( tableauJeu[j][i]==combinaisonDefense[i] ) {
						tableauReponseJoueur[j][i]="=";
					}
					if ( tableauJeu[j][i]<combinaisonDefense[i] ) {
						tableauReponseJoueur[j][i]="+";
						boleenSiGagne = false;
					}
					if ( tableauJeu[j][i]>combinaisonDefense[i] ) {
						tableauReponseJoueur[j][i]="-";
						boleenSiGagne = false;
					}
				}
				
				//2.1.1.3 Affichage & tests
				System.out.print("REPONSE: ");
				for (i=0; i<Main.nPions; i++) {
					System.out.print(tableauReponseJoueur[j][i]);
				}

				System.out.println("");
				
				//2.1.1.4 test
				
				if (tourRestant == 0 && !boleenSiGagne ) {
					verdict = "PERDU!";
				}
				else if (boleenSiGagne==true) {
					// Ne sors pas du while ...(?)
					verdict = "GAGNE!";
					//test
					while1 = !verdict.equals("GAGNE!") && !verdict.equals("PERDU!");
					
					//test
					System.out.println("while (dans boucle test) = " + while1);
				}
				//test
				System.out.println("while (fin boucle test)= " + while1);
				
				tourRestant = Main.nCoups - tour;
				System.out.println(" -> Il vous reste: "+ tourRestant + " coups!");
			}
			System.out.println("verdict =" + verdict);
			
		} while (!verdict.equals("GAGNE!") && !verdict.equals("PERDU!")) ;
		System.out.println("...Fin de la partie : L'ordinateur a "+ verdict);
	}
}
