

package ija.game;

import java.util.ArrayList;
import ija.game.board.*;
import ija.game.treasure.*;
import ija.game.player.*;
import java.io.IOException;
import java.util.Random;
import java.io.*;
import java.util.Collections;


/**
 * Hlavni trida, jejiz instanci je hra
 * 
 * 
 * @author Jan
 */
public class Game implements Serializable {
    
    
    private ArrayList<Player> players;
    private ArrayList<TreasureCard> r_cards;
    private ArrayList<Integer> players_figurine;
    private final MazeBoard board;
    private final CardPack pack;
    private final int n_players;
    private int actual_player;
    private boolean end_of_game;
    private boolean stop_move;
    private int n_move;
    private boolean is_shift;
    private int n_cards;
    
    /**
     * Konstruktor vytvari hru tzn. pole hracu, hraci desku a balicek karet, 
     * provadi se take inicializace tzn. pocatecni rozlozeni hracu a pocatecni
     * rozlozeni hledanych pokladu. 
     * 
     * @param n_players Pocet hracu (2 nebo 4)
     * @param size_of_board Rozloha hraci desky (nejmene 3)
     * @param n_cards Pocet karet v balicku
     * @throws java.io.IOException
     * 
     */
    public Game(int n_players, int size_of_board, int n_cards) throws IOException{
        
        //Vytvorime hraci desku
        this.board = MazeBoard.createMazeBoard(size_of_board);
        //Pocet hracu
        this.n_players = n_players;
        //Hrac na tahu
        this.actual_player = -1;
        //List hracu
        this.players = new ArrayList<Player>();
        //List nahodne vybranych karet
        this.r_cards = new ArrayList<TreasureCard>();
        //List figurek
        this.players_figurine = new ArrayList<Integer>();
        //Pocet tahu, ktere byli provedeny
        this.n_move = 0;
        //Pocet karet v balicku jednoho hrace
        this.n_cards = n_cards;
        //Indikator konce hry
        this.end_of_game = false;
        //Indikator zastaveni pohybu
        this.stop_move = false;
        //Indikator posunu hracu (nezavisle na ceste)
        this.is_shift = false;
        
        
        int i;
        
        Treasure.createSet();
        
        //Nastavime rozlozeni kamenu na desce
        this.board.newGame();
        
        
        
        //Pocatecni inicializace hracu (postaveni na desce)
        if (n_players == 2){
            this.players.add(new Player(1, 1));
            this.players.add(new Player(this.board.get_size(), this.board.get_size()));
        }
        
        if (n_players == 3){
            this.players.add(new Player(1, 1));
            this.players.add(new Player(this.board.get_size(), 1));
            this.players.add(new Player(1, this.board.get_size()));
        }
        
        if (n_players == 4){
             this.players.add(new Player(1, 1));
            this.players.add(new Player(this.board.get_size(), 1));
            this.players.add(new Player(1, this.board.get_size()));
            this.players.add(new Player(this.board.get_size(), this.board.get_size()));
        }
        
        //Vytvoreni a zamichani balicku
        this.pack = new CardPack(this.n_cards,24);
        this.pack.shuffle();
        
        //Kazdy hrac si vytahne jednu kartu s balicku
        for (i = 0; i < n_players; ++i){
            this.players.get(i).set_card(this.pack.popCard());
        }
        //Projdeme zbytek balicku a nahodne vybereme poklady, ktere umistime navic na desku
        for (i = 0; i < n_players; ++i){
            this.add_r_card();
        }
        //Nahodne rideli hracum figurky
        for (i = 1; i <= n_players; ++i){
            this.players_figurine.add(i);
        }
        Collections.shuffle(this.players_figurine);
        
        //Pripnuti pokladu na pole (MazeCard)
        for (Player tmp: this.players){
            this.stick_treasure(tmp.get_card().get_treasure());
        }
        for (TreasureCard tmp: this.r_cards){
            this.stick_treasure(tmp.get_treasure());
        }
        
    }
    
    /**
     * Kontroluje stav hry.
     * 
     * @return True pokud nastal konec hry, jinak false 
     */
    
    public boolean check_end_of_game(){
        return this.end_of_game; 
    }
    /**
     * Vraci hrace na tahu
     * 
     * @return Hrac na tahu
     */
    
    public Player get_actual_player(){
        return this.players.get(this.actual_player);
    }
    /**
     * Kontroluje pocatecni stav hry 
     * 
     * @return True pokud je hra v pocatecnim stavu, jinak false
     */
    
    public boolean get_initial_condition(){
        return this.actual_player == -1;
    }
    
    /**
     * Vraci cislo figurky pro ahrace na tahu
     * 
     * @return Cislo figurky pro hrace na tahu
     */
    
    public int get_actual_figurine(){
        return this.players_figurine.get(this.actual_player);
    }
    
    /**
     * Ulozi aktualni stav hry do slozky: labyrint/undo v uzivatelske slozce
     * 
     * @throws IOException 
     */
    
