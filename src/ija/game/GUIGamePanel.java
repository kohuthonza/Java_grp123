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
                ImageIcon icon = null;

                switch (field.getCard().get_type()) {
                    case "C":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/C0.png"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/C90.png"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/C180.png"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/C270.png"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/C0.png"));
                                break;
                        }
                        break;
                    case "F":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/F0.png"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/F90.png"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/F180.png"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/F270.png"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/F0.png"));
                                break;
                        }
                        break;
                    case "L":
                        switch(field.getCard().getRotation()) {
                            case 0: 
                                icon = new ImageIcon(this.getClass().getResource("images/L0.png"));
                                break;
                            case 90: 
                                icon = new ImageIcon(this.getClass().getResource("images/L90.png"));
                                break;
                            case 180: 
                                icon = new ImageIcon(this.getClass().getResource("images/L0.png"));
                                break;
                            case 270: 
                                icon = new ImageIcon(this.getClass().getResource("images/L90.png"));
                                break;
                            default:
                                icon = new ImageIcon(this.getClass().getResource("images/L0.png"));
                                break;
                        }
                        break;
                }
                
                //vvrstva 1 - herni pole
                layerCard.setIcon(icon);
                layerCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                policko.add(layerCard, new Integer(1));
                
                //vrstva 2 - poklady
                if(field.getCard().get_treasure() != null){
                    JLabel treasureCard = new JLabel();
                    icon = new ImageIcon(this.getClass().getResource("images/bone.png"));
                    treasureCard.setIcon(icon);
                    treasureCard.setSize(icon.getIconHeight(),icon.getIconWidth());
                    
                    policko.add(treasureCard, new Integer(2));
                }
                
                //vrstva 3 - hraci
                for (int s = 0; s < game.players.size(); s++) {
                    if(game.players.get(s).get_x() == i && game.players.get(s).get_y() == j){
                        JLabel playerCard = new JLabel();
                        if(game.players.size() == 2 && s==1){
                            s = 3;
                        }
                        switch (s){
                            case 0:
                                icon = new ImageIcon(this.getClass().getResource("images/Player1.png"));
                                break;
                            case 1:
                                icon = new ImageIcon(this.getClass().getResource("images/Player2.png"));
                                break;
                            case 2:
                                icon = new ImageIcon(this.getClass().getResource("images/Player3.png"));
                                break;
                            case 3:
                                icon = new ImageIcon(this.getClass().getResource("images/Player4.png"));
                                break;                                                               
                        }
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


