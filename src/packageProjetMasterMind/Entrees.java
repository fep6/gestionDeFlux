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
		 
		System.out.println("\n RECAPTULATIF: \n Vous avez choisi le jeu:");
//		if (typeJeu == 1) {
//			System.out.println("Recherche +/-");
//		}
//		if (typeJeu == 2) {
//			System.out.println("MasterMind");
//		}
		System.out.println("Avec " + nPions + " pions avec " + nCouleurs + " couleurs, le tout � retrouver en " 
		+ nCoups +" coups maximum.");
		System.out.println("Enfin, vous avez choisi le mode:");
		if (modeJeu == 1) {
			System.out.println(" \' Challenger \' o� vous devez trouver la combinaison secr�te de l'ordinateur");
		}
		if (modeJeu == 2) {
			System.out.println("  \' D�fenseur \' o� c'est � l'ordinateur de trouver votre combinaison secr�te");
		}
		if (modeJeu == 3) {
			System.out.println("  \' Duel \' o� l'ordinateur et vous jouez tour � tour,\n" + 
					"le premier � trouver la combinaison secr�te de l'autre a gagn�");
		}
		
	}
}
