
package ija.game.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.Serializable;

/**
 * Implementuje hraci desku a operace nad ni
 * 
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
@SuppressWarnings("serial")
public class MazeBoard implements Serializable {
    
    //List policek
    private final ArrayList<MazeField> board;
    //Velikost herni desky
    private final int size;
    //Volny kamen
    private MazeCard freeCard;
    //List typu kamenu
    private static final ArrayList<String> typeCard = new ArrayList<String>(Arrays.asList("C", "L", "F"));
    private static MazeField tmpMf;
    private static int index, i, j;
    
    //Uchovani predchoziho kamene, ktery slouzil pro posun
    private MazeField previousField;
    //Indikator posunu hraci desky
    private boolean isShift;
   
    
    private MazeBoard(int n){
        
        this.size = n;
        this.freeCard = null;
        this.previousField = null;
        this.board = new ArrayList<MazeField>();
        this.isShift = false;
        //Vytvorime hraci desku
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
    public int getSize(){
        return this.size;
    }
    
    /**
     * Vlozi kameny na hraci desku a vytvori jeden volny kamen. Zajisti spravnou
     * inicializaci (natoceni) kamenu. 
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
                
                tmpMf = this.board.get(getIndex(i, j));
                
                if (i == 1 && j == 1){
                    tmpMf.putCard(MazeCard.create("C"));
                    tmpMf.getCard().turnRight();
                    tmpMf.getCard().turnRight();
                    continue;
                }
                
                if (i == 1 && j == this.size){
                    tmpMf.putCard(MazeCard.create("C"));
                    tmpMf.getCard().turnRight();
                    tmpMf.getCard().turnRight();
                    tmpMf.getCard().turnRight();
                    continue;
                }
                    
                if (i == this.size && j == 1){
                    tmpMf.putCard(MazeCard.create("C"));
                    tmpMf.getCard().turnRight();
                    continue;
                }
                
                if (i == this.size && j == this.size){
                    tmpMf.putCard(MazeCard.create("C"));
                    continue;
                }
                
                if ((i % 2) == 1 && (j % 2) == 1){
                    if (i == 1){
                        tmpMf.putCard(MazeCard.create("F"));
                        tmpMf.getCard().turnRight();
                        tmpMf.getCard().turnRight();
                        continue;
                    }
                    if (i == this.size){
                        tmpMf.putCard(MazeCard.create("F"));
                        continue;
                    }
                    if (j == 1){
                        tmpMf.putCard(MazeCard.create("F"));
                        tmpMf.getCard().turnRight();
                        continue;
                    }
                    if (j == this.size){
                        tmpMf.putCard(MazeCard.create("F"));
                        tmpMf.getCard().turnRight();
                        tmpMf.getCard().turnRight();
                        tmpMf.getCard().turnRight();
                        continue;
                    }
                    tmpMf.putCard(MazeCard.create("F"));
                    continue;      
                }
                
        
                index = new Random().nextInt(typeCard.size());
                tmpMf.putCard(MazeCard.create(typeCard.get(index)));
                        
                for (int x = 0; x <= new Random().nextInt(2); ++x){
                    tmpMf.getCard().turnRight();
                } 
            }
        }
        index = new Random().nextInt(typeCard.size());
        this.freeCard = MazeCard.create(typeCard.get(index));
                        
        for (i = 0; i <= new Random().nextInt(2); i++){
            this.freeCard.turnRight();
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
    public MazeField getMazeField(int r, int c){
        
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
        return this.freeCard;
    }
    /**
     * Vraci index do pole na zaklade dvou souradnic (prevod matice na pole)
     * @param i Radek
     * @param j Sloupec
     * @return Index
     */
    private int getIndex(int i, int j){
        return (i - 1)*this.size + j - 1;
    }
    
    /**
     * Nastavi, zda je deska posunuta, nebo ne
     * 
     * @param isShift True deska byla posunuta, false nebyla
     */
    public void setIsShift(boolean isShift){
        this.isShift = isShift;
    }  
    /**
     * Vraci stav posunuti desky
     * 
     * @return True deska je posunuta, jinak deska neni posunuta 
     */
    public boolean getIsShift(){
        return this.isShift;
    }
     
    /**
     * Vlozi volny kamen na zadanou pozici (vklada se pouze z kraje na sude sloupce, 
     * radky), ostatni kameny posune prislusnym smerem. Kamen ktery vypadne z
     * desky se stava volnym kamenem.
     * 
     * @param mf Pole, na ktere se ma vlozit volny kamen.
     */
     
    public void shift(MazeField mf){
        
        if(!mf.equals(this.previousField) && !this.isShift){
            
            
        
            MazeCard tmpFreeCard = this.freeCard;
            int x, y;
        
            i = mf.getRow();
            j = mf.getCol();
        
            if ((j % 2) == 0){
                if (i == 1){
                    this.freeCard = this.board.get(getIndex(this.size, j)).getCard();
                    for(y = this.size; y >= 2; --y){  
                        this.board.get(getIndex(y, j)).putCard(this.board.get(getIndex(y - 1, j)).getCard());
                    }
                    this.board.get(j - 1).putCard(tmpFreeCard);
                    this.isShift = true;
                    this.previousField = new MazeField(this.size,mf.getCol());
                    return;  
                }
                if (i == this.size){
                    this.freeCard = this.board.get(j - 1).getCard();
                    for(y = 1; y <= this.size - 1; ++y){
                        this.board.get(getIndex(y, j)).putCard(this.board.get(getIndex(y + 1, j)).getCard());
                    }
                    this.board.get(getIndex(i, j)).putCard(tmpFreeCard);
                    this.isShift = true;
                    this.previousField = new MazeField(1,mf.getCol());
                    return;
                } 
            }
            if ((i % 2) == 0){
                if (j == 1){
                    this.freeCard = this.board.get(getIndex(i, this.size)).getCard();
                    for(x = this.size; x >= 2; --x){  
                        this.board.get(getIndex(i, x)).putCard(this.board.get(getIndex(i, x - 1)).getCard());
                    }
                    this.board.get(getIndex(i, j)).putCard(tmpFreeCard);
                    this.isShift = true;
                    this.previousField = new MazeField(mf.getRow(),this.size);
                    return;  
                }
                if (j == this.size){
                    this.freeCard = this.board.get(getIndex(i, 1)).getCard();
                    for(x = 1; x <= this.size - 1; ++x){
                        this.board.get(getIndex(i, x)).putCard(this.board.get(getIndex(i, x + 1)).getCard());
                    }
                    this.board.get(getIndex(i, j)).putCard(tmpFreeCard);
                    this.isShift = true;
                    this.previousField = new MazeField(mf.getRow(), 1);
                } 
            }
        }
    }
}
