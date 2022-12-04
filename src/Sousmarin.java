import java.io.Serializable;

public class Sousmarin extends Navire implements Serializable{
		
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

