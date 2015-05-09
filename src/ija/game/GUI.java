
package ija.game;

import ija.game.board.*;
import ija.game.treasure.CardPack;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                try{
                    game.next_player();
                    System.out.printf("hrac: %d\n",game.get_actual_figurine());
                    game.move_player('R');
                } catch (IOException except){
                    System.out.printf("hra nebyla vytvorena");
                    System.exit(1);
                }
                topPanel.updatePanel();
                System.out.println("You clicked the button");
            }
        });
        add(button);
        
        
 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((gameSize * 75 > 400)? gameSize * 75 : 400, gameSize * 75 + 146);
        //pack();
        setLocationRelativeTo(null);
        setTitle("Labyrinth - grp123");
        setResizable(true);
        setVisible(true);

    }

    
}
