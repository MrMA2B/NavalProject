public class Cuirasses extends Navire {

	public Cuirasses() {
		super();
		pv = 7;

	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 8);
		int p = (int) (Math.random() * 2);
		boolean gg = false;

		if (p == 0) {
			while (gg == false) {
				gg = testA(7, l, c, "C1", grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 8);
			}

		}
		if (p == 1) {
			while (gg == false) {
				gg = testB(7, l, c, "C1", grille);
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
	public boolean tirer(int y, int x, Grille grille) {
		if ((y > 0) && (x > 0) && (y < 14) && (x < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		else if ((y == 0) && (x == 0)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		else if ((y > 0) && (x == 0) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		else if ((y == 14) && (x == 0)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x; j <= x + 1; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		else if ((y == 14) && (x > 0) && (x < 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		else if ((y == 14) && (x == 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		else if ((y > 0) && (x == 14) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		else if ((y == 0) && (x == 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		else if ((y == 0) && (x > 0) && (x < 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					shoot(i, j, grille);
				}
			}
			return true;
		}

		return false;
	}

}