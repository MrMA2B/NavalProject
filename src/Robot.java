import java.util.*;

public class Robot {
	
	HashMap<String, Navire> hashMapp = new HashMap<String, Navire>();
	ArrayList<String> bateau = new ArrayList <String>(Arrays.asList("S1","S2","S3","S4","D1","D2","D3","F1","F2","C1"));
	Random random = new Random(); 
	ArrayList<Character> pos = new ArrayList <Character>(Arrays.asList('H','B','G','D')); 
	
	
	Grille grilleR = new Grille(15, 15);
	
	public void placementRobot() {
		
		
		System.out.println("Vous êtes l'ordinateur");

		

		Sousmarin s1 = new Sousmarin();
		s1.placer(grilleR,"S1");
		Sousmarin s2 = new Sousmarin();
		s2.placer(grilleR,"S2");
		Sousmarin s3 = new Sousmarin();
		s3.placer(grilleR,"S3");
		Sousmarin s4 = new Sousmarin();
		s4.placer(grilleR,"S4");

		Destroyers d1 = new Destroyers();
		d1.placer(grilleR,"D1");
		Destroyers d2 = new Destroyers();
		d2.placer(grilleR,"D2");
		Destroyers d3 = new Destroyers();
		d3.placer(grilleR,"D3");

		Fregate f1 = new Fregate();
		f1.placer(grilleR,"F1");
		Fregate f2 = new Fregate();
		f2.placer(grilleR,"F2");

		Cuirasses c0 = new Cuirasses();
		c0.placer(grilleR);

		
		hashMapp.put("S1", s1);
		hashMapp.put("S2", s2);
		hashMapp.put("S3", s3);
		hashMapp.put("S4", s4);
		hashMapp.put("D1", d1);
		hashMapp.put("D2", d2);
		hashMapp.put("D3", d3);
		hashMapp.put("F1", f1);
		hashMapp.put("F2", f2);
		hashMapp.put("C0", c0);

		grilleR.afficher();
		grilleR.affichercacher();
		}
	
	public void jouerRobot () {
		int a = random.nextInt(2);
		int randomIndex= random.nextInt(bateau.size()); // random dans une liste qui contient ["S1", "S2", ....]
		String choixBat = bateau.get(randomIndex);
		Navire navire = hashMapp.get(choixBat);
		int randomIndexPos= random.nextInt(pos.size()); // random dans une liste qui contient ["S1", "S2", ....]
		char choixPos = pos.get(randomIndexPos);
		switch(a) {
		case 0 : //tirer
			int tx = random.nextInt(15);
			System.out.println("Case en X est : "+tx);
			int ty = random.nextInt(15);
			System.out.println("Case en Y est :"+ty);
			navire.tirer(tx,ty,grilleR,hashMapp);
			grilleR.afficher();
			grilleR.affichercacher();
			break;
		
		case 1: //déplacer choiPos = H ou G ou D
			System.out.println("le navire choisi est :"+choixBat);
			
			if (grilleR.getAxe(choixBat) == 0) {
				while(grilleR.testerPos(grilleR.getX(choixBat), grilleR.getY(choixBat), choixPos, grilleR.getNbrcase(choixBat),
						grilleR.getAxe(choixBat)) == false) {
					randomIndexPos= random.nextInt(pos.size());
					choixPos = pos.get(randomIndexPos);
				}
				grilleR.changementPos(grilleR.getX(choixBat), grilleR.getY(choixBat), choixBat, choixPos,grilleR.getNbrcase(choixBat));
				grilleR.afficher();
			}
			if (grilleR.getAxe(choixBat) == 1) {				
				while(grilleR.testerPos(grilleR.getX(choixBat), grilleR.getY(choixBat), choixPos, grilleR.getNbrcase(choixBat),
						grilleR.getAxe(choixBat)) == false) {
					randomIndexPos= random.nextInt(pos.size());
					choixPos = pos.get(randomIndexPos);
				}
				grilleR.changementPos(grilleR.getX(choixBat), grilleR.getY(choixBat), choixBat, choixPos,grilleR.getNbrcase(choixBat));
				grilleR.afficher();
				}
			
			if (grilleR.getAxe(choixBat) == 2) {				
				while(grilleR.testerSousmarin(grilleR.getX(choixBat), grilleR.getY(choixBat),choixPos) == false) {
					randomIndexPos= random.nextInt(pos.size());
					choixPos = pos.get(randomIndexPos);
					grilleR.testerSousmarin(grilleR.getX(choixBat), grilleR.getY(choixBat),choixPos);
				}
				grilleR.changeSousmarin(grilleR.getX(choixBat), grilleR.getY(choixBat),choixPos, choixBat);
				grilleR.afficher();
			}
			
			break;
		}
		
	}
}

