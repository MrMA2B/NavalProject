import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

		System.out.println("Vous jouez contre un ordinateur. Saurez-vous vous montrer plus stratégique que lui ?");

		Joueur joueur = new Joueur();
		Robot robot = new Robot();

		Grille grilleH = joueur.jeuTriche();
		Grille grilleR = robot.jeuTriche();

		HashMap<String, Navire> hashMapBoatsOfJoueur = joueur.getHashMap();
		HashMap<String, Navire> hashMapBoatsOfRobot = robot.getHashMap();

		int generalPvH = joueur.getGeneralPvHTriche();
		int generalPvR = robot.getGeneralPvRTriche();

		ArrayList<String> listOfBoatRadomTargetChoice = new ArrayList<String>(
				Arrays.asList("S1","D1","F1","C0"));
		ArrayList<Character> listOfRandomPositionChoice = new ArrayList<Character>(Arrays.asList('H', 'B', 'G', 'D'));
		Random random = new Random();

		while ((generalPvH > 0) || (generalPvR > 0)) { // NE PAS OUBLIER DE GETTER LE PV GENERAL EN FIN DE BOUCLE
			
			System.out.println("\n C'est votre tour moussaillon ! \n");
			
			System.out.println("Voici votre grille mon Amiral : ");
			grilleH.afficher();
			System.out.println("Voici la grille ennemie : ");
			grilleR.afficher();
			
			
			System.out.println("\n Entrez 1 pour : Tirer");
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

					testH = navireH.tirer(targetX, targetY, grilleR, hashMapBoatsOfJoueur);

					System.out.println("Voici votre grille mon Amiral : ");
					grilleH.afficher();
					System.out.println("Voici la grille ennemie : ");
					grilleR.afficher();
				}
			}
			if (actionChoice == 2) {

				System.out.print("Quel navire voulez-vous déplacer ?");
				String chosenBoat = sc4.nextLine();

				if (grilleH.getAxe(chosenBoat) == 0) {

					System.out.println("Pour déplacer vers le haut, entrez : H");
					System.out.println("Pour déplacer vers le bas, entrez : B");

					System.out.print("En attente d'ordre d'action : ");
					char chosenDirection = sc5.next().charAt(0);

					while (grilleH.testerPos(grilleH.getX(chosenBoat), grilleH.getY(chosenBoat), chosenDirection,
							grilleH.getNbrcase(chosenBoat), grilleH.getAxe(chosenBoat)) == false) {
						System.out.println("Pour déplacer vers le haut, entrez : H");
						System.out.println("Pour déplacer vers le bas, entrez : B");
						System.out.print("En attente d'ordre d'action : ");
						chosenDirection = sc6.next().charAt(0);
					}

					grilleH.changementPos(grilleH.getX(chosenBoat), grilleH.getY(chosenBoat), chosenBoat,
							chosenDirection, grilleH.getNbrcase(chosenBoat));
				}

				if (grilleH.getAxe(chosenBoat) == 1) {

					System.out.println("Pour déplacer vers la gauche, entrez : G");
					System.out.println("Pour déplacer vers la droite, entrez : D");

					System.out.print("En attente d'ordre d'action : ");
					char chosenDirection = sc7.next().charAt(0);

					while (grilleH.testerPos(grilleH.getX(chosenBoat), grilleH.getY(chosenBoat), chosenDirection,
							grilleH.getNbrcase(chosenBoat), grilleH.getAxe(chosenBoat)) == false) {
						System.out.println("Pour déplacer vers la gauche, entrez : G");
						System.out.println("Pour déplacer vers la droite, entrez : D");
						System.out.print("En attente d'ordre d'action : ");
						chosenDirection = sc8.next().charAt(0);
					}
					grilleH.changementPos(grilleH.getX(chosenBoat), grilleH.getY(chosenBoat), chosenBoat,
							chosenDirection, grilleH.getNbrcase(chosenBoat));
				}

				if (grilleH.getAxe(chosenBoat) == 2) {
					System.out.println("Pour déplacer vers le haut, entrez : H");
					System.out.println("Pour déplacer vers le bas, entrez : B");
					System.out.println("Pour déplacer vers la gauche, entrez : G");
					System.out.println("Pour déplacer vers la droite, entrez : D");

					System.out.print("En attente d'ordre d'action : ");
					char chosenDirection = sc9.next().charAt(0);

					while (grilleH.testerSousmarin(grilleH.getX(chosenBoat), grilleH.getY(chosenBoat),
							chosenDirection) == false) {
						System.out.println("Pour déplacer vers le haut, entrez : H");
						System.out.println("Pour déplacer vers le bas, entrez : B");
						System.out.println("Pour déplacer vers la gauche, entrez : G");
						System.out.println("Pour déplacer vers la droite, entrez : D");
						System.out.print("En attente d'ordre d'action : ");
						chosenDirection = sc10.next().charAt(0);
					}
					grilleH.changeSousmarin(grilleH.getX(chosenBoat), grilleH.getY(chosenBoat), chosenDirection,
							chosenBoat);
				}

				System.out.println("Voici votre grille mon Amiral : ");
				grilleH.afficher();
				System.out.println("Voici la grille ennemie : ");
				grilleR.afficher();

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
				
				navireR.tirer(randomTargetX, randomTargetY, grilleH, hashMapBoatsOfRobot);

				System.out.println("Voici votre grille mon Robot Amiral : ");
				grilleR.afficher();
				System.out.println("Voici la grille de l'ennemi humain : ");
				grilleH.affichercacher();
				break;

			case 1: // déplacer
				System.out.println("Le Robot Amiral à choisi de déplacer le navire : " + randomTargetChoice);

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
	}

}
