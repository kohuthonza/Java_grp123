

package ija.game.treasure;

import java.io.Serializable;

/**
 * Implementuje kartu a operace nad ni
 * 
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
@SuppressWarnings("serial")
public class TreasureCard implements Serializable{
    
    private final Treasure tr;
    
    /**
     * Hash code je hodnota pokladu na karte
     * 
     * @return Hash code
     */
    @Override
    public int hashCode(){
        return tr.code;
    }
 
    /**
     * Karty se srovnavaji na zaklade hodnoty pokladu na karte
     * 
     * @param obj Objekt
     * @return True, pokud jsou shodne, jinak false
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof TreasureCard) {
            TreasureCard temp = (TreasureCard)obj;
            return (temp.tr.code == tr.code);
        } 
        else
            return false;
    }
    /**
     * Vytvori kartu reprezentujici dany poklad
     * 
     * @param tr Poklad
     */
    public TreasureCard (Treasure tr){
       this.tr = tr; 
    }
    
    /**
     * Vrati poklad na karte
     * 
     * @return Poklad
     */
    public Treasure getTreasure(){
        return this.tr;
    }
    
}
