
public class Cuirasses extends Navire {

	public Cuirasses(String name, int lenght, int pv) {
		super(name, lenght, pv);
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		if (grille.getCase(l, c) == '.') {
			grille.changeCase(l, c, 'C');
		}
	}
}
