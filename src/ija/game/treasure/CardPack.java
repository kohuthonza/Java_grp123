

package ija.game.treasure;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;
import java.util.Collections;

/**
 * Implementuje balicek karet a operace nad nim
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
public class CardPack implements Serializable{
    
    private final int size;
    private final ArrayList<TreasureCard> pack;
    private static TreasureCard storeCard;
    
    /**
     * Vytvori balicek karet o zadanem poctu
     * 
     * @param size pocet karet
     */
    public CardPack (int size){
        
        this.size = size;
        
        this.pack = new ArrayList<TreasureCard>();
        for (int i = 0; i < this.size; i++){
            this.pack.add(new TreasureCard(Treasure.getTreasure(i)));
        }   
    }
    /**
     * Vytahne kartu z balicku 
     * 
     * @return Karta
     */
    public TreasureCard popCard (){
        CardPack.storeCard = this.pack.get(0);
        this.pack.remove(0);
        return CardPack.storeCard;
    }
    
    /**
     * Vrati nahodnou kartu z balicku
     * 
     * @return Karta
     */
    public TreasureCard randomCard(){
        
        Random ran = new Random();
        
        return this.pack.get(ran.nextInt(this.pack.size()));
        
    }
    /**
     * Vrati velikost balicku
     * 
     * @return Velikost balicku
     */
    public int size (){
        return this.pack.size();
    }
    
    
    /**
     * Provede zamichani balicku
     */
    public void shuffle (){
        
        Collections.shuffle(this.pack); 
    
    }
}
