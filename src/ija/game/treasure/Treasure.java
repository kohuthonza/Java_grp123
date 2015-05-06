

package ija.game.treasure;


/**
 * 13. 3. 2015
 * xkohut08 
 * @author Jan Kohut
 */
public class Treasure {
    
    private static final int  n_treasure = 24;
    private static Treasure[] treasure;
    
    int code;
    
    /**
     * Konstruktor, nastavi hodnotu daneho pokladu
     * @param code 
     */
    private Treasure (int code){
        this.code = code;
    }
    
    
   
    @Override
    public int hashCode(){
        return this.code;
    }
    
    
    /**
     * Pokud je objekt srovnavanym objektem objek typu Treasure, srovnaji 
     * se jejich hodnoty
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Treasure) {
            Treasure tr = (Treasure)obj;
            return (tr.code == this.code);
        } 
        else
            return false;
    }
    
    /**
     * Vytvori pole objektu
     */
    public static void createSet (){
        Treasure.treasure = new Treasure[Treasure.n_treasure];
        for (int i = 0; i < treasure.length; i++){
            Treasure.treasure[i] = new Treasure(i);
        }
    }
    
    
    public int get_type(){
        return this.code;
    }
    
    /**
     * Vrati null pokud pristupujeme mimo rozsah, nebo jsme jeste nevytvorili 
     * poklady
     * @param code
     * @return 
     */
    
    public static Treasure getTreasure (int code){
       
        if (code > 23 || code < 0 || Treasure.treasure == null)
            return null;
        else
            return Treasure.treasure[code];
    }
    
}
