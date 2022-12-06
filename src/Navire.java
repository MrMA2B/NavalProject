import java.util.*;
import java.util.Map.Entry;

abstract class Navire {
	public int x;
	public int y;
	public int pv;

	public Navire() {
	}

	public boolean testA(int taille, int c, int l, String strnav, Grille grille) {
		int cases = 0;

		for (int b = 0; b < taille; b++) {
			if (grille.getCase(l + b, c) == ". ") {
				cases = cases + 1;
			}
		}
		if (cases == taille) {
			for (int b = 0; b < taille; b++) {
				x = c;
				y = l;
				grille.changeCase(l + b, c, strnav);
			}
			return true;
		} else {
			return false;
		}

	}

	public boolean testB(int taille, int l, int c, String strnav, Grille grille) {
		int cases = 0;

		for (int b = 0; b < taille; b++) {
			if (grille.getCase(l, c + b) == ". ") {
				cases = cases + 1;
			}
		}
		if (cases == taille) {
			for (int b = 0; b < taille; b++) {
				x = c;
				y = l;
				grille.changeCase(l, c + b, strnav);
			}
		} else {
			return false;
		}
		return true;
	}

	public boolean tirer(int x, int y, Grille grille,HashMap<String, Navire> hashMap) {
		return false;
	}

	public boolean shoot(int x, int y, Grille grille,HashMap<String, Navire> hashMap) {
		if (grille.getCase(x, y).equals(". ")) {
			grille.changeCase(x, y, "O ");
			return true;
		}

		if (grille.getCase(x, y).equals("O ")) {
			grille.changeCase(x, y, "O ");
			return true;
		}

		if (grille.getCase(x, y).equals("S1") || grille.getCase(x, y).equals("S2") || grille.getCase(x, y).equals("S3")
				|| grille.getCase(x, y).equals("S4")) {
			System.out.println("Vous ne pouvez pas toucher de sous-marin avec ce navire");
			return true;
		}

		if (grille.getCase(x, y).equals("T ")||grille.getCase(x, y).equals("X ")) {
			System.out.println("Vous ne pouvez pas tirer sur un une case déjà touchée.");
			return true;
		}

		else {
			if(getNavire(hashMap, grille.getCase(x, y)).pv>1) {
				getNavire(hashMap, grille.getCase(x, y)).touche();
				grille.changeCase(x, y, "T ");
				return true;
			}
			else {
				getNavire(hashMap, grille.getCase(x, y)).touche();
				grille.changeCase(x, y, "X ");
				return true;	
			}
		}
	}

	public int getPv() {
		return pv;
	}

	public void touche() {
		pv = pv - 1;
	}

	public int getPositionX() {
		return x;
	}

	public int getPositionY() {
		return y;
	}

	public Navire getNavire(HashMap<String, Navire> hashMap, String s) {
		return hashMap.get(s);
	}

	public String getNavireString(HashMap<String, Navire> hashMap, Navire navire) {
		for (Entry<String, Navire> entry : hashMap.entrySet()) {
			if (entry.getValue() == navire) {
				return entry.getKey();
			}
		}
		return null;
	}
}
