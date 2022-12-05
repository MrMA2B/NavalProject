public class Sousmarin extends Navire {

	public Sousmarin() {
		super();
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		if (grille.getCase(l, c) == ". ") {
			grille.changeCase(l, c, "S1");
		}
	}

	@Override
	public boolean tirer(int x, int y, Grille grille) {
		if (grille.getCase(x, y) == ". ") {
			grille.changeCase(x, y, "O ");
			return true;
		}

		if (grille.getCase(x, y).equals("S1") || grille.getCase(x, y).equals("S2") || grille.getCase(x, y).equals("S3")
				|| grille.getCase(x, y).equals("S4")) {
			grille.changeCase(x, y, "X ");
			return true;
		}

		if (grille.getCase(x, y) == "X") {
			System.out.println("Vous ne pouvez pas tirer sur un sous-marin sur lequel vous avez déjà tiré.");
			return false;
		}

		else {
			System.out.println("Vous ne pouvez pas toucher ces bateaux avec vos sous-marin");
			return true;
		}
	}

}
