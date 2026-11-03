/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Hxru
 */
public class Ronda extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Ronda.class.getName());

    /**
     * Creates new form Ronda
     */
    public Ronda() {
        initComponents();

        String[] resultados = {"0", "1", "2"};

        cbResultado1.setModel(new javax.swing.DefaultComboBoxModel<>(resultados));
        cbResultado2.setModel(new javax.swing.DefaultComboBoxModel<>(resultados));
        cbResultado3.setModel(new javax.swing.DefaultComboBoxModel<>(resultados));
        cbResultado4.setModel(new javax.swing.DefaultComboBoxModel<>(resultados));

        this.setSize(303, 260);
        this.setLocationRelativeTo(null);

        generarRonda();

        lblRonda.setText("Ronda " + (Principal.numeroRonda + 1));
}
    
    private void generarRonda() {

    ArrayList<String> participantes =
            new ArrayList<>(Jugadores.jugadores);

    int cantidad = participantes.size();

    if (cantidad < 3 || cantidad > 5) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Debes seleccionar entre 3 y 5 jugadores.");
        return;
    }
    
    

    // Mezclar jugadores aleatoriamente
    Collections.shuffle(participantes);

    // Primer enfrentamiento
    lblPlayer1.setText(participantes.get(0));
    lblPlayer2.setText(participantes.get(1));

    // Segundo enfrentamiento
    if (cantidad >= 4) {

        lblPlayer3.setText(participantes.get(2));
        lblPlayer4.setText(participantes.get(3));

        lblPlayer3.setVisible(true);
        lblPlayer4.setVisible(true);

        cbResultado3.setVisible(true);
        cbResultado4.setVisible(true);

    } 
    
    else {
        lblPlayer3.setVisible(false);
        lblPlayer4.setVisible(false);

        cbResultado3.setVisible(false);
        cbResultado4.setVisible(false);
    }

    // Asignar juez cuando corresponda
    if (cantidad % 2 != 0) {
        lblJuez.setText(participantes.get(cantidad - 1));

        lblJuez.setVisible(true);
        jLabel4.setVisible(true);
    } 
    else {
        lblJuez.setVisible(false);
        jLabel4.setVisible(false);
        }
    }

    private void asignarPuntos(String jugador1, String jugador2,
        int puntos1, int puntos2) {

        int indice1 = Jugadores.jugadores.indexOf(jugador1);
        int indice2 = Jugadores.jugadores.indexOf(jugador2);

        if (puntos1 > puntos2) {

            // Victoria del jugador 1
            Principal.puntajes.set(indice1,
                    Principal.puntajes.get(indice1) + 3);

        } else if (puntos2 > puntos1) {

            // Victoria del jugador 2
            Principal.puntajes.set(indice2,
                    Principal.puntajes.get(indice2) + 3);

        } else {

            // Empate: un punto para cada jugador
            Principal.puntajes.set(indice1,
                    Principal.puntajes.get(indice1) + 1);

            Principal.puntajes.set(indice2,
                    Principal.puntajes.get(indice2) + 1);
        }
    }
    
    private void registrarEstadisticas(String jugador1, String jugador2,
        int puntos1, int puntos2) {

        // Buscar los índices de ambos jugadores
        int indice1 = Jugadores.jugadores.indexOf(jugador1);
        int indice2 = Jugadores.jugadores.indexOf(jugador2);

        double winRate1;
        double winRate2;

        // Registrar un enfrentamiento disputado por cada jugador
        Principal.partidasJugadas.set(indice1,
                Principal.partidasJugadas.get(indice1) + 1);

        Principal.partidasJugadas.set(indice2,
                Principal.partidasJugadas.get(indice2) + 1);

        if (puntos1 > puntos2) {

            // Ganó el jugador 1
            Principal.rondasGanadas.set(indice1,
                    Principal.rondasGanadas.get(indice1) + 1);

            winRate1 = 100;

            if (puntos2 == 1) {
                winRate2 = 50;
            } else {
                winRate2 = 0;
            }

        } else if (puntos2 > puntos1) {

            // Ganó el jugador 2
            Principal.rondasGanadas.set(indice2,
                    Principal.rondasGanadas.get(indice2) + 1);

            winRate2 = 100;

            if (puntos1 == 1) {
                winRate1 = 50;
            } else {
                winRate1 = 0;
            }

        } else {

            // Empate: 25% para cada jugador
            winRate1 = 25;
            winRate2 = 25;
        }

        // Acumular Win Rate del jugador 1
        Principal.winRateAcumulado.set(indice1,
                Principal.winRateAcumulado.get(indice1) + winRate1);

        // Acumular Win Rate del jugador 2
        Principal.winRateAcumulado.set(indice2,
                Principal.winRateAcumulado.get(indice2) + winRate2);
    }
    
    private boolean validarResultado(int puntos1, int puntos2) {

        if (puntos1 == 2 && puntos2 == 2) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "No puede existir un empate 2-2 en un mejor de 3."
            );

            return false;
        }

        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPlayer2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblJuez = new javax.swing.JLabel();
        cbResultado1 = new javax.swing.JComboBox<>();
        cbResultado2 = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblPlayer3 = new javax.swing.JLabel();
        cbResultado3 = new javax.swing.JComboBox<>();
        lblRonda = new javax.swing.JLabel();
        lblPlayer4 = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();
        cbResultado4 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPlayer2.setText("player2");

        jLabel4.setText("Juez:");

        lblJuez.setText("judge");

        cbResultado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbResultado1.addActionListener(this::cbResultado1ActionPerformed);

        cbResultado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegistrar.setText("Registrar ronda");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        lblPlayer3.setText("player3");

        cbResultado3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbResultado3.addActionListener(this::cbResultado3ActionPerformed);

        lblRonda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRonda.setText("Ronda 0");

        lblPlayer4.setText("player4");

        lblPlayer1.setText("player1");

        cbResultado4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("v/s");

        jLabel2.setText("v/s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblPlayer1)
                                .addGap(18, 18, 18)
                                .addComponent(cbResultado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPlayer3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblJuez)
                                    .addComponent(cbResultado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPlayer4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPlayer2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbResultado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbResultado4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblRonda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lblRonda)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayer1)
                    .addComponent(lblPlayer2)
                    .addComponent(cbResultado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbResultado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayer3)
                    .addComponent(lblPlayer4)
                    .addComponent(cbResultado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbResultado4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblJuez))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegistrar))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbResultado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResultado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbResultado1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        // Obtener resultados del primer enfrentamiento
        int puntos1 = Integer.parseInt(cbResultado1.getSelectedItem().toString());
        int puntos2 = Integer.parseInt(cbResultado2.getSelectedItem().toString());

        // Validar primer enfrentamiento
        if (!validarResultado(puntos1, puntos2)) {
            return;
        }

        // Preparar segundo enfrentamiento
        int puntos3 = 0;
        int puntos4 = 0;

        boolean segundoDuelo = Jugadores.jugadores.size() >= 4;

        // Obtener resultados del segundo enfrentamiento
        if (segundoDuelo) {

            puntos3 = Integer.parseInt(cbResultado3.getSelectedItem().toString());
            puntos4 = Integer.parseInt(cbResultado4.getSelectedItem().toString());

            if (!validarResultado(puntos3, puntos4)) {
                return;
            }
        }

        // Confirmar registro
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Deseas registrar la Ronda " + (Principal.numeroRonda + 1) + "?",
                "Confirmar ronda",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {

            // Registrar puntos del primer enfrentamiento
            asignarPuntos(
                    lblPlayer1.getText(),
                    lblPlayer2.getText(),
                    puntos1,
                    puntos2
            );
            
            registrarEstadisticas(
            lblPlayer1.getText(),
            lblPlayer2.getText(),
            puntos1,
            puntos2
            );

            // Registrar puntos del segundo enfrentamiento
            if (segundoDuelo) {

                asignarPuntos(
                        lblPlayer3.getText(),
                        lblPlayer4.getText(),
                        puntos3,
                        puntos4
                );
                
                registrarEstadisticas(
                lblPlayer3.getText(),
                lblPlayer4.getText(),
                puntos3,
                puntos4
                );
            }
            
            // Asignar un punto al juez
            if (Jugadores.jugadores.size() % 2 != 0) {

                int indiceJuez = Jugadores.jugadores.indexOf(lblJuez.getText());

                Principal.puntajes.set(indiceJuez,
                        Principal.puntajes.get(indiceJuez) + 1);
            }

            // Aumentar contador de rondas
            Principal.numeroRonda++;

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Ronda " + Principal.numeroRonda
                    + " registrada correctamente."
            );

            // Regresar a Principal
            Principal ventana = new Principal();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cbResultado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResultado3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbResultado3ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal ventana = new Principal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Ronda().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbResultado1;
    private javax.swing.JComboBox<String> cbResultado2;
    private javax.swing.JComboBox<String> cbResultado3;
    private javax.swing.JComboBox<String> cbResultado4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblJuez;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblPlayer3;
    private javax.swing.JLabel lblPlayer4;
    private javax.swing.JLabel lblRonda;
    // End of variables declaration//GEN-END:variables
}
