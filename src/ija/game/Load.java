/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;
import javax.swing.*;
import java.io.*;



/**
 * Implementuje JFileChooser pro vyber hry, ktera se ma nahrat
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
@SuppressWarnings("serial")
public class Load extends JFrame{
    
    private static final File dir = new File(System.getProperty("user.home")+"/labyrint/saved_games");
    
    /**
     * 
     * Spusti okno pro vyber souboru
     * 
     * @return Vybrany soubor
     */
    public static File chooseFile(){
        
        Load.dir.mkdirs();
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")+"/labyrint/saved_games"));
        
        
        int filename = chooser.showOpenDialog(null);

        if (filename == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile();
        }
        
    
        return null;
    
    }
}
