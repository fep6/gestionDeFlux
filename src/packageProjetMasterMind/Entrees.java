package packageProjetMasterMind;

import java.util.Scanner;

public class Entrees {
	protected int nCoups; 
	protected int nPions; 
	protected int nCouleurs; 
	protected int modeJeu;
	private Scanner sc = new Scanner(System.in);
	
	// Entrées des données du jeu
	Entrees(){
		
		System.out.println("veuillez entrer le mode à choisir:\n"
				+ "1-> Mode challenger où vous devez trouver la combinaison secr�te de l'ordinateur \n"+
				"2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" +
				"3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
				+ "le premier à trouver la combinaison secréte de l'autre a gagné");
		modeJeu = sc.nextInt();
		while (modeJeu != 1 && modeJeu != 2 && modeJeu != 3) {
			System.out.println("veuillez bien entrer le mode à choisir:\n"
					+ "1-> Mode challenger où vous devez trouver la combinaison secr�te de l'ordinateur \n"+
					"2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \\n" +
					"3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n "
					+ "le premier à trouver la combinaison secr�te de l'autre a gagné");
			modeJeu = sc.nextInt();	
		}
		System.out.println("veuillez entrer le nombre de pions:");
		nPions = sc.nextInt();
		System.out.println("veuillez entrer le nombre de couleurs:");
		nCouleurs = sc.nextInt();
		System.out.println("veuillez entrer le nombre de coups maximum:");
		nCoups = sc.nextInt();
		
		
	}
}
