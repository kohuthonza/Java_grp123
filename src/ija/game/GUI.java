
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
    
    public static GUI create(){
       
        game = new Game(2, 5);
        
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
                //if (field == null) return;
                JLabel label = new JLabel();
                ImageIcon icon;
                switch (field.getCard().get_type()) {
                    case "C":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/C0.jpg"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/C90.jpg"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/C180.jpg"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/C270.jpg"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/C0.jpg"));
                                break;
                        }
                        label.setIcon(icon);
                        GamePanel.add(label);
                        break;
                    case "F":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/T0.jpg"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/T90.jpg"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/T180.jpg"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/T270.jpg"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/T0.jpg"));
                                break;
                        }
                        label.setIcon(icon);
                        GamePanel.add(label);
                        break;
                    case "L":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/L0.jpg"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/L90.jpg"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/L0.jpg"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/L90.jpg"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/L0.jpg"));
                                break;
                        }
                        label.setIcon(icon);
                        GamePanel.add(label);
                        break;
                }
            }
            
        }
     
        mainFrame.getContentPane().add(GamePanel);
        mainFrame.pack();
    }
    
}
