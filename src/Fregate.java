
public class Fregate extends Navire {

	public Fregate() {
		super();
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 10);
		int p = (int) (Math.random() * 2);
		boolean gg = false;

		if (p == 0) {
			while (gg == false) {
				gg = testA(5, l, c, 'F',grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}
		if (p == 1) {
			while (gg == false) {
				gg = testB(5, l, c, 'F',grille);
				l = (int) (Math.random() * 15);
				c = (int) (Math.random() * 12);
			}
		}
	}
	@Override
	public boolean tirer(int x, int y, Grille grille) {
		if(grille.getCase(x,y)=='.') {
			grille.changeCase(x,y,'o');}
		if(grille.getCase(x,y-1)=='.') {
			grille.changeCase(x,y-1,'o' );}
		if(grille.getCase(x-1,y)=='.') {
			grille.changeCase(x-1,y,'o' );}
		if(grille.getCase(x+1,y)=='.') {
			grille.changeCase(x+1,y,'o' );}
		if(grille.getCase(x,y+1)=='.') {
			grille.changeCase(x,y+1,'o' );}
		
		if (grille.getCase(x,y)=='C'||grille.getCase(x,y)=='F'||grille.getCase(x,y)=='D')	{
			grille.changeCase(x,y,'X');}
		if(grille.getCase(x,y-1)=='C'||grille.getCase(x,y-1)=='F'||grille.getCase(x,y-1)=='D') {
			grille.changeCase(x,y-1,'X' );}
		if(grille.getCase(x-1,y)=='C'||grille.getCase(x-1,y)=='F'||grille.getCase(x-1,y)=='D') {
			grille.changeCase(x-1,y,'X' );}
		if(grille.getCase(x+1,y)=='C'||grille.getCase(x+1,y)=='F'||grille.getCase(x+1,y)=='D') {
			grille.changeCase(x+1,y,'X' );}
		if(grille.getCase(x,y+1)=='C'||grille.getCase(x,y+1)=='F'||grille.getCase(x,y+1)=='D') {
			grille.changeCase(x,y+1,'X' );}
		
		if (grille.getCase(x,y)=='S') {
			grille.changeCase(x,y,'?');}
		if(grille.getCase(x,y-1)=='C') {
			grille.changeCase(x,y-1,'?' );}
		if(grille.getCase(x-1,y)=='S') {
			grille.changeCase(x-1,y,'?' );}
		if(grille.getCase(x+1,y)=='S') {
			grille.changeCase(x+1,y,'?' );}
		if(grille.getCase(x,y+1)=='S') {
			grille.changeCase(x,y+1,'?' );}
		
		
		if(grille.getCase(x, y)=='x') {
			return false; 
		}
		return true;
	}
}
