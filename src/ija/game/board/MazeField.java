
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
