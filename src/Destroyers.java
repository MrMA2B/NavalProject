
public class Destroyers extends Navire {

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
        		placee = testA(3,l,c,"D",grille);//Modifier 3 par lenght du bateau 
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
        		int x1 = getPositionX();
                int y1 = getPositionY();
                
                int y2 = y1+1;
                int y3 = y2+1;
                System.out.println("X : "+x1);
                System.out.println("Y : "+y1);
                System.out.println("X : "+x1);
                System.out.println("Y : "+y2);
                System.out.println("X : "+x1);
                System.out.println("Y : "+y3);
        	}
        }
        
		if(p==1) {
			while(placee == false) {
        		placee = testB(3,l,c,"D",grille);
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
        		int x1 = getPositionX();
                int y1 = getPositionY();
                int x2 = x1+1;
                int x3 = x2+1;
                System.out.println("X : "+x1);
                System.out.println("Y : "+y1);
                System.out.println("X : "+x2);
                System.out.println("Y : "+y1);
                System.out.println("X : "+x3);
                System.out.println("Y : "+y1);
			}
		}
	}
	
}
