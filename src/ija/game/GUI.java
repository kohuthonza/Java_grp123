
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
        
        this.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                
                topPanel.updatePanel();
                gamePanel.update(game);
                
            } 
        });
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        
        topPanel = new TopPanel(game);
        add(topPanel);              
        gamePanel = new GUIGamePanel(game);
        add(gamePanel);
                  
           
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((game.getMazeBoard().getSize() * 75 > 400)? game.getMazeBoard().getSize() * 75 : 400, game.getMazeBoard().getSize() * 75 + 146);
        
        JButton showDialogButton = new JButton("Update");
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                topPanel.updatePanel();
                gamePanel.update(game);
            }
        });
        add(showDialogButton);

        setLocationRelativeTo(null);
        setTitle("Labyrinth - grp123");
        setResizable(true);
        setVisible(true);

    }
    
    public void mouseClicked(){
                        topPanel.updatePanel();
                gamePanel.update(game);
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
            

            topPanel.updatePanel();
            gamePanel.update(game);
            System.out.println("Next player");          
                
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {   
            System.out.printf("figurka %s moves DOWN from %d %d ",game.getActualFigurine(), game.getActualPlayer().getX(), game.getActualPlayer().getY());
            game.move_player('D');
            gamePanel.update(game);
            topPanel.updatePanel();
            System.out.printf("to %d %d\n", game.getActualPlayer().getX(), game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.printf("figurka %s moves UP from %d %d ",game.getActualFigurine(), game.getActualPlayer().getX(), game.getActualPlayer().getY());
            game.move_player('U');
            gamePanel.update(game);
            topPanel.updatePanel();
            System.out.printf("to %d %d\n", game.getActualPlayer().getX(), game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.printf("figurka %s moves LEFT from %d %d ",game.getActualFigurine(), game.getActualPlayer().getX(), game.getActualPlayer().getY());
            game.move_player('L');
            gamePanel.update(game);
            topPanel.updatePanel();
            System.out.printf("to %d %d\n", game.getActualPlayer().getX(), game.getActualPlayer().getY());
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.printf("figurka %s moves RIGHT from %d %d ",game.getActualFigurine(), game.getActualPlayer().getX(), game.getActualPlayer().getY());
            game.move_player('R');
            gamePanel.update(game);
            topPanel.updatePanel();
            System.out.printf("to %d %d\n", game.getActualPlayer().getX(), game.getActualPlayer().getY());
        }
    }
    
    public void keyReleased(KeyEvent e){
        //not using
    }    
    
}
