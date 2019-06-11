package packageProjetMasterMind;
import java.util.Scanner;

public class GestionExeptionEntreesGlobales {
	
	// private static int iteration=0;
	private Scanner sc = new Scanner(System.in);
	// Variable d'entrée
	private String str;
	// Résultat
	private int resultat;
	
	void setGestionExeptionEntreesGlobales (int test) {
		do {
			str = sc.nextLine();
			try {
				test = Integer.parseInt(str);
				System.out.println("Vous avez entré :" + test);
				resultat = test;
			} catch (NumberFormatException e){
				System.out.println(" : Cette valeur n'est pas une entrée valide!");
			}
		} while(str.equals(""));
	}
	
	int getResultatGestionExeptionEntreesGlobales() {
		return resultat;
	}

}
