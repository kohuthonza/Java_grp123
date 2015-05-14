/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;

import ija.game.board.MazeField;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import ija.game.player.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Tomáš
 */
public class GUIGamePanel extends JPanel {
    
    
    
    public GUIGamePanel(Game game) {
        int size = game.getMazeBoard().getSize();
        setLayout(new GridLayout(size, size));
        setSize(size*75,size*75);
    }
    public void clear(){
        removeAll();
        revalidate();
        repaint();    
    }
    
    public void update(Game game){
        clear();
        initialize(game); 
    }
    
    public void initialize(Game game){
        int size = game.getMazeBoard().getSize();
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                MazeField field = game.getMazeBoard().getMazeField(i,j);

                JLayeredPaneEdited policko = new JLayeredPaneEdited();
                policko.x = i;
                policko.y = j;
                
                        
                JLabel layerCard = new JLabel();
                ImageIcon icon;
                
                icon = new ImageIcon(this.getClass().getResource("images/mazes/"+field.getCard().getType()+"/"+Integer.toString(field.getCard().getRotation())+".png"));

                //vvrstva 1 - herni pole
                layerCard.setIcon(icon);
                layerCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                policko.add(layerCard, new Integer(1));
                
                //vrstva 2 - poklady
                if(field.getCard().getTreasure() != null){
                    JLabel treasureCard = new JLabel();
                    icon = new ImageIcon(this.getClass().getResource("images/treasures/"+Integer.toString(field.getCard().getTreasure().get_type()+1)+".png"));
                    treasureCard.setIcon(icon);
                    treasureCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                    
                    policko.add(treasureCard, new Integer(2));
                }
                

                //vrstva 3 - hraci
                ArrayList<Player> players = game.getPlayers();
                ArrayList<Integer> figurine = game.getPlayersFigurine();
                
                for (int s = 0; s < players.size(); s++) {
                    if(players.get(s).getY() == i && players.get(s).getX() == j){
                        JLabel playerCard = new JLabel();
                        icon = new ImageIcon(this.getClass().getResource("images/players/"+Integer.toString(figurine.get(s))+".png"));
                        playerCard.setIcon(icon);
                        playerCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                        policko.add(playerCard, new Integer(3));
                    }
		}
                add(policko);
            }            
        }
        
        addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            if (!getComponentAt(e.getPoint()).getClass().equals( JLayeredPaneEdited.class)){
               //System.out.println(String.valueOf(getComponentAt(e.getPoint()).getClass()));
                return;
            }
            JLayeredPaneEdited ptr = (JLayeredPaneEdited) getComponentAt(e.getPoint());
            if (ptr == null) {
               return;
            }
            System.out.printf("shift - kliknuto na pole: %d %d\n", ptr.x, ptr.y);
            
            MazeField ptrField = game.getMazeBoard().getMazeField(ptr.x, ptr.y);
            
            game.getMazeBoard().shift(ptrField);
            game.shiftPlayer(ptrField);
            
            GUI.updateGUI();
         }
      });
    }
    
}

