/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;

import java.util.ArrayList;
import ija.game.board.*;
import ija.game.treasure.*;
import ija.game.player.*;

/**
 *
 * @author Jan
 */


public class Game {
    
    private ArrayList<Player> players;
    private final MazeBoard board;
    private final CardPack pack;
    private final int n_players;
    
    public Game(int n_players, MazeBoard board, CardPack pack){
        this.board = board;
        this.pack = pack;
        this.n_players = n_players;
        if (n_players == 2 || n_players == 4){
            this.players.add(new Player(1,1));
            this.players.add(new Player(this.board.get_size(),this.board.get_size()));
        }
        //else err
        if (n_players == 4){
            this.players.add(new Player(this.board.get_size(),1));
            this.players.add(new Player(1,this.board.get_size()));
        }
    }
    
    
    
    
    public void shift(MazeField mf){
        
        int n;
        int r;
        int c;
        
        r = mf.row();
        c = mf.col();
        
        if (((c % 2) == 0) && (r == 1 || r == this.board.get_size())){
            
            for (n = 0; n < this.n_players; ++n){
                if (this.players.get(n).get_x() == c){
                    if (r == 1){
                        this.shift_down(this.players.get(n));
                    }
                    if (r == this.board.get_size()){
                        this.shift_up(this.players.get(n));
                    }
                }
            }
        }    
        
        
        if (((r % 2) == 0)&&(c == 1 || c == this.board.get_size())){
            
            for (n = 0; n < this.n_players; ++n){
                if (this.players.get(n).get_y() == r){
                    if (c == 1){
                        this.shift_right(this.players.get(n));
                    }
                    if (c == this.board.get_size()){
                        this.shift_left(this.players.get(n));
                    }
                }
            }
        }
    }
        
    private void shift_right(Player player){
        
        if ((player.get_x() + 1) > this.board.get_size())
            player.set_x(1);
        else
            player.set_x(player.get_x() + 1);
        
    }    
    
    private void shift_left(Player player){
        
        if ((player.get_x() - 1) < 1)
            player.set_x(this.board.get_size());
        else
            player.set_x(player.get_x() - 1);
        
    } 
    
    private void shift_up(Player player){
        
        if ((player.get_y() - 1) < 1)
            player.set_y(this.board.get_size());
        else
            player.set_y(player.get_y() - 1);
        
    } 
    
    private void shift_down(Player player){
        
        if ((player.get_y() + 1) > this.board.get_size())
            player.set_y(1);
        else
            player.set_y(player.get_y() + 1);
        
    } 
    
    public void move(int player, char direction){
        
        switch (direction){
            case 'R':
                move_right(this.players.get(player));
                break;
            case 'L':
                move_left(this.players.get(player));
                break;
            case 'U':
                move_up(this.players.get(player));
                break;
            case 'D':
                move_down(this.players.get(player));
                break;
            }
             
    }
    
     private void move_right(Player player){
         
        int tmp_x;
        int tmp_y;
        
        tmp_x = player.get_x();
        tmp_y = player.get_y(); 
        
        if ((tmp_x + 1) <= this.board.get_size()){
            if (this.board.get(tmp_y, tmp_x).getCard().canGo(MazeCard.CANGO.RIGHT)){
                if (this.board.get(tmp_y, tmp_x + 1).getCard().canGo(MazeCard.CANGO.LEFT))
                    player.set_x(tmp_x + 1);
            }
        }   
    }    
    
    private void move_left(Player player){
        
        int tmp_x;
        int tmp_y;
        
        tmp_x = player.get_x();
        tmp_y = player.get_y();
        
        if ((tmp_x - 1) >= 1){
            if (this.board.get(tmp_y, tmp_x).getCard().canGo(MazeCard.CANGO.LEFT)){
                if (this.board.get(tmp_y, tmp_x + 1).getCard().canGo(MazeCard.CANGO.RIGHT))
                    player.set_x(tmp_x - 1);
            }
        }
    } 
    
    private void move_up(Player player){
        
        int tmp_x;
        int tmp_y;
        
        tmp_x = player.get_x();
        tmp_y = player.get_y();
        
        if ((tmp_y - 1) >= 1){
            if (this.board.get(tmp_y, tmp_x).getCard().canGo(MazeCard.CANGO.UP)){
                if (this.board.get(tmp_y, tmp_x + 1).getCard().canGo(MazeCard.CANGO.DOWN))
                    player.set_y(tmp_y - 1);
            }
        }
    } 
    
    private void move_down(Player player){
        
        int tmp_x;
        int tmp_y;
        
        tmp_x = player.get_x();
        tmp_y = player.get_y();
        
        if ((tmp_y + 1) <= this.board.get_size()){
            if (this.board.get(tmp_y, tmp_x).getCard().canGo(MazeCard.CANGO.DOWN)){
                if (this.board.get(tmp_y, tmp_x + 1).getCard().canGo(MazeCard.CANGO.UP))
                    player.set_y(tmp_y + 1);
            }
        }
    }    
}
