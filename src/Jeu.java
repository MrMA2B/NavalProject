import java.util.Scanner;

public class Jeu {
	static Scanner sc = new Scanner(System.in);
	public void jeu() {
	
	System.out.println("Vous jouez contre l'ordinateur");

	// Création de la grille
	Grille grille = new Grille(15, 15);
	
	// 4sm / 3 D / 2F / 1C;
	
//	Sousmarin s1 = new Sousmarin();
//	s1.placer(grille);
//	Sousmarin s2 = new Sousmarin();
//	s2.placer(grille);
//	Sousmarin s3 = new Sousmarin();
//	s3.placer(grille);
//	Sousmarin s4 = new Sousmarin();
//	s4.placer(grille);
//	grille.afficher();

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
		//Object choixbat = sc.nextInt();
		System.out.println("Faire H");
		System.out.println("Faire B");
		System.out.println("Faire G");
		System.out.println("Faire D");
		char sens = sc.next().charAt(0);
		while(grille.testerPos(d1, 1, sens, 3) == false) {
			System.out.println("Faire H");
			System.out.println("Faire B");
			sens = sc.next().charAt(0);
		}
		grille.testerPos(d1, 0, sens, 3);
		grille.anciennePos(d1, "D", sens);	
		grille.afficher();
		grille.nouvellePos(d1, "D", sens);
		grille.afficher();
	}
	System.out.println("Au tour de l'adversaire...");	
	}
}
