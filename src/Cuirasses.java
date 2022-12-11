import java.io.Serializable;
import java.util.HashMap;

public class Cuirasses extends Navire implements Serializable {

	public Cuirasses() {
		super();
		pv = 7;
		length = 7;
	}

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

	/**
	 * Rq : Error si que des X et que le joueur joue (ex: 9X et on tire )
	 * 
	 * @param x
	 * @param y
	 * @param grille
	 * 
	 * @return
	 */

	@Override
	public boolean tirer(int y, int x, Grille grille, HashMap<String, Navire> hashMap) {
		if ((y > 0) && (x > 0) && (y < 14) && (x < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

		else if ((y == 0) && (x == 0)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

		else if ((y > 0) && (x == 0) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

		else if ((y == 14) && (x == 0)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

		else if ((y == 14) && (x > 0) && (x < 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

		else if ((y == 14) && (x == 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

		else if ((y > 0) && (x == 14) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

		else if ((y == 0) && (x == 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille, hashMap);
				}
			}
			return true;
		}

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
