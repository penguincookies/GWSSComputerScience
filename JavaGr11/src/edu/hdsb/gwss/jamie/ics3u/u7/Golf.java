/*
 * Author: Jamie
 * Date: June 25, 2020
 * Version: v1.1
 * Description: This program will take up to 18 golf scores and print the 
 * maximum, minimum, and the total of the scores
 */
package edu.hdsb.gwss.jamie.ics3u.u7;

/**
 *
 * @author revit
 */
public class Golf extends javax.swing.JFrame {
    int[] golfScores = new int [ 18 ];
    int counter = 0;
    int max, min, total = 0;
    boolean done = false;
    /**
     * Creates new form NewJFrame
     */
    public Golf() {
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

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        score = new javax.swing.JTextField();
        instructions = new javax.swing.JLabel();
        addScore = new javax.swing.JButton();
        displayScore = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultScreen = new javax.swing.JTextArea();
        resultTally = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stats = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(13, 181, 26));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText("Golf Scores");

        description.setText("This program records the scores for a round of 18 holes of golf.");

        score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreActionPerformed(evt);
            }
        });

        instructions.setText("Enter the score for hole #1");

        addScore.setText("Add score to array");
        addScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addScoreActionPerformed(evt);
            }
        });

        displayScore.setText("Display Golf Scores");
        displayScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayScoreActionPerformed(evt);
            }
        });

        resultScreen.setEditable(false);
        resultScreen.setBackground(new java.awt.Color(13, 181, 26));
        resultScreen.setColumns(20);
        resultScreen.setRows(5);
        jScrollPane1.setViewportView(resultScreen);

        resultTally.setText("Results Here");

        stats.setBackground(new java.awt.Color(13, 181, 26));
        stats.setColumns(20);
        stats.setRows(5);
        jScrollPane2.setViewportView(stats);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(description))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(instructions, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addScore))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displayScore)
                            .addComponent(resultTally, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(description)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instructions)
                    .addComponent(addScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayScore)
                .addGap(18, 18, 18)
                .addComponent(resultTally)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreActionPerformed

    private void addScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addScoreActionPerformed
        if ( counter < 18 ){
            golfScores[counter] = Integer.parseInt(score.getText());
            counter++;
            score.setText("");
            if (counter < 18){
                instructions.setText ("Enter the score for hole #" + (counter+1));
            }
            else {
                instructions.setText ("Stop inputting more holes.");
            }
        }
        
    }//GEN-LAST:event_addScoreActionPerformed

    private void displayScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayScoreActionPerformed
        if (!done){
            resultTally.setText("Number of golf scores entered: " + counter);
            for (int i = 0; i < counter; i++) {
                if ( i < 9 ){
                    resultScreen.append("Hole " + (i+1) + ":      " + golfScores[i] + "\n");
                }
                else {
                    resultScreen.append("Hole " + (i+1) + ":    " + golfScores[i] + "\n");
                }
            }
            done = true;
            
            max = golfScores[0];
            min = golfScores[0];
            
            for (int i = 1; i < counter; i++) {
                if ( golfScores[i] > max ){
                    max = golfScores[i];
                }
            }
            for (int i = 1; i < counter; i++) {
                if ( golfScores[i] < min ){
                    min = golfScores[i];
                }
                System.out.println(golfScores[i]);
            }
            for (int i = 0; i < golfScores.length; i++) {
                total += golfScores[i];
            }
            
            stats.append("Total: " + total + "\n");
            stats.append("Highest Score: " + max + "\n");
            stats.append("Lowest Score: " + min );
        }
    }//GEN-LAST:event_displayScoreActionPerformed

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
            java.util.logging.Logger.getLogger(Golf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Golf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Golf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Golf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Golf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addScore;
    private javax.swing.JLabel description;
    private javax.swing.JButton displayScore;
    private javax.swing.JLabel instructions;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea resultScreen;
    private javax.swing.JLabel resultTally;
    private javax.swing.JTextField score;
    private javax.swing.JTextArea stats;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
