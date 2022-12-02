
public class Grille {
	private int ligne;
	private int col;
	private String [][] grille;
	

	public Grille(int n, int p) {
		ligne = n;
		col = p;
		grille = new String[ligne][col];

		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++) {
				grille[i][j] = ".";
			}
		}
	}
	public void afficher() {
		String[] cologne = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
		System.out.println();
		System.out.println("   1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
		for(int i=0; i<ligne; i++) {
			System.out.print(cologne[i]);
			for(int j=0; j<col; j++) {
				System.out.print("  "+ grille[i][j]);
			}
			System.out.println("  ");		
		}
		System.out.println();
	}

	public String getCase(int l, int c) {
		return grille[l][c];
	}

	public void changeCase(int l, int c, String a) {
		grille[l][c] = a;
	}
	
	public boolean isWater(int l, int c) {
		if(getCase(l, c) == ".") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSm(int l, int c) {
		if(getCase(l, c) == "S") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isF(int l, int c) {
		if(getCase(l, c) == "F") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isC(int l, int c) {
		if(getCase(l, c) == "C") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isD(int l, int c) {
		if(getCase(l, c) == "D") {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Getter
	  public String[][] getGrille() {
	    return grille;
	  }

	  // Setter
	  public void setGrille(String[][] newGrille) {
	    this.grille = newGrille;
	  }
	  
	  public void deplacerH(Navire navire) {
		  String tmp;
		  int i = navire.getPositionY();
		  int j = navire.getPositionX();
		  for(int b=0;b<3;b++) {
			  if(grille[i+b][j] == "D") {
				  if(i-1 >= 0) {
					  tmp = grille[i+b][j];
					  grille[i+b][j] = ".";
					  grille[i+b-1][j] = tmp;
			  }
		  }
		  }
	  }
	  public void deplacerB(Navire navire) {
		  String tmp;
		  int i = navire.getPositionY();
		  int j = navire.getPositionX();
			  if(grille[i][j] == "D") {
				  if(i+1 < 15) {
					  tmp = grille[i][j];
					  grille[i][j] = ".";
					  grille[i][j]=grille[i++][j];
					  System.out.println(i);
					  while( grille[i][j] != ".") {
						  grille[i][j]=grille[i++][j];
					  }
					  grille[i++][j] = tmp;
			  }
		  }
		  
	  }
	  public void deplacerG(Navire navire) {
		  String tmp;
		  int i = navire.getPositionY();
		  int j = navire.getPositionX();
		  for(int b=0;b<3;b++) {
			  if(grille[i][j+b] == ".") {
				  if(j-1 >= 0) {
					  tmp = grille[i][j+b];
					  grille[i][j+b] = ".";
					  grille[i][j+b-1] = tmp;
			  }
		  }
		  }
	  }
	  public void deplacerD(Navire navire) {
		  String tmp;
		  int i = navire.getPositionY();
		  int j = navire.getPositionX();
		  if(grille[i][j] == "D") {
			  if(j+1 < 15) {
				  tmp = grille[i][j];
				  grille[i][j] = ".";
				  grille[i][j]=grille[i][j++];
				  System.out.println(i);
				  while( grille[i][j] != ".") {
					  grille[i][j]=grille[i][j++];
				  }
				  grille[i][j++] = tmp;
		  }
	  }
	  }

	  public void anciennePos(Navire navire, String test, char val) {
		  int i = navire.getPositionY();
		  int j = navire.getPositionX();
		  if(grille[i][j] == test) {
			  if(val == 'H') {
				  for(int b=0;b<3;b++) {
					  grille[i+b][j] = ".";
				  }
			  }
			  if(val == 'B') {
				  for(int b=0;b<3;b++) {
					  grille[i+b][j] = ".";
				  }
			  }
			  if(val == 'G') {
				  for(int b=0;b<3;b++) {
					  grille[i][j+b] = ".";
				  }
			  }
			  if(val == 'D') {
				  for(int b=0;b<3;b++) {
					  grille[i][j+b] = ".";
				  }
			  }
	  }
}
	  public void nouvellePos(Navire navire, String test, char val) {
		  int i = navire.getPositionY();
		  int j = navire.getPositionX();
		  if(val == 'H') {
			  i = i-1;
			  if(grille[i][j] == ".") {
				  System.out.println("t");
				  for(int b=0;b<3;b++) {
					  System.out.println("gg");
					  grille[i+b][j] = test;
				  }
			  }
		  }
		  if(val == 'B') {
			  i = i+1;
			  if(grille[i][j] == ".") {
				  for(int b=0;b<3;b++) {
					  grille[i+b][j] = test;
				  }
		  }
		  }
		  if(val == 'G') {
			  j = i-1;
			  if(grille[i][j] == ".") {
				  for(int b=0;b<3;b++) {
					  grille[i][j-b] = test;
				  }
		  }
		  }
		  if(val == 'D') {
			  j = j+1;
			  if(grille[i][j] == ".") {
				  for(int b=0;b<3;b++) {
					  grille[i][j+b] = test;
				  }
		  }
		  }
		  
}
	  public boolean testerPos(Navire navire, int sens, char val, int cases) {
		  int i = navire.getPositionY();
		  int j = navire.getPositionX();
		  if(sens == 0) {
			  if(val == 'H') {
			  	if(grille[i-1][j] == "." && i-1 >= 0 ) {
			  		return true;
			  	}
			  }
			  if(val == 'B') {
				  	if(grille[i+cases][j] == "." && i+cases < ligne) {
				  		return true;
				  	}
				  }
		  }
		  if(sens == 1) {
			  if(val == 'G') {
				  	if(grille[i][j-1] == "." && j-1 >= 0) {
				  		return true;
				  	}
				  }
			  if(val == 'D') {
				  	if(grille[i][j+cases] == "." && j+cases < col) {
				  		System.out.println(j);
				  		return true;
				  	}
				  }
		  }
		  return false;
	  }
}
