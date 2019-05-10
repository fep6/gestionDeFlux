package packageProjetMasterMind;
import java.util.Scanner;

//Test de l'entrée de l'utilisateur

public class TestEntreesJeu {
	
	// entrée (tableau 1d)
	private int reponse1 [];
	// maximum autorisé de chaque élément de 'reponse'
	private int max;
	
	private Scanner sc = new Scanner(System.in);
	

	
	TestEntreesJeu ( int pReponse [], int pMax ) {
		
		// Renseignement des variables de classe par les variables d'instance
		reponse1 = pReponse;
		max = pMax;
		// for (int i=0; i<this.reponse.length;i++)
		/// (i à renommer)
		for (int i : reponse1) {
				// A retrouver indexof()
			boolean testEntier = false;
			String str;
			
			do {
				System.out.print(i+1 + "eme pion?");
				str = sc.nextLine();
				
				try {
					this.reponse1 [i] = Integer.parseInt(str);
					testEntier = true;
				} catch (NumberFormatException e){
					System.out.println(reponse1 [i]);
					System.out.println(" : Cette valeur n'est pas une entrée valide!");
				}
			} while (testEntier != true && (reponse1 [i] >= 0 && reponse1 [i] < max) );
		}
	}
}
