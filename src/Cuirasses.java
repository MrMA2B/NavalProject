
public class Cuirasses extends Navire {

	public Cuirasses(String name, int lenght, int pv) {
		super(name, lenght, pv);
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 8);
		int p = (int) (Math.random() * 2);
		boolean gg = false;

		if (p == 0) {
			while (gg == false) {
				gg = testA(7, l, c, 'C',grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 8);
			}

		}
		if (p == 1) {
			while (gg == false) {
				gg = testB(7, l, c, 'C',grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 8);
			}
		}
	}
}