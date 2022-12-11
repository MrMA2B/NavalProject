
/**
 * This class define all the methods' Destroyers
 *
 * @author Adrien MATTEI, Thierry RINGLET, Felix HUMEAU, Augustin MEAUDRE
 */

import java.io.Serializable;
import java.util.HashMap;
/**
 * La class destroyers est la class qui va gérer tout les paramètres concercant ce navire
 */

public class Destroyers extends Navire implements Serializable {

	// Constructor
	public Destroyers() {
		super();
		pv = 3;
		length = 3;
	}

	/**
	 * Méthode qui permet de placer un navire aléatoirement sur la grille
	 * @param grille
	 * @param s
	 */

	public void placer(Grille grille, String s) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 12);
		int axe = (int) (Math.random() * 2);
		boolean placer = false;

		if (axe == 0) {

			while (placer == false) {
				placer = testA(3, l, c, s, grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}

		if (axe == 1) {
			while (placer == false) {
				placer = testB(3, l, c, s, grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}
	}

	// Tirer revient à toucher une case en faisant appel à la méthode shoot
	@Override
	public boolean tirer(int x, int y, Grille grille, HashMap<String, Navire> hashMap) {
		shoot(x, y, grille, hashMap);
		return true;
	}
}