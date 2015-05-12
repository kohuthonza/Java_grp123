
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
 * Hlavni trida
 * 
 * Implementuje metody pro operace s hraci na zaklade balicku karet 
 * a hraci desky
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
public class Game implements Serializable {
    
    
    private ArrayList<Player> players;
    private ArrayList<TreasureCard> rCards;
    private ArrayList<Integer> playersFigurine;
    private final MazeBoard board;
    private final CardPack pack;
    private final int nPlayers;
    private int actualPlayer;
    private boolean endOfGame;
    private boolean stopMove;
    private int nMove;
    private boolean isShift;
    private int nCards;
    
    /**
     * Konstruktor vytvari hru tzn. pole hracu, hraci desku a balicek karet, 
     * provadi se take inicializace tzn. pocatecni rozlozeni hracu a pocatecni
     * rozlozeni hledanych pokladu. 
     * 
     * @param nPlayers Pocet hracu (2 nebo 4)
     * @param sizeOfBoard Rozloha hraci desky (nejmene 3)
     * @param nCards Pocet karet v balicku
     * @throws java.io.IOException
     * 
     */
    public Game(int nPlayers, int sizeOfBoard, int nCards) throws IOException{
        
        //Vytvorime hraci desku
        this.board = MazeBoard.createMazeBoard(sizeOfBoard);
        //Pocet hracu
        this.nPlayers = nPlayers;
        //Hrac na tahu
        this.actualPlayer = -1;
        //List hracu
        this.players = new ArrayList<Player>();
        //List nahodne vybranych karet
        this.rCards = new ArrayList<TreasureCard>();
        //List figurek
        this.playersFigurine = new ArrayList<Integer>();
        //Pocet tahu, ktere byli provedeny
        this.nMove = 0;
        //Pocet karet v balicku jednoho hrace
        this.nCards = nCards;
        //Indikator konce hry
        this.endOfGame = false;
        //Indikator zastaveni pohybu
        this.stopMove = false;
        //Indikator posunu hracu (nezavisle na ceste)
        this.isShift = false;
        
        
        int i;
        
        Treasure.createSet();
        
        //Nastavime rozlozeni kamenu na desce
        this.board.newGame();
        
        
        
        //Pocatecni inicializace hracu (postaveni na desce)
        if (nPlayers == 2){
            this.players.add(new Player(1, 1));
            this.players.add(new Player(this.board.getSize(), this.board.getSize()));
        }
        
        if (nPlayers == 3){
            this.players.add(new Player(1, 1));
            this.players.add(new Player(this.board.getSize(), 1));
            this.players.add(new Player(1, this.board.getSize()));
        }
        
        if (nPlayers == 4){
             this.players.add(new Player(1, 1));
            this.players.add(new Player(this.board.getSize(), 1));
            this.players.add(new Player(1, this.board.getSize()));
            this.players.add(new Player(this.board.getSize(), this.board.getSize()));
        }
        
        //Vytvoreni a zamichani balicku
        this.pack = new CardPack(this.nCards*nPlayers);
        this.pack.shuffle();
        
        //Kazdy hrac si vytahne jednu kartu s balicku
        for (i = 0; i < nPlayers; ++i){
            this.players.get(i).setCard(this.pack.popCard());
        }
        //Projdeme zbytek balicku a nahodne vybereme poklady, ktere umistime navic na desku
        for (i = 0; i < nPlayers; ++i){
            this.addRandomCard();
        }
        //Nahodne rideli hracum figurky
        for (i = 1; i <= nPlayers; ++i){
            this.playersFigurine.add(i);
        }
        Collections.shuffle(this.playersFigurine);
        
        //Pripnuti pokladu na pole (MazeCard)
        for (Player tmp: this.players){
            this.stickTreasure(tmp.getCard().getTreasure());
        }
        if (this.rCards.size() > 0){
            for (TreasureCard tmp: this.rCards){
                this.stickTreasure(tmp.getTreasure());
            }
        }
        
    }
    
    /**
     * Kontroluje stav hry.
     * 
     * @return True pokud nastal konec hry, jinak false 
     */
    
