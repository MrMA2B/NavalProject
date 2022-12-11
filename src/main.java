
/**
 * This class define all the methods' Cuirasses
 *
 * @author Adrien MATTEI, Thierry RINGLET, Felix HUMEAU, Augustin MEAUDRE
 */

import java.io.Serializable;
import java.util.*;
import java.util.Scanner;

public class main implements Serializable {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int entrer = 0;
		while (true) {
			if (entrer != 0) {
				System.out.println("Faire Entrer pour continuer");
				try {
					System.in.read();
				} catch (Exception e) {
				}
			}
			entrer = 1;

			System.out.println("Bienvenue dans Bataille Navale Mobile. Entrez : \n");
			System.out.println("1 : Pour jouer une partie");
			System.out.println("2 : Pour charger une partie");
			System.out.println("3 : Pour obtenir de l'aide");
			System.out.println("4 : Pour quitter");

			int choix = 0;

			while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)) {
				try {
					System.out.print("\nFaites votre choix : ");
					choix = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nContrordre Amiral ! On attend de vous :\nl");
					System.out.println("	- De lancer une partie (1)");
					System.out.println("	- De charger une partie (2)");
					System.out.println("	- D'obtenir de l'aide (3)");
					System.out.println("	- Ou de quitter (4)");
					sc.next();
					continue;
				}
			}

			switch (choix) {
			case 1:
				JeuTriche j = new JeuTriche();
				j.newGame();
				break;
			case 2:
				Deserialisation charger = new Deserialisation();
				charger.verifierExistenceFichier();
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
