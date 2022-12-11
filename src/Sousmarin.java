
/**
 * This class define a sous-marin
 *
 * @author Adrien MATTEI, Thierry RINGLET, Felix HUMEAU, Augustin MEAUDRE
 */

import java.io.Serializable;
import java.util.HashMap;

public class Sousmarin extends Navire implements Serializable {

	// Constructeur
	public Sousmarin() {
		super();
		pv = 1;
		length = 1;
	}

	// On place le sous-marin
	public void placer(Grille grille, String s) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		if (grille.getCase(l, c) == ". ") {
			grille.changeCase(l, c, s);
		}
	}

	// Tirer avec un sous-marin c'est comme shoot mais qu'avec les sous-marins
	@Override
	public boolean tirer(int x, int y, Grille grille, HashMap<String, Navire> hashMap) {
		// Si . alors on marque O touché dans l'eau
		if (grille.getCase(x, y) == ". ") {
			grille.changeCase(x, y, "O ");
			return true;
		}

		// Si SM alors on le coule et on lui enleve une vie
		if (grille.getCase(x, y).equals("S1") || grille.getCase(x, y).equals("S2") || grille.getCase(x, y).equals("S3")
				|| grille.getCase(x, y).equals("S4")) {

			getNavire(hashMap, grille.getCase(x, y)).pv--;
			grille.changeCase(x, y, "X ");
			return true;
		}

		// Si déjà coulé impossible et on recommence
		if (grille.getCase(x, y) == "X") {
			System.out.println("Vous ne pouvez pas tirer sur un sous-marin sur lequel vous avez déjà tiré.");
			return false;
		}

		// Sinon alors ce sont des navires et on ne peut pas les atteindre
		else {
			System.out.println("Vous ne pouvez pas toucher ces bateaux avec vos sous-marin");
			return true;
		}
	}

}
