import java.io.Serializable;

public class Destroyers extends Navire implements Serializable{

	public Destroyers() {
		super();
	}

	public void placer(Grille grille) {
		int l = (int)(Math.random() * 15);
		int c = (int)(Math.random() * 12);
        int p = (int)(Math.random() * 2);
        boolean placee = false;
        
        if(p==0) {
        	while(placee == false) {
        		placee = testA(3,l,c,'D',grille);//Modifier 3 par lenght du bateau 
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
        	}
        }
        
		if(p==1) {
			while(placee == false) {
        		placee = testB(3,l,c,'D',grille);
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
			}
		}
	}
}
