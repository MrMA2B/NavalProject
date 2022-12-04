import java.io.Serializable;

public class Grille implements Serializable{

	private int ligne;
	private int col;
	private char[][] grille;

	public Grille(int n, int p) {
		ligne = n;
		col = p;
		grille = new char[ligne][col];

		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++) {
				grille[i][j] = '.';
			}
		}
	}

	public void afficher() {
		String[] colonne = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
		System.out.println();
		System.out.println("   1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
		for (int i = 0; i < ligne; i++) {
			System.out.print(colonne[i]);
			for (int j = 0; j < col; j++) {
				System.out.print("  " + grille[i][j]);
			}
			System.out.println("  ");
		}
		System.out.println();
	}

	public char getCase(int l, int c) {
		return grille[l][c];
	}

	public void changeCase(int l, int c, char a) {
		grille[l][c] = a;
	}
	
	public boolean isWater(int l, int c) {
		if(getCase(l, c) == '.') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSm(int l, int c) {
		if(getCase(l, c) == 'S') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isF(int l, int c) {
		if(getCase(l, c) == 'F') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isC(int l, int c) {
		if(getCase(l, c) == 'C') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isD(int l, int c) {
		if(getCase(l, c) == 'D') {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Getter
	  public char[][] getGrille() {
	    return grille;
	  }

	  // Setter
	  public void setGrille(char[][] newGrille) {
	    this.grille = newGrille;
	  }
}