    public void undo_save() throws IOException{
        this.n_move = this.n_move + 1;
        File file;
        File dir;
        dir = new File(System.getProperty("user.home")+"/labyrint/undo");
        dir.mkdirs();
        file = new File(System.getProperty("user.home")+"/labyrint/undo/undo"+Integer.toString(this.n_move));
        SaveLoad.serialize(this, file);
    }
    
    /**
     * Nastavi pocet tahu hry
     * 
     * @param n_move Pocet tahu hry
     */
    
    public void set_n_move(int n_move){
        this.n_move = n_move;
    }
    
    /**
     * 
     * Vraci hru o jeden tah zpet
     * 
     * @return Hra o jeden tah zpet
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    
    public Game undo_game() throws IOException, ClassNotFoundException{
        
        if (!(this.n_move < 1)){
            
            Game undo; 
            File file;
            file = new File(System.getProperty("user.home")+"/labyrint/undo/undo"+Integer.toString(this.n_move));
            undo = (Game)SaveLoad.deserialize(file);
            //Pocatecni stav hry zustane uchovan po dobu behu cele hry
            if (this.n_move > 1){
                SaveLoad.delete_game(file);
                undo.set_n_move(this.n_move - 1);
            }
            return undo;
        }
        return null;
    }
    
    /**
     * Vraci list hracu
     * 
     * @return List hracu
     */
    
    public ArrayList get_players(){
        return this.players;
    }
    
    /**
     * 
     * Vraci list figurek
     * 
     * @return List figurek
     */
    
    public ArrayList get_players_figurine(){
        return this.players_figurine;
    }
    
    /**
     * Zkontroluje pozici zadaneho hrace. Kontroluje se, jestli hrac sebral
     * poklad a zaroven, jestli uz to neni jeho posledni (konec hry). Pokud
     * hrac vezme poklad, vygeneruje se novy (pokud je jeste nejaky k dispozici)
     * 
     * @param player Hrac
     */
    private void check_position(Player player){
       
        MazeCard tmp_MazeCard;
        
        tmp_MazeCard = this.board.get(player.get_y(), player.get_x()).getCard();
        
        if (tmp_MazeCard.get_treasure() == player.get_card().get_treasure()){
            tmp_MazeCard.set_treasure(null);
            //Pokud hrac vezme poklad, zastavi se mu pohyb
            this.stop_move = true;
            player.set_picked_cards(player.get_picked_cards() + 1);
            if (player.get_picked_cards() == this.n_cards)
                this.end_of_game = true;
            else{
                player.set_card(this.pack.popCard());
                if (this.n_players == 2 && this.pack.size() < 2)
                    return;
                if (this.n_players == 3 && this.pack.size() < 3)
                    return;
                if (this.n_players == 4 && this.pack.size() < 4)
                    return;
                if (this.r_cards.contains(player.get_card()))
                    this.stick_treasure(this.add_r_card().get_treasure());
                else
                    this.stick_treasure(player.get_card().get_treasure());  
            }
        }   
    }
    
    /**
     * Prilepi, navaze zadany poklad na nahodny kamen
     * 
     * @param treasure Poklad
     */
    
    private void stick_treasure(Treasure treasure){
        
        Random ran;
        int tmp_x;
        int tmp_y; 
        int i;
        boolean player;
         
        ran = new Random();
         
        while (true){
            tmp_x = ran.nextInt(this.board.get_size()) + 1;
            tmp_y = ran.nextInt(this.board.get_size()) + 1;
         
            if (this.board.get(tmp_y, tmp_x).getCard().get_treasure() == null){
                player = false;
                for(i = 0; i < this.n_players; ++i){
                    if (this.players.get(i).get_x() == tmp_x &&
                        this.players.get(i).get_y() == tmp_y) {
                        player = true;
                    }
                }
                if (!player){
                    this.board.get(tmp_y, tmp_x).getCard().set_treasure(treasure);
                    break;
                }
            }
        }
    }
    
    /**
     * Vraci nahodnou kartu s balicku karet
     * 
     * @return Karta
     */
    private TreasureCard add_r_card(){
        
        while (true){
            TreasureCard tmp_card = this.pack.randomCard();
            
            if (!this.r_cards.contains(tmp_card)){
                this.r_cards.add(tmp_card);
                return tmp_card;
                }
            } 
    }
    
    /**
     * Vraci hraci desku
     * 
     * @return Hraci deska
     */
    public MazeBoard getMazeBoard() {
        return board;
    }
    
    /**
     * Prepina na dalsiho hrace v poradi.
     * 
     */
    public void next_player() throws IOException{
        
        this.stop_move = false;
        this.is_shift = false;
        this.board.set_is_shift(false);
        
        //Cykleni hracu
        if (this.actual_player + 1 == n_players)
            this.actual_player = 0;
        else
            this.actual_player = this.actual_player + 1;
    
        this.undo_save();
    }
    