    public boolean checkEndOfGame(){
        return this.endOfGame; 
    }

    /**
     * Vraci pocet karet s poklady v aktualni hre
     * 
     * @return pocet karet
     */
    
    public int getCardsNumber(){
        return nCards;
    }
    
     /**
     * Vraci hrace na tahu
     * 
     * @return Hrac na tahu
     */
    
    public Player getActualPlayer(){
        return this.players.get(this.actualPlayer);
    }
    /**
     * Kontroluje pocatecni stav hry 
     * 
     * @return True pokud je hra v pocatecnim stavu, jinak false
     */
    
    public boolean getInitialCondition(){
        return this.actualPlayer == -1;
    }
    
    /**
     * Vraci cislo figurky pro ahrace na tahu
     * 
     * @return Cislo figurky pro hrace na tahu
     */
    
    public int getActualFigurine(){
        return this.playersFigurine.get(this.actualPlayer);
    }
    
    /**
     * Ulozi aktualni stav hry do slozky: labyrint/undo v uzivatelske slozce
     * 
     * @throws IOException 
     */
    
    public void undoSave() throws IOException{
        this.nMove = this.nMove + 1;
        File file;
        File dir;
        dir = new File(System.getProperty("user.home")+"/labyrint/undo");
        dir.mkdirs();
        file = new File(System.getProperty("user.home")+"/labyrint/undo/undo"+Integer.toString(this.nMove));
        SaveLoad.serialize(this, file);
    }
    
    /**
     * Nastavi pocet tahu hry
     * 
     * @param nMove Pocet tahu hry
     */
    
    public void setNMove(int nMove){
        this.nMove = nMove;
    }
    
    /**
     * 
     * Vraci hru o jeden tah zpet
     * 
     * @return Hra o jeden tah zpet
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    
    public Game undoGame() throws IOException, ClassNotFoundException{
        
        if (!(this.nMove < 1)){
            
            Game undo; 
            File file;
            file = new File(System.getProperty("user.home")+"/labyrint/undo/undo"+Integer.toString(this.nMove));
            undo = (Game)SaveLoad.deserialize(file);
            //Pocatecni stav hry zustane uchovan po dobu behu cele hry
            if (this.nMove > 1){
                SaveLoad.deleteGame(file);
                undo.setNMove(this.nMove - 1);
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
    
    public ArrayList getPlayers(){
        return this.players;
    }
    
    /**
     * 
     * Vraci list figurek
     * 
     * @return List figurek
     */
    
    public ArrayList getPlayersFigurine(){
        return this.playersFigurine;
    }
    /**
     * Vraci poradove cislo hrace na tahu 
     * @return Poradove cislo
     */
    public int getActualPlayerN(){
        return this.actualPlayer + 1;
    }
    
    /**
     * Zkontroluje pozici zadaneho hrace. Kontroluje se, jestli hrac sebral
     * poklad a zaroven, jestli uz to neni jeho posledni (konec hry). Pokud
     * hrac vezme poklad, vygeneruje se novy (pokud je jeste nejaky k dispozici)
     * 
     * @param player Hrac
     */
    private void checkPosition(Player player){
       
        MazeCard tmpMazeCard;
        
        tmpMazeCard = this.board.getMazeField(player.getY(), player.getX()).getCard();
        
        if (tmpMazeCard.getTreasure() == player.getCard().getTreasure()){
            tmpMazeCard.setTreasure(null);
            //Pokud hrac vezme poklad, zastavi se mu pohyb
            this.stopMove = true;
            player.setPickedCards(player.getPickedCards() + 1);
            if (player.getPickedCards() == this.nCards)
                this.endOfGame = true;
            else{
                player.setCard(this.pack.popCard());
                if (this.nPlayers == 2 && this.pack.size() < 2)
                    return;
                if (this.nPlayers == 3 && this.pack.size() < 3)
                    return;
                if (this.nPlayers == 4 && this.pack.size() < 4)
                    return;
                if (this.rCards.contains(player.getCard()))
                    this.stickTreasure(this.addRandomCard().getTreasure());
                else
                    this.stickTreasure(player.getCard().getTreasure());  
            }
        }   
    }
    
