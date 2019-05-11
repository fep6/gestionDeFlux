package packageProjetMasterMind;
import java.util.Scanner;

// Mode 1 : 'Challenger' où vous devez trouver la combinaison secréte de l'ordinateur


public class RechercheMode1 {
	
// Renvoie si la partie est gagnée ou non
private String verdict = new String();
// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur
private String correctif []= new String[Main.nPions];
// Nombre de tour de jeu
private int tour = 0;
private int tourRestant = Main.nCoups;
// Variable true si la partie est gagnée
private static boolean boleenSiGagne= true;

private Scanner sc = new Scanner(System.in);
// Tableau pour la saisie d'entrée	
private int reponse1 [] = new int[Main.nPions];


	RechercheMode1(){
		
	if (Main.modeJeu == 1) {
			//2.1.1 par tableau (combinaison1, reponse1)
			while (verdict != "GAGNE!" || verdict != "PERDU!") {
				
			    //2.1.1.1 entrées du joueur (var reponse1)
				
				tour++;
				
				// entrées et tests 
				EntreesEtTestJeu tej = new EntreesEtTestJeu ();
				
				// Rapatriement des données de l'instance tej dans la variable de classe reponse1
				for (int i=0;i<Main.nPions;i++) {
					
					reponse1[i]=tej.getReponse1(i);
					
					//tests
					System.out.println("test: tej.getReponse1(" + i + ")= " + tej.getReponse1(i));
					System.out.println("test: RechercheMode1.reponse1[" + i + "]= " + reponse1[i]);
					
				}
				
				//2.1.1.2 comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			

				for (int i=0; i<Main.nPions; i++) {
					if ( reponse1[i]==Main.combinaisonDefense[i] ) {
						correctif[i]="=";
					}
					if ( reponse1[i]<Main.combinaisonDefense[i] ) {
						correctif[i]="-";
						boleenSiGagne = false;
					}
					if ( reponse1[i]>Main.combinaisonDefense[i] ) {
						correctif[i]="+";
						boleenSiGagne = false;
					}
				}
				//2.1.1.3 Affichage & tests
				System.out.println("Réponse:");
				for (int i=0; i<Main.nPions; i++) {
					System.out.print(correctif[i]);
				}
				
				//2.1.1.4 test
				tourRestant = Main.nCoups - tour;
				System.out.println(" -> Il vous reste: "+ tourRestant + " coups!");
				if (tourRestant == 0 &&  !boleenSiGagne ) {
					verdict = "PERDU!";
				}
				else if (boleenSiGagne) {
					verdict = "GAGNE!";
				}
			}
			System.out.println(verdict);
		}
	}
}
