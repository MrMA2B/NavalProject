
public class Sousmarin extends Navire {
	
	Grille grille = new Grille();
	
	public Sousmarin(String name, int lenght, int pv) {
		super(name, lenght, pv);
	}

	public void placer() {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		if (grille.getCase(l, c) == '.') {
			grille.changeCase(l, c, 'S');
		}
	}
}
