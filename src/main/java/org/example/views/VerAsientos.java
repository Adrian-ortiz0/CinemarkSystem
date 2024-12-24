package org.example.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.example.controllers.AsientosController;
import org.example.controllers.FunctionsController;
import org.example.models.Asiento;
import org.example.models.Funcion;

public class VerAsientos extends javax.swing.JFrame {
    private int idFuncion;
    private ArrayList<Asiento> asientos;
    private ArrayList<Asiento> asientosSeleccionados = new ArrayList<>();
    private String cedula;
    private double total = 0;
    public VerAsientos(int idFuncion, String cedulaObtenida) {
        this.cedula = cedulaObtenida;
        this.idFuncion = idFuncion;
        initComponents();
        this.setSize(800, 800);
        asientosPanel.setVisible(true);
        cargarAsientosPorFuncion();
    }
    
    private void cargarAsientosPorFuncion() {
        asientos = FunctionsController.obtenerAsientosPorFuncion(idFuncion);
        System.out.println("Número de asientos: " + asientos.size());
        cargarAsientos();
    }
    
    private void cargarAsientos() {
        asientosPanel.removeAll();
    
        JPanel contenedorPrincipal = new JPanel();
        contenedorPrincipal.setLayout(new BorderLayout(0, 20));

        JLabel pantallaLabel = new JLabel("Pantalla", SwingConstants.CENTER);
        pantallaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        pantallaLabel.setForeground(Color.BLUE); 
        contenedorPrincipal.add(pantallaLabel, BorderLayout.NORTH);

        JPanel contenedorAsientos = new JPanel();
        contenedorAsientos.setLayout(new BorderLayout());
        contenedorPrincipal.add(contenedorAsientos, BorderLayout.CENTER);

        JPanel panelRelleno = new JPanel();
        panelRelleno.setPreferredSize(new Dimension(0, 50)); 
        contenedorAsientos.add(panelRelleno, BorderLayout.NORTH);

        JPanel gridAsientosPanel = new JPanel();
        int numColumnas = 10; 
        int numFilas = (int) Math.ceil(asientos.size() / (double) numColumnas);
        gridAsientosPanel.setLayout(new GridLayout(numFilas, numColumnas, 5, 5));

        for (int i = 0; i < asientos.size(); i++) {
        Asiento asiento = asientos.get(i);
        JButton asientoButton = new JButton(asiento.getFila() + asiento.getNumero());
        asientoButton.setPreferredSize(new Dimension(50, 50));
        asientoButton.setMinimumSize(new Dimension(50, 50));
        asientoButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        if (asiento.isOcupado()) {
            asientoButton.setBackground(Color.RED);
            asientoButton.setEnabled(false);
        } else {
            asientoButton.setBackground(Color.GREEN);
        }

        asientoButton.addActionListener(e -> {
            if (!asiento.isOcupado()) {
                if (asientosSeleccionados.contains(asiento)) {
                    asientosSeleccionados.remove(asiento);
                    asiento.setOcupado(false);
                    asientoButton.setBackground(Color.GREEN);
                } else {
                    asientosSeleccionados.add(asiento);
                    asiento.setOcupado(true);
                    total += asiento.getTipo().getPrecio();
                    asientoButton.setBackground(Color.YELLOW);
                }
                FunctionsController.actualizarEstadoAsiento(idFuncion, asiento.getId(), asiento.isOcupado());
                cargarAsientos();
            } else {
                JOptionPane.showMessageDialog(this, "El asiento no está disponible.");
            }
        });

        gridAsientosPanel.add(asientoButton);
    }


        contenedorAsientos.add(gridAsientosPanel, BorderLayout.CENTER);

        asientosPanel.setLayout(new BorderLayout());
        asientosPanel.add(contenedorPrincipal, BorderLayout.CENTER);

        asientosPanel.revalidate();
        asientosPanel.repaint();

        System.out.println("Panel size: " + asientosPanel.getSize());
        System.out.println("Panel visible: " + asientosPanel.isVisible());
        System.out.println("Asientos seleccionados: " + asientosSeleccionados);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        asientosPanel = new javax.swing.JPanel();
        salirButton = new javax.swing.JButton();
        siguienteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(11, 11, 11));

        asientosPanel.setBackground(new java.awt.Color(31, 31, 31));

        javax.swing.GroupLayout asientosPanelLayout = new javax.swing.GroupLayout(asientosPanel);
        asientosPanel.setLayout(asientosPanelLayout);
        asientosPanelLayout.setHorizontalGroup(
            asientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        asientosPanelLayout.setVerticalGroup(
            asientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        salirButton.setBackground(new java.awt.Color(51, 51, 51));
        salirButton.setForeground(new java.awt.Color(255, 255, 255));
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        siguienteButton.setBackground(new java.awt.Color(51, 51, 51));
        siguienteButton.setForeground(new java.awt.Color(255, 255, 255));
        siguienteButton.setText("Siguiente");
        siguienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(asientosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(salirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(siguienteButton)))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton)
                    .addComponent(siguienteButton))
                .addGap(33, 33, 33)
                .addComponent(asientosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(722, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteButtonActionPerformed
         if (asientosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar al menos un asiento para continuar!");
        } else {
            CompraTicket ct = new CompraTicket(asientosSeleccionados, idFuncion, cedula, total);
            ct.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_siguienteButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        TiqueteroSystem ts = new TiqueteroSystem();
        ts.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel asientosPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton siguienteButton;
    // End of variables declaration//GEN-END:variables
}
