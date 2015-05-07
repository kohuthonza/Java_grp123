
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
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                MazeField field = board.get(i,j);
                //if (field == null) return;
                JLabel label = new JLabel();
                ImageIcon icon;
                switch (field.getCard().get_type()) {
                    case "C":
                        icon = new ImageIcon("C:\\VUT FIT\\2015 L\\IJA\\Java_grp123\\src\\ija\\game\\T.jpg");
                        label.setIcon(icon);
                        GamePanel.add(label);
                        break;
                    case "F":
                        icon = new ImageIcon("C:\\VUT FIT\\2015 L\\IJA\\Java_grp123\\src\\ija\\game\\I.jpg");
                        label.setIcon(icon);
                        GamePanel.add(label);
                        break;
                    case "L":
                        icon = new ImageIcon("C:\\VUT FIT\\2015 L\\IJA\\Java_grp123\\src\\ija\\game\\L.jpg");
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
