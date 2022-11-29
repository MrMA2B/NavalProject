import java.util.*;
public class Test {
	
	private int ligne;
	private int col;
	private char [][] grille;
	
	public Test(int n, int p){
		ligne = n;
		col = p;
		grille = new char[ligne][col];
		
		for(int i=0; i<ligne; i++) {
			for(int j=0; j<col; j++) {
				grille[i][j] = '.';
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
	
public void sousmarin() {
		
		int l = (int)(Math.random() * 15);
		int c = (int)(Math.random() * 15);
		
			if(grille[l][c] == '.') {
				grille[l][c] = 'S';
			}
	}
	
	public void destroyer() {
		int l = (int)(Math.random() * 15);
		int c = (int)(Math.random() * 12);
        int p = (int)(Math.random() * 2);
        boolean placee = false;
        
        if(p==0) {
        	while(placee == false) {
        		placee = testA(3,l,c,'D');
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
        	}
        }
        
		if(p==1) {
			while(placee == false) {
        		placee = testB(3,l,c,'D');
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
			}
		}
	}
	
public void croiseur() {
		
		int l = (int)(Math.random() * 15);
		int c = (int)(Math.random() * 10);
		int p = (int)(Math.random() * 2);
		boolean gg = false;

		if(p==0) {
			while(gg == false) {
        		gg = testA(5,l,c,'F');
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
			}
		}
		if(p==1) {
			while(gg == false) {
        		gg = testB(5,l,c,'F');
        		l = (int)(Math.random() * 15);
        		c = (int)(Math.random() * 12);
			}
		}
	}
	public void cuirasse() {
	
		
	int l = (int)(Math.random() * 15);
	int c = (int)(Math.random() * 8);
	int p = (int)(Math.random() * 2);
	boolean gg = false;
	
	
	if(p==0) {
		while(gg == false) {
    		gg = testA(7,l,c,'C');
    		l = (int)(Math.random() * 15);
    		c = (int)(Math.random() * 8);
		}
	
	}
	if(p==1) {
		while(gg == false) {
    		gg = testB(7,l,c,'C');
    		l = (int)(Math.random() * 15);
    		c = (int)(Math.random() * 8);
		}
	}
}
	
	public char getCase(int l, int c) {
		return grille[l][c];
	}
	
	public boolean testA(int val, int t1, int t2, char ch) {
		int l = t2;
        int c = t1;
		int test = 0;
    		
			for(int b=0;b<val;b++) {
			if(grille[l+b][c] == '.') {
				test=test+1;
				}
			}
			if(test==val) {
				for(int b=0;b<val;b++) {
		        	
					grille[l+b][c] = ch;
		        	}
				return true;
			}
			else {
				return false;
			}
		
	}

	public boolean testB(int val, int t1, int t2, char ch) {
		int l = t1;
        int c = t2;
		int test = 0;
    		
			for(int b=0;b<val;b++) {
			if(grille[l][c+b] == '.') {
				test=test+1;
				}
			}
			if(test==val) {
				for(int b=0;b<val;b++) {
		        	
					grille[l][c+b] = ch;
		        	}
			}
			else {
				return false;
			}
			return true;
	}
	

	
}