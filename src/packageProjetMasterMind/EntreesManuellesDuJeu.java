package packageProjetMasterMind;

//Test de l'entrée de l'utilisateur

public class EntreesManuellesDuJeu {

	private int[] reponse = new int[EntreesConfigJeu.getNPions()];
	GestionExeptionEntreesGlobales test = new GestionExeptionEntreesGlobales();
	
	void setEntreesManuellesDuJeu () {
		for (int pion=0; pion<reponse.length ; pion++) {
			if (pion == 0) {
				System.out.print((int)(pion+1) + "ère entrée?");
			}
			else {
				System.out.print((int)(pion+1) + "eme entrée?");
			}	
			test.setGestionExeptionEntreesGlobales(reponse [pion]);
			reponse [pion] = test.getResultatGestionExeptionEntreesGlobales();
		}
	}
	int getEntree(int p){
		return reponse[p];
	}
}
