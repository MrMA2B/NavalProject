import java.util.ArrayList;
public class Fregate extends Navire {
	ArrayList<String> fregate = new ArrayList<String>();

	public Fregate() {
		super();
		fregate.add("F2");
		fregate.add("F1");
	}

	public void placer(Grille grille) {
		int strnav = fregate.size() - 1;
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 10);
		int axe = (int) (Math.random() * 2);
		boolean placer = false;

		if (axe == 0) {
			while (placer == false) {
				placer = testA(5, l, c, fregate.get(fregate.size()-1), grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 10);
			}
			fregate.remove(strnav);
			System.out.println(fregate.get(fregate.size()-1));
		}
		if (axe == 1) {
			while (placer == false) {
				placer = testB(5, l, c, fregate.get(fregate.size()-1), grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 10);
			}
			fregate.remove(strnav);
		}
	}
/**
 * EX : J 11 ne fonctionne pas... autres cas ? / pourquoi ? / A corriger
 */
	public boolean tirer(int y, int x, Grille grille) {
		shoot(y, x, grille);
		if ((y > 0) && (x > 0) && (y < 14) && (x < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
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