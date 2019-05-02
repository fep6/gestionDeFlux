package packageProjetMasterMind;

import java.util.Scanner;

public class Entrees {
	private int pnCoups; 
	private int pnPions; 
	private int pnCouleurs = 0; 
	private int pModeJeu = 0;
	private Scanner sc = new Scanner(System.in);
	
	// Entrées des données du jeu 
	Entrees(int pnCoups, int pnPions, int pnCouleurs, int pModeJeu){
		
		System.out.println("veuillez entrer le mode à choisir:\n"
				+ "1-> Mode challenger où vous devez trouver la combinaison secr�te de l'ordinateur \n"+
				"2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" +
				"3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
				+ "le premier à trouver la combinaison secréte de l'autre a gagné");
		pModeJeu = sc.nextInt();
		while (pModeJeu != 1 && pModeJeu != 2 && pModeJeu != 3) {
			System.out.println("veuillez bien entrer le mode à choisir:\n"
					+ "1-> Mode challenger où vous devez trouver la combinaison secr�te de l'ordinateur \n"+
					"2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \\n" +
					"3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n "
					+ "le premier à trouver la combinaison secr�te de l'autre a gagné");
			pModeJeu = sc.nextInt();	
		}
		System.out.println("veuillez entrer le nombre de pions:");
		pnPions = sc.nextInt();
		System.out.println("veuillez entrer le nombre de couleurs:");
		pnCouleurs = sc.nextInt();
		System.out.println("veuillez entrer le nombre de coups maximum:");
		pnCoups = sc.nextInt();
		 
		System.out.println("\n RECAPTULATIF: \n Vous avez choisi le jeu:");
//		if (typeJeu == 1) {
//			System.out.println("Recherche +/-");
//		}
//		if (typeJeu == 2) {
//			System.out.println("MasterMind");
//		}
		System.out.println("Avec " + pnPions + " pions avec " + pnCouleurs + " couleurs, le tout � retrouver en " 
		+ pnCoups +" coups maximum.");
		System.out.println("Enfin, vous avez choisi le mode:");
		if (pModeJeu == 1) {
			System.out.println(" \' Challenger \' o� vous devez trouver la combinaison secr�te de l'ordinateur");
		}
		if (pModeJeu == 2) {
			System.out.println("  \' D�fenseur \' o� c'est � l'ordinateur de trouver votre combinaison secr�te");
		}
		if (pModeJeu == 3) {
			System.out.println("  \' Duel \' o� l'ordinateur et vous jouez tour � tour,\n" + 
					"le premier � trouver la combinaison secr�te de l'autre a gagn�");
		}
		
	}
}
