/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import java.util.ArrayList;

/**
 *
 * @author Hxru
 */
public class Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    /**
     * Creates new form Principal1
     */
    public Principal() {
        initComponents();
        this.setSize(395, 380);
        this.setLocationRelativeTo(null);
        if (numeroRonda == 0) {
            mostrarJugadores();
        } else {
            mostrarUltimaRonda();
        }
    }
    
    private void mostrarJugadores() {

    txtDatos.setEditable(false);
    txtDatos.setText("");

    txtDatos.append("=== JUGADORES INSCRITOS ===\n\n");

    for (int i = 0; i < Jugadores.jugadores.size(); i++) {
        txtDatos.append((i + 1) + ". "
                + Jugadores.jugadores.get(i) + "\n");
        }
    }
    
    private void mostrarStanding() {

        txtDatos.setText("");
        txtDatos.append("=== STANDING DEL TORNEO ===\n\n");

        ArrayList<String> nombres = new ArrayList<>(Jugadores.jugadores);
        ArrayList<Integer> puntos = new ArrayList<>(Principal.puntajes);

        // Ordenar jugadores de mayor a menor puntaje
        for (int i = 0; i < puntos.size() - 1; i++) {

            for (int j = i + 1; j < puntos.size(); j++) {

                if (puntos.get(j) > puntos.get(i)) {

                    // Intercambiar puntajes
                    int auxiliarPuntos = puntos.get(i);
                    puntos.set(i, puntos.get(j));
                    puntos.set(j, auxiliarPuntos);

                    // Intercambiar nombres
                    String auxiliarNombre = nombres.get(i);
                    nombres.set(i, nombres.get(j));
                    nombres.set(j, auxiliarNombre);
                }
            }
        }

    // Mostrar Standing
    for (int i = 0; i < nombres.size(); i++) {

        txtDatos.append(
                (i + 1) + ". " +
                nombres.get(i) + " - " +
                puntos.get(i) + " puntos\n"
            );
        }
    }
    
    private void mostrarEstadisticas() {

    txtDatos.setText("");
    txtDatos.append("=== ESTADÍSTICAS DEL TORNEO ===\n\n");
    
    // Mostrar total de rondas registradas
    txtDatos.append("Total de rondas jugadas: " + numeroRonda + "\n");
    txtDatos.append("============================\n\n");

    for (int i = 0; i < Jugadores.jugadores.size(); i++) {

        double winRate = 0.0;

        if (partidasJugadas.get(i) > 0) {
            winRate = (rondasGanadas.get(i) * 100.0)
                    / partidasJugadas.get(i);
        }

        // Mostrar información del jugador
        txtDatos.append("Jugador: " + Jugadores.jugadores.get(i) + "\n");
        txtDatos.append("Puntaje: " + puntajes.get(i) + "\n");
        txtDatos.append("Rondas ganadas: " + rondasGanadas.get(i) + "\n");
        txtDatos.append("Win Rate: " + String.format("%.2f", winRate) + "%\n");
        txtDatos.append("----------------------------\n\n");
        }
    }
    
    private void mostrarUltimaRonda() {

    txtDatos.setText(ultimoResultado);
    }
    
    private void finalizarTorneo() {

    // Verificar que existan rondas registradas
    if (numeroRonda == 0) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Debes registrar al menos una ronda antes de finalizar."
        );

        return;
    }

    // Crear lista de índices de jugadores
    ArrayList<Integer> posiciones = new ArrayList<>();

    for (int i = 0; i < Jugadores.jugadores.size(); i++) {
        posiciones.add(i);
    }

    // Ordenar por puntaje y luego por Win Rate
    for (int i = 0; i < posiciones.size() - 1; i++) {

        for (int j = i + 1; j < posiciones.size(); j++) {

            int indice1 = posiciones.get(i);
            int indice2 = posiciones.get(j);

            double winRate1 = 0.0;
            double winRate2 = 0.0;

            if (partidasJugadas.get(indice1) > 0) {
                winRate1 = (rondasGanadas.get(indice1) * 100.0)
                        / partidasJugadas.get(indice1);
            }

            if (partidasJugadas.get(indice2) > 0) {
                winRate2 = (rondasGanadas.get(indice2) * 100.0)
                        / partidasJugadas.get(indice2);
            }

            // Comparar primero puntaje y luego Win Rate
            if (puntajes.get(indice2) > puntajes.get(indice1)
                    || (puntajes.get(indice2).equals(puntajes.get(indice1))
                    && winRate2 > winRate1)) {

                int auxiliar = posiciones.get(i);
                posiciones.set(i, posiciones.get(j));
                posiciones.set(j, auxiliar);
            }
        }
    }
    
    // Construir mensaje del podio
    String mensaje = "=== PODIO DEL TORNEO TEMPLARIO ===\n\n";

    String[] medallas = {"CAMPEÓN", "SUBCAMPEÓN", "TERCER LUGAR"};

    for (int i = 0; i < 3; i++) {

        int indice = posiciones.get(i);

        double winRate = 0.0;

        if (partidasJugadas.get(indice) > 0) {
            winRate = (rondasGanadas.get(indice) * 100.0)
                    / partidasJugadas.get(indice);
        }

        mensaje += (i + 1) + "° LUGAR - " + medallas[i] + "\n";
        mensaje += Jugadores.jugadores.get(indice) + "\n";
        mensaje += "Puntaje: " + puntajes.get(indice) + "\n";
        mensaje += "Win Rate: "
                + String.format("%.2f", winRate) + "%\n\n";
        }

        // Mostrar resultados finales
        javax.swing.JOptionPane.showMessageDialog(
            this,
            mensaje,
            "Resultados finales - Torneo Templario",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
        // Cerrar completamente la aplicación
        System.exit(0);
    }
    
    public static int numeroRonda = 0;
    public static String ultimoResultado = "";
    
    public static ArrayList<Integer> puntajes = new ArrayList<>();
    
    public static ArrayList<Integer> rondasGanadas = new ArrayList<>();
    public static ArrayList<Double> winRateAcumulado = new ArrayList<>();
    public static ArrayList<Integer> partidasJugadas = new ArrayList<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDatos = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevaRonda = new javax.swing.JButton();
        btnStanding = new javax.swing.JButton();
        btnEstadisticas = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        txtDatos.setColumns(20);
        txtDatos.setRows(5);
        jScrollPane2.setViewportView(txtDatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Torneos Templario 🗡🛡");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnNuevaRonda.setBackground(new java.awt.Color(0, 204, 0));
        btnNuevaRonda.setText("Nueva ronda");
        btnNuevaRonda.addActionListener(this::btnNuevaRondaActionPerformed);

        btnStanding.setText("Standing");
        btnStanding.addActionListener(this::btnStandingActionPerformed);

        btnEstadisticas.setText("Estadísticas");
        btnEstadisticas.addActionListener(this::btnEstadisticasActionPerformed);

        btnFinalizar.setBackground(new java.awt.Color(204, 0, 0));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(this::btnFinalizarActionPerformed);

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("@Hxru - 2026 - ver 1.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevaRonda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStanding)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEstadisticas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFinalizar)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaRonda)
                    .addComponent(btnStanding)
                    .addComponent(btnEstadisticas)
                    .addComponent(btnFinalizar))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaRondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaRondaActionPerformed
        // TODO add your handling code here:
        Ronda ventana = new Ronda();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnNuevaRondaActionPerformed

    private void btnStandingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStandingActionPerformed
        // TODO add your handling code here:
        mostrarStanding();
    }//GEN-LAST:event_btnStandingActionPerformed

    private void btnEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasActionPerformed
        // TODO add your handling code here:
        mostrarEstadisticas();
    }//GEN-LAST:event_btnEstadisticasActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        finalizarTorneo();
    }//GEN-LAST:event_btnFinalizarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEstadisticas;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnNuevaRonda;
    private javax.swing.JButton btnStanding;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtDatos;
    // End of variables declaration//GEN-END:variables

   
}
