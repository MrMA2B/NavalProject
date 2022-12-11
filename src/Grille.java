import java.io.Serializable;
/**
 * La class Grille permet de générer et modifier la grille de jeux
 */


public class Grille implements Serializable {
	int ligne;
	int col;
	String[][] grille;
	
	/**
	 * Permet la création d'une grille en String
	 * @param n
	 * @param p
	 */


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
	/**
	 * Permet l'affichage de la grille
	 */

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
				if ((grille[i][j] == ". ") || (grille[i][j] == "X ") || (grille[i][j] == "O ")
						|| (grille[i][j] == "T ")) {
					System.out.print("  " + grille[i][j]);
				} else {
					System.out.print("  . ");
				}
			}
			System.out.println("  ");
		}
		System.out.println();
	}

	public void flashbang(int x, int y) {
		String[] cologne = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
		System.out.println();
		System.out.println("   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15");
		for (int i = x; i < x + 4; i++) {
			System.out.print(cologne[i]);
			for (int j = y; j < y + 4; j++) {
				if ((grille[i][j] == ". ") || (grille[i][j] == "X ") || (grille[i][j] == "O ") || (grille[i][j] == "S1")
						|| (grille[i][j] == "S2") || (grille[i][j] == "S3") || (grille[i][j] == "S4")
						|| (grille[i][j] == "C1") || (grille[i][j] == "F1") || (grille[i][j] == "F2")) {
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
	
	/**
	 * Permet de déplacer un sous marin selon le choix du joueur
	 * @param i
	 * @param j
	 * @param direction
	 * @param strnav
	 */

	public void changeSousmarin(int i, int j, char direction, String strnav) {
		if (direction == 'H') {
			grille[i][j] = ". ";
			grille[i - 1][j] = strnav;
		}
		if (direction == 'B') {
			grille[i][j] = ". ";
			grille[i + 1][j] = strnav;
		}
		if (direction == 'G') {
			grille[i][j] = ". ";
			grille[i][j - 1] = strnav;
		}
		if (direction == 'D') {
			grille[i][j] = ". ";
			grille[i][j + 1] = strnav;
		}

	}
	/**
	 * Permet de tester si le déplacement est possible pour un sousmarin selon le choix du joueur
	 * @param i
	 * @param j
	 * @param direction
	 * @return true 
	 */

	public boolean testerSousmarin(int i, int j, char direction) {
		if (direction == 'H') {
			if (i - 1 >= 0 && grille[i - 1][j] == ". ") {
				return true;
			}
		}
		if (direction == 'B') {
			if (i + 1 >= 0 && grille[i + 1][j] == ". ") {
				return true;
			}
		}
		if (direction == 'G') {
			if (j - 1 >= 0 && grille[i][j - 1] == ". ") {
				return true;
			}
		}
		if (direction == 'D') {
			if (j + 1 < 15 && grille[i][j + 1] == ". ") {
				return true;
			}
		}
		return false;
	}
	/**
	 * Permet de supprimer les anciennes coordonnées d'un navire et de poser les nouvelles coordonnées du navire
	 * @param x
	 * @param y
	 * @param strnav
	 * @param direction
	 * @param cases
	 */

	public void changementPos(int x, int y, String strnav, char direction, int cases) {
		anciennePos(x, y, strnav, direction, cases);
		nouvellePos(x, y, strnav, direction, cases);
	}
	/**
	 * Permet de supprimer les anciennes coordonnées d'un navire
	 * @param x
	 * @param y
	 * @param strnav
	 * @param direction
	 * @param cases
	 */

	public void anciennePos(int x, int y, String strnav, char direction, int cases) {
		int i = x;
		int j = y;
		if (grille[i][j].equals(strnav)) {
			if (direction == 'H') {
				for (int b = 0; b < cases; b++) {
					grille[i + b][j] = ". ";
				}
			}
			if (direction == 'B') {
				for (int b = 0; b < cases; b++) {
					grille[i + b][j] = ". ";
				}
			}
			if (direction == 'G') {
				for (int b = 0; b < cases; b++) {
					grille[i][j + b] = ". ";
				}
			}
			if (direction == 'D') {
				for (int b = 0; b < cases; b++) {
					grille[i][j + b] = ". ";
				}
			}
		}
	}
	/**
	 * Permet de poser les nouvelles coordonnées d'un navire
	 * @param x
	 * @param y
	 * @param strnav
	 * @param direction
	 * @param cases
	 */


	public void nouvellePos(int x, int y, String strnav, char direction, int cases) {
		int i = x;
		int j = y;
		if (direction == 'H') {
			i = i - 1;
			if (grille[i][j] == ". "|| grille[i][j] == "O ") {
				for (int b = 0; b < cases; b++) {
					grille[i + b][j] = strnav;
				}
			}
		}
		if (direction == 'B') {
			i = i + 1;
			if (grille[i][j] == ". "|| grille[i][j] == "O ") {
				for (int b = 0; b < cases; b++) {
					grille[i + b][j] = strnav;
				}
			}
		}
		if (direction == 'G') {
			j = j - 1;
			if (grille[i][j] == ". "|| grille[i][j] == "O ") {
				for (int b = 0; b < cases; b++) {
					grille[i][j + b] = strnav;
				}
			}
		}
		if (direction == 'D') {
			j = j + 1;
			if (grille[i][j] == ". "|| grille[i][j] == "O ") {
				for (int b = 0; b < cases; b++) {
					grille[i][j + b] = strnav;
				}
			}
		}

	}
	/**
	 * Permet de tester si le déplacement d'un d'un navire vers une direction est possible
	 * @param x
	 * @param y
	 * @param direction
	 * @param cases
	 * @param axe
	 * @return true
	 */


	public boolean testerPos(int x, int y, char direction, int cases, int axe) {
		int i = x;
		int j = y;
		if (axe == 0) {
			if (direction == 'H') {
				if (i - 1 >= 0) {
					if (grille[i - 1][j] == ". " || grille[i - 1][j] == "O ") {
						return true;
					} else {
						return false;
					}
				}
			}
			if (direction == 'B') {
				if (i + 1 < 15) {
					if (grille[i + cases][j] == ". " && i + cases < 15|| grille[i + cases][j] == "O "&& i + cases < 15) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		if (axe == 1) {
			if (direction == 'G') {
				if (j - 1 >= 0) {
					if (grille[i][j - 1] == ". "|| grille[j - 1][j] == "O ") {
						return true;
					} else {
						return false;
					}
				}
			}
			if (direction == 'D') {
				if (j + 1 < 15) {
					if (grille[i][j + cases] == ". " && j + cases < 15 || grille[j + cases][j] == "O "&& j + cases < 15) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Permet de récupérer l'axe d'un navire (horizontal ou vertical)
	 * @param strnav
	 * @return 0
	 * @return 1
	 * @return 2
	 */


	public int getAxe(String strnav) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++)
				if (grille[i][j].equals(strnav)) {
					if (i+1 < 15 && grille[i + 1][j] == grille[i][j]) {
						return 0;
					}
					if (j+1 < 15 &&grille[i][j + 1] == grille[i][j]) {
						return 1;
					} else {
						return 2;
					}
				}
		}
		return 0;
	}
	/**
	 * Permet de récupérer la coordonnées X d'un navire 
	 * @param strnav
	 * @return i
	 */


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
	/**
	 * Permet de récupérer la coordonnées Y d'un navire 
	 * @param strnav
	 * @return i
	 */

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
	/**
	 * Permet de vérifier si un navire est totalement touché pour le couler
	 * @param x
	 * @param y
	 * @param axe
	 * @param strnav
	 */

	public void testerCouler(int x, int y, int axe, String strnav) {
		int i = x;
		int j = y;
		if (axe == 0) {
			if (grille[i - 1][j] == "T ") {
				while (i>=0 && grille[i][j] == "T " && i>=0 || grille[i][j] == strnav) {
					i = i - 1; 
				}
				i = i + 1;
				while (i<15 && grille[i][j] == "T " && i<15   || grille[i][j] == strnav) {
					grille[i][j] = "X ";
					i = i + 1;
				}
			} else {
				while (grille[i][j] == "T " || grille[i][j] == strnav) {
					grille[i][j] = "X ";
					i = i + 1;
				}
			}
		}
		if (axe == 1) {
			if (grille[i][j - 1] == "T ") {
				while (j>=0 && grille[i][j] == "T "  || j>=0 && grille[i][j] == strnav) {
					j = j - 1;
				}
				j = j + 1;
				while (j<15 && grille[i][j] == "T "|| j<15 && grille[i][j] == strnav) {
					grille[i][j] = "X ";
					j = j + 1;
				}
			} else {
				while (grille[i][j] == "T " || grille[i][j] == strnav) {
					grille[i][j] = "X ";
					j = j + 1;
				}
			}
		}
	}
	/**
	 * Permet de récupérer l'axe d'un navire touché
	 * @param x
	 * @param y
	 * @return 0
	 * @return 1
	 */

	public int getAxe2(int x, int y) {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++)
				if (grille[i][j] == grille[x][y]) {
					if (i + 1 < 15 && grille[i + 1][j] == "T ") {
						return 0;
					}
					if (i - 1 >= 0 && grille[i - 1][j] == "T ") {
						return 0;
					}
					if (j - 1 >= 0 && grille[i][j - 1] == "T ") {
						return 1;
					}
					if (j + 1 < 15 && grille[i][j + 1] == "T ") {
						return 1;
					}
				}
		}
		return 0;
	}
	/**
	 * Permet de récupérer le nombre de cases d'un navire
	 * @param strnav
	 * @return cases
	 */

	public int getNbrcase(String strnav) {
		int axe = getAxe(strnav);
		int x = getX(strnav);
		int y = getY(strnav);
		int cases = 0;
		if (axe == 0) {
			while (grille[x][y].equals(strnav) && x < 15) {
				x = x + 1;
				cases = cases + 1;
			}

			return cases;

		}
		if (axe == 1) {
			while (grille[x][y].equals(strnav) && y < 15) {
				y = y + 1;
				cases = cases + 1;
			}
			return cases;
		}
		return 0;
	}

}
