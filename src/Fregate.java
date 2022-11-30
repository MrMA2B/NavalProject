
public class Fregate extends Navire {

	public Fregate(String name, int lenght, int pv) {
		super(name, lenght, pv);
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 10);
		int p = (int) (Math.random() * 2);
		boolean gg = false;

		if (p == 0) {
			while (gg == false) {
				gg = testA(5, l, c, 'F',grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}
		if (p == 1) {
			while (gg == false) {
				gg = testB(5, l, c, 'F',grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}
	}
}
