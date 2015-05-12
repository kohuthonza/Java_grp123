
package ija.game;



import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;


public class GUI extends JFrame implements KeyListener{
    static Game game;
    static TopPanel topPanel;
    static GUIGamePanel gamePanel;

    static public void updateGUI(){
        topPanel.updatePanel();
        gamePanel.update(game);
    }
    
    public GUI(int numPlayers, int gameSize, int packSize, Game load_game) throws IOException{
       
        if (load_game != null){
            game = load_game;
            if (game.getInitialCondition())
                game.nextPlayer();
            
        }
        else{
            try{
                game = new Game(numPlayers, gameSize, packSize);
                game.nextPlayer();
            } catch(IOException e){
                System.out.printf("hra nebyla vytvorena v GUI");
                System.exit(1);
            }
        }    
        

        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        addKeyListener(this);
        setFocusable(true);
        
        setFocusTraversalKeysEnabled(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((game.getMazeBoard().getSize() * 75 > 400)? game.getMazeBoard().getSize() * 75 : 400, game.getMazeBoard().getSize() * 75 + 146);   
        setLocationRelativeTo(null);
        setTitle("Labyrinth - grp123");
        setResizable(true);
        setVisible(true);
        topPanel = new TopPanel(game);
        add(topPanel);              
        gamePanel = new GUIGamePanel(game);
        add(gamePanel);
                  
    }

    
    public void keyTyped(KeyEvent e){
        //not using
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            
            if(game.checkEndOfGame()){
                EndGameFrame EGF = new EndGameFrame(game);
                EGF.setVisible(true);
                setVisible(false);
            }
            try{             
                game.nextPlayer();
                System.out.printf("hrac: %d\n",game.getActualFigurine());
            } catch (IOException except){
                System.out.printf("next player exception");
                System.exit(1);
            }
           
            GUI.updateGUI();
            System.out.println("Next player");                   
        }
        
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {   
            System.out.printf("figurka %s moves DOWN from %d %d ",game.getActualFigurine(), game.getActualPlayer().getX(), game.getActualPlayer().getY());
            game.move_player('D');
            GUI.updateGUI();
            System.out.printf("to %d %d\n", game.getActualPlayer().getX(), game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.printf("figurka %s moves UP from %d %d ",game.getActualFigurine(), game.getActualPlayer().getX(), game.getActualPlayer().getY());
            game.move_player('U');
            GUI.updateGUI();
            System.out.printf("to %d %d\n", game.getActualPlayer().getX(), game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.printf("figurka %s moves LEFT from %d %d ",game.getActualFigurine(), game.getActualPlayer().getX(), game.getActualPlayer().getY());
            game.move_player('L');
            GUI.updateGUI();
            System.out.printf("to %d %d\n", game.getActualPlayer().getX(), game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.printf("figurka %s moves RIGHT from %d %d ",game.getActualFigurine(), game.getActualPlayer().getX(), game.getActualPlayer().getY());
            game.move_player('R');
            GUI.updateGUI();
            System.out.printf("to %d %d\n", game.getActualPlayer().getX(), game.getActualPlayer().getY());
        }
    }
    
    public void keyReleased(KeyEvent e){
        //not using
    }    
    
}
