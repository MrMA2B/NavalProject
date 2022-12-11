import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main implements Serializable {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
			// Définissez le frame
	        JFrame frame = new JFrame("Bataille Navale");

	        // Définir les boutons
	        JButton btn0 = new JButton("Jouer une partie");
	        JButton btn1 = new JButton("Mode triche");
	        JButton btn2 = new JButton("Charger une partie");
	        JButton btn3 = new JButton("Aide");
	        JButton btn4 = new JButton("Quitter"); 
	        // Ajouter les boutons au frame

	        JPanel b0 = new JPanel();
	        //On définit le layout en lui indiquant qu'il travaillera en ligne
	        b0.setLayout(new BoxLayout(b0, BoxLayout.LINE_AXIS));
	        b0.add(btn0);
	        JPanel b1 = new JPanel();
	        //On définit le layout en lui indiquant qu'il travaillera en ligne
	        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	        b1.add(btn1);
	        JPanel b2 = new JPanel();
	        //On définit le layout en lui indiquant qu'il travaillera en ligne
	        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	        b2.add(btn2);
	        JPanel b3 = new JPanel();
	        //On définit le layout en lui indiquant qu'il travaillera en ligne
	        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
	        b3.add(btn3);
	        JPanel b4 = new JPanel();
	        //On définit le layout en lui indiquant qu'il travaillera en ligne
	        b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
	        b4.add(btn4);
	        JPanel b5 = new JPanel();
	        //On positionne maintenant ces trois lignes en colonne
	        b5.setLayout(new BoxLayout(b5, BoxLayout.PAGE_AXIS));
	        // Ajouter label et panel au frame
	        b5.add(b0);
	        b5.add(b1);
	        b5.add(b2);
	        b5.add(b3);
	        b5.add(b4);
	        frame.getContentPane().add(b5);
	        
	        // On définit la frame 500*500 et on la rend visible
	        frame.pack();
	        frame.setSize(250, 250);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	        // On définit une action pour chaque
	        btn0.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        		Jeu jeu = new Jeu();
	        		frame.dispose();
	        		jeu.newGame();
	        	    }  
	        });
	        btn1.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        		JeuTriche jeuTriche = new JeuTriche();
	        		frame.dispose();
	        		jeuTriche.newGame();
	        	    }  
	        });
	        btn2.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        		frame.dispose();
	        		Deserialisation charger = new Deserialisation();
					charger.verifierExistenceFichier();
	        	    }  
	        });
	        btn3.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){
	        		frame.dispose();
	        		Aide();  	        
	        	    }  
	        });
	        btn4.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        		frame.dispose();
	        	    }  
	        });
	    }
	
	private static void Aide() {
		System.out.println(" ______________________________________________________________________________________________________________________  \n" +
				
"|                                               								       |\n"
+ "|       				Bienvenue dans la Bataille Navale       				       |\n"
+ "|                                                                                                                      |\n"
+ "|       Vous disposez de 4 navires de longueurs différentes positionner aléatoirement sur un plateau de 15 sur 15.     |\n"
+ "|       Tour à tour decidez si vous voulez déplacer un navire ou tirer depuis un navire                                |\n"
+ "|       Si toutes les cases d'un même bateau sont touchées, il sera affiché par des 'X' pour indiquer qu'il a coulé.   |\n"
+ "|       A l'inverse, si l'adversaire touche un de vos navires, le message 'vous avez été touché' s'affichera et s'il   |\n"
+ "|       parvient à couler votre bateau il sera afficher par des 'X'.						       |\n"
+ "|       Le but est de couler tous les bateaux de l'adversaire 							       |\n"
+ "|       Bon jeu!                  									               |\n"
+ "|______________________________________________________________________________________________________________________|");
		
		/*
		 Permet d'obliger le joueur un faire un choix 
		 */
		int choix = 0;

		while ((choix != 1) && (choix != 2)) {
			try {
				System.out.println("\nContrordre Amiral ! On attend de vous :\n");
				System.out.println("	- De lancer une partie (1)");
				System.out.println("	- Ou de quitter (2)");
				System.out.print("\nFaites votre choix : ");
				choix = sc.nextInt();
			} catch (InputMismatchException e) {
				
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
					System.out.println("Vous avez quitté le jeu...");
					System.exit(0);
					break;
				}
	}
}