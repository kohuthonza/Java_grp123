/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;
import javax.swing.*;
import java.io.*;
/**
 *
 * Implementuje JFileChooser pro ulozeni hry
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
public class Save extends JFrame{
    
    private static final File dir = new File(System.getProperty("user.home")+"/labyrint/saved_games");
    /**
     * Spusti okno, ktere umozni vytvoreni souboru na vybrane adrese
     * 
     * @return Vytvoreny soubor
     */
    public static File createFile(){
        
        Save.dir.mkdirs();
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")+"/labyrint/saved_games"));
        
        
        int filename = chooser.showSaveDialog(null);

        if (filename == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile();
        }
        
    
        return null;
    
    }
    
    
}
