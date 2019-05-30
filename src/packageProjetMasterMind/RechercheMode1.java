package packageProjetMasterMind;

// Mode 1 "Challenger" : L'intelligence artificielle de l’ordinateur joue le rôle de défenseur. 
//			Elle définit une combinaison de X chiffres aléatoirement.

public class RechercheMode1 {
	
// Renvoie si la partie est gagnée ou non
private static String verdict = new String();
// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur
private static String correctif []= new String[Main.nPions];
// Nombre de tour de jeu
private static int coup =0;
//tour restant
private static int tourRestantMode1 = Main.nCoups;
// Variable true si la partie est gagnée
private static boolean boleenSiGagne;
// Tableau pour la saisie d'entrée du joueur
private static int reponse [] = new int[Main.nPions];
// Combinaison de l'ordinateur (mode1)
private static int combinaisonOrdi [];
//N° de pion
private static int pion;
 


	RechercheMode1(){
		
		//2.1  Entrée de la combinaison de l'ordi.:
		CombinaisonSecrete cso = new CombinaisonSecrete();
		combinaisonOrdi= cso.getcombinaisonSecreteOrdi();
		
		//2.2 recherche +/- et affichage	
		while (verdict != "GAGNE!" && verdict != "PERDU!") {
			coup++;
			boleenSiGagne= true;
			
			    //2.2.1 entrées du joueur (var reponse)
				entreesJoueur();
				//2.2.2 Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
				comparatifCombinaisonSecreteMode1();
				//2.2.3 Affichage & tests
				affichageEtTest();
				
		}
		System.out.println("...Mais c'est "+verdict);
	}
	
	//entrées du joueur (var reponse)
	static void entreesJoueur() {
		System.out.print("Veuillez entrer votre code: ");
		EntreesManuellesDuJeu tejMode1 = new EntreesManuellesDuJeu ();
		// Rapatriement des données de l'instance tej dans la variable de classe reponse
		for (pion=0;pion<Main.nPions;pion++) {				
			reponse[pion]=tejMode1.getEntree(pion);	
		}
	}
	
	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
	static void comparatifCombinaisonSecreteMode1(){
		for (int pion=0; pion<Main.nPions; pion++) {
			if ( reponse[pion]==combinaisonOrdi[pion] ) {
				correctif[pion]="=";
			}
			if ( reponse[pion]<combinaisonOrdi[pion] ) {
				correctif[pion]="+";
				boleenSiGagne = false;
			}
			if ( reponse[pion]>combinaisonOrdi[pion] ) {
				correctif[pion]="-";
				boleenSiGagne = false;
			}
		}
	}
	
	//Affichage & tests
	static void affichageEtTest(){
		System.out.print("REPONSE: ");
		for (int pion=0; pion<Main.nPions; pion++) {
			System.out.print(correctif[pion]);
		}
		//2.1.1.4 test
		if (tourRestantMode1 == 0 && !boleenSiGagne ) {
			verdict = "PERDU!";
		}
		else if (boleenSiGagne==true) {
			verdict = "GAGNE!";
		}
		tourRestantMode1 = Main.nCoups - coup;
		System.out.println(" -> Il vous reste: "+ tourRestantMode1 + " coups!");
	}
}
