
public class Cuirasses extends Navire {

	Grille grille = new Grille(15, 15);

	public Cuirasses(String name, int lenght, int pv) {
		super(name, lenght, pv);
	}

	public void placer() {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		if (grille.getCase(l, c) == '.') {
			grille.changeCase(l, c, 'C');
		}
	}
}
