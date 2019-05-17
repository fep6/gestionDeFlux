package packageProjetMasterMind;
import java.util.Scanner;

//Test de l'entrée de l'utilisateur

public class TestEntreesManuellesDuJeu {
	
	// entrée (tableau 1d) à la taille du nommbre de pions
	private int reponse [] = new int[Main.nPions];
// Entrée clavier	
	private Scanner sc = new Scanner(System.in);
	

	
	TestEntreesManuellesDuJeu () {
		// Renseignement des variables de classe par les variables d'instance

		for (int i=0; i<reponse.length ; i++) {
				// A retrouver indexof()
			boolean testEntier = false;
			String str;
			
			do {
				if (i==0) {
					System.out.print(i+1 + "ère entrée?");
				}
				else {
					System.out.print(i+1 + "eme entrée?");
				}
				str = sc.nextLine();			
				try {
					reponse [i] = Integer.parseInt(str);
					testEntier = true;
				} catch (NumberFormatException e){
					System.out.println(reponse [i]);
					System.out.println(" : Cette valeur n'est pas une entrée valide!");
				}
			} while (testEntier != true && (reponse [i] >= 0 && reponse [i] < 10) );
		}
	}
	int getEntree(int p){
		return reponse[p];
	}
}
