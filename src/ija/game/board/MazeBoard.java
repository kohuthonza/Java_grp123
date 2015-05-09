
package ija.game.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.Serializable;

/**
 *Trida, jejiz instanci je hraci deska.
 * 
 * 
 * @author Jan
 */
public class MazeBoard implements Serializable {
    
    private final ArrayList<MazeField> board;
    private final int size;
    private MazeCard free_card;
    private static final ArrayList<String> type_card = new ArrayList<String>(Arrays.asList("C", "L", "F"));
    private static MazeField tmp_mf;
    private static int index, i, j;
    private MazeField previous_field;
    private boolean is_shift;
   
    
    private MazeBoard(int n){
        
        this.size = n;
        this.free_card = null;
        this.previous_field = null;
        this.board = new ArrayList<MazeField>();
        this.is_shift = false;
        for (i = 1; i <= n; i++){
            for(j = 1; j <= n; j++){
                this.board.add(new MazeField(i, j)); 
            }
        }
    }
    
    /**
     * Vytvori hraci desku o zadanem rozmeru.
     * 
     * @param n Rozmer hraci desky.
     * @return Hraci deska.
     */
    public static MazeBoard createMazeBoard(int n){
        
        return new MazeBoard(n);
        }
    
    /**
     * 
     * Vraci velikost hraci desky.
     * 
     * @return Velikost hraci desky.
     */
    public int get_size(){
        return this.size;
    }
    
    /**
     * Vlozi kameny na hraci desku a vytvori jeden volny kamen.
     * 
     */
    public void newGame(){
         
        this.board.get(0).putCard(MazeCard.create("C"));
        this.board.get(0).getCard().turnRight();
        this.board.get(0).getCard().turnRight();
        
        this.board.get(this.size - 1).putCard(MazeCard.create("C"));
        this.board.get(this.size - 1).getCard().turnRight();
        this.board.get(this.size - 1).getCard().turnRight();
        this.board.get(this.size - 1).getCard().turnRight();
        
        this.board.get((this.size - 1)*this.size).putCard(MazeCard.create("C"));
        this.board.get((this.size - 1)*this.size).getCard().turnRight();
        
        this.board.get(this.size*this.size - 1).putCard(MazeCard.create("C"));
        
        
        for (i = 1; i <= this.size; i++){
            for(j = 1; j <= this.size; j++){
                
                tmp_mf = this.board.get(get_index(i, j));
                
                if (i == 1 && j == 1){
                    tmp_mf.putCard(MazeCard.create("C"));
                    tmp_mf.getCard().turnRight();
                    tmp_mf.getCard().turnRight();
                    continue;
                }
                
                if (i == 1 && j == this.size){
                    tmp_mf.putCard(MazeCard.create("C"));
                    tmp_mf.getCard().turnRight();
                    tmp_mf.getCard().turnRight();
                    tmp_mf.getCard().turnRight();
                    continue;
                }
                    
                if (i == this.size && j == 1){
                    tmp_mf.putCard(MazeCard.create("C"));
                    tmp_mf.getCard().turnRight();
                    continue;
                }
                
                if (i == this.size && j == this.size){
                    tmp_mf.putCard(MazeCard.create("C"));
                    continue;
                }
                
                if ((i % 2) == 1 && (j % 2) == 1){
                    if (i == 1){
                        tmp_mf.putCard(MazeCard.create("F"));
                        tmp_mf.getCard().turnRight();
                        tmp_mf.getCard().turnRight();
                        continue;
                    }
                    if (i == this.size){
                        tmp_mf.putCard(MazeCard.create("F"));
                        continue;
                    }
                    if (j == 1){
                        tmp_mf.putCard(MazeCard.create("F"));
                        tmp_mf.getCard().turnRight();
                        continue;
                    }
                    if (j == this.size){
                        tmp_mf.putCard(MazeCard.create("F"));
                        tmp_mf.getCard().turnRight();
                        tmp_mf.getCard().turnRight();
                        tmp_mf.getCard().turnRight();
                        continue;
                    }
                    tmp_mf.putCard(MazeCard.create("F"));
                    continue;      
                }
                
        
                index = new Random().nextInt(type_card.size());
                tmp_mf.putCard(MazeCard.create(type_card.get(index)));
                        
                for (int x = 0; x <= new Random().nextInt(2); ++x){
                    tmp_mf.getCard().turnRight();
                } 
            }
        }
        index = new Random().nextInt(type_card.size());
        this.free_card = MazeCard.create(type_card.get(index));
                        
        for (i = 0; i <= new Random().nextInt(2); i++){
            this.free_card.turnRight();
        }
    }
    
