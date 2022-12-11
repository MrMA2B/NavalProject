
/**
 * This class define all the methods' Fregate
 *
 * @author Adrien MATTEI, Thierry RINGLET, Felix HUMEAU, Augustin MEAUDRE
 */

import java.io.Serializable;
import java.util.HashMap;

public class Fregate extends Navire implements Serializable {

	// Constructor
	public Fregate() {
		super();
		pv = 5;
		length = 5;
	}

	// Methode placer() qui place le navire de maniere aléatoire sur la grille
	// donnée avec un caractère donnée qui sera le nom affiché du navire sur la
	// grille (ex : F2)

	public void placer(Grille grille, String s) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 10);
		int axe = (int) (Math.random() * 2);
		boolean placer = false;

		if (axe == 0) {
			while (placer == false) {
				placer = testA(5, l, c, s, grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 10);
			}
		}
		if (axe == 1) {
			while (placer == false) {
				placer = testB(5, l, c, s, grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 10);
			}
		}
	}

	// Méthode tirer() permettant le tire en croix sur 5 éléments. Ex :
	// . T
	// T T T
	// . T
	public boolean tirer(int y, int x, Grille grille, HashMap<String, Navire> hashMap) {
		// On tire (en faisant appel à la méthode shoot) sur la case donnée
		shoot(y, x, grille, hashMap);

		// Si on est dans le cas où aucun Out of Band ne nous affecte :
		if ((y > 0) && (x > 0) && (y < 14) && (x < 14)) {
			// On itère sur tous les éléments formant la croix recherchée
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					// Si les coordonnées de la case séléctionnée sont pairs
					if (Math.abs(x - y) % 2 == 0) {
						// Alor pour toutes les cases de coordonées impairs on tire
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						// Sinon alors l'élément selectionné est impair et on tire sur les cases paires
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}

		// Remarque si on tire en haut à gauche alors on distingue le cas et on ne prend
		// pas en compte les cases qui seraient alors en Out of Band
		else if ((y == 0) && (x == 0)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y > 0) && (x == 0) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 14) && (x == 0)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 14) && (x > 0) && (x < 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 14) && (x == 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y > 0) && (x == 14) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 0) && (x == 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}
		// De même que pour précédement pour éviter les Out of Band
		else if ((y == 0) && (x > 0) && (x < 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille, hashMap);
						}
					}
				}
			}
			return true;
		}

		return false;
	}
}