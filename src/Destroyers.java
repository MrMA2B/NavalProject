
public class Destroyers extends Navire {
    int axe;
    int test = 0;
	public Destroyers() {
		super();
	}

	public void placerD1(Grille grille) {
		int l = (int)(Math.random() * 15);
		int c = (int)(Math.random() * 12);
        int p = (int)(Math.random() * 2);
        test =1;
        boolean placee = false;
        
        if(p==0) {
        	axe = p;
        	while(placee == false) {
        		placee = testA(getTaille(),l,c,"D1",grille);//Modifier 3 par lenght du bateau 
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
        	}
        }
        
		if(p==1) {
			axe=p;
			while(placee == false) {
        		placee = testB(getTaille(),l,c,"D1",grille);
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
			}
		}
	}
	public void placerD2(Grille grille) {
		int l = (int)(Math.random() * 15);
		int c = (int)(Math.random() * 12);
        int p = (int)(Math.random() * 2);
        test =2;
        boolean placee = false;
        
        if(p==0) {
        	axe = p;
        	while(placee == false) {
        		placee = testA(getTaille(),l,c,"D2",grille);//Modifier 3 par lenght du bateau 
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
        	}
        }
        
		if(p==1) {
			axe=p;
			while(placee == false) {
        		placee = testB(getTaille(),l,c,"D2",grille);
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
			}
		}
	}
	public int getTaille() {
		int cases = 3;
    	return cases;
    }
	public int getAxe() {
		return axe;
	}
	
}