    /**
     * Prilepi, navaze zadany poklad na nahodny kamen
     * 
     * @param treasure Poklad
     */
    
    private void stickTreasure(Treasure treasure){
        
        Random ran;
        int tmpX;
        int tmpY; 
        int i;
        boolean player;
         
        ran = new Random();
         
        while (true){
            tmpX = ran.nextInt(this.board.getSize()) + 1;
            tmpY = ran.nextInt(this.board.getSize()) + 1;
         
            if (this.board.getMazeField(tmpY, tmpX).getCard().getTreasure() == null){
                player = false;
                for(i = 0; i < this.nPlayers; ++i){
                    if (this.players.get(i).getX() == tmpX &&
                        this.players.get(i).getY() == tmpY) {
                        player = true;
                    }
                }
                if (!player){
                    this.board.getMazeField(tmpY, tmpX).getCard().setTreasure(treasure);
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
    private TreasureCard addRandomCard(){
        
        if (this.pack.size() > 0){
            while (true){
                TreasureCard tmpCard = this.pack.randomCard();
            
                if (!this.rCards.contains(tmpCard)){
                    this.rCards.add(tmpCard);
                    return tmpCard;
                    }
            }
        }
        else
            return null;
    }
    
    /**
     * Vraci hraci desku
     * 
     * @return Hraci deska
     */
    public MazeBoard getMazeBoard() {
        return this.board;
    }
    
    /**
     * Prepina na dalsiho hrace v poradi.
     * 
     */
    public void nextPlayer() throws IOException{
        
        this.stopMove = false;
        this.isShift = false;
        this.board.setIsShift(false);
        
        //Cykleni hracu
        if (this.actualPlayer + 1 == nPlayers)
            this.actualPlayer = 0;
        else
            this.actualPlayer = this.actualPlayer + 1;
    
        this.undoSave();
    }
    
    /**
     * Provede posun vsech hracu (nezavisle na ceste), kteri stoji na posouvanem radku, sloupci 
     * (prave posouvany radek se urci pomoci pole, na ktere se vklada volny
     * kamen). Pokud je hrac vysunut z desky, objevi se na druhe strane desky 
     * (na nove vlozenem kamenu).
     * 
     * @param mf Pole, na ktere se vklada volny kamen
     */
    public void shiftPlayer(MazeField mf){
        
        //Posun se provede pouze tehdy, byla-li posunuta hraci deska (pokud 
        //uz se posun hracu v danem tahu provedl, tak se podruhe neprovede)
        if (this.board.getIsShift() && !this.isShift){    
        
            this.isShift = true;
            
            int n;
            int r;
            int c;
        
            r = mf.getRow();
            c = mf.getCol();
        
            if (((c % 2) == 0) && (r == 1 || r == this.board.getSize())){
            
                for (n = 0; n < this.nPlayers; ++n){
                    if (this.players.get(n).getX() == c){
                        if (r == 1){
                            this.shiftDown(this.players.get(n));
                        }
                        if (r == this.board.getSize()){
                            this.shiftUp(this.players.get(n));
                        }
                    }
                }
            }    
        
        
            if (((r % 2) == 0)&&(c == 1 || c == this.board.getSize())){
            
                for (n = 0; n < this.nPlayers; ++n){
                    if (this.players.get(n).getY() == r){
                        if (c == 1){
                            this.shiftRight(this.players.get(n));
                        }
                        if (c == this.board.getSize()){
                            this.shiftLeft(this.players.get(n));
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
    private void shiftRight(Player player){
        
        if ((player.getX() + 1) > this.board.getSize()){
            player.setX(1);
            this.checkPosition(player);
        }
        else
            player.setX(player.getX() + 1);
        
    }    
    /**
     * Posune hrace doleva
     * @param player 
     */
    private void shiftLeft(Player player){
        
        if ((player.getX() - 1) < 1){
            player.setX(this.board.getSize());
            this.checkPosition(player);
        }
        else
            player.setX(player.getX() - 1);
        
    } 
    /**
     * Posune hrace nahoru
     * @param player 
     */
    private void shiftUp(Player player){
        
        if ((player.getY() - 1) < 1){
            player.setY(this.board.getSize());
            this.checkPosition(player);
        }
        else
            player.setY(player.getY() - 1);
        
    } 
    /**
     * Posune hrace dolu
     * @param player 
     */
    private void shiftDown(Player player){
        
        if ((player.getY() + 1) > this.board.getSize()){
            player.setY(1);
            this.checkPosition(player);
        }
        else
            player.setY(player.getY() + 1);
        
    } 
    
    /**
     * Posune hrace zadanym smerem. Pokud timto smerem nelze provest posun, 
     * nic se nestane.
     * 
     * @param direction Smer, kterym se ma hrac posunout: R (vpravo), L (vlevo), 
     * U (nahoru), D (doprava) 
     */
    public void move_player(char direction){
        
        if (this.board.getIsShift() && !this.stopMove){
            
            switch (direction){
                case 'R':
                    moveRight(this.players.get(this.actualPlayer));
                    break;
                case 'L':
                    moveLeft(this.players.get(this.actualPlayer));
                    break;
                case 'U':
                    moveUp(this.players.get(this.actualPlayer));
                    break;
                case 'D':
                    moveDown(this.players.get(this.actualPlayer));
                    break;
            }
        }      
    }
    //Metody pro posun hrace danym smerem
    
    /**
     * Posune hrace doprava
     * @param player 
     */
    private void moveRight(Player player){
         
        int tmpX;
        int tmpY;
        
        tmpX = player.getX();
        tmpY = player.getY(); 
        
        if ((tmpX + 1) <= this.board.getSize()){
            if (this.board.getMazeField(tmpY, tmpX).getCard().canGo(MazeCard.CANGO.RIGHT)){
                if (this.board.getMazeField(tmpY, tmpX + 1).getCard().canGo(MazeCard.CANGO.LEFT)){
                    player.setX(tmpX + 1);
                    this.checkPosition(player);
                }
            }
        }   
    }    
    /**
     * Posune hrace doleva
     * @param player 
     */
    private void moveLeft(Player player){
        
        int tmpX;
        int tmpY;
        
        tmpX = player.getX();
        tmpY = player.getY();
        
        if ((tmpX - 1) >= 1){
            if (this.board.getMazeField(tmpY, tmpX).getCard().canGo(MazeCard.CANGO.LEFT)){
                if (this.board.getMazeField(tmpY, tmpX - 1).getCard().canGo(MazeCard.CANGO.RIGHT)){
                    player.setX(tmpX - 1);
                    this.checkPosition(player);
                }
            }
        }
    } 
    /**
     * Posune hrace nahoru
     * @param player 
     */
    private void moveUp(Player player){
        
        int tmpX;
        int tmpY;
        
        tmpX = player.getX();
        tmpY = player.getY();
        
        if ((tmpY - 1) >= 1){
            if (this.board.getMazeField(tmpY, tmpX).getCard().canGo(MazeCard.CANGO.UP)){
                if (this.board.getMazeField(tmpY - 1, tmpX).getCard().canGo(MazeCard.CANGO.DOWN)){
                    player.setY(tmpY - 1);
                    this.checkPosition(player);
                }
            }
        }
    } 
    /**
     * Posune hrace dolu
     * @param player 
     */
    private void moveDown(Player player){
        
        int tmpX;
        int tmpY;
        
        tmpX = player.getX();
        tmpY = player.getY();
        
        if ((tmpY + 1) <= this.board.getSize()){
            if (this.board.getMazeField(tmpY, tmpX).getCard().canGo(MazeCard.CANGO.DOWN)){
                if (this.board.getMazeField(tmpY + 1, tmpX).getCard().canGo(MazeCard.CANGO.UP)){
                    player.setY(tmpY + 1);
                    this.checkPosition(player);
                }
            }
        }
    }    
}
