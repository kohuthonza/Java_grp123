
package ija.game.board;


import ija.game.treasure.Treasure;
import java.io.Serializable;


/**
 * 
 * Implementuje kamen a operace nad nim
 * 
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
public class MazeCard implements Serializable{
    
    private CANGO direction1;
    private CANGO direction2;
    private CANGO direction3;
    private String type;
    private Treasure treasure;
    
    /**
     *Seznam smeru
     */
    public static enum CANGO{
       LEFT, UP, RIGHT, DOWN; 
    }
    
    /**
     * Vrati typ kamene
     * 
     * @return Typ kamene
     */
    
    public String getType(){
        return this.type;
    }
    
    /**
     * Vytvori typ kamene
     * 
     * @param type Typ kamene
     */
    private MazeCard(String type){
       
        this.type = type;
        this.treasure = null;
        
        switch (type){
         
            case "C":
                this.direction1 = CANGO.LEFT;
                this.direction2 = CANGO.UP;
                break;
                
            case "L":
                this.direction1 = CANGO.LEFT;
                this.direction2 = CANGO.RIGHT;
                break;
            
            case "F":
                this.direction1 = CANGO.LEFT;
                this.direction2 = CANGO.UP;
                this.direction3 = CANGO.RIGHT;
                break;
                
            default:
                throw new IllegalArgumentException(type);
            }   
    }
    /**
     * Vytvori kamen
     * 
     * @param type Typ kamene
     * @return Kamen
     */
    
    public static MazeCard create(String type){ 
        return new MazeCard(type);
    } 
    
    /**
     * Kontroluje, zda jde jit danym smerem z kamene
     * 
     * @param dir Smer, kterym chceme jit
     * @return True pokud jde jit zadanym smerem, jinak false
     */
    public boolean canGo(MazeCard.CANGO dir){
        
        if (dir.equals(this.direction1)||
            dir.equals(this.direction2))
            return true;
        
        if ("F".equals(this.type)){
            if (dir.equals(this.direction3))
                return true;    
        }
        return false;
    }
    /**
     * Otoci dany smer o devadesat stupnu doprava
     * 
     * @param dir Smer
     * @return 
     */
    private MazeCard.CANGO turnDirection(MazeCard.CANGO dir){
        
        switch (dir){
                    
                case LEFT:
                    dir = CANGO.UP;
                    break;
                  
                case RIGHT:
                    dir = CANGO.DOWN;
                    break;
                   
                case UP:
                    dir = CANGO.RIGHT;
                    break;
                    
                case DOWN:
                    dir = CANGO.LEFT;
                    break;
                    
                default:
                    break;
                        
                }
        
        return dir;
        
    }
    
    /**
     * Otoci kamen doprava o devadesat stupnu
     */
    public void turnRight(){
        
       this.direction1 = turnDirection(this.direction1);
       this.direction2 = turnDirection(this.direction2);
       
       if ("F".equals(this.type))
         this.direction3 = turnDirection(this.direction3);    
       
    }
    /**
     * Vraci rotaci kamene
     * 
     * @return Rotace kamene sda
     * 
     */
    public int getRotation(){
        
        switch(this.direction1){
            case UP:
                return 90;
            case RIGHT:
                return 180;
            case DOWN:
                return 270;
            default:
                return 0;
                }
    }
    
    /**
     * Provede nastaveni, prilepeni pokladu ke kamenu
     * 
     * @param treasure Poklad
     */
    public void setTreasure(Treasure treasure){
        this.treasure = treasure;
    }
    /**
     * Vrati poklad na danem kamenu, pokud zadny polad na kamenu neni vraci null
     * 
     * @return Poklad
     */
    public Treasure getTreasure(){
        return this.treasure;
    }
}
