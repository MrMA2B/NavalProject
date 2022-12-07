import java.io.Serializable;
import java.util.*;

public class Robot implements Serializable {
	HashMap<String, Navire> hashMap = new HashMap<String, Navire>();

	public Grille jeu() {

		Grille grilleR = new Grille(15, 15);

		Sousmarin s1 = new Sousmarin();
		s1.placer(grilleR, "S1");
		Sousmarin s2 = new Sousmarin();
		s2.placer(grilleR, "S2");
		Sousmarin s3 = new Sousmarin();
		s3.placer(grilleR, "S3");
		Sousmarin s4 = new Sousmarin();
		s4.placer(grilleR, "S4");

		Destroyers d1 = new Destroyers();
		d1.placer(grilleR, "D1");
		Destroyers d2 = new Destroyers();
		d2.placer(grilleR, "D2");
		Destroyers d3 = new Destroyers();
		d3.placer(grilleR, "D3");

		Fregate f1 = new Fregate();
		f1.placer(grilleR, "F1");
		Fregate f2 = new Fregate();
		f2.placer(grilleR, "F2");

		Cuirasses c0 = new Cuirasses();
		c0.placer(grilleR);

		hashMap.put("S1", s1);
		hashMap.put("S2", s2);
		hashMap.put("S3", s3);
		hashMap.put("S4", s4);
		hashMap.put("D1", d1);
		hashMap.put("D2", d2);
		hashMap.put("D3", d3);
		hashMap.put("F1", f1);
		hashMap.put("F2", f2);
		hashMap.put("C0", c0);

		return grilleR;

	}

	public Grille jeuTriche() {

		Grille grilleR = new Grille(15, 15);

		Sousmarin s1 = new Sousmarin();
		s1.placer(grilleR, "S1");

		Destroyers d1 = new Destroyers();
		d1.placer(grilleR, "D1");

		Fregate f1 = new Fregate();
		f1.placer(grilleR, "F1");

		Cuirasses c0 = new Cuirasses();
		c0.placer(grilleR);

		hashMap.put("S1", s1);
		hashMap.put("D1", d1);
		hashMap.put("F1", f1);
		hashMap.put("C0", c0);

		return grilleR;

	}

	public HashMap<String, Navire> getHashMap() {
		return this.hashMap;
	}

	public int getGeneralPvR() {
		return hashMap.get("S1").pv + hashMap.get("S2").pv + hashMap.get("S3").pv + hashMap.get("S4").pv
				+ hashMap.get("D1").pv + hashMap.get("D2").pv + hashMap.get("D3").pv + hashMap.get("F1").pv
				+ hashMap.get("F2").pv + hashMap.get("C0").pv;
	}

	public int getGeneralPvRTriche() {
		return hashMap.get("S1").pv + hashMap.get("D1").pv + hashMap.get("F1").pv + hashMap.get("C0").pv;
	}
}
