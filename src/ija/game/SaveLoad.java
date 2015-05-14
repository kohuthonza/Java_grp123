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


/**
 *
 * Zajistuje serializaci a deserializaci souboru
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
@SuppressWarnings("serial")
public class SaveLoad {
    
    /**
     * 
     * Provede serializaci objektu do daneho souboru
     * 
     * @param obj Objekt, ktery ma byt serializovan
     * @param file Objekt souboru do ktereho se ma serializace ulozit
     * @throws IOException Chyba vstupniho souboru
     */
    public static void serialize(Object obj, File file)
            throws IOException {
        
        
        
        FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
 
        fos.close();
    }
    
    /**
     * 
     * Provede deserializaci zadaneho souboru
     * 
     * @param file Soubor, ktery se ma deserializovat
     * @return Deserializovany objekt
     * @throws IOException Chyba vstupniho souboru
     * @throws ClassNotFoundException Kontrola existence nacitane tridy
     */
    public static Object deserialize(File file) throws IOException, ClassNotFoundException {
 
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    /**
     * Provede odstraneni zadaneho souboru
     * 
     * @param file Soubor
     */
    public static void deleteGame(File file){
        file.delete();
    }
    
}
