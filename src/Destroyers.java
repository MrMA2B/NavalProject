
public class Destroyers extends Navire {

	Grille grille = new Grille(15, 15);

	public Destroyers(String nom, int taille, int vie) {
		super(nom, taille, vie);
	}

	public void placer() {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		if (grille.getCase(l, c) == '.') {
			grille.changeCase(l, c, 'D');
		}

	}

}
