
public class Case {
	Navire bat; // Bateau se trouvant sur la case
	int typeBat; // identifiant du bateau se trouvant sur la case
	boolean deja; // case deja jouée ou non
	EtatCase how; // Etat de la cas
	
	public Case(EtatCase etat, int i) {
		how = etat;
		bat = null;
		deja = false;
		typeBat = i;
	}
	public Navire getBat() {
		return bat;
		
	}

	public void setBat(Navire bat) {
		this.bat = bat;
	}

	public boolean getDeja() {
		return deja;
	}

	public void setDeja(boolean deja) {
		this.deja = deja;
	}

	public EtatCase getHow() {
		return how;
	}

	public void setHow(EtatCase how) {
		this.how = how;
	}

	public int getTypeBat() {
		return typeBat;
	}

	public void setTypeBat(int typeBat) {
		this.typeBat = typeBat;
	}
}
