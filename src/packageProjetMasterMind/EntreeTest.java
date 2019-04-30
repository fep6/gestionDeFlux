package packageProjetMasterMind;
import java.util.Scanner;

//Test de l'entrée de l'utilisateur

public class EntreeTest {
	
	// entrée (tableau 1d)
	private int reponse [];
	// maximum autorisé de chaque élément de 'reponse'
	private int max;
	
	private Scanner sc = new Scanner(System.in);
	

	
	EntreeTest ( int pReponse [], int pMax ) {
		
		// repositionnement des paramètres d'entrée en variables
		reponse = pReponse;
		max = pMax;
		// for (int i=0; i<this.reponse.length;i++)
		/// (i à renommer)
		for (int i : reponse) {
				// A retrouver indexof()
			boolean testEntier = false;
			String str;
			
			do {
				System.out.print(i+1 + "eme pion?");
				str = sc.nextLine();
				
				try {
					this.reponse [i] = Integer.parseInt(str);
					testEntier = true;
				} catch (NumberFormatException e){
					System.out.println(reponse [i]);
					System.out.println(" : Cette valeur n'est pas une entrée valide!");
				}
			} while (testEntier != true && (reponse [i] >= 0 && reponse [i] < max) );
		}
	}
}
