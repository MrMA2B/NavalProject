public class Destroyers extends Navire {

    public Destroyers() {
        super();
        pv = 3;
    }

    public void placer(Grille grille) {
        int l = (int)(Math.random() * 15);
        int c = (int)(Math.random() * 12);
        int p = (int)(Math.random() * 2);
        boolean placee = false;
        
        if(p==0) {
            while(placee == false) {
                placee = testA(3,l,c,"D1",grille);//Modifier 3 par lenght du bateau 
                l = (int)(Math.random() * 15);
                c = (int)(Math.random() * 12);
            }
        }
        
        if(p==1) {
            while(placee == false) {
                placee = testB(3,l,c,"D1",grille);
                l = (int)(Math.random() * 15);
                c = (int)(Math.random() * 12);
            }
        }
    }
    @Override
    public boolean tirer (int x, int y, Grille grille) {
        if(grille.getCase(x,y)==". ") {
            grille.changeCase(x,y,"O");}
            
    if (grille.getCase(x,y)=="C1"||grille.getCase(x,y)=="F1"||grille.getCase(x,y)=="D1")    {
        grille.changeCase(x,y,"X ");}
    
    if (grille.getCase(x,y)=="S1")    {
        grille.changeCase(x,y,"? ");
        }
        
    if(grille.getCase(x, y)=="X ") {
        return false;
    }
    return true;
    }
}