
public class Navire {
	int x;
    int y;
    int axe;
    int[] coordAxe = new int[3];
    int[] coordX = new int[3];
    int[] coordY = new int[3];
    
	public Navire() {
	}

	public boolean testA(int val, int t1, int t2, String ch, Grille grille) {
		int l = t2;
		int c = t1;
		int test = 0;

		for (int b = 0; b < val; b++) {
			if (grille.getCase(l+b,c) == ". ") {
				test = test + 1;
			}
		}
		if (test == val) {
			for (int b = 0; b < val; b++) {
				x=c;
				y=l;
				grille.changeCase(l+b, c, ch);
				axe = 0;
				coordAxe[b]=0;
				System.out.println();
			}
			return true;
		} else {
			return false;
		}

	}

	public boolean testB(int val, int t1, int t2, String ch, Grille grille) {
		int l = t1;
		int c = t2;
		int test = 0;

		for (int b = 0; b < val; b++) {
			if (grille.getCase(l,c + b) == ". ") {
				test = test + 1;
			}
		}
		if (test == val) {
			for (int b = 0; b < val; b++) {
				x=c;
				y=l;
				axe = 1;
				grille.changeCase(l, c+b, ch);
				coordAxe[b++]=1;
			}
		} else {
			return false;
		}
		return true;
	}
	public int getPositionX() {
        return x;
    }
    public int getPositionY() {
        return y;
    }
    public int getAxe() {
    	System.out.println(axe);
    	return axe;
    }
    public int getBat(int i) {   
    	if(i == 1) {
    		return 1; 		
    	}
    	if(i == 2) {
    		return 2;
    	}
    	return i;
    }
    
    public int getAxeb(int i) {
    	if(i == 1) {
    		int bat1 = coordAxe[0];
    		System.out.println(bat1);
        	return bat1;
    	}
    	if(i == 2) {
    		int bat2 = coordAxe[1];
    		System.out.println(bat2);
        	return bat2;
    	}
    	return i;
    }
    
    public int getX(int i) {
    	if(i == 1) {
    		int x1 = coordX[0];
        	return x1;
    	}
    	if(i == 2) {
    		int x2 = coordX[1];
        	return x2;
    	}
    	return i;
    }
    public int getY(int i) {
    	if(i == 1) {
    		int y1 = coordY[0];
        	return y1;
    	}
    	if(i == 2) {
    		int y2 = coordY[1];
        	return y2;
    	}
    	return i;
    }
    
}
