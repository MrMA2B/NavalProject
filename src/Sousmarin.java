
public class Sousmarin extends Navire {
		
	public Sousmarin() {
		super();
	}

	public void placer(Grille grille) {
		int l = (int) (Math.random() * 15);
		int c = (int) (Math.random() * 15);
		if (grille.getCase(l, c) == '.') {
			grille.changeCase(l, c, 'S');
		}
	}
	@Override 
	public boolean tirer(int x,int y, Grille grille) {
	if(grille.getCase(x,y)=='.') {
		grille.changeCase(x,y,'o');
	}
			
	if (grille.getCase(x,y)=='S') {
		grille.changeCase(x,y,'X');
	}
	if (grille.getCase(x,y)=='C'||grille.getCase(x,y)=='F'||grille.getCase(x,y)=='D') {
		grille.changeCase(x,y,'*');
		System.out.println("Vous ne pouvez pas toucher ces bateaux avec vos sous-marin");
	}
		
		
	
		
	if(grille.getCase(x, y)=='x') {
		return false;
	}
	return true;}
	
}

