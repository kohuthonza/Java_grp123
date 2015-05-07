

package ija.game.treasure;

import java.io.Serializable;

/**
 * 13. 3. 2015
 * xkohut08
 * @author Jan Kohut
 */
public class TreasureCard implements Serializable{
    
    private final Treasure tr;
    
    @Override
    public int hashCode(){
        return tr.code;
    }
 
    @Override
    public boolean equals(Object obj){
        if (obj instanceof TreasureCard) {
            TreasureCard temp = (TreasureCard)obj;
            return (temp.tr.code == tr.code);
        } 
        else
            return false;
    }
    
    public TreasureCard (Treasure tr){
       this.tr = tr; 
    }
    
    public Treasure get_treasure(){
        return this.tr;
    }
    
}
