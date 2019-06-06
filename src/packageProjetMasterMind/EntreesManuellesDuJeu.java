package packageProjetMasterMind;

//Test de l'entrée de l'utilisateur

public class EntreesManuellesDuJeu {
	
// entrée 
private int[] reponse = new int[EntreesConfigJeu.getNPions()];
	
	EntreesManuellesDuJeu () {
		// Renseignement des variables de classe par les variables d'instance

		for (int i=0; i<reponse.length ; i++) {

				if (i == 0) {
					System.out.print((int)(i+1) + "ère entrée?");
				}
				else {
					System.out.print((int)(i+1) + "eme entrée?");
				}
					//instanciation du test try/catch 
					GestionExeptionEntreesGlobales geeg = new GestionExeptionEntreesGlobales(reponse [i]);
					// retour des données
					reponse [i] = geeg.getResultatGestionExeptionEntreesGlobales();
				
		}
	}
	 int getEntree(int p){
		return reponse[p];
	}
}
