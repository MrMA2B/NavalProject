public class Sousmarin extends Navire {
        
    public Sousmarin() {
        super();
    }

    public void placer(Grille grille) {
        int l = (int) (Math.random() * 15);
        int c = (int) (Math.random() * 15);
        if (grille.getCase(l, c) == ". ") {
            grille.changeCase(l, c, "S1");
        }
    }
    @Override 
    public boolean tirer(int x,int y, Grille grille) {
    if(grille.getCase(x,y)==". ") {
        grille.changeCase(x,y,"O ");
    }
            
    if (grille.getCase(x,y)=="S1") {
        grille.changeCase(x,y,"X ");
    }
    if (grille.getCase(x,y)=="C1"||grille.getCase(x,y)=="F1"||grille.getCase(x,y)=="D1") {
        grille.changeCase(x,y,"* ");
        System.out.println("Vous ne pouvez pas toucher ces bateaux avec vos sous-marin");
    }
        
        
    
        
    if(grille.getCase(x, y)=="X ") {
        return false;
    }
    return true;}
    
}
