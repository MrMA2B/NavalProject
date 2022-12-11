
/**
 * This class define all the methods' Cuirasses
 *
 * @author Adrien MATTEI, Thierry RINGLET, Felix HUMEAU, Augustin MEAUDRE
 */

import java.io.Serializable;
import java.util.HashMap;
/**
 * La class cuirasses est la class qui va gérer tout les paramètres concercant ce navire
 */

public class Cuirasses extends Navire implements Serializable {

	// Constructor
	public Cuirasses() {
		super();
		pv = 7;
		length = 7;
	}

	/**
	 * Méthode qui permet de placer un navire aléatoirement sur la grille
	 * @param grille
	 */

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 8);
		int axe = (int) (Math.random() * 2);
		boolean placer = false;

		if (axe == 0) {
			while (placer == false) {
				placer = testA(7, l, c, "C0", grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 8);
			}

		}
		if (axe == 1) {
			while (placer == false) {
				placer = testB(7, l, c, "C0", grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 8);
			}
		}
	}

	// Modification de la méthode tirer() de la classe mère Navire. Ainsi faire un
	// appel à la méthode tirer sur les navires Cuirasses donnera lieu à une autre
	// implémentation du code spécifique au cuirasses
	@Override
	public boolean tirer(int y, int x, Grille grille, HashMap<String, Navire> hashMap) {
		// Si on tire au milieu alors on procède au tire sur chaqu'une des cases
		if ((y > 0) && (x > 0) && (y < 14) && (x < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap); // On fait appel à la méthode shoot pour chaqu'une des cases
													// sélectionnées
				}
			}
			return true;
		}
		// Remarque si on tire en haut à gauche alors on distingue le cas et on ne prend
		// pas en compte les 3 cases qui seraient alors en Out of Band
		else if ((y == 0) && (x == 0)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y > 0) && (x == 0) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 14) && (x == 0)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 14) && (x > 0) && (x < 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 14) && (x == 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y > 0) && (x == 14) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 0) && (x == 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 0) && (x > 0) && (x < 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

		return false;
	}

}
