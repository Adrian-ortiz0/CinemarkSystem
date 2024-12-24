package org.example.views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.example.controllers.ClientsController;
import org.example.controllers.CombosController;
import org.example.models.Cliente;
import org.example.models.Combo;
import org.example.models.MateriaPrima;
import org.example.models.Producto;


public class ComprarCombos extends javax.swing.JFrame {
    private ArrayList<Combo> combos;
    private ArrayList<Producto> productos;
    private String cedulaCliente;
    private double total;
    
    public ComprarCombos(ArrayList<Combo> combosSeleccionados, ArrayList<Producto> productosSeleccionados, String cedula, double totalFacturado) {
        this.cedulaCliente = cedula;
        initComponents();
        totalLbl.setText(String.valueOf(totalFacturado));
        this.combos = combosSeleccionados;
        this.productos = productosSeleccionados;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputMedioDePago = new javax.swing.JComboBox<>();
        comprarButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        totalLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Metodo de Pago:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cinemark");

        inputMedioDePago.setBackground(new java.awt.Color(51, 51, 51));
        inputMedioDePago.setForeground(new java.awt.Color(255, 255, 255));
        inputMedioDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "TARJETA" }));

        comprarButton.setBackground(new java.awt.Color(51, 51, 51));
        comprarButton.setForeground(new java.awt.Color(255, 255, 255));
        comprarButton.setText("Comprar");
        comprarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarButtonActionPerformed(evt);
            }
        });

        salirButton.setBackground(new java.awt.Color(51, 51, 51));
        salirButton.setForeground(new java.awt.Color(255, 255, 255));
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        totalLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(255, 255, 255));
        totalLbl.setText("Total:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(salirButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(comprarButton)
                .addGap(180, 180, 180))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputMedioDePago, 0, 195, Short.MAX_VALUE)
                    .addComponent(totalLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLbl)
                    .addComponent(jLabel7))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputMedioDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comprarButton)
                    .addComponent(salirButton))
                .addGap(59, 59, 59))
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
        
        Cliente cliente = ClientsController.obtenerClientePorCedula(cedulaCliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            return;
        }

        double totalFacturado = 0;

        for (Combo combo : combos) {
            totalFacturado += combo.getPrecioTotal();
            List<Producto> productosCombo = combo.getProductos();
            if (productosCombo != null) {
                for (Producto producto : productosCombo) {
                    ArrayList<MateriaPrima> materiasPrimas = CombosController.obtenerMateriasPrimasProducto(producto.getId());
                    for (MateriaPrima mp : materiasPrimas) {
                        boolean actualizado = CombosController.actualizarInventario(mp.getId(), mp.getCantidad());
                        if (!actualizado) {
                            JOptionPane.showMessageDialog(this, "Error al actualizar inventario para producto: " + producto.getNombre());
                            return;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "El combo seleccionado no tiene productos asociados.");
                return;
            }
        }

        for (Producto producto : productos) {
            totalFacturado += producto.getPrecio();
            ArrayList<MateriaPrima> materiasPrimas = CombosController.obtenerMateriasPrimasProducto(producto.getId());
            for (MateriaPrima mp : materiasPrimas) {
                boolean actualizado = CombosController.actualizarInventario(mp.getId(), mp.getCantidad());
                if (!actualizado) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar inventario para producto: " + producto.getNombre());
                    return;
                }
            }
        }

        int idCompra = CombosController.insertarCompra(cliente.getId(), totalFacturado, (String) inputMedioDePago.getSelectedItem());

        if (idCompra <= 0) {
            JOptionPane.showMessageDialog(this, "Error al registrar la compra.");
            return;
        }

        for (Combo combo : combos) {
            boolean detalleInsertado = CombosController.insertarDetalleCompra(idCompra, combo.getId(), null, 1, combo.getPrecioTotal());
            if (!detalleInsertado) {
                JOptionPane.showMessageDialog(this, "Error al registrar detalles del combo.");
            }
        }

        for (Producto producto : productos) {
            boolean detalleInsertado = CombosController.insertarDetalleCompra(idCompra, null, producto.getId(), 1, producto.getPrecio());
            if (!detalleInsertado) {
                JOptionPane.showMessageDialog(this, "Error al registrar detalles del producto.");
            }
        }

        JOptionPane.showMessageDialog(this, "Compra realizada con éxito!");
        inputMedioDePago.setSelectedIndex(0);
    }//GEN-LAST:event_comprarButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        VenderCombos vc = new VenderCombos(cedulaCliente);
        vc.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_salirButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comprarButton;
    private javax.swing.JComboBox<String> inputMedioDePago;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JButton salirButton;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
