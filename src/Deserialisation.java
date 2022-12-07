import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Deserialisation implements Serializable {
	public void sauvegarde(String nomFichier) {
		try (FileInputStream fis = new FileInputStream(nomFichier);
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			Grille grille = (Grille) ois.readObject();
			Navire navire = (Navire) ois.readObject();

			Fregate fregate = (Fregate) ois.readObject();
			Fregate f1 = (Fregate) ois.readObject();
			Fregate f2 = (Fregate) ois.readObject();

			Sousmarin sousmarin = (Sousmarin) ois.readObject();
			Sousmarin s1 = (Sousmarin) ois.readObject();
			Sousmarin s2 = (Sousmarin) ois.readObject();
			Sousmarin s3 = (Sousmarin) ois.readObject();
			Sousmarin s4 = (Sousmarin) ois.readObject();

			Cuirasses cuirasses = (Cuirasses) ois.readObject();
			Cuirasses c1 = (Cuirasses) ois.readObject();

			Destroyers destroyers = (Destroyers) ois.readObject();
			Destroyers d1 = (Destroyers) ois.readObject();
			Destroyers d2 = (Destroyers) ois.readObject();
			Destroyers d3 = (Destroyers) ois.readObject();

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
