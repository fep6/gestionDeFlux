package packageProjetMasterMind;
import java.util.Scanner;

public class GestionExeptionEntreesConfigJeu {
	
	// private static int iteration=0;
	private Scanner sc = new Scanner(System.in);
	static boolean testEntier = false;
	String str;
	static int test;
	static int resultat;
	
	GestionExeptionEntreesConfigJeu (int test) {
		//iteration++;
		//System.out.println("Numéro d'itération de test de gestion d'exeption = " + iteration);
		
		
		str = sc.nextLine();
		try {
			test = Integer.parseInt(str);
			testEntier = true;
			System.out.println("il s'agit bien d'un entier");
			resultat = test;
		} catch (NumberFormatException e){
			System.out.println(" : Cette valeur n'est pas une entrée valide!");
		}
	}
	
	
	static int getResultatGestionExeptionEntreesConfigJeu() {
		return resultat;
	}
	
	static boolean getTestEntierGestionExeptionEntreesConfigJeu() {
		return testEntier;
	}

}
