package packageProjetMasterMind;
import java.util.Scanner;

public class GestionExeptionEntreesGlobales {
	
	// private static int iteration=0;
	private Scanner sc = new Scanner(System.in);
	//Variable de test
	private static boolean testEntier = false;
	// Variable d'entrée
	private String str;
	// Tampon de test
	private int test;
	// Résultat
	private int resultat;
	
	GestionExeptionEntreesGlobales (int test) {
		//iteration++;
		//System.out.println("Numéro d'itération de test de gestion d'exeption = " + iteration);
		
		
		str = sc.nextLine();
		try {
			test = Integer.parseInt(str);
			testEntier = true;
			System.out.println("Vous avez entré :" + test);
			resultat = test;
		} catch (NumberFormatException e){
			System.out.println(" : Cette valeur n'est pas une entrée valide!");
		}
	}
	
	
	int getResultatGestionExeptionEntreesGlobales() {
		return resultat;
	}
	
//	boolean getTestEntierGestionExeptionEntreesGlobales() {
//		return testEntier;
//	}

}
