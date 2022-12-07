import java.io.Serializable;
import java.util.HashMap;

public class Fregate extends Navire implements Serializable{

	public Fregate() {
		super();
		pv = 5;
	}

	public void placer(Grille grille,String s) {
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
/**
 * EX : J 11 ne fonctionne pas... autres cas ? / pourquoi ? / A corriger
 */
	public boolean tirer(int y, int x, Grille grille,HashMap<String, Navire> hashMap) {
		shoot(y, x, grille,hashMap);
		if ((y > 0) && (x > 0) && (y < 14) && (x < 14)) {
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					if (Math.abs(x - y) % 2 == 0) {
						if ((!(Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
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
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
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
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
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
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
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
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
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
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
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
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
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
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
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
							shoot(i, j, grille,hashMap);
						}
					} else {
						if (((Math.abs(i - j) % 2 == 0)) || ((i == y) && (j == x))) {
							shoot(i, j, grille,hashMap);
						}
					}
				}
			}
			return true;
		}

		return false;
	}
}