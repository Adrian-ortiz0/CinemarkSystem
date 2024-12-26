package org.example.views;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.example.controllers.AsientosController;
import org.example.controllers.ClientsController;
import org.example.controllers.FacturasController;
import org.example.controllers.FunctionsController;
import org.example.controllers.PDFGenerator;
import org.example.controllers.TiqueteroController;
import org.example.models.Asiento;
import org.example.models.Boleto;
import org.example.models.Cliente;
import org.example.models.FacturaBoleto;
import org.example.models.Funcion;

public class CompraTicket extends javax.swing.JFrame {
    private ArrayList<Asiento> asientos;
    private int idFuncion;
    private String cedula;
    private double total;

    public CompraTicket(ArrayList<Asiento> asientosElegidos, int idFuncion, String cedulaObtenida, double total) {
        this.cedula = cedulaObtenida;
        this.total = total;
        this.asientos = asientosElegidos;
        this.idFuncion = idFuncion;
        initComponents();
        totalLbl.setText(String.valueOf(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comprarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        salirButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        inputMedioPago = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));

        comprarButton.setBackground(new java.awt.Color(51, 51, 51));
        comprarButton.setForeground(new java.awt.Color(255, 255, 255));
        comprarButton.setText("Comprar");
        comprarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cinemark");

        salirButton.setBackground(new java.awt.Color(51, 51, 51));
        salirButton.setForeground(new java.awt.Color(255, 255, 255));
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Metodo de pago:");

        inputMedioPago.setForeground(new java.awt.Color(255, 255, 255));
        inputMedioPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "TARJETA" }));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total:");

        totalLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputMedioPago, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(comprarButton)))
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalLbl))
                .addGap(141, 141, 141)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputMedioPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comprarButton)
                    .addComponent(salirButton))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comprarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarButtonActionPerformed
        Cliente cliente = ClientsController.obtenerClientePorCedula(cedula);
        Funcion funcion = FunctionsController.obtenerFuncionesPorId(idFuncion);

        if (funcion == null) {
            JOptionPane.showMessageDialog(this, "Error: La función no se encontró.");
            return;
        }

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Error: El cliente no se encontró.");
            return;
        }

        String metodoPago = (String) inputMedioPago.getSelectedItem();
        double totalFacturado = 0;
        ArrayList<Boleto> boletosComprados = new ArrayList<>();

        for (Asiento asiento : asientos) {
            if (asiento.getTipo() == null) {
                JOptionPane.showMessageDialog(this, "Error: El tipo de asiento es nulo.");
                return;
            }

            Boleto boleto = new Boleto();
            boleto.setAsientos(asiento);
            boleto.setCliente(cliente);
            boleto.setFuncion(funcion);

            boolean boletoCreado = TiqueteroController.venderBoleto(boleto);
            if (boletoCreado) {
                boletosComprados.add(boleto);

                double precioUnitario = funcion.getSala().getPrecio() + asiento.getTipo().getPrecio();
                double precioConDescuento = cliente.aplicarDescuento(precioUnitario);
                totalFacturado += precioConDescuento;

                boolean actualizado = AsientosController.actualizarAsiento(asiento.getId());
                if (actualizado) {
                    System.out.println("Asiento " + asiento.getId() + " actualizado en la base de datos.");
                    asiento.setOcupado(true);
                } else {
                    System.out.println("Error al actualizar el asiento " + asiento.getId() + " en la base de datos.");
                }
                
                PDFGenerator.generarTicketDeCompra(boleto, precioUnitario, precioConDescuento);
                
            }
        }

        boolean facturaInsertada = FacturasController.insertarFacturasYDetalles(Date.valueOf(LocalDate.now()), cliente.getId(), totalFacturado, metodoPago);
        if (facturaInsertada) {
            JOptionPane.showMessageDialog(this, "Tiquete/s generados con éxito!");
            TiqueteroSystem ts = new TiqueteroSystem();
                ts.setVisible(true);
                dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al generar la factura.");
        }
    }//GEN-LAST:event_comprarButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        TiqueteroSystem ts = new TiqueteroSystem();
        ts.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompraTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompraTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompraTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompraTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comprarButton;
    private javax.swing.JComboBox<String> inputMedioPago;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salirButton;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
