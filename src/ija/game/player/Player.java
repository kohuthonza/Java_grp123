/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game.player;

import java.util.ArrayList;
import ija.game.treasure.*;
/**
 *
 * @author Jan
 */
public class Player {
    
    //Pole hracu
    
    /*Promenne pro hrace*/
    //Poloha
    private int x;
    private int y;
    private TreasureCard actual_card;
    
    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.actual_card = null;
    }
    
    public int get_x(){
        return this.x;
    }
    
    public int get_y(){
        return this.y;
    }
    
    public void set_x(int x){
        this.x = x;
    }
    
    public void set_y(int y){
        this.y = y;
    }
    
    public void set_card(TreasureCard card){
        this.actual_card = card;
    }
    
    public TreasureCard get_card(){
        return this.actual_card;
    }
}
