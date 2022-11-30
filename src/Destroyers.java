
public class Destroyers extends Navire {

	public Destroyers(String nom, int taille, int vie) {
		super(nom, taille, vie);
	}

	public void placer(Grille grille) {
		int l = (int)(Math.random() * 15);
		int c = (int)(Math.random() * 12);
        int p = (int)(Math.random() * 2);
        boolean placee = false;
        
        if(p==0) {
        	while(placee == false) {
        		placee = testA(3,l,c,'D',grille);
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
