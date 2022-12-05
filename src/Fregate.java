
public class Fregate extends Navire {

	public Fregate() {
		super();
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 10);
		int p = (int) (Math.random() * 2);
		boolean gg = false;

		if (p == 0) {
			while (gg == false) {
				gg = testA(5, l, c, "F1", grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}
		if (p == 1) {
			while (gg == false) {
				gg = testB(5, l, c, "F1", grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}
	}

	public boolean tirer(int y, int x, Grille grille) {
		shoot(y, x, grille);
		if ((y > 0) && (x > 0) && (y < 14) && (x < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		else if ((y == 0) && (x == 0)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		else if ((y > 0) && (x == 0) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		else if ((y == 14) && (x == 0)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		else if ((y == 14) && (x > 0) && (x < 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		else if ((y == 14) && (x == 14)) {
			for (int i = y - 1; i <= y; i++) {
				for (int j = x - 1; j <= x; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		else if ((y > 0) && (x == 14) && (y < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		else if ((y == 0) && (x == 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		else if ((y == 0) && (x > 0) && (x < 14)) {
			for (int i = y; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0) && (Math.abs(i - j) != 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					}
				}
			}
			return true;
		}

		return false;
	}
}