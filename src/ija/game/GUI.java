package ija.game;



import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Hlavni JFrame cele hry
 * Obsahuje 2 framy:
 *  topPanel - panel se stavem hry
 *  gamePanel - panel s hracim polem
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
@SuppressWarnings("serial")
public class GUI extends JFrame implements KeyListener{
    static private Game game;
    static private TopPanel topPanel;
    static private GUIGamePanel gamePanel;

    static public void updateGUI(){
        topPanel.updatePanel();
        gamePanel.update();
    }
    
    static Game getGame(){
        return GUI.game;
    }
    
    static void setGame(Game game){
        GUI.game = game;
    }
    /**
     * Konstruktor grafickeho rozhrani hry, vytvori hravni JFrame a spusti jadro hry.
     * Hodnoty argumentu dostane z predchoziho grafickeho menu.
     * 
     * @param numPlayers - počet hracu ve hre
     * @param gameSize - počet policek = velikost herní plochy
     * @param packSize - počet karet s poklady pro jednoho hrace
     * @param load_game - pokud se jedna o nacteni hry, dostane celou hru, kterou si do sebe nahraje
     * @throws IOException Kontrola existence vstupnich souboru
     */
    public GUI(int numPlayers, int gameSize, int packSize, Game load_game) throws IOException{
       
        if (load_game != null){
            GUI.game = load_game;
            if (GUI.game.getInitialCondition())
                GUI.game.nextPlayer();
            else{
                GUI.game.setNMove(0);
                GUI.game.undoSave();
            }
        }
        else{
            try{
                GUI.game = new Game(numPlayers, gameSize, packSize);
                GUI.game.nextPlayer();
            } catch(IOException e){
                System.out.printf("hra nebyla vytvorena v GUI");
                System.exit(1);
            }
        }    
        

        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        addKeyListener(GUI.this);
        setFocusable(true);
        
        setFocusTraversalKeysEnabled(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((GUI.game.getMazeBoard().getSize() * 75 > 400)? GUI.game.getMazeBoard().getSize() * 75 : 400, GUI.game.getMazeBoard().getSize() * 75 + 146);
        //setSize(game.getMazeBoard().getSize() * 75, game.getMazeBoard().getSize() * 75 + 146+500);   
        setLocationRelativeTo(null);
        setTitle("Labyrinth - grp123");
        setResizable(true);
        setVisible(true);
        
        topPanel = new TopPanel();
        add(topPanel);              
        gamePanel = new GUIGamePanel();
        add(gamePanel);
        
        updateGUI();
        
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                
                GUI.game.deleteUndo();
                System.out.println("Closed");
                e.getWindow().dispose();
            }
        });
    }

    
   
    /**
     * reakce na stisknutou klavesu
     *      - ENTER: je zavolana metoda game.nextPlaer()
     *              na radu se dostane dalsi hrac, je updatovano graficke rozhrani
     *      - SIPKY: pohyb hrace, aktualni hrac se pohne podle zmacknute sipky, obnoveno graficke rozhrani
     * 
     * @param e - stisknuta hlavesa 
     */
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            
            if(GUI.game.checkEndOfGame()){
                EndGameFrame EGF = new EndGameFrame();
                EGF.setVisible(true);
                setVisible(false);
            }
            else{
                try{             
                    GUI.game.nextPlayer();
                    System.out.printf("hrac: %d\n",GUI.game.getActualFigurine());
                } catch (IOException except){
                    System.out.printf("next player exception");
                    System.exit(1);
                }
            }
            GUI.updateGUI();
            System.out.println("Next player");                   
        }
        
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {   
            System.out.printf("figurka %s moves DOWN from %d %d ",GUI.game.getActualFigurine(), GUI.game.getActualPlayer().getX(), GUI.game.getActualPlayer().getY());
            GUI.game.move_player('D');
            GUI.updateGUI();
            System.out.printf("to %d %d\n", GUI.game.getActualPlayer().getX(), GUI.game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.printf("figurka %s moves UP from %d %d ",GUI.game.getActualFigurine(), GUI.game.getActualPlayer().getX(), GUI.game.getActualPlayer().getY());
            GUI.game.move_player('U');
            GUI.updateGUI();
            System.out.printf("to %d %d\n", GUI.game.getActualPlayer().getX(), GUI.game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.printf("figurka %s moves LEFT from %d %d ",GUI.game.getActualFigurine(), GUI.game.getActualPlayer().getX(), GUI.game.getActualPlayer().getY());
            GUI.game.move_player('L');
            GUI.updateGUI();
            System.out.printf("to %d %d\n", GUI.game.getActualPlayer().getX(), GUI.game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.printf("figurka %s moves RIGHT from %d %d ", GUI.game.getActualFigurine(), GUI.game.getActualPlayer().getX(), GUI.game.getActualPlayer().getY());
            GUI.game.move_player('R');
            GUI.updateGUI();
            System.out.printf("to %d %d\n", GUI.game.getActualPlayer().getX(), GUI.game.getActualPlayer().getY());
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        //not using
    }  
    
    @Override
    public void keyTyped(KeyEvent e){
        //not using
    }
    
    
}