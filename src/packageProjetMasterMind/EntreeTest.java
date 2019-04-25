package packageProjetMasterMind;
import java.util.Scanner;

//Test de l'entr�e de l'utilisateur

public class EntreeTest {
	
	// entr�e (tableau 1d)
	private int reponse [];
	// maximum autorisé de chaque élément de 'reponse'
	private int max;
	
	private Scanner sc = new Scanner(System.in);
	

	
	EntreeTest ( int pReponse [], int pMax ) {
		
		// repositionnement des param�tres d'entr�e en variables
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
