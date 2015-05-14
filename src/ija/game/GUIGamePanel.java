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
    
    
    /**
     * Konstruktor JPanelu se hrou
     * 
     * 
     */
    public GUIGamePanel() {
        int size = GUI.getGame().getMazeBoard().getSize();
        setLayout(new GridLayout(size, size));
        setSize(size*75,size*75);
    }
    /**
     * Vycisti panel se hrou
     */
    public void clear(){
        removeAll();
        revalidate();
        repaint();    
    }
    /**
     * obnovi panel se hrou
     * 
     * 
     */
    public void update(){
        clear();
        initialize(); 
    }
    /**
     * Inicializace herniho panelu podle aktualniho stavu hry.
     * Vysklada jednotlive policka po vrstvach (policko, treasure, hrac).
     * 
     * 
     */
    public void initialize(){
        int size = GUI.getGame().getMazeBoard().getSize();
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                MazeField field = GUI.getGame().getMazeBoard().getMazeField(i,j);

                JLayeredPaneEdited policko = new JLayeredPaneEdited();
                policko.x = i; //ulozime aktualni souradnice policka
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
                ArrayList<Player> players = GUI.getGame().getPlayers();
                ArrayList<Integer> figurine = GUI.getGame().getPlayersFigurine();
                
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
        
        /**
         * Reakce na klik na policko.
         * Policko je typu JLayerPaneEdited = JLayerPane + souradnice X a Y.
         * Po kliknuti dostaneme referenci, z te vytahneme souradnice X a Y a provedeme shift.
         */
        addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            if (!getComponentAt(e.getPoint()).getClass().equals( JLayeredPaneEdited.class)){
               return;
            }
            JLayeredPaneEdited ptr = (JLayeredPaneEdited) getComponentAt(e.getPoint());
            if (ptr == null) {
               return;
            }
            System.out.printf("shift - kliknuto na pole: %d %d\n", ptr.x, ptr.y);
            
            MazeField ptrField = GUI.getGame().getMazeBoard().getMazeField(ptr.x, ptr.y);
            
            GUI.getGame().getMazeBoard().shift(ptrField);
            GUI.getGame().shiftPlayer(ptrField);
            
            GUI.updateGUI();
         }
      });
    }
    
}

