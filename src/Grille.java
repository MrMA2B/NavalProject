
public class Grille {
	int ligne;
	int col;
	String[][] grille;

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

	public int getColonne(String str) {
		String[] colonne = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
		for (int i = 0; i < colonne.length; i++) {
			if (colonne[i].equals(str)) {
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

	public void affichercacher() {
		String[] cologne = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
		System.out.println();
		System.out.println("   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15");
		for (int i = 0; i < ligne; i++) {
			System.out.print(cologne[i]);
			for (int j = 0; j < col; j++) {
				if ((grille[i][j] == ". ") || (grille[i][j] == "X ")|| (grille[i][j] == "O ")|| (grille[i][j] == "T ")) {
					System.out.print("  " + grille[i][j]);
				} else {
					System.out.print("  . ");
				}
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

	// Getter
	public String[][] getGrille() {
		return grille;
	}

	// Setter
	public void setGrille(String[][] newGrille) {
		this.grille = newGrille;
	}

	public void changementPos(int x, int y, String strnav, char direction) {
		anciennePos(x, y, strnav, direction);
		nouvellePos(x, y, strnav, direction);
	}

	public void anciennePos(int x, int y, String strnav, char direction) {
		int i = x;
		int j = y;
		if (grille[i][j].equals(strnav)) {
			if (direction == 'H') {
				for (int b = 0; b < 3; b++) {
					grille[i + b][j] = ". ";
				}
			}
			if (direction == 'B') {
				for (int b = 0; b < 3; b++) {
					grille[i + b][j] = ". ";
				}
			}
			if (direction == 'G') {
				for (int b = 0; b < 3; b++) {
					grille[i][j + b] = ". ";
				}
			}
			if (direction == 'D') {
				for (int b = 0; b < 3; b++) {
					grille[i][j + b] = ". ";
				}
			}
		}
	}

	public void nouvellePos(int x, int y, String strnav, char direction) {
		int i = x;
		int j = y;
		if (direction == 'H') {
			i = i - 1;
			if (grille[i][j] == ". ") {
				for (int b = 0; b < 3; b++) {
					grille[i + b][j] = strnav;
				}
			}
		}
		if (direction == 'B') {
			i = i + 1;
			if (grille[i][j] == ". ") {
				for (int b = 0; b < 3; b++) {
					grille[i + b][j] = strnav;
				}
			}
		}
		if (direction == 'G') {
			j = j - 1;
			if (grille[i][j] == ". ") {
				for (int b = 0; b < 3; b++) {
					grille[i][j + b] = strnav;
				}
			}
		}
		if (direction == 'D') {
			j = j + 1;
			if (grille[i][j] == ". ") {
				for (int b = 0; b < 3; b++) {
					grille[i][j + b] = strnav;
				}
			}
		}

	}

	public boolean testerPos(int x, int y, char direction, int cases, int axe) {
		int i = x;
		int j = y;
		if (axe == 0) {
			if (direction == 'H') {
				if (grille[i - 1][j] == ". " && i - 1 >= 0) {
					return true;
				}
			}
			if (direction == 'B') {
				if (grille[i + cases][j] == ". " && i + cases < ligne) {
					return true;
				}
			}
		}
		if (axe == 1) {
			if (direction == 'G') {
				if (grille[i][j - 1] == ". " && j - 1 >= 0) {
					return true;
				}
			}
			if (direction == 'D') {
				if (grille[i][j + cases] == ". " && j + cases < col) {
					return true;
				}
			}
		}
		return false;
	}

	public int getAxe(String strnav) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++)
				if (grille[i][j].equals(strnav)) {
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

	public int getX(String strnav) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++) {
				if (grille[i][j].equals(strnav)) {
					return i;
				}
			}
		}
		return 0;
	}

	public int getY(String strnav) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++) {
				if (grille[i][j].equals(strnav)) {
					return j;
				}
			}
		}
		return 0;
	}
}
