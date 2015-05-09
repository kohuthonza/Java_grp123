
package ija.game;

import ija.game.board.*;
import ija.game.treasure.CardPack;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.event.KeyAdapter;

import java.io.IOException;


public class GUI extends JFrame implements KeyListener{
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
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((gameSize * 75 > 400)? gameSize * 75 : 400, gameSize * 75 + 146);
        //pack();
        setLocationRelativeTo(null);
        setTitle("Labyrinth - grp123");
        setResizable(true);
        setVisible(true);

    }
    
    public void keyTyped(KeyEvent e){
        //not using
    }
    
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            try{
                game.next_player();
                System.out.printf("hrac: %d\n",game.get_actual_figurine());
                game.move_player('R');
            } catch (IOException except){
                System.out.printf("next player exception");
                System.exit(1);
            }
            
            topPanel.updatePanel();
            System.out.println("Next player");  
    
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {   
            System.out.printf("player %s moves DOWN from %d %d ",game.get_actual_figurine(), game.get_actual_player().get_x(), game.get_actual_player().get_x());
            game.move_player('D');
            System.out.printf("to %d %d\n", game.get_actual_player().get_x(), game.get_actual_player().get_x());
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.printf("player %s moves UP from %d %d ",game.get_actual_figurine(), game.get_actual_player().get_x(), game.get_actual_player().get_x());
            game.move_player('U');
            System.out.printf("to %d %d\n", game.get_actual_player().get_x(), game.get_actual_player().get_x());
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.printf("player %s moves LEFT from %d %d ",game.get_actual_figurine(), game.get_actual_player().get_x(), game.get_actual_player().get_x());
            game.move_player('L');
            System.out.printf("to %d %d\n", game.get_actual_player().get_x(), game.get_actual_player().get_x());
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.printf("player %s moves RIGHT from %d %d ",game.get_actual_figurine(), game.get_actual_player().get_x(), game.get_actual_player().get_x());
            game.move_player('R');
            System.out.printf("to %d %d\n", game.get_actual_player().get_x(), game.get_actual_player().get_x());
        }
    }
    
    public void keyReleased(KeyEvent e){
        //not using
    }    
    
}
