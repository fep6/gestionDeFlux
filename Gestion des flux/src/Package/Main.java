package Package;
//Package à importer afin d'utiliser l'objet File  
import java.io.File;


// import java.io.IOException; pour f.getCanonicalPath()

public class Main {

	public static void main(String[] args) // pour f.getCanonicalPath() :  throws IOException 
	{
		
		// Test push   
		File f= new File("test.txt");
		
		
		System.out.println("Nom du fichier : "+f.getName());
		System.out.println("Chemin absolu du fichier : "+f.getAbsolutePath());
		// System.out.println("Chemin canonique du fichier (?) : "+f.getCanonicalPath());
		
//		//Tests
//		System.out.println("Est-ce que le fichier existe? "+f.exists());
//		System.out.println("Est-ce un répertoire? "+f.isDirectory());
//		System.out.println("Est-ce un fichier? "+f.isFile());
//		System.out.println("Longueur du fichier : "+ f.length());
//		System.out.println("Peut-on lire le fichier? "+f.canRead());
//		System.out.println("Peut-on exécuter le fichier? "+ f.canExecute());
//		System.out.println("Peut-on écrire dans le fichier? "+f.canWrite());
//		
//		//Divers
//		System.out.println("Hachage de f : "+f.hashCode());
//		// liste des fichiers (tableau)
//		f.listFiles()
//		//Liste des racines (tableau)
//		f.listRoots()
		
		// A voir 
//		new StringBuffer("Hello ").append(f).append("s3").toString();
//		System.out.println(StringBuffer());// Ne fonctionne pas 
		
		System.out.println("Affichage à la racine du PC:");
		for(File file : f.listRoots()) {
			System.out.println(file.getAbsolutePath());
			try {
				int i = 1;
				// On parcourt la liste des fichier et des repertoires
				for(File nom : file.listFiles()) {
					System.out.println("\t\t"+((nom.isDirectory()) ? nom.getName()+"/":nom.getName()));
					
					
					// ?
					if((i%4) == 0) {
						System.out.println("\n");
					}
					i++;
				}
				System.out.println("\n");
			} catch (NullPointerException e){
		        //L'instruction peut générer une NullPointerException
		        //s'il n'y a pas de sous-fichier !
			}
		}
	}
}
