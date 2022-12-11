
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * La class permet de sauvegarder la partie 
 */
public class Serialisation implements Serializable {
	public void sauvegarde(String nomFichier, JeuTriche jeuTriche) {
		try {
			FileOutputStream fos = new FileOutputStream(nomFichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(jeuTriche);

			oos.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
