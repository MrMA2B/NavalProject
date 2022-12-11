import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
/**
 * La class Navire va appliquer des méthodes générales pour l'ensemble des navires
 */

abstract class Navire implements Serializable {
	public int x;
	public int y;
	public int pv;
	public int length;

	// Constructeur
	public Navire() {
	}
	/**
	 * La méthode testA permet de vérifier si les coordonnées pour placer un navire son disponible si son axe est verticale
	 * @param taille
	 * @param c
	 * @param l
	 * @param strnav
	 * @param grille
	 * return true
	 * return false
	 */

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
	/**
	 * La méthode testB permet de vérifier si les coordonnées pour placer un navire son disponible si son axe est horizontale
	 * @param taille
	 * @param c
	 * @param l
	 * @param strnav
	 * @param grille
	 * return true
	 * return false
	 */

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

	public boolean tirer(int x, int y, Grille grille, HashMap<String, Navire> hashMap) {
		return false;
	}

	/**
	 * La méthode permet de vérifier les coordonnées sur lequel le joueur veut tirer
	 * @param x
	 * @param y
	 * @param grille
	 * @param hashMap
	 * @param grille
	 * return true
	 * return false
	 */

	public boolean shoot(int x, int y, Grille grille, HashMap<String, Navire> hashMap) {
		// Si c'est un point alors on change pour un O
		if (grille.getCase(x, y).equals(". ")) {
			grille.changeCase(x, y, "O ");
			return true;
		}

		// Si c'est une case déjà touché O alors on retest car on sait jamais des
		// navires peuvent se déplacer sur cette case
		if (grille.getCase(x, y).equals("O ")) {
			grille.changeCase(x, y, "O ");
			return true;
		}
		// Si ce sont des sous-marin alors on peut pas car shoot est propre à tous les
		// navires sauf les sous-marins
		if (grille.getCase(x, y).equals("S1") || grille.getCase(x, y).equals("S2") || grille.getCase(x, y).equals("S3")
				|| grille.getCase(x, y).equals("S4")) {
			System.out.println("Vous ne pouvez pas toucher de sous-marin avec ce navire");
			return true;
		}

		// Si c'est déjà touché alors on ne peut pas et on affiche pq
		if (grille.getCase(x, y).equals("T ") || grille.getCase(x, y).equals("X ")) {
			System.out.println("Vous ne pouvez pas tirer sur un une case déjà touchée.");
			return true;
		}

		// Dans tous les autres cas alors càd qu'on tire sur des navires
		else {
			// Si ses pv sont sup à 1 alors on le touche
			if (getNavire(hashMap, grille.getCase(x, y)).pv > 1) {

				getNavire(hashMap, grille.getCase(x, y)).pv--;

				grille.changeCase(x, y, "T ");
				return true;
				// Sinon alors on le coule
			} else {
				getNavire(hashMap, grille.getCase(x, y)).pv--;
				grille.testerCouler(x, y, grille.getAxe2(x, y),
						getNavireString(hashMap, getNavire(hashMap, grille.getCase(x, y))));
				return true;
			}
		}
	}
	/**
	 * La méthode permet de récuperer le nombre de point de vie d'un navire
	 * @return pv
	 */

	public int getPv() {
		return this.pv;
	}
	/**
	 * La méthode d'enlever 1 à pv
	 */

	public void touche(Navire navire) {
		navire.pv--;
	}
	/**
	 * Permet de récupérer la coordonnée X
	 * return x
	 */

	public int getPositionX() {
		return x;
	}
	/**
	 * Permet de récupérer la coordonnée Y
	 * return y
	 */

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
