
package ija.game;

import ija.game.board.*;
import ija.game.treasure.CardPack;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;


public class GUI {
    private static JFrame mainFrame;
    static int size;
    static MazeBoard board;
    
    public static GUI create(){
        MazeBoard board = MazeBoard.createMazeBoard(5);
        CardPack pack = new CardPack (22, 22);
        pack.shuffle();
        
        Game game = new Game(2, board, pack);
        
        GUI graphicalInterface = new GUI();
        mainFrame = new JFrame("Labyrinth - grp123");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        size = board.get_size();
        board = MazeBoard.createMazeBoard(size);
        return graphicalInterface;
    }
    
    public void addContent(){
        JPanel GamePanel = new JPanel(new GridLayout(size, size));
        
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                MazeField field = board.get(i,j);
                JLabel label = new JLabel();
                //switch field.getCard().get_type()
                ImageIcon icon = new ImageIcon("C:\\VUT FIT\\2015 L\\IJA\\Java_grp123\\src\\ija\\game\\T.jpg");
                label.setIcon(icon);
                //JButton button1 = new JButton("tlacitko");
                GamePanel.add(label);
            }
            
        }
     
        mainFrame.getContentPane().add(GamePanel);
        mainFrame.pack();
    }
    
}
