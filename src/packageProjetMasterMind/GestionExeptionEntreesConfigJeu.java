package packageProjetMasterMind;
import java.util.Scanner;

public class GestionExeptionEntreesConfigJeu {
	
	// private static int iteration=0;
	private Scanner sc = new Scanner(System.in);
	//Variable de test
	static boolean testEntier = false;
	// Variable d'entrée
	String str;
	// Tampon de test
	int test;
	// Résultat
	int resultat;
	
	GestionExeptionEntreesConfigJeu (int test) {
		//iteration++;
		//System.out.println("Numéro d'itération de test de gestion d'exeption = " + iteration);
		
		
		str = sc.nextLine();
		try {
			test = Integer.parseInt(str);
			testEntier = true;
			System.out.println("il s'agit bien d'un entier. Vous avez entré :" + test);
			resultat = test;
		} catch (NumberFormatException e){
			System.out.println(" : Cette valeur n'est pas une entrée valide!");
		}
	}
	
	
	int getResultatGestionExeptionEntreesConfigJeu() {
		return resultat;
	}
	
	boolean getTestEntierGestionExeptionEntreesConfigJeu() {
		return testEntier;
	}

}
