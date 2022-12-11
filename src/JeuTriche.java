
/**
 * This class define the gameplay. Ie. all the proccess to play
 *
 * @author Adrien MATTEI, Thierry RINGLET, Felix HUMEAU, Augustin MEAUDRE
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JeuTriche implements Serializable {
	Scanner sc0 = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	Scanner sc3 = new Scanner(System.in);
	Scanner sc4 = new Scanner(System.in);
	Scanner sc5 = new Scanner(System.in);
	Scanner sc6 = new Scanner(System.in);
	Scanner sc7 = new Scanner(System.in);
	Scanner sc8 = new Scanner(System.in);
	Scanner sc9 = new Scanner(System.in);
	Scanner sc10 = new Scanner(System.in);

	public void newGame() {

		// On crée tous les objets pour le robots et le joueur

		System.out.println("\nVous jouez contre un ordinateur. Saurez-vous vous montrer plus stratégique que lui ?");

		Joueur joueur = new Joueur();
		Robot robot = new Robot();

		Grille grilleH = joueur.jeuTriche();
		Grille grilleR = robot.jeuTriche();

		HashMap<String, Navire> hashMapBoatsOfJoueur = joueur.getHashMap();
		HashMap<String, Navire> hashMapBoatsOfRobot = robot.getHashMap();

		int generalPvH = joueur.getGeneralPvHTriche();
		int generalPvR = robot.getGeneralPvRTriche();

		ArrayList<String> listOfBoatRadomTargetChoice = new ArrayList<String>(Arrays.asList("S1", "D1", "F1", "C0"));
		ArrayList<Character> listOfRandomPositionChoice = new ArrayList<Character>(Arrays.asList('H', 'B', 'G', 'D'));
		ArrayList<String> listOfCoordX = new ArrayList<>(
				Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"));
		ArrayList<Integer> listOfCoordY = new ArrayList<>(
				Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));
		Random random = new Random();
		
		int tour = 0;

		// Ici on test pour chaque tour si il reste des navires à toucher
		while ((generalPvH > 0) && (generalPvR > 0)) {

			System.out.println("\nC'est votre tour moussaillon ! \n");

			// Rq on affiche notre Grille et celle du Robot car on est dans le mode Triche
			System.out.println("Voici votre grille Amiral : ");
			grilleH.afficher();
			System.out.println("Voici la grille ennemie : ");
			grilleR.afficher();

			System.out.println("\nEntrez 1 pour : Tirer");
			System.out.println("Entrez 2 pour : Déplacer");

			int actionChoice = 0;

			// On blinde les entrées utilisateurs
			while ((actionChoice != 1) && (actionChoice != 2)) {
				try {
					System.out.print("\nEn attente d'ordre d'action : ");
					actionChoice = sc0.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nContrordre Amiral ! On attend de vous :\n");
					System.out.println("	- De tirer (1)");
					System.out.println("	- De déplacer un navire (2)");
					sc0.next();
					continue;
				}
			}

			// Si 1 on tire
			if (actionChoice == 1) {
				System.out.print("\nDepuis quel navire voulez-vous tirer ?");
				String targetChoice = sc1.nextLine();

				// On blinde les entrées utilisateurs
				while (!listOfBoatRadomTargetChoice.contains(targetChoice)) {
					System.out.println("\nContrordre Amiral ! On attend de vous d'identifier un navire parmi :\n");
					System.out.println("	S1, D1, F1, et C0");
					System.out.print("\nDepuis quel navire voulez-vous tirer ?");
					targetChoice = sc1.nextLine();
				}

				// On récupère l'objet navire selectionné par l'utilisateur en entrant un string
				// correspondant au nom du navire
				Navire navireH = hashMapBoatsOfJoueur.get(targetChoice);

				// On vérifie que le navire n'a pas déjà été coulé car sinon on ne peut pas
				// tirer avec et alors on redemande à l'utilisateur d'entrer un autre navire
				while (navireH.getPv() == 0) {
					System.out.println("\nVous ne pouvez pas tirer à partir d'un navire coulé");
					System.out.print("Depuis quel navire voulez-vous tirer ?");
					targetChoice = sc1.nextLine();

					// On blinde la nouvelle entrée dans le cas où la première ne passe pas
					while (!listOfBoatRadomTargetChoice.contains(targetChoice)) {
						System.out
								.println("\nContrordre Amiral ! On attend de vous d'identifier parmi ceux restant :\n");
						System.out.print("\nDepuis quel navire voulez-vous tirer ?");
						targetChoice = sc1.nextLine();
					}
					navireH = hashMapBoatsOfJoueur.get(targetChoice);
				}

				boolean testH = false;

				// Tant que le tire n'a pas fonctionné
				while (testH == false) {

					System.out.print("\nEntrez les coordonées X de votre cible (ex : A, G, O) : ");
					String targetChar = sc2.nextLine();

					// On blinde l'entrée utilisateur
					while (!listOfCoordX.contains(targetChar)) {
						System.out.println(
								"\nContrordre Amiral ! On attend de vous d'identifier une ligne comprise entre A et O :\n");
						System.out.print("Entrez les coordonées X de votre cible (ex : A, G, O) : ");
						targetChar = sc2.nextLine();
					}

					int targetX = grilleR.getColonne(targetChar);

					int targetY = 22;

					// On blinde l'entrée utilisateur
					while (!listOfCoordY.contains(targetY)) {
						try {
							System.out.print("Entrez les coordonées Y de votre cible (ex : 1, 6, 15) : ");
							targetY = sc3.nextInt() - 1;
						} catch (InputMismatchException e) {
							System.out.println(
									"\nContrordre Amiral ! On attend de vous d'identifier une colonne comprise entre 1 et 15 :\n");
							sc3.next();
							continue;
						}
					}

					// On tire sur la case selectionne avec le navire souhaité
					testH = navireH.tirer(targetX, targetY, grilleR, hashMapBoatsOfRobot);

					generalPvH = joueur.getGeneralPvHTriche();
					generalPvR = robot.getGeneralPvRTriche();
				}
			}

			// Si 2 alors on déplace le navire
			if (actionChoice == 2) {

				System.out.print("Quel navire voulez-vous déplacer ?");
				String choosenBoat = sc4.nextLine();

				// On blinde l'entrée utilisateur
				while (!listOfBoatRadomTargetChoice.contains(choosenBoat)) {
					System.out.println("\nContrordre Amiral ! On attend de vous d'identifier un navire parmi :\n");
					System.out.println("	S1, D1, F1, et C0");
					System.out.print("\nDepuis quel navire voulez-vous tirer ?");
					choosenBoat = sc4.nextLine();
				}

				// On teste si le navire n'a pas déjà été touché car si tel était le cas alors
				// on ne pourrait plus le déplacer
				while (hashMapBoatsOfJoueur.get(choosenBoat).getPv() != hashMapBoatsOfJoueur.get(choosenBoat).length) {
					System.out.println("\nLe bateau selectionné ne peut pas être déplacé car il a déjà été touché.");
					System.out.print("Quel navire voulez-vous déplacer : ");
					choosenBoat = sc4.nextLine();
					// On blinde l'entrée utilisateur
					while (!listOfBoatRadomTargetChoice.contains(choosenBoat)) {
						System.out.println(
								"\nContrordre Amiral ! On attend de vous d'identifier un navire parmi ceux restant :\n");
						System.out.println("	S1, D1, F1, et C0");
						choosenBoat = sc4.nextLine();
					}
				}

				// En fonction de l'axe du navire on propose de déplacer à G/D ou en H/B
				if (grilleH.getAxe(choosenBoat) == 0) {

					System.out.println("Pour déplacer vers le haut, entrez : H");
					System.out.println("Pour déplacer vers le bas, entrez : B");

					System.out.print("En attente d'ordre d'action : ");
					char chosenDirection = sc5.next().charAt(0);

					while (grilleH.testerPos(grilleH.getX(choosenBoat), grilleH.getY(choosenBoat), chosenDirection,
							grilleH.getNbrcase(choosenBoat), grilleH.getAxe(choosenBoat)) == false) {
						System.out.println("Pour déplacer vers le haut, entrez : H");
						System.out.println("Pour déplacer vers le bas, entrez : B");
						System.out.print("En attente d'ordre d'action : ");
						chosenDirection = sc6.next().charAt(0);
					}

					grilleH.changementPos(grilleH.getX(choosenBoat), grilleH.getY(choosenBoat), choosenBoat,
							chosenDirection, grilleH.getNbrcase(choosenBoat));
				}

				if (grilleH.getAxe(choosenBoat) == 1) {

					System.out.println("Pour déplacer vers la gauche, entrez : G");
					System.out.println("Pour déplacer vers la droite, entrez : D");

					System.out.print("En attente d'ordre d'action : ");
					char chosenDirection = sc7.next().charAt(0);

					while (grilleH.testerPos(grilleH.getX(choosenBoat), grilleH.getY(choosenBoat), chosenDirection,
							grilleH.getNbrcase(choosenBoat), grilleH.getAxe(choosenBoat)) == false) {
						System.out.println("Pour déplacer vers la gauche, entrez : G");
						System.out.println("Pour déplacer vers la droite, entrez : D");
						System.out.print("En attente d'ordre d'action : ");
						chosenDirection = sc8.next().charAt(0);
					}
					grilleH.changementPos(grilleH.getX(choosenBoat), grilleH.getY(choosenBoat), choosenBoat,
							chosenDirection, grilleH.getNbrcase(choosenBoat));
				}

				if (grilleH.getAxe(choosenBoat) == 2) {
					System.out.println("Pour déplacer vers le haut, entrez : H");
					System.out.println("Pour déplacer vers le bas, entrez : B");
					System.out.println("Pour déplacer vers la gauche, entrez : G");
					System.out.println("Pour déplacer vers la droite, entrez : D");

					System.out.print("En attente d'ordre d'action : ");
					char chosenDirection = sc9.next().charAt(0);

					while (grilleH.testerSousmarin(grilleH.getX(choosenBoat), grilleH.getY(choosenBoat),
							chosenDirection) == false) {
						System.out.println("Pour déplacer vers le haut, entrez : H");
						System.out.println("Pour déplacer vers le bas, entrez : B");
						System.out.println("Pour déplacer vers la gauche, entrez : G");
						System.out.println("Pour déplacer vers la droite, entrez : D");
						System.out.print("En attente d'ordre d'action : ");
						chosenDirection = sc10.next().charAt(0);
					}
					grilleH.changeSousmarin(grilleH.getX(choosenBoat), grilleH.getY(choosenBoat), chosenDirection,
							choosenBoat);
				}
			}

			// Ici on test si la dernière action de l'Humain n'a pas conduit à l'élimination
			// du dernier navire au quel cas la partie est terminée et on finit la manche
			if ((generalPvH == 0) || (generalPvR == 0)) {
				break;
			}

			System.out.println("\n Au tour de l'ennemi... \n");

			// Ici c'est exactement le même processus que précédement mais avec des entrées
			// aléatoires afin de générer le jeu du robot

			int randomActionChoice = random.nextInt(2);
			int indexOfBoatRadomTargetChoice = random.nextInt(listOfBoatRadomTargetChoice.size());
			String randomTargetChoice = listOfBoatRadomTargetChoice.get(indexOfBoatRadomTargetChoice);
			Navire navireR = hashMapBoatsOfRobot.get(randomTargetChoice);

			int randomIndexDirection = random.nextInt(listOfRandomPositionChoice.size());
			char randomPositionChoice = listOfRandomPositionChoice.get(randomIndexDirection);

			System.out.println("Voici votre grille mon Robot Amiral : ");
			grilleR.afficher();
			System.out.println("Voici la grille de l'ennemi humain : ");
			grilleH.affichercacher();

			switch (randomActionChoice) {

			case 0: // Shoot

				int randomTargetX = random.nextInt(15);
				System.out.println("L'ordinateur à choisi la coordonnée X : " + randomTargetX);

				int randomTargetY = random.nextInt(15);
				System.out.println("L'ordinateur à choisi la coordonnée Y : " + randomTargetY);

				while (hashMapBoatsOfRobot.get(randomTargetChoice).getPv() == 0) {
					indexOfBoatRadomTargetChoice = random.nextInt(listOfBoatRadomTargetChoice.size());
					randomTargetChoice = listOfBoatRadomTargetChoice.get(indexOfBoatRadomTargetChoice);
					navireR = hashMapBoatsOfRobot.get(randomTargetChoice);
				}

				navireR.tirer(randomTargetX, randomTargetY, grilleH, hashMapBoatsOfJoueur);

				generalPvH = joueur.getGeneralPvHTriche();
				generalPvR = robot.getGeneralPvRTriche();

				System.out.println("Voici votre grille mon Robot Amiral : ");
				grilleR.afficher();
				System.out.println("Voici la grille de l'ennemi humain : ");
				grilleH.affichercacher();
				break;

			case 1: // déplacer

				while (hashMapBoatsOfRobot.get(randomTargetChoice)
						.getPv() != hashMapBoatsOfRobot.get(randomTargetChoice).length) {
					indexOfBoatRadomTargetChoice = random.nextInt(listOfBoatRadomTargetChoice.size());
					randomTargetChoice = listOfBoatRadomTargetChoice.get(indexOfBoatRadomTargetChoice);
					navireR = hashMapBoatsOfRobot.get(randomTargetChoice);
				}

				System.out.println(navireR);

				if (grilleR.getAxe(randomTargetChoice) == 0) {

					while (grilleR.testerPos(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
							randomPositionChoice, grilleR.getNbrcase(randomTargetChoice),
							grilleR.getAxe(randomTargetChoice)) == false) {

						randomIndexDirection = random.nextInt(listOfRandomPositionChoice.size());
						randomPositionChoice = listOfRandomPositionChoice.get(randomIndexDirection);
					}

					grilleR.changementPos(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
							randomTargetChoice, randomPositionChoice, grilleR.getNbrcase(randomTargetChoice));

				}
				if (grilleR.getAxe(randomTargetChoice) == 1) {
					while (grilleR.testerPos(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
							randomPositionChoice, grilleR.getNbrcase(randomTargetChoice),
							grilleR.getAxe(randomTargetChoice)) == false) {

						randomIndexDirection = random.nextInt(listOfRandomPositionChoice.size());
						randomPositionChoice = listOfRandomPositionChoice.get(randomIndexDirection);
					}

					grilleR.changementPos(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
							randomTargetChoice, randomPositionChoice, grilleR.getNbrcase(randomTargetChoice));

				}

				if (grilleR.getAxe(randomTargetChoice) == 2) {
					while (grilleR.testerSousmarin(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
							randomPositionChoice) == false) {

						randomIndexDirection = random.nextInt(listOfRandomPositionChoice.size());
						randomPositionChoice = listOfRandomPositionChoice.get(randomIndexDirection);
						grilleR.testerSousmarin(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
								randomPositionChoice);
					}
					grilleR.changeSousmarin(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
							randomPositionChoice, randomTargetChoice);
				}

				System.out.println("Voici votre grille mon Robot Amiral : ");
				grilleR.afficher();
				System.out.println("Voici la grille de l'ennemi humain : ");
				grilleH.affichercacher();
				break;
			}

			generalPvH = joueur.getGeneralPvHTriche();
			generalPvR = robot.getGeneralPvRTriche();
			
			tour++;
		}

		// Ici on sort de la boucle while càd que une des 2 grille a tous ses bateaux
		// éliminés et alors la partie est terminée
		System.out.println("La partie est terminée! ");
		// Ici si les pv de la grille homme sont à 0 alors on affiche que l'homme a
		// perdu
		if (generalPvH == 0) {
			System.out.println("Dommage vous avez perdu en "+tour+" tours");
			// Sinon alors on a gagné
		} else {
			System.out.println("Bravo vous avez été plus fort que le robot Amiral ! Vous avez gagné en "+tour+" tours");
		}
	}

}
