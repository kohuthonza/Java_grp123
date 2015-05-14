

package ija.game.treasure;

import java.io.Serializable;

/**
 * Implementuje poklad a operace nad nim
 * 
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
public class Treasure implements Serializable{
    
    private static final int  n_treasure = 24;
    private static Treasure[] treasure;
    
    int code;
    
    /**
     * Vytvori poklad o zadane hodnote
     * @param code Hodnota
     */
    private Treasure (int code){
        this.code = code;
    }
    
    /**
     *Hash code je hodnota pokladu
     * 
     * @return Hash code
     */
    @Override
    public int hashCode(){
        return this.code;
    }
    
    
    /**
     * Pro srovnavani se pouzije hodnota pokladu
     * 
     * @param obj Objekt
     * @return True, rovnaji se, jinak false
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
     * Vytvori pole pokladu o velikosti 24
     */
    public static void createSet (){
        Treasure.treasure = new Treasure[Treasure.n_treasure];
        for (int i = 0; i < treasure.length; i++){
            Treasure.treasure[i] = new Treasure(i);
        }
    }
    
    /**
     * Funkce vrati typ pokladu
     *
     * @return typ pokladu
     */
    public int get_type(){
        return this.code;
    }
    
    /**
     * Vrati null pokud pristupujeme mimo rozsah, nebo jsme jeste nevytvorili 
     * poklady
     * 
     * @param code Hodnota pokladu
     * @return null pokud pristupujeme mimo rozsah, nebo jsme jeste nevytvorili 
     * poklady
     */
    
    public static Treasure getTreasure (int code){
       
        if (code > 23 || code < 0 || Treasure.treasure == null)
            return null;
        else
            return Treasure.treasure[code];
    }
    
}
