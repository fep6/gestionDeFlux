package packageProjetMasterMind;
import java.util.Scanner;

//Test de l'entrée de l'utilisateur

public class EntreesEtTestJeu {
	
	// entrée (tableau 1d) à la taille du nommbre de pions
	private int reponse1 [] = new int[Main.nPions];
	// maximum autorisé de chaque élément de 'reponse'( dépend du nombre de couleurs )
//	private int max = Main.nCouleurs;;
	
	private Scanner sc = new Scanner(System.in);
	

	
	EntreesEtTestJeu () {
		// Renseignement des variables de classe par les variables d'instance

		for (int i=0; i<reponse1.length ; i++) {
				// A retrouver indexof()
			boolean testEntier = false;
			String str;
			
			do {
				System.out.print(i+1 + "eme pion?");
				str = sc.nextLine();
				
				try {
					reponse1 [i] = Integer.parseInt(str);
					testEntier = true;
					//test
					System.out.println("Test EntreesEtTestJeu valide: de validation de l'entrée : EntreesEtTestJeu.reponse1["+i+"]= "+reponse1[i]);
					
				} catch (NumberFormatException e){
					System.out.println(reponse1 [i]);
					System.out.println(" : Cette valeur n'est pas une entrée valide!");
				}
//			} while (testEntier != true && (reponse1 [i] >= 0 && reponse1 [i] < max) );
			} while (testEntier != true && (reponse1 [i] >= 0 && reponse1 [i] < 10) );
		}
	}
	int getReponse1(int p){
		return reponse1[p];
	}
}
