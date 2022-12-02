
import java.util.Scanner;

public class main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int entrer = 0;

		while (true) {
			if (entrer != 0) {
				System.out.println("Faire Entrer pour continuer");
				Serialisation sauvegarde;
				
				try {
					System.in.read();
				} catch (Exception e) {
				}

			}
			entrer = 1;

			System.out.println("Bienvenue dans Bataille Navale. Sélectionnez un choix pour commencer");
			System.out.println("1. Jouer une partie");
			System.out.println("2. Charger une partie");
			System.out.println("3. Aide");
			System.out.println("4. Quitter");

			int choix = sc.nextInt();
			switch (choix) {
			case 1:
				System.out.println("Vous jouez contre l'ordinateur");

				// Création de la grille
				Grille grille = new Grille(15, 15);
				
				// 4sm / 3 D / 2F / 1C;
				// 30C
				
				Sousmarin s1 = new Sousmarin();
				s1.placer(grille);
				Sousmarin s2 = new Sousmarin();
				s2.placer(grille);
				Sousmarin s3 = new Sousmarin();
				s3.placer(grille);
				Sousmarin s4 = new Sousmarin();
				s4.placer(grille);
				
				Destroyers d1 = new Destroyers();
				d1.placer(grille);
				Destroyers d2 = new Destroyers();
				d2.placer(grille);
				Destroyers d3 = new Destroyers();
				d3.placer(grille);
				
				Fregate f1 = new Fregate();
				f1.placer(grille);
				Fregate f2 = new Fregate();
				f2.placer(grille);
						
				Cuirasses c1 = new Cuirasses();
				c1.placer(grille);
				
				
				grille.afficher();

				break;
			case 2:
				System.out.println("En travaux...");
				break;
			case 3:
				Aide();
				break;
			case 4:
				System.out.println("Vous avez quitté le jeu...");
				System.exit(0);
				break;
			}
		}
	}

	private static void Aide() {
		System.out.println(
				"Vous disposez de 5 bateaux de longueurs différentes à positionner sur un plateau de 10 sur 10.");
		System.out.println("Tour à tour positionnez les bateaux qui vous sont proposés de la manière suivante:");
		System.out.println(
				"Si vous avez choisi de positionner votre bateau verticalement, votre bateau se situera en-dessous de la case rentrée.");
		System.out.println(
				"Si vous avez choisi de positionner votre bateau horizontalement, votre bateau se situera à droite de la case rentrée");
		System.out.println(
				"Le jeu commence, sélectionnez une case sur laquelle tirer sur le plateau adverse, si un bateau s'y situe le message 'touché' s'affichera sinon rien");
		System.out.println("Si toutes les cases d'un même bateau sont touchées, le message 'coulé' s'affichera");
		System.out.println(
				"A l'inverse, si l'adversaire touche un de vos bateau, le message 'vous avez été touché' s'affichera et s'il parvient à couler votre bateau le message 'votre bateau a coulé' s'affichera");
		System.out.println("Le but est de couler tous les bateaux de l'adversaire");
	}

}



