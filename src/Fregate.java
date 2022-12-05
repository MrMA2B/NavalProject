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

	@Override
	public boolean tirer(int x, int y, Grille grille) {
		if (grille.getCase(x, y) == ". ") {
			grille.changeCase(x, y, "O ");
		}
		if (grille.getCase(x, y - 1) == ". ") {
			grille.changeCase(x, y - 1, "O ");
		}
		if (grille.getCase(x - 1, y) == ". ") {
			grille.changeCase(x - 1, y, "O ");
		}
		if (grille.getCase(x + 1, y) == ". ") {
			grille.changeCase(x + 1, y, "O ");
		}
		if (grille.getCase(x, y + 1) == ". ") {
			grille.changeCase(x, y + 1, "O ");
		}

		if (grille.getCase(x, y) == "C1" || grille.getCase(x, y) == "F1" || grille.getCase(x, y) == "D1") {
			grille.changeCase(x, y, "X ");
		}
		if (grille.getCase(x, y - 1) == "C1" || grille.getCase(x, y - 1) == "F1" || grille.getCase(x, y - 1) == "D1") {
			grille.changeCase(x, y - 1, "X ");
		}
		if (grille.getCase(x - 1, y) == "C1" || grille.getCase(x - 1, y) == "F1" || grille.getCase(x - 1, y) == "D1") {
			grille.changeCase(x - 1, y, "X ");
		}
		if (grille.getCase(x + 1, y) == "C1" || grille.getCase(x + 1, y) == "F1" || grille.getCase(x + 1, y) == "D1") {
			grille.changeCase(x + 1, y, "X ");
		}
		if (grille.getCase(x, y + 1) == "C1" || grille.getCase(x, y + 1) == "F1" || grille.getCase(x, y + 1) == "D1") {
			grille.changeCase(x, y + 1, "X ");
		}

		if (grille.getCase(x, y) == "S1") {
			grille.changeCase(x, y, "? ");
		}
		if (grille.getCase(x, y - 1) == "C1") {
			grille.changeCase(x, y - 1, "? ");
		}
		if (grille.getCase(x - 1, y) == "S1") {
			grille.changeCase(x - 1, y, "? ");
		}
		if (grille.getCase(x + 1, y) == "S1") {
			grille.changeCase(x + 1, y, "? ");
		}
		if (grille.getCase(x, y + 1) == "S1") {
			grille.changeCase(x, y + 1, "? ");
		}

		if (grille.getCase(x, y) == "X ") {
			return false;
		}
		return true;
	}
}