/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game.player;


import ija.game.treasure.*;
import java.io.Serializable;

/**
 *
 * Implementuje hrace a operace nad nim
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
public class Player implements Serializable{
    
    //Souradnice hrace (osa x a prevracena osa y)
    private int x;
    private int y;
    //Karta, kterou ma hrac vytazenou
    private TreasureCard actualCard;
    //Pocet posbiranych, splnenych karet
    private int pickedCards;
    
    /**
     * Vytvori hrace na pozicich x, y
     * 
     * @param x Pozice na ose x
     * @param y Pozice na obracene ose y
     */
    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.actualCard = null;
        this.pickedCards = 0;
    }
    
    /**
     * Vraci x-ovou pozici hrace
     * 
     * @return X-ova pozice 
     * 
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Vraci y-ovou pozici hrace
     * 
     * @return Y-ova pozice hrace
     */
    public int getY(){
        return this.y;
    }
    /**
     * Nastavi x-ovou pozici hrace
     * 
     * @param x X-ova pozice hrace 
     * 
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * Nastavi y-ovou pozici hrace
     * 
     * @param y Y-ova pozice hrace
     */
    public void setY(int y){
        this.y = y;
    }
    
    /**
     * Nastavi vytazenou kartu
     * 
     * @param card Karta
     */
    public void setCard(TreasureCard card){
        this.actualCard = card;
    }
    /**
     * Vrati kartu, kterou ma hrac vytazenou
     * 
     * @return Karta
     */
    public TreasureCard getCard(){
        return this.actualCard;
    }
    
    /**
     * Nastavi pocet posbiranych, splnenych karet
     * 
     * @param pickedCards Pocet
     */
    public void setPickedCards(int pickedCards){
        this.pickedCards = pickedCards;  
    }
    /**
     * Vrati pocet posbiranych, splnenych karet
     * 
     * @return Pocet
     */
    public int getPickedCards(){
        return this.pickedCards;
    }
}
