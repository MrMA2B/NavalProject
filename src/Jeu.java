import java.util.Scanner;

public class Jeu {
	static Scanner sc = new Scanner(System.in);
	public void jeu() {
	
	System.out.println("Vous jouez contre l'ordinateur");

	Grille grille = new Grille(15, 15);
	Navire axe = new Navire();
	Destroyers d1 = new Destroyers();
	d1.placer(grille);
	
	grille.afficher();

	System.out.println("Que voulez-vous faire : ");	
	System.out.println("1.Tirer");
	System.out.println("2.Déplacer");	
	int choix = sc.nextInt();
	if(choix==1) {
		System.out.println("Attente...");
	}
	if(choix==2) {
		System.out.println("Quel navire voulez-vous déplacer ?");
		int choixbat = sc.nextInt();
			if(choixbat == 1) {
				if(d1.getAxe() == 0) {
					System.out.println("Faire H");
					System.out.println("Faire B");
					char direction = sc.next().charAt(0);
					while(grille.testerPos(d1, direction, 3) == false) {
						System.out.println("Faire H");
						System.out.println("Faire B");
						direction = sc.next().charAt(0);
					}
					grille.testerPos(d1, direction, 3);
					grille.anciennePos(d1, "D1", direction);	
					grille.nouvellePos(d1, "D1", direction);
					grille.afficher();
				}
				if(d1.getAxe() == 1) {
					System.out.println("Faire G");
					System.out.println("Faire D");
					char direction2 = sc.next().charAt(0);
					while(grille.testerPos(d1, direction2, 3) == false) {
						System.out.println("Faire G");
						System.out.println("Faire D");
						direction2 = sc.next().charAt(0);
					}
						grille.testerPos(d1, direction2, 3);
						grille.anciennePos(d1, "D1", direction2);	
						grille.nouvellePos(d1, "D1", direction2);
						grille.afficher();
					
				}
			}
	}
	System.out.println("Au tour de l'adversaire...");	
	}
	
}
