package packageProjetMasterMind;
import java.util.Scanner;

public class GestionExeptionEntreesConfigJeu {
	
	private Scanner sc = new Scanner(System.in);
	boolean testEntier = false;
	private String str ="";
	// private int a = 0;
	
	
	GestionExeptionEntreesConfigJeu (int test){
		str = sc.nextLine();
		try {
			test = Integer.parseInt(str);
			testEntier = true;
		} catch (NumberFormatException e){
			System.out.println(test);
			System.out.println(" : Cette valeur n'est pas une entrée valide!");
		}
		
		
	}

}
