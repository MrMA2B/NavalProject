
public class Navire {

	public String name;
	private int lenght;
	private int pv;

	public Navire(String nom, int taille, int vie) {
		name = nom;
		lenght = taille;
		pv = vie;
	}

	public String getName() {
		return name;
	}

	public int getLenght() {
		return lenght;
	}

	public int getPv() {
		return pv;
	}

}
