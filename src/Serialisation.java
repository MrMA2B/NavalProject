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
	oos.writeObject(Grille.grille);
	//oos.writeObject();
	
	
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