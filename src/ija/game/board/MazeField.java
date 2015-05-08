
package ija.game.board;

import java.io.Serializable;

/**
 *
 * @author Jan
 */
public class MazeField implements Serializable{
    
    private final int row;
    private final int col;
    private MazeCard mc;
    
    
 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.row;
        hash = 73 * hash + this.col;
        return hash;
    }

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
    
    public MazeField(int row, int col){
        
        this.row = row;
        this.col = col;
        this.mc = null;
    
    }
    
    public int row(){
        return this.row; 
    }
    
    public int col(){
        return this.col; 
    }
    
    public MazeCard getCard(){
        
        return this.mc;
    }
    
    public void putCard(MazeCard c){
        this.mc = c;
    }
    
}
