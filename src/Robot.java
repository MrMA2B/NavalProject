import java.util.HashMap;


public class Robot {


		public void Robot() {

			

			Grille grilleR = new Grille(15, 15);

			Sousmarin s1 = new Sousmarin();
			s1.placer(grilleR);
			Sousmarin s2 = new Sousmarin();
			s2.placer(grilleR);
			Sousmarin s3 = new Sousmarin();
			s3.placer(grilleR);
			Sousmarin s4 = new Sousmarin();
			s4.placer(grilleR);

			Destroyers d1 = new Destroyers();
			d1.placer(grilleR);
			Destroyers d2 = new Destroyers();
			d2.placer(grilleR);
			Destroyers d3 = new Destroyers();
			d3.placer(grilleR);

			Fregate f1 = new Fregate();
			f1.placer(grilleR);
			Fregate f2 = new Fregate();
			f2.placer(grilleR);
			
			Cuirasses c0 = new Cuirasses();
			c0.placer(grilleR);
			
			HashMap<String, Navire> hashMap = new HashMap<String, Navire>();
			hashMap.put("S1",s1);
			hashMap.put("S2",s2);
			hashMap.put("S3",s3);
			hashMap.put("S4",s4);
			hashMap.put("D1",d1);
			hashMap.put("D2",d2);
			hashMap.put("D3",d3);
			hashMap.put("F1",f1);
			hashMap.put("F2",f2);
			hashMap.put("C0",c0);
			
			grilleR.afficher(); }}

//			System.out.println("1.Tirer");
//			System.out.println("2.Déplacer");
//			System.out.println("Que voulez-vous faire : ");
//			int choix = sc.nextInt();
//			if (choix == 1) {
//				System.out.println("Depuis quel navire voulez-vous tirer?");
//				//String choixbat = sc1.nextLine();
//				Navire navire = hashMap.get(choixbat);
//				boolean test = false;
//
//				while (test == false) {
//					System.out.println("Rentrer X : ");
//					int x = sc.nextInt() - 1;
//					System.out.println("Rentrer Y : ");
//					int y = sc.nextInt() - 1;
//					test = navire.tirer(x, y, grilleR);
//				}
//				test = false;
//				grilleR.afficher();
//				System.out.println("Continuer : ");
//				String TEST = sc1.nextLine();
//							
//				while (!TEST.equals("Q")) {
//					
//					System.out.println("X : ");
//					String aux = sc2.nextLine();
//					int x = grilleR.getColonne(aux);
//					
//					System.out.println("Y : ");
//					int y = sc.nextInt()-1;
//					
//					test = navire.tirer(x, y, grilleR);
//					navire.touche();
//					grilleR.afficher();
//					
//					System.out.println("Continuer : ");
//					TEST = sc1.nextLine();
//					
//					System.out.println("Depuis quel navire voulez-vous tirer?");
//					choixbat = sc1.nextLine();
//					navire = hashMap.get(choixbat);
//				}
//
//			}
//			if (choix == 2) {
//				System.out.println("Quel navire voulez-vous déplacer ?");
//				String choixbat = sc1.nextLine();
//
//				if (grilleR.getAxe(choixbat) == 0) {
//
//					System.out.println("Faire B");
//					char direction = sc.next().charAt(0);
//					grilleR.testerPos(grilleR.getX(choixbat), grilleR.getY(choixbat), direction, 3, grilleR.getAxe(choixbat));
//					grilleR.changementPos(grilleR.getX(choixbat), grilleR.getY(choixbat), choixbat, direction);
//					grilleR.afficher();
//				}
//				if (grilleR.getAxe(choixbat) == 1) {
//					System.out.println("Faire G");
//					System.out.println("Faire D");
//					char direction2 = sc.next().charAt(0);
//					grilleR.testerPos(grilleR.getX(choixbat), grilleR.getY(choixbat), direction2, 3, grilleR.getAxe(choixbat));
//					grilleR.changementPos(grilleR.getX(choixbat), grilleR.getY(choixbat), choixbat, direction2);
//					grilleR.afficher();
//				}
//			}
//			System.out.println("Au tour de l'adversaire...");
//		}

	

