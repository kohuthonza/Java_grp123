/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomáš
 */
public class GUImenu extends javax.swing.JFrame {

    /**
     * Creates new form GUImenu
     */
    public GUImenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(320, 290));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Projekt IJA 2015 - xkohut08, xjuric22");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("2 hráči");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("3 hráči");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("4 hráči");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });

        jLabel2.setText("Počet hráčů:");

        jLabel3.setText("Velikost pole:");

        jButton1.setText("New Game");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Load Game");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("7x7");
        jRadioButton4.setEnabled(false);
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("5x5");
        jRadioButton5.setEnabled(false);
        jRadioButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton5MouseClicked(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("3x3");
        jRadioButton6.setEnabled(false);
        jRadioButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton6MouseClicked(evt);
            }
        });

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("9x9");
        jRadioButton7.setEnabled(false);
        jRadioButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton7MouseClicked(evt);
            }
        });

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("11x11");
        jRadioButton8.setEnabled(false);
        jRadioButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton8MouseClicked(evt);
            }
        });

        jLabel4.setText("Počet karet:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jRadioButton5)
                                    .addComponent(jRadioButton6)
                                    .addComponent(jLabel3)
                                    .addComponent(jRadioButton7)
                                    .addComponent(jRadioButton8))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        int numPlayers = 0;
        int numFields = 0;
        
        if(jRadioButton1.isSelected()){
            numPlayers = 2;
        }
        else if(jRadioButton2.isSelected()){
            numPlayers = 3;    
        }
        else if(jRadioButton3.isSelected()){
            numPlayers = 4;    
        }
        
        if(jRadioButton6.isSelected()){
            numFields = 3;
        }
        else if(jRadioButton5.isSelected()){
            numFields = 5;    
        }
        else if(jRadioButton4.isSelected()){
            numFields = 7;    
        }
        else if(jRadioButton7.isSelected()){
            numFields = 9;    
        }
        else if(jRadioButton8.isSelected()){
            numFields = 11;    
        }        
            
        
        
        try {
            GUI frame = new GUI(numPlayers, numFields, new Integer(1), null);
        } catch (IOException ex) {
            Logger.getLogger(GUImenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        jRadioButton6.setEnabled(true);
        jRadioButton5.setEnabled(true);
        jRadioButton4.setEnabled(true);
        jRadioButton7.setEnabled(true);
        jRadioButton8.setEnabled(true);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        jRadioButton6.setEnabled(true);
        jRadioButton5.setEnabled(true);
        jRadioButton4.setEnabled(true);
        jRadioButton7.setEnabled(true);
        jRadioButton8.setEnabled(true); 
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        jRadioButton5.setEnabled(true);
        jRadioButton4.setEnabled(true);
        jRadioButton7.setEnabled(true);
        jRadioButton8.setEnabled(true);
        
        if(jRadioButton6.isSelected()){
            jRadioButton6.setSelected(false);
            jButton1.setEnabled(false);           
        }
        jRadioButton6.setEnabled(false);
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton8MouseClicked
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton8MouseClicked

    private void jRadioButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton7MouseClicked
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton7MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton4MouseClicked

    private void jRadioButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton5MouseClicked
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton5MouseClicked

    private void jRadioButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton6MouseClicked
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton6MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            File file = Load.chooseFile();
            if (file != null){
                GUI frame = new GUI(0,0,0,(Game)SaveLoad.deserialize(file));
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GUImenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUImenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUImenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUImenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUImenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUImenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
