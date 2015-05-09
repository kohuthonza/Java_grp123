/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Jan
 */
public class SaveLoad {
    
    private static final File dir = new File(System.getProperty("user.home")+"/labyrint/save_games");
    private static ArrayList<String> game_list = new ArrayList<String>();
    
    
    public static void serialize(Object obj, File file)
            throws IOException {
        
        
        SaveLoad.dir.mkdirs();
        
        FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
 
        fos.close();
    }
    
    
    public static Object deserialize(File file) throws IOException,
            ClassNotFoundException {
        SaveLoad.dir.mkdirs();
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    public static void delete_game(File file){
        file.delete();
    }
   
    public static void reload_game_list(){
        
        File[] files = new File(System.getProperty("user.home")+"/labyrint/save_games/").listFiles(); 
        SaveLoad.game_list.clear();
        
        for (File file : files) {
            if (file.isFile()) {
                SaveLoad.game_list.add(file.getName());
            }
        }
        
    }
    /*
    public static ArrayList get_game_list(){
       
        SaveLoad.reload_game_list(); 
        return SaveLoad.game_list;
    }
    */
}