    /**
     * Provede posun vsech hracu (nezavisle na ceste), kteri stoji na posouvanem radku, sloupci 
     * (prave posouvany radek se urci pomoci pole, na ktere se vklada volny
     * kamen). Pokud je hrac vysunut z desky, objevi se na druhe strane desky 
     * (na nove vlozenem kamenu).
     * 
     * @param mf Pole, na ktere se vklada volny kamen
     */
    public void shift_player(MazeField mf){
        
        //Posun se provede pouze tehdy, byla-li posunuta hraci deska (pokud 
        //uz se posun hracu v danem tahu provedl, tak se podruhe neprovede)
        if (this.board.get_is_shift() && !this.is_shift){    
        
            this.is_shift = true;
            
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
    }
    
    //Metody pro posuny hracu danym smerem (nezavisle na ceste). 
    
    /**
     * Posune hrace doprava
     * @param player 
     */
    private void shift_right(Player player){
        
        if ((player.get_x() + 1) > this.board.get_size())
            player.set_x(1);
        else
            player.set_x(player.get_x() + 1);
        
    }    
    /**
     * Posune hrace doleva
     * @param player 
     */
    private void shift_left(Player player){
        
        if ((player.get_x() - 1) < 1)
            player.set_x(this.board.get_size());
        else
            player.set_x(player.get_x() - 1);
        
    } 
    /**
     * Posune hrace nahoru
     * @param player 
     */
    private void shift_up(Player player){
        
        if ((player.get_y() - 1) < 1)
            player.set_y(this.board.get_size());
        else
            player.set_y(player.get_y() - 1);
        
    } 
    /**
     * Posune hrace dolu
     * @param player 
     */
    private void shift_down(Player player){
        
        if ((player.get_y() + 1) > this.board.get_size())
            player.set_y(1);
        else
            player.set_y(player.get_y() + 1);
        
    } 
    
    /**
     * Posune hrace zadanym smerem. Pokud timto smerem nelze provest posun, 
     * nic se nestane.
     * 
     * @param direction Smer, kterym se ma hrac posunout: R (vpravo), L (vlevo), 
     * U (nahoru), D (doprava) 
     */
    public void move_player(char direction){
        
        if (this.board.get_is_shift() && !this.stop_move){
            
            switch (direction){
                case 'R':
                    move_right(this.players.get(this.actual_player));
                    break;
                case 'L':
                    move_left(this.players.get(this.actual_player));
                    break;
                case 'U':
                    move_up(this.players.get(this.actual_player));
                    break;
                case 'D':
                    move_down(this.players.get(this.actual_player));
                    break;
            }
        }      
    }
    //Metody pro posun hrace danym smerem
    
    /**
     * Posune hrace doprava
     * @param player 
     */
    private void move_right(Player player){
         
        int tmp_x;
        int tmp_y;
        
        tmp_x = player.get_x();
        tmp_y = player.get_y(); 
        
        if ((tmp_x + 1) <= this.board.get_size()){
            if (this.board.get(tmp_y, tmp_x).getCard().canGo(MazeCard.CANGO.RIGHT)){
                if (this.board.get(tmp_y, tmp_x + 1).getCard().canGo(MazeCard.CANGO.LEFT)){
                    player.set_x(tmp_x + 1);
                    this.check_position(player);
                }
            }
        }   
    }    
    /**
     * Posune hrace doleva
     * @param player 
     */
    private void move_left(Player player){
        
        int tmp_x;
        int tmp_y;
        
        tmp_x = player.get_x();
        tmp_y = player.get_y();
        
        if ((tmp_x - 1) >= 1){
            if (this.board.get(tmp_y, tmp_x).getCard().canGo(MazeCard.CANGO.LEFT)){
                if (this.board.get(tmp_y, tmp_x - 1).getCard().canGo(MazeCard.CANGO.RIGHT)){
                    player.set_x(tmp_x - 1);
                    this.check_position(player);
                }
            }
        }
    } 
    /**
     * Posune hrace nahoru
     * @param player 
     */
    private void move_up(Player player){
        
        int tmp_x;
        int tmp_y;
        
        tmp_x = player.get_x();
        tmp_y = player.get_y();
        
        if ((tmp_y - 1) >= 1){
            if (this.board.get(tmp_y, tmp_x).getCard().canGo(MazeCard.CANGO.UP)){
                if (this.board.get(tmp_y - 1, tmp_x).getCard().canGo(MazeCard.CANGO.DOWN)){
                    player.set_y(tmp_y - 1);
                    this.check_position(player);
                }
            }
        }
    } 
    /**
     * Posune hrace dolu
     * @param player 
     */
    private void move_down(Player player){
        
        int tmp_x;
        int tmp_y;
        
        tmp_x = player.get_x();
        tmp_y = player.get_y();
        
        if ((tmp_y + 1) <= this.board.get_size()){
            if (this.board.get(tmp_y, tmp_x).getCard().canGo(MazeCard.CANGO.DOWN)){
                if (this.board.get(tmp_y + 1, tmp_x).getCard().canGo(MazeCard.CANGO.UP)){
                    player.set_y(tmp_y + 1);
                    this.check_position(player);
                }
            }
        }
    }    
}
