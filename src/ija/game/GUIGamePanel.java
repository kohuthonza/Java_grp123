/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;

import static ija.game.GUI.game;
import ija.game.board.MazeField;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import ija.game.player.Player;


/**
 *
 * @author Tomáš
 */
public class GUIGamePanel extends JPanel {
    
    
    
    public GUIGamePanel(Game game) {
        int size = game.getSizeOfGame();
        setLayout(new GridLayout(size, size));
         
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                MazeField field = game.getMazeBoard().get(i,j);

                JLayeredPane policko = new JLayeredPane();
                
                JLabel layerCard = new JLabel();
                ImageIcon icon;
                
                icon = new ImageIcon(this.getClass().getResource("images/mazes/"+field.getCard().get_type()+"/"+Integer.toString(field.getCard().getRotation())+".png"));
                
                
                
                //vvrstva 1 - herni pole
                layerCard.setIcon(icon);
                layerCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                policko.add(layerCard, new Integer(1));
                
                //vrstva 2 - poklady
                if(field.getCard().get_treasure() != null){
                    JLabel treasureCard = new JLabel();
                    icon = new ImageIcon(this.getClass().getResource("images/treasures/"+Integer.toString(field.getCard().get_treasure().get_type()+1)+".png"));
                    treasureCard.setIcon(icon);
                    treasureCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                    
                    policko.add(treasureCard, new Integer(2));
                }
                
     
                
                //vrstva 3 - hraci
                ArrayList<Player> players = game.get_players();
                
                for (int s = 0; s < players.size(); s++) {
                    if(players.get(s).get_x() == i && players.get(s).get_y() == j){
                        JLabel playerCard = new JLabel();
                        if(game.get_players().size() == 2 && s==1){
                            s = 3;
                        }
                        icon = new ImageIcon(this.getClass().getResource("images/players/"+Integer.toString(s+1)+".png"));
                        playerCard.setIcon(icon);
                        playerCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                        policko.add(playerCard, new Integer(3));
                    }
		}
                add(policko);
            }            
        }
    }    
}

