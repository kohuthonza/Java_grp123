
package ija.game;

import ija.game.board.*;
import ija.game.treasure.CardPack;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;


public class GUI {
    private static JFrame mainFrame;
    static Game game;
    
    public static GUI create(int numPlayers, int gameSize){
       
        game = new Game(numPlayers, gameSize);
        
        GUI graphicalInterface = new GUI();
        
        mainFrame = new JFrame("Labyrinth - grp123");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        return graphicalInterface;
    }
    
    public void addContent(){
        int size = game.getSizeOfGame();
        JPanel GamePanel = new JPanel(new GridLayout(size, size));
        
        MazeBoard board = game.getMazeBoard();
        
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                MazeField field = board.get(i,j);

                JLayeredPane policko = new JLayeredPane();
                
                JLabel layerCard = new JLabel();
                ImageIcon icon = null;

                switch (field.getCard().get_type()) {
                    case "C":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/C0.png"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/C90.png"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/C180.png"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/C270.png"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/C0.png"));
                                break;
                        }
                        break;
                    case "F":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/F0.png"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/F90.png"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/F180.png"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/F270.png"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/F0.png"));
                                break;
                        }
                        break;
                    case "L":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/L0.png"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/L90.png"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/L0.png"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/L90.png"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/L0.png"));
                                break;
                        }
                        break;
                }
                
                layerCard.setIcon(icon);
                layerCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                policko.add(layerCard, new Integer(2));
                
                if(field.getCard().get_treasure() != null){
                    JLabel treasureCard = new JLabel();
                    icon = new ImageIcon(this.getClass().getResource("images/bone.png"));
                    treasureCard.setIcon(icon);
                    treasureCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                    
                    policko.add(treasureCard, new Integer(3));
                }
                GamePanel.add(policko);
                
            }
            
        }
        
        
        mainFrame.getContentPane().add(GamePanel);
        mainFrame.getContentPane().setSize(size*90, size*90 + 100);
        //mainFrame.pack();
    }
    
}
