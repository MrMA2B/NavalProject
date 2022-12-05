
public class Navire {
	public int x;
    public int y;
    protected int pv;
  
    
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
				grille.changeCase(l, c+b, ch);
			}
		} else {
			return false;
		}
		return true;
	}
	public boolean tirer(int x ,int y, Grille grille) {
        if(grille.getCase(x,y)==". ") {
                grille.changeCase(x,y,"O ");}
                
        if (grille.getCase(x,y)=="S1"||grille.getCase(x,y)=="C1"||grille.getCase(x,y)=="F1"||grille.getCase(x,y)=="D1")    
        {
            grille.changeCase(x,y,"X ");
            }
 
        if(grille.getCase(x, y)=="X ") {
            return false;
        }
        return true;
        }
    
    
    public int getPv() {
        return pv;
    }
    
    public void touche() {
        pv=pv-1;
    }
    
    public int getPositionX() {
        return x;
    }
    public int getPositionY() {
        return y;
    }

}
