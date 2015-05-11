
package ija.game.board;

import java.io.Serializable;

/**
 * Implemetuje policko na hraci desce a operace nad nim
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
public class MazeField implements Serializable{
    
    private final int row;
    private final int col;
    private MazeCard mC;
    
    /**
     * Hash code se spocita na zaklada pozice policka 
     * 
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.row;
        hash = 73 * hash + this.col;
        return hash;
    }
    /**
     * Policko se porovnava na zaklade pozice
     * 
     * @param obj
     * @return True, pokud se rovnaji, jinak false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MazeField other = (MazeField) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.col == other.col;
    }
    
    /**
     * Vytvori policko o zadanem radku a sloupci
     * 
     * @param row Radek
     * @param col Sloupec
     */
    public MazeField(int row, int col){
        
        this.row = row;
        this.col = col;
        this.mC = null;
    
    }
    
    /**
     * Vrati radek pole
     * 
     * @return Radek pole
     */
    public int getRow(){
        return this.row; 
    }
    /**
     * Vrati sloupec pole
     * 
     * @return Sloupec pole 
     */
    public int getCol(){
        return this.col; 
    }
    /**
     * Vrati kamen na danem poli
     * 
     * @return Kamen
     */
    public MazeCard getCard(){
        
        return this.mC;
    }
    
    /**
     * Nastavi kamen na dane pole 
     * 
     * @param c Kamen
     */
    public void putCard(MazeCard c){
        this.mC = c;
    }
    
}
