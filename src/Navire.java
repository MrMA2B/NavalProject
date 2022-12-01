
public class Navire {

	public Navire() {
	}

	public boolean testA(int val, int t1, int t2, char ch, Grille grille) {
		int l = t2;
		int c = t1;
		int test = 0;

		for (int b = 0; b < val; b++) {
			if (grille.getCase(l+b,c) == '.') {
				test = test + 1;
			}
		}
		if (test == val) {
			for (int b = 0; b < val; b++) {

				grille.changeCase(l+b, c, ch);
			}
			return true;
		} else {
			return false;
		}

	}

	public boolean testB(int val, int t1, int t2, char ch, Grille grille) {
		int l = t1;
		int c = t2;
		int test = 0;

		for (int b = 0; b < val; b++) {
			if (grille.getCase(l,c + b) == '.') {
				test = test + 1;
			}
		}
		if (test == val) {
			for (int b = 0; b < val; b++) {

				grille.changeCase(l, c+b, ch);
			}
		} else {
			return false;
		}
		return true;
	}
	
	public void tirer(int x ,int y, Navire n, Grille grille) {
		if(grille.getCase(x,y)=='.') {
			grille.changeCase(x,y,'o');
		}
		if (grille.getCase(x,y)'S'||'C')	{
			grille.changeCase(x,y,'x');
	}
}
