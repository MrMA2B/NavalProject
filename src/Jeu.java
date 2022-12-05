import java.util.Scanner;

public class Jeu {
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);
	Scanner sc3 = new Scanner(System.in);
	public void jeu() {
	
	System.out.println("Vous jouez contre l'ordinateur");

	Grille grille = new Grille(15, 15);
	Destroyers d1 = new Destroyers();
	Navire nav = new Navire();
	d1.placer(grille);
	grille.afficher();

	System.out.println("1.Tirer");
	System.out.println("2.Déplacer");
	System.out.println("Que voulez-vous faire : ");	
	int choix = sc.nextInt();
	if(choix==1) {
		System.out.println("Depuis quel navire voulez-vous tirer?");
		String choixbat = sc1.nextLine();
		boolean test = false;

		while (test == false) {
		System.out.println("Rentrer X : ");
		int x = sc.nextInt()-1;
		System.out.println("Rentrer Y : ");
		int y = sc.nextInt()-1;
		test = nav.tirer(x, y, grille); 
		}
		test = false;
		grille.afficher();
		System.out.println("Rentre coord");
		while (test == false) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			test = nav.tirer(x, y, grille);
			nav.touche();
			}
		test = false;
		grille.afficher();
		System.out.println("Rentre coord");
		while (test == false) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			test = nav.tirer(x, y, grille);
			nav.touche();
			}
			
			grille.afficher();
	}
	if(choix==2) {
		System.out.println("Quel navire voulez-vous déplacer ?");
		String choixbat = sc1.nextLine();
		
			if(grille.getAxe(choixbat) == 0) {
				
					System.out.println("Faire H");
					System.out.println("Faire B");
					char direction = sc.next().charAt(0);
					grille.testerPos(grille.getX(choixbat), grille.getY(choixbat), direction, 3, grille.getAxe(choixbat));
					grille.changementPos(grille.getX(choixbat), grille.getY(choixbat), choixbat, direction);
					grille.afficher();
			}
				if(grille.getAxe(choixbat) == 1){
					System.out.println("Faire G");
					System.out.println("Faire D");
					char direction2 = sc.next().charAt(0);
					grille.testerPos(grille.getX(choixbat), grille.getY(choixbat), direction2, 3, grille.getAxe(choixbat));
					grille.changementPos(grille.getX(choixbat), grille.getY(choixbat), choixbat, direction2);
					grille.afficher();
					}
			}
	System.out.println("Au tour de l'adversaire...");	
	}
	
}
