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

		while ((generalPvH > 0) && (generalPvR > 0)) {

			System.out.println("\nC'est votre tour moussaillon ! \n");

			System.out.println("Voici votre grille Amiral : ");
			grilleH.afficher();
			System.out.println("Voici la grille ennemie : ");
			grilleR.afficher();

			System.out.println("\nEntrez 1 pour : Tirer");
			System.out.println("Entrez 2 pour : Déplacer");

			int actionChoice = 0;

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

			if (actionChoice == 1) {

				System.out.print("\nDepuis quel navire voulez-vous tirer ?");
				String targetChoice = sc1.nextLine();

				while (!listOfBoatRadomTargetChoice.contains(targetChoice)) {
					System.out.println("\nContrordre Amiral ! On attend de vous d'identifier un navire parmi :\n");
					System.out.println("	S1, D1, F1, et C0");
					System.out.print("\nDepuis quel navire voulez-vous tirer ?");
					targetChoice = sc1.nextLine();
				}

				Navire navireH = hashMapBoatsOfJoueur.get(targetChoice);

				while (navireH.getPv() == 0) {
					System.out.println("\nVous ne pouvez pas tirer à partir d'un navire coulé");
					System.out.print("Depuis quel navire voulez-vous tirer ?");
					targetChoice = sc1.nextLine();
					while (!listOfBoatRadomTargetChoice.contains(targetChoice)) {
						System.out
								.println("\nContrordre Amiral ! On attend de vous d'identifier parmi ceux restant :\n");
						System.out.print("\nDepuis quel navire voulez-vous tirer ?");
						targetChoice = sc1.nextLine();
					}
					navireH = hashMapBoatsOfJoueur.get(targetChoice);
				}

				boolean testH = false;

				while (testH == false) {

					System.out.print("\nEntrez les coordonées X de votre cible (ex : A, G, O) : ");
					String targetChar = sc2.nextLine();

					while (!listOfCoordX.contains(targetChar)) {
						System.out.println(
								"\nContrordre Amiral ! On attend de vous d'identifier une ligne comprise entre A et O :\n");
						System.out.print("Entrez les coordonées X de votre cible (ex : A, G, O) : ");
						targetChar = sc2.nextLine();
					}

					int targetX = grilleR.getColonne(targetChar);

					int targetY = 22;

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

					testH = navireH.tirer(targetX, targetY, grilleR, hashMapBoatsOfRobot);

					generalPvH = joueur.getGeneralPvHTriche();
					generalPvR = robot.getGeneralPvRTriche();

				}
			}
			if (actionChoice == 2) {

				System.out.print("Quel navire voulez-vous déplacer ?");
				String choosenBoat = sc4.nextLine();

				while (!listOfBoatRadomTargetChoice.contains(choosenBoat)) {
					System.out.println("\nContrordre Amiral ! On attend de vous d'identifier un navire parmi :\n");
					System.out.println("	S1, D1, F1, et C0");
					System.out.print("\nDepuis quel navire voulez-vous tirer ?");
					choosenBoat = sc4.nextLine();
				}

				while (hashMapBoatsOfJoueur.get(choosenBoat).getPv() != hashMapBoatsOfJoueur.get(choosenBoat).length) {
					System.out.println("\nLe bateau selectionné ne peut pas être déplacé car il a déjà été touché.");
					System.out.print("Quel navire voulez-vous déplacer : ");
					choosenBoat = sc4.nextLine();
					while (!listOfBoatRadomTargetChoice.contains(choosenBoat)) {
						System.out.println(
								"\nContrordre Amiral ! On attend de vous d'identifier un navire parmi ceux restant :\n");
						System.out.println("	S1, D1, F1, et C0");
						choosenBoat = sc4.nextLine();
					}
				}

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
			
			if((generalPvH == 0) || (generalPvR == 0)) {
				break;
			}

			System.out.println("\n Au tour de l'ennemi... \n");

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
				System.out.println("L'ordinateur à choisi la coordonnée X : " + randomTargetX); // A CORRIGER POUR
																								// AFFICHER DES "A" "B"
																								// ....
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
		}
		
		System.out.println("La partie est terminée! ");
		if(generalPvH == 0) {
			System.out.println("Dommage vous avez perdu.");
		}
		else {
			System.out.println("Bravo vous avez été plus fort que le robot Amiral !");
		}
	}

}
