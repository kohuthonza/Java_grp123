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
 * @author Jan
 */
public class Save extends JFrame{
    
    
    public static File create_file(){
        
        JFileChooser chooser = new JFileChooser();
        
        
        
        int filename = chooser.showSaveDialog(null);

        if (filename == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile();
        }
        
    
    return null;
    
    }
    
    
}
