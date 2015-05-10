/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;

import java.io.IOException;
import ija.game.board.MazeBoard;
import java.io.File;
/**
 *
 * @author Jan
 */


public class Main {
    
    public static void main(String argv[]) throws IOException, ClassNotFoundException{
        
        
        //GUImenu menu = new GUImenu();
        //menu.setVisible(true);
          
        //Game new_game = new Game(4,7);
        
        //SaveLoad.serialize(new_game, Save.create_file());
        
        GUImenu menu = new GUImenu();
        menu.setVisible(true);
        
        //TextUI textUI = new TextUI();
        //textUI.start(undo.getMazeBoard());
    }
            
   
}
