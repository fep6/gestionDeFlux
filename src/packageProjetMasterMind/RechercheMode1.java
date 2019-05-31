package packageProjetMasterMind;

// Mode 1 "Challenger" : L'intelligence artificielle de l’ordinateur joue le rôle de défenseur. 
//			Elle définit une combinaison de X chiffres aléatoirement.

public class RechercheMode1 {
	
// Renvoie si la partie est gagnée ou non
private String verdictMode1 = new String();
// Variable réponse corrective de l'ordinateur en fonction du jeu du joueur
private static String correctif []= new String[Main.nPions];
// Nombre de tour de jeu
private static int coup =0;
//tour restant
private static int tourRestant= Main.nCoups;
// Variable true si la partie est gagnée
private static boolean boleenSiGagneMode1;
// Tableau pour la saisie d'entrée du joueur
private static int reponseMode1 [] = new int[Main.nPions];
// Combinaison de l'ordinateur
private static int combinaisonOrdi [];
//N° de pion
private static int pion;
 


	RechercheMode1(){
		
		//2.1  Entrée de la combinaison de l'ordi.:
		CombinaisonSecrete cso = new CombinaisonSecrete();
		combinaisonOrdi= cso.getcombinaisonSecreteOrdi();
		
		//2.2 recherche +/- et affichage	
		while (verdictMode1 != "GAGNE!" && verdictMode1 != "PERDU!") {
			coup++;
			boleenSiGagneMode1= true;
			
			    //2.2.1 entrées du joueur (var reponse)
				entreesJoueur();
				//2.2.2 Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="	et affichage et test
					
					//Après factorisation dans ComparatifAffichageTest
				ComparatifAffichageTestMode1();
				
					// Avant factorisation dans ComparatifAffichageTest: 
					// comparatifCombinaisonSecreteMode1();
				//2.2.3 Affichage & tests
					// Avant factorisation dans ComparatifAffichageTest:
					// affichageEtTestMode1();
				
		}
		System.out.println("...Mais c'est "+verdictMode1);
	}
	
	//entrées du joueur (var reponse)
	static void entreesJoueur() {
		System.out.print("Veuillez entrer votre code: ");
		EntreesManuellesDuJeu tejMode1 = new EntreesManuellesDuJeu ();
		// Rapatriement des données de l'instance tej dans la variable de classe reponse
		for (pion=0;pion<Main.nPions;pion++) {				
			reponseMode1[pion]=tejMode1.getEntree(pion);	
		}
	}

	// après factorisation dans ComparatifAffichageTest (méthode pour retour pour le mode 3)
	static void ComparatifAffichageTestMode1(){
		// comparatifCombinaisonSecreteMode1();
		ComparatifAffichageTest.comparatifCombinaisonSecrete(pion,reponseMode1,combinaisonOrdi, correctif, boleenSiGagneMode1);
		// Affichage & tests
		ComparatifAffichageTest.affichageEtTest(pion,correctif,tourRestant,boleenSiGagneMode1,verdictMode1,coup);
	}
	
	
	// Avant factorisation
	
//	//Comparatif combinaison secrète / entrée => réponse ordinateur par "+" ou "-" ou "="			
//	static void comparatifCombinaisonSecreteMode1(){
//		for (pion=0; pion<Main.nPions; pion++) {
//			if ( reponse[pion]==combinaisonOrdi[pion] ) {
//				correctif[pion]="=";
//			}
//			if ( reponse[pion]<combinaisonOrdi[pion] ) {
//				correctif[pion]="+";
//				boleenSiGagne = false;
//			}
//			if ( reponse[pion]>combinaisonOrdi[pion] ) {
//				correctif[pion]="-";
//				boleenSiGagne = false;
//			}
//		}
//	}
//	
//	//Affichage & tests
//	static void affichageEtTestMode1(){
//		System.out.print("REPONSE: ");
//		for (pion=0; pion<Main.nPions; pion++) {
//			System.out.print(correctif[pion]);
//		}
//		//2.1.1.4 test
//		if (tourRestantMode1 == 0 && !boleenSiGagne ) {
//			verdictMode1 = "PERDU!";
//		}
//		else if (boleenSiGagne==true) {
//			verdictMode1 = "GAGNE!";
//		}
//		tourRestantMode1 = Main.nCoups - coup;
//		System.out.println(" -> Il vous reste: "+ tourRestantMode1 + " coups!");
//	}
}
