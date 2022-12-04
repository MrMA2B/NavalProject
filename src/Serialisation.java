import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.*;


public class Serialisation implements Serializable{
	public void sauvegarde() {
		try {
		FileOutputStream fos = new FileOutputStream("partie.ser");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(Grille.class);
//		oos.writeObject(Navire.class);
//		oos.writeObject(Fregate.class);
//		oos.writeObject(Sousmarin.class);
//		oos.writeObject(Cuirasses.class);
//		oos.writeObject(Destroyers.class);
//		oos.writeObject(main.class);
		
		oos.writeObject(f1);
		
		oos.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		}
	
}