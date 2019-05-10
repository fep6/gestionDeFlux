package packageProjetMasterMind;
 
// Mode 1 : 'Challenger' où vous devez trouver la combinaison secréte de l'ordinateur


public class RechercheMode1 {
	
// Renvoie si la partie est gagnée ou non
String verdict = new String();
// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur
String correctif []= new String[Main.nPions];
// Nombre de tour de jeu
int tour = 0;
int tourRestant = Main.nCoups;
// Variable true si la partie est gagnée
boolean boleenSiGagne;
	
	RechercheMode1(){
		
	if (Main.modeJeu == 1) {
			//2.1.1 par tableau (combinaison1, reponse1)
			while (verdict != "GAGNE!" || verdict != "PERDU!") {
				
				//2.1.1.1 entrées du joueur (var reponse1)
				tour++;
				System.out.println("\n \n Veuillez entrer votre code:");
				
				// test de l'entrée
				
				TestEntreesJeu entreesJeu = new TestEntreesJeu (Main.reponse1,Main.nCouleurs);
				
				//2.1.1.2 comparatif combiaison secrète / entrée => réponse ordinateur
				boleenSiGagne = true;
				
				for (int i=0; i<Main.nPions; i++) {
					if ( Main.reponse1[i]==Main.combinaisonDefense[i] ) {
						correctif[i]="=";
					}
					if ( Main.reponse1[i]<Main.combinaisonDefense[i] ) {
						correctif[i]="-";
						boleenSiGagne = false;
					}
					if ( Main.reponse1[i]>Main.combinaisonDefense[i] ) {
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
				System.out.println(" TRICHE 2 : reponse1 "+ Main.reponse1 + " 1 combinaisonDefense "+ Main.combinaisonDefense);
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
