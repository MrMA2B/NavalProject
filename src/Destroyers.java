public class Destroyers extends Navire {

	public Destroyers() {
		super();
		pv = 3;
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		int axe = (int) (Math.random() * 2);
		boolean placer = false;

		if (axe == 0) {
			while (placer == false) {
				placer = testA(3, l, c, "D1", grille);// Modifier 3 par lenght du bateau
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}

		if (axe == 1) {
			while (placer == false) {
				placer = testB(3, l, c, "D1", grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}
	}

	@Override
	public boolean tirer(int x, int y, Grille grille) {
		shoot(x,y,grille);
		return true;
	}
}