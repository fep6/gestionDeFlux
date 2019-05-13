package packageProjetMasterMind;

public class CombinaisonSecreteOrdi {

//1.2  Création Combinaison secrète de l'ordi., et entrées du joueur (pour modes 1 & 3):	
	
// combinaison1 en défense (Mode 1 & 3)
int combinaisonDefense [] = new int[Main.nPions];
// combinaison2 en attaque (Mode 2 & 3)
// int combinaisonAttaque []= new int[Main.nPions];
// Création variable tampon réponse
int reponse1 [] = new int [Main.nPions];
	
	CombinaisonSecreteOrdi(){
	
if ( Main.modeJeu == 1 || Main.modeJeu == 3) {
		
			//1.2.1 Combinaison secrète généré par l'ordi. 
			// combinaison1 (tableau)
			for (int i=0 ; i<combinaisonDefense.length; i++) {
//				combinaisonDefense[i]=(int) (Math.random()*Main.nCouleurs);
				combinaisonDefense[i]=(int) (Math.random()*10);
			}
			// 1.2.2 Triche
			System.out.println("\n \n-------------------------------------");
			System.out.println("TRICHE : combinaisonDefense= ");
			for (int i=0 ; i<combinaisonDefense.length; i++) {
				System.out.print((int)combinaisonDefense[i]);
			};
			System.out.println("\n-------------------------------------");
		}
	}
	//Getters
	int[] getCombinaisonDefense() {
		return combinaisonDefense;
	}	
}
