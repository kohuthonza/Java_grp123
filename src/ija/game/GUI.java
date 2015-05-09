
package ija.game;

import ija.game.board.*;
import ija.game.treasure.CardPack;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class GUI extends JFrame{
    static Game game;
    static TopPanel topPanel;
    static GUIGamePanel gamePanel;
    static JButton button;

    
    public GUI(int numPlayers, int gameSize){
       
        try{
            game = new Game(numPlayers, gameSize);
            game.next_player();
        } catch(IOException e){
           System.out.printf("hra nebyla vytvorena");
           System.exit(1);
        }
        
        
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        
        topPanel = new TopPanel(game);
        add(topPanel);              
        gamePanel = new GUIGamePanel(game);
        add(gamePanel);
                button = new JButton();
        add(button);
        
        
 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((gameSize * 75 > 400)? gameSize * 75 : 400, gameSize * 75 + 146);
        //pack();
        setLocationRelativeTo(null);
        setTitle("Labyrinth - grp123");
        setResizable(true);
        setVisible(true);

    }
    
    public void keyPressed(KeyEvent e){
        try{
            game.next_player();
        } catch (IOException except){
           System.out.printf("hra nebyla vytvorena");
           System.exit(1);
        }
        topPanel.repaint();
        button.setText("zmacknuto");
    }
    
}