    /**
     * 
     * Vraci pole hraci desky.
     * 
     * @param r Radek.
     * @param c Sloupec.
     * @return Pole hraci desky.
     */
    public MazeField get(int r, int c){
        
        if (r > this.size || c > this.size)
             return null;       
        return this.board.get((r - 1)*this.size + c - 1);
    }
    
    /**
     * Vraci volny kamen.
     * 
     * @return Volny kamen. 
     */
    
    public MazeCard getFreeCard(){
        return this.free_card;
    }
    
    private int get_index(int i, int j){
        return (i - 1)*this.size + j - 1;
    }
    
    
     public MazeField get_previous_field(){
        return this.previous_field;
    }
    
    public void set_is_shift(boolean is_shift){
        this.is_shift = is_shift;
    }  
    
    public boolean get_is_shift(){
        return this.is_shift;
    }
     
    /**
     * Vlozi volny kamen na zadanou pozici (vklada se pouze z kraje na sude sloupce, 
     * radky), ostatni kameny posune prislusnym smerem. Kamen ktery vypadne z
     * desky se stava volnym kamenem.
     * 
     * @param mf Pole, na ktere se ma vlozit volny kamen.
     */
     
    public void shift(MazeField mf){
        
        if(!mf.equals(this.previous_field) && !this.is_shift){
            
            
        
            MazeCard tmp_free_card = this.free_card;
            int x, y;
        
            i = mf.row();
            j = mf.col();
        
            if ((j % 2) == 0){
                if (i == 1){
                    this.free_card = this.board.get(get_index(this.size, j)).getCard();
                    for(y = this.size; y >= 2; --y){  
                        this.board.get(get_index(y, j)).putCard(this.board.get(get_index(y - 1, j)).getCard());
                    }
                    this.board.get(j - 1).putCard(tmp_free_card);
                    this.is_shift = true;
                    this.previous_field = mf;
                    return;  
                }
                if (i == this.size){
                    this.free_card = this.board.get(j - 1).getCard();
                    for(y = 1; y <= this.size - 1; ++y){
                        this.board.get(get_index(y, j)).putCard(this.board.get(get_index(y + 1, j)).getCard());
                    }
                    this.board.get(get_index(i, j)).putCard(tmp_free_card);
                    this.is_shift = true;
                    this.previous_field = mf;
                    return;
                } 
            }
            if ((i % 2) == 0){
                if (j == 1){
                    this.free_card = this.board.get(get_index(i, this.size)).getCard();
                    for(x = this.size; x >= 2; --x){  
                        this.board.get(get_index(i, x)).putCard(this.board.get(get_index(i, x - 1)).getCard());
                    }
                    this.board.get(get_index(i, j)).putCard(tmp_free_card);
                    this.is_shift = true;
                    this.previous_field = mf;
                    return;  
                }
                if (j == this.size){
                    this.free_card = this.board.get(get_index(i, 1)).getCard();
                    for(x = 1; x <= this.size - 1; ++x){
                        this.board.get(get_index(i, x)).putCard(this.board.get(get_index(i, x + 1)).getCard());
                    }
                    this.board.get(get_index(i, j)).putCard(tmp_free_card);
                    this.is_shift = true;
                    this.previous_field = mf;
                } 
            }
        }
    }
}
