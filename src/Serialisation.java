
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialisation implements Serializable {
	public void sauvegarde(String nomFichier, Grille grille, Navire navire, Fregate fregate, Fregate f1, Fregate f2,
			Sousmarin sousmarin, Sousmarin s1, Sousmarin s2, Sousmarin s3, Sousmarin s4, Cuirasses cuirasses,
			Cuirasses c1, Destroyers destroyers, Destroyers d1, Destroyers d2, Destroyers d3) {
		try {
			FileOutputStream fos = new FileOutputStream(nomFichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(grille);
			oos.writeObject(navire);

			oos.writeObject(sousmarin);
			oos.writeObject(s1);
			oos.writeObject(s2);
			oos.writeObject(s3);
			oos.writeObject(s4);

			oos.writeObject(destroyers);
			oos.writeObject(d1);
			oos.writeObject(d2);
			oos.writeObject(d3);

			oos.writeObject(fregate);
			oos.writeObject(f1);
			oos.writeObject(f2);

			oos.writeObject(cuirasses);
			oos.writeObject(c1);

			oos.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
