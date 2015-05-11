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
        
        jLabel5.setText("Hrac cislo "+ Integer.toString(game.get_actual_player_n()) +" zvitezil!");
        
        if (size>=1){
            Player P1 = (Player) game.get_players().get(0);
            jLabel1.setText("Skore hrace 1:  " + Integer.toString(P1.get_picked_cards()));
        }
        else{
            jLabel1.setText("");
        }
        
        if (size>=2){
            Player P2 = (Player) game.get_players().get(1);
            jLabel2.setText("Skore hrace 2:  " + Integer.toString(P2.get_picked_cards()));
        }
        else{
            jLabel2.setText("");
        }

        if (size>=3){
            Player P3 = (Player) game.get_players().get(2);
            jLabel3.setText("Skore hrace 3:  " + Integer.toString(P3.get_picked_cards()));
        }
        else{
            jLabel3.setText("");
        }
        
        if (size>=4){
            Player P4 = (Player) game.get_players().get(3);
            jLabel4.setText("Skore hrace 4:  " + Integer.toString(P4.get_picked_cards()));
        }
        else{
            jLabel4.setText("");
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

        jLabel1.setText("Hrac 1 nehral");

        jLabel2.setText("Hrac 2 nehral");

        jLabel3.setText("Hrac 3 nehral");

        jLabel4.setText("Hrac 4 nehral");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Konec hry");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 176, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(28, Short.MAX_VALUE))
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
