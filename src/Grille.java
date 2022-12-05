import java.util.*;

public class Grille {
	int ligne;
	int col;
	String[][] grille;
	Navire nav = new Navire();
	
	public Grille(int n, int p) {
		ligne = n;
		col = p;
		grille = new String[ligne][col];

		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++) {
				grille[i][j] = ". ";
			}
		}
	}
	
	public int getColonne(String s) {
		String[] colonne = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
		for (int i = 0; i < colonne.length; i++)
	    {
	        if (colonne[i].equals(s)) {
	            return i;
	        }
	    }
	    return -1;
	}

	public void afficher() {
		String[] cologne = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
		System.out.println();
		System.out.println("   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15");
		for (int i = 0; i < ligne; i++) {
			System.out.print(cologne[i]);
			for (int j = 0; j < col; j++) {
				System.out.print("  " + grille[i][j]);
			}
			System.out.println("  ");
		}
		System.out.println();
	}

	public String getCase(int l, int c) {
		return grille[l][c];
	}

	public void changeCase(int l, int c, String a) {
		grille[l][c] = a;
	}

	public boolean isWater(int l, int c) {
		if (getCase(l, c) == ". ") {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSm(int l, int c) {
		if (getCase(l, c) == "S") {
			return true;
		} else {
			return false;
		}
	}

	public boolean isF(int l, int c) {
		if (getCase(l, c) == "F") {
			return true;
		} else {
			return false;
		}
	}

	public boolean isC(int l, int c) {
		if (getCase(l, c) == "C") {
			return true;
		} else {
			return false;
		}
	}

	public boolean isD(int l, int c) {
		if (getCase(l, c) == "D") {
			return true;
		} else {
			return false;
		}
	}

	// Getter
	public String[][] getGrille() {
		return grille;
	}

	// Setter
	public void setGrille(String[][] newGrille) {
		this.grille = newGrille;
	}

	public void changementPos(int x, int y, String test, char val) {
		anciennePos(x, y, test, val);
		nouvellePos(x, y, test, val);
	}

	public void anciennePos(int x, int y, String test, char val) {
		int i = x;
		int j = y;
		if (grille[i][j].equals(test)) {
			if (val == 'H') {
				for (int b = 0; b < 3; b++) {
					grille[i + b][j] = ". ";
				}
			}
			if (val == 'B') {
				for (int b = 0; b < 3; b++) {
					grille[i + b][j] = ". ";
				}
			}
			if (val == 'G') {
				for (int b = 0; b < 3; b++) {
					grille[i][j + b] = ". ";
				}
			}
			if (val == 'D') {
				for (int b = 0; b < 3; b++) {
					grille[i][j + b] = ". ";
				}
			}
		}
	}

	public void nouvellePos(int x, int y, String test, char val) {
		int i = x;
		int j = y;
		if (val == 'H') {
			i = i - 1;
			if (grille[i][j] == ". ") {
				for (int b = 0; b < 3; b++) {
					grille[i + b][j] = test;
				}
			}
		}
		if (val == 'B') {
			i = i + 1;
			if (grille[i][j] == ". ") {
				for (int b = 0; b < 3; b++) {
					grille[i + b][j] = test;
				}
			}
		}
		if (val == 'G') {
			j = j - 1;
			if (grille[i][j] == ". ") {
				for (int b = 0; b < 3; b++) {
					grille[i][j + b] = test;
				}
			}
		}
		if (val == 'D') {
			j = j + 1;
			if (grille[i][j] == ". ") {
				for (int b = 0; b < 3; b++) {
					grille[i][j + b] = test;
				}
			}
		}

	}

	public boolean testerPos(int x, int y, char val, int cases, int axe1) {
		int i = x;
		int j = y;
		int axe = axe1;
		if (axe == 0) {
			if (val == 'H') {
				if (grille[i - 1][j] == ". " && i - 1 >= 0) {
					return true;
				}
			}
			if (val == 'B') {
				if (grille[i + cases][j] == ". " && i + cases < ligne) {
					return true;
				}
			}
		}
		if (axe == 1) {
			if (val == 'G') {
				if (grille[i][j - 1] == ". " && j - 1 >= 0) {
					return true;
				}
			}
			if (val == 'D') {
				if (grille[i][j + cases] == ". " && j + cases < col) {
					return true;
				}
			}
		}
		return false;
	}

	public int getAxe(String s) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++)
				if (grille[i][j].equals(s)) {
					if (grille[i + 1][j] == grille[i][j]) {
						return 0;
					}
					if (grille[i][j + 1] == grille[i][j]) {
						return 1;
					}
				}
		}
		return 0;
	}

	public int getX(String s) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++) {
				if (grille[i][j].equals(s)) {
					return i;
				}
			}
		}
		return 0;
	}

	public int getY(String s) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++) {
				if (grille[i][j].equals(s)) {
					return j;
				}
			}
		}
		return 0;
	}

}
