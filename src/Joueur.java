
/**
 * This class define a Joueur
 *
 * @author Adrien MATTEI, Thierry RINGLET, Felix HUMEAU, Augustin MEAUDRE
 */

import java.io.Serializable;
import java.util.*;

public class Joueur implements Serializable {
	HashMap<String, Navire> hashMap = new HashMap<String, Navire>();

	// Constructeur
	public Grille jeu() {

		// On crée un grille propre au joueur
		Grille grilleH = new Grille(15, 15);

		// On crée tous les navires propres au joueur
		Sousmarin s1 = new Sousmarin();
		s1.placer(grilleH, "S1");
		Sousmarin s2 = new Sousmarin();
		s2.placer(grilleH, "S2");
		Sousmarin s3 = new Sousmarin();
		s3.placer(grilleH, "S3");
		Sousmarin s4 = new Sousmarin();
		s4.placer(grilleH, "S4");

		Destroyers d1 = new Destroyers();
		d1.placer(grilleH, "D1");
		Destroyers d2 = new Destroyers();
		d2.placer(grilleH, "D2");
		Destroyers d3 = new Destroyers();
		d3.placer(grilleH, "D3");

		Fregate f1 = new Fregate();
		f1.placer(grilleH, "F1");
		Fregate f2 = new Fregate();
		f2.placer(grilleH, "F2");

		Cuirasses c0 = new Cuirasses();
		c0.placer(grilleH);

		// On ajoute les objets dans une HashMap avec les noms associés en String
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

		return grilleH;
	}

	// Pareil mais pour le mode triche avec moins de bateaux
	public Grille jeuTriche() {

		Grille grilleH = new Grille(15, 15);

		Sousmarin s1 = new Sousmarin();
		s1.placer(grilleH, "S1");

		Destroyers d1 = new Destroyers();
		d1.placer(grilleH, "D1");

		Fregate f1 = new Fregate();
		f1.placer(grilleH, "F1");

		Cuirasses c0 = new Cuirasses();
		c0.placer(grilleH);

		hashMap.put("S1", s1);
		hashMap.put("D1", d1);
		hashMap.put("F1", f1);
		hashMap.put("C0", c0);

		return grilleH;
	}

	public HashMap<String, Navire> getHashMap() {
		return this.hashMap;
	}

	// On récupère la sommes de tous les pv de chaque navire du joueur
	public int getGeneralPvH() {
		return hashMap.get("S1").pv + hashMap.get("S2").pv + hashMap.get("S3").pv + hashMap.get("S4").pv
				+ hashMap.get("D1").pv + hashMap.get("D2").pv + hashMap.get("D3").pv + hashMap.get("F1").pv
				+ hashMap.get("F2").pv + hashMap.get("C0").pv;
	}

	public int getGeneralPvHTriche() {
		return hashMap.get("S1").pv + hashMap.get("D1").pv + hashMap.get("F1").pv + hashMap.get("C0").pv;
	}

}
