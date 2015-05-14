/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Vrchní JPanel v hlavním JFramu.
 * Obsahuje 2 tlačítka: Save a Undo
 * a 3 labely (aktualni hrac, jeho poklad a volne policko)
 * 
 * @author Jan Kohut, xkohut08
 * @author Tomas Jurica, xjuric22
 */
public class TopPanel extends javax.swing.JPanel {
    private ImageIcon hiddenIcon;
    /**
     * Creates new form TopPanel
     */
public TopPanel() {
        initComponents();

        jButton1.setFocusable(false);
        jButton2.setFocusable(false);
    }

    /**
     * Metoda aktualizuje obsah TopPanelu
     * 
     */
    public void updatePanel(){
        ImageIcon icon = new ImageIcon(this.getClass().getResource("images/players/"+Integer.toString(GUI.getGame().getActualFigurine())+"Top.png"));
        jLabel2.setIcon(icon);
        
        hiddenIcon = new ImageIcon(this.getClass().getResource("images/treasures/"+Integer.toString(GUI.getGame().getActualPlayer().getCard().getTreasure().get_type()+1)+".png"));
        icon = new ImageIcon(this.getClass().getResource("images/treasures/hidden.png"));
        jLabel1.setIcon(icon);
        
        icon = new ImageIcon(this.getClass().getResource("images/mazes/"+GUI.getGame().getMazeBoard().getFreeCard().getType()+"/"+GUI.getGame().getMazeBoard().getFreeCard().getRotation()+".png"));
        JLabel labelCard = new JLabel(); 
        labelCard.setSize(icon.getIconHeight(),icon.getIconWidth());
        labelCard.setIcon(icon);
        
        jLayeredPane1.removeAll();
        jLayeredPane1.add(labelCard, new Integer(1));
        
        if(GUI.getGame().getMazeBoard().getFreeCard().getTreasure() != null){
            JLabel treasureCard = new JLabel();
            icon = new ImageIcon(this.getClass().getResource("images/treasures/"+Integer.toString(GUI.getGame().getMazeBoard().getFreeCard().getTreasure().get_type()+1)+".png"));
            treasureCard.setSize(icon.getIconHeight(),icon.getIconWidth());
            treasureCard.setIcon(icon);
            jLayeredPane1.add(treasureCard, new Integer(2));
        }
        
        jLabel5.setText("Pocet sebranych karet: " + Integer.toString(GUI.getGame().getActualPlayer().getPickedCards()) + "/" + Integer.toString(GUI.getGame().getCardsNumber()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        setMaximumSize(new java.awt.Dimension(400, 106));
        setMinimumSize(new java.awt.Dimension(400, 106));
        setPreferredSize(new java.awt.Dimension(400, 106));

        jButton1.setText("Save");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("treasure");
        jLabel1.setMinimumSize(new java.awt.Dimension(75, 75));
        jLabel1.setPreferredSize(new java.awt.Dimension(75, 75));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        jLabel2.setText("hrac");
        jLabel2.setMinimumSize(new java.awt.Dimension(75, 75));
        jLabel2.setPreferredSize(new java.awt.Dimension(75, 75));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jButton2.setText("Undo");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel5.setText("jLabel5");

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(75, 75));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(75, 75));
        jLayeredPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLayeredPane1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            File file = Save.createFile();
            if (file != null){
                SaveLoad.serialize(GUI.getGame(), file);
            }
        } catch (IOException ex) {
            Logger.getLogger(TopPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            Game undo_game = GUI.getGame().undoGame();
            if (undo_game != null){
                GUI.setGame(undo_game);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TopPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        GUI.updateGUI();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jLayeredPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MouseClicked
        GUI.getGame().getMazeBoard().getFreeCard().turnRight();
        updatePanel();
    }//GEN-LAST:event_jLayeredPane1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setIcon(hiddenIcon);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        ImageIcon icon = new ImageIcon(this.getClass().getResource("images/treasures/hidden.png"));
        jLabel1.setIcon(icon);
    }//GEN-LAST:event_jLabel1MouseExited

	
        
         
        
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
