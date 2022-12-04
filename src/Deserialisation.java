import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Deserialisation implements Serializable
{
//	public void charger(string a) {
//		
//	}

	
	try (FileInputStreal fis = new FileInputStream ("partie.ser");
	ObjectInputStream ois = new ObjectInputStream(fis)){
		Grille grille = (Grille)ois.readObject();
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

