
public class Sousmarin extends Navire {
		
	public Sousmarin() {
		super();
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		if (grille.getCase(l, c) == '.') {
			grille.changeCase(l, c, 'S');
		}
	}
}

