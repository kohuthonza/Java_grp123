
package ija.game;

import ija.game.board.*;
import ija.game.treasure.CardPack;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

import java.io.IOException;


public class GUI extends JFrame{
    static Game game;

    
    public GUI(int numPlayers, int gameSize){
       
        try{
            game = new Game(numPlayers, gameSize);
        } catch(IOException e){
           System.out.printf("hra nebyla vytvorena");
           System.exit(1);
        }
        
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        
        add(new TopPanel(game));              
        add(new GUIGamePanel(game));
        
 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((gameSize * 75 > 400)? gameSize * 75 : 400, gameSize * 75 + 146);
        //pack();
        setLocationRelativeTo(null);
        setTitle("Labyrinth - grp123");
        setResizable(true);
        setVisible(true);

    }
    
}
