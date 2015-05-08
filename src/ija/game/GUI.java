
package ija.game;

import ija.game.board.*;
import ija.game.treasure.CardPack;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;


public class GUI extends JFrame{
    static Game game;

    
    public GUI(int numPlayers, int gameSize){
       
        game = new Game(numPlayers, gameSize);
        
        
        getContentPane().setLayout(new BorderLayout());
        add(new JButton("tlacitko"));              
        add(new GUIGamePanel(game));
        
 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(gameSize * 75, gameSize * 75+10);
        setLocationRelativeTo(null);
        setTitle("Labyrinth - grp123");
        setResizable(true);
        setVisible(true);

    }
    
}
