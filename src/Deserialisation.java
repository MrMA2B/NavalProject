import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;
/**
 * La class permet de restaurer une partie 
 */
public class Deserialisation implements Serializable {
	static Scanner sc = new Scanner(System.in);

	public void verifierExistenceFichier() {

		File fichier;
		System.out.println("Veuillez entrer le nom du fichier : à finir");
		String nomFichier = sc.nextLine();
		fichier = new File(nomFichier);

		while (fichier.exists() == false) {
			System.out.println("Le fichier n'existe pas");
			System.out.println("Veuillez entrer le nom du fichier : à finir");
			nomFichier = sc.nextLine();
			fichier = new File(nomFichier);
		}
		restaurer(nomFichier);

	}

	@SuppressWarnings("unused")
	public void restaurer(String nomFichier) {

		try (FileInputStream fis = new FileInputStream(nomFichier);
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			JeuTriche jeuTriche = (JeuTriche) ois.readObject();

			ois.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
