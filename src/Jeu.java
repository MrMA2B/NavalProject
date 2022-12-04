import java.util.Scanner;

public class Jeu {
	static Scanner sc = new Scanner(System.in);
	public void jeu() {
	
	System.out.println("Vous jouez contre l'ordinateur");

	Grille grille = new Grille(15, 15);
	Destroyers d1 = new Destroyers();
	Navire nav = new Navire();
	d1.placerD1(grille);
	d1.placerD2(grille);
	int x = nav.getPositionX();
	int y = nav.getPositionY();
	grille.afficher();

	System.out.println("1.Tirer");
	System.out.println("2.Déplacer");
	System.out.println("Que voulez-vous faire : ");	
	int choix = sc.nextInt();
	if(choix==1) {
		System.out.println("Attente...");
	}
	if(choix==2) {
		System.out.println("Quel navire voulez-vous déplacer ?");
		int choixbat = sc.nextInt();
			if(choixbat == nav.getBat(choixbat)) {
				if(nav.getAxeb(choixbat) == 0) {
					System.out.println("Faire H");
					System.out.println("Faire B");
					char direction = sc.next().charAt(0);
					while(grille.testerPos(nav.getX(choixbat),nav.getY(choixbat), direction, 3, choixbat, nav.getAxeb(choixbat)) == false) {
						System.out.println("Faire H");
						System.out.println("Faire B");
						direction = sc.next().charAt(0);
					}
					grille.testerPos(nav.getX(choixbat),nav.getY(choixbat), direction, 3, choixbat, nav.getAxeb(choixbat));
					grille.anciennePos(nav.getX(choixbat),nav.getY(choixbat), "D1", direction);	
					grille.nouvellePos(nav.getX(choixbat),nav.getY(choixbat), "D1", direction);
					grille.afficher();
				}
				if(nav.getAxeb(choixbat)  == 1) {
					System.out.println("Faire G");
					System.out.println("Faire D");
					char direction2 = sc.next().charAt(0);
					while(grille.testerPos(nav.getX(choixbat),nav.getY(choixbat), direction2, 3, choixbat, nav.getAxeb(choixbat)) == false) {
						System.out.println("Faire G");
						System.out.println("Faire D");
						direction2 = sc.next().charAt(0);
					}
						grille.testerPos(nav.getX(choixbat),nav.getY(choixbat), direction2, 3, choixbat, nav.getAxeb(choixbat));
						grille.anciennePos(nav.getX(choixbat),nav.getY(choixbat), "D1", direction2);	
						grille.nouvellePos(nav.getX(choixbat),nav.getY(choixbat), "D1", direction2);
						grille.afficher();
				}
			}
	}
	System.out.println("Au tour de l'adversaire...");	
	}
	
}
