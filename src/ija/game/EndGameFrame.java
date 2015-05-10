/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.game;
import ija.game.player.Player;

/**
 *
 * @author Tom�
 */
public class EndGameFrame extends javax.swing.JFrame {

    /**
     * Creates new form EndGameFrame
     */
    public EndGameFrame(Game game) {
        initComponents();
        int size = game.get_players().size();
        
        if (size>=1){
            Player P1 = (Player) game.get_players().get(0);
            jLabel1.setText("Skore hrace 1:  " + Integer.toString(P1.get_picked_cards()));
        }
        else{
            jLabel1.setText("Hrac 1 nehral");
        }
        
        if (size>=2){
            Player P2 = (Player) game.get_players().get(1);
            jLabel2.setText("Skore hrace 2:  " + Integer.toString(P2.get_picked_cards()));
        }
        else{
            jLabel2.setText("Hrac 2 nehral");
        }

        if (size>=3){
            Player P3 = (Player) game.get_players().get(2);
            jLabel3.setText("Skore hrace 3:  " + Integer.toString(P3.get_picked_cards()));
        }
        else{
            jLabel3.setText("Hrac 3 nehral");
        }
        
        if (size>=4){
            Player P4 = (Player) game.get_players().get(3);
            jLabel4.setText("Skore hrace 4:  " + Integer.toString(P4.get_picked_cards()));
        }
        else{
            jLabel4.setText("Hrac 4 nehral");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("Konec hry");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}