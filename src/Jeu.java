import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Jeu implements Serializable {
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

		System.out.println("Vous jouez contre un ordinateur. Saurez-vous vous montrer plus stratégique que lui ?");

		Joueur joueur = new Joueur();
		Robot robot = new Robot();

		Grille grilleH = joueur.jeu();
		Grille grilleR = robot.jeu();

		HashMap<String, Navire> hashMapBoatsOfJoueur = joueur.getHashMap();
		HashMap<String, Navire> hashMapBoatsOfRobot = robot.getHashMap();

		int generalPvH = joueur.getGeneralPvH();
		int generalPvR = robot.getGeneralPvR();

		ArrayList<String> listOfBoatRadomTargetChoice = new ArrayList<String>(
				Arrays.asList("S1", "S2", "S3", "S4", "D1", "D2", "D3", "F1", "F2", "C0"));
		ArrayList<Character> listOfRandomPositionChoice = new ArrayList<Character>(Arrays.asList('H', 'B', 'G', 'D'));
		Random random = new Random();

		System.out.println("Voici votre grille mon Amiral : ");
		grilleH.afficher();
		System.out.println("Voici la grille ennemie : ");
		grilleR.affichercacher();

		while ((generalPvH > 0) && (generalPvR > 0)) { // NE PAS OUBLIER DE GETTER LE PV GENERAL EN FIN DE BOUCLE
			System.out.println("C'est votre tour moussaillon ! \n");
			System.out.println("Entrez 1 pour : Tirer");
			System.out.println("Entrez 2 pour : Déplacer");

			System.out.print("En attente d'ordre d'action : ");
			int actionChoice = sc0.nextInt();

			if (actionChoice == 1) {

				System.out.print("Depuis quel navire voulez-vous tirer ?");
				String targetChoice = sc1.nextLine();

				Navire navireH = hashMapBoatsOfJoueur.get(targetChoice);
				boolean testH = false;

				while (testH == false) {

					System.out.print("Entrez les coordonées X de votre cible (ex : A, G, O) : ");
					String targetChar = sc2.nextLine();
					int targetX = grilleR.getColonne(targetChar);

					System.out.print("Entrez les coordonées Y de votre cible (ex : 1, 6, 15) : ");
					int targetY = sc3.nextInt() - 1;

					testH = navireH.tirer(targetX, targetY, grilleR, hashMapBoatsOfRobot);
					
					generalPvH = joueur.getGeneralPvH();
					generalPvR = robot.getGeneralPvR();
					
					System.out.println("Voici votre grille mon Amiral : ");
					grilleH.afficher();
					System.out.println("Voici la grille ennemie : ");
					grilleR.affichercacher();
				}
			}
			if (actionChoice == 2) {

				System.out.print("Quel navire voulez-vous déplacer ?");
				String choosenBoat = sc4.nextLine();

				if (hashMapBoatsOfJoueur.get(choosenBoat).getPv() == grilleH.getNbrcase(choosenBoat)) {

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
				} else {
					System.out.println("Impossible à déplacer : ");
				}

				System.out.println("Voici votre grille mon Amiral : ");
				grilleH.afficher();
				System.out.println("Voici la grille ennemie : ");
				grilleR.affichercacher();

			}

			System.out.println("\n Au tour de l'ennemi... \n");

			int randomActionChoice = random.nextInt(2);
			int indexOfBoatRadomTargetChoice = random.nextInt(listOfBoatRadomTargetChoice.size());
			String randomTargetChoice = listOfBoatRadomTargetChoice.get(indexOfBoatRadomTargetChoice);
			Navire navireR = hashMapBoatsOfRobot.get(randomTargetChoice);

			int randomIndexDirection = random.nextInt(listOfRandomPositionChoice.size());
			char randomPositionChoice = listOfRandomPositionChoice.get(randomIndexDirection);

			switch (randomActionChoice) {

			case 0: // Shoot

				int randomTargetX = random.nextInt(15);
				System.out.println("L'ordinateur à choisi la coordonnée X : " + randomTargetX); // A CORRIGER POUR
																								// AFFICHER DES "A" "B"
																								// ....
				int randomTargetY = random.nextInt(15);
				System.out.println("L'ordinateur à choisi la coordonnée Y : " + randomTargetY);

				navireR.tirer(randomTargetX, randomTargetY, grilleH, hashMapBoatsOfJoueur);
				
				generalPvH = joueur.getGeneralPvH();
				generalPvR = robot.getGeneralPvR();

				System.out.println("Voici votre grille mon Robot Amiral : ");
				grilleR.afficher();
				System.out.println("Voici la grille de l'ennemi humain : ");
				grilleH.affichercacher();
				break;

			case 1: // déplacer
				System.out.println("Le Robot Amiral à choisi de déplacer le navire : " + randomTargetChoice);
				
				if (hashMapBoatsOfRobot.get(randomTargetChoice).getPv() == grilleR.getNbrcase(randomTargetChoice)) {
					
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
						while (grilleR.testerSousmarin(grilleR.getX(randomTargetChoice),
								grilleR.getY(randomTargetChoice), randomPositionChoice) == false) {

							randomIndexDirection = random.nextInt(listOfRandomPositionChoice.size());
							randomPositionChoice = listOfRandomPositionChoice.get(randomIndexDirection);
							grilleR.testerSousmarin(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
									randomPositionChoice);
						}
						grilleR.changeSousmarin(grilleR.getX(randomTargetChoice), grilleR.getY(randomTargetChoice),
								randomPositionChoice, randomTargetChoice);
					}
				} else {
					System.out.println("Imopossible de déplacer ");
				}

				System.out.println("Voici votre grille mon Robot Amiral : ");
				grilleR.afficher();
				System.out.println("Voici la grille de l'ennemi humain : ");
				grilleH.affichercacher();
				break;
			}
		}
	}

}
