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
				grille[l][c] = '0';
			}
	}
	
	public void destroyer() {
		
        int p = (int)(Math.random() * 2);
        
        if(p==0) {
        	testA(3,14,11,'1');
        }
		if(p==1) {
			testB(3,14,11,'1');
			
		}
	}
	
public void croiseur() {
		

		int p = (int)(Math.random() * 2);

		if(p==0) {
			testA(5,14,9,'2');
		}
		if(p==1) {
			testB(5,14,9,'2');
		}
	}
	public void cuirasse() {
	

	int p = (int)(Math.random() * 2);
	
	
	if(p==0) {
		testA(7,14,7,'3');
	}
	if(p==1) {
		testB(7,14,7,'3');
	}
}
	
	public char getCase(int l, int c) {
		return grille[l][c];
	}
	
	public void testA(int val, int t1, int t2, char ch) {
		int l = t2;
        int c = t1;
		int test = 0;
    	
		while(true) {
			
				if(grille[l+1][c] == '.') {
					test=test+1;
					System.out.println(test);
				}
				else {
					l = (int)(Math.random() * t2);
			        c = (int)(Math.random() * t1);
				}
				if(test==val) {
					break;
				}
		}
    	for(int b=0;b<val;b++) {
        	
			grille[l+b][c] = ch;
        	}
	}
	public void testB(int val, int t1, int t2, char ch) {
		int l = t1;
        int c = t2;
		int test = 0;
    	
		while(true) {
			
				if(grille[l][c+1] == '.') {
					test = test+1;
					System.out.println(test);
				}
				else {
					l = (int)(Math.random() * t1); 
			        c = (int)(Math.random() * t2);
				}
				if(test==val) {
					break;
				}
		}
    	for(int b=0;b<val;b++) {
        	
			grille[l][c+b] = ch;
        	}
	}
	

	
}