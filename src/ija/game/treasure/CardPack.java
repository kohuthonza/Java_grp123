

package ija.game.treasure;

import java.util.ArrayList;
import java.util.Random;

/**
 * 13. 3. 2015
 * xkohut08
 * @author Jan Kohut
 */
public class CardPack {
    
    private final int maxSize;
    private final int initSize;
    private final ArrayList<TreasureCard> pack;
    private static TreasureCard store_card;
    
    public CardPack (int maxSize, int initSize){
        
        this.maxSize = maxSize;
        this.initSize = initSize; 
        
        this.pack = new ArrayList<TreasureCard>();
        for (int i = 0; i < this.initSize; i++){
            this.pack.add(new TreasureCard(Treasure.getTreasure(i)));
        }   
    }
    
    public TreasureCard popCard (){
        CardPack.store_card = this.pack.get(0);
        this.pack.remove(0);
        return CardPack.store_card;
    }
    
    public int size (){
        return this.pack.size();
    }
    
    
    /**
     * Generuji se dve nahodna cisla podle velikosti balicku, karty na techto 
     * pozicich se prohodi, toto se provede dvacetkrat
     */
    public void shuffle (){
        
        Random ran = new Random();
        int index_1;
        int index_2;
        
        for (int i = 0; i < 20; i++){
            index_1 = ran.nextInt(this.pack.size());
            index_2 = ran.nextInt(this.pack.size());
            CardPack.store_card = this.pack.get(index_1);
            this.pack.set(index_1, this.pack.get(index_2));
            this.pack.set(index_2, CardPack.store_card);
        }
    }
}
