package org.example.views;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.example.controllers.InventaryController;
import org.example.models.MateriaPrima;

public class OrderProductsSystem extends javax.swing.JFrame {
    DefaultTableModel mt = new DefaultTableModel();
    public OrderProductsSystem() {
        initComponents();
        String [] columnas = {"Producto", "Cantidad", "CantidadMinima", "NombreEmpresa", "PrecioUnitario"};
        mt.setColumnIdentifiers(columnas);
        ArrayList<MateriaPrima> materiaPrimaCasiAgotada = InventaryController.mostrarProductosCasiAgotados();
        for(MateriaPrima mp : materiaPrimaCasiAgotada){
            Object[] fila = {
                mp.getNombre(),
                mp.getCantidad(),
                mp.getCantidadMinima(),
                mp.getProveedor().getNombreEmpresa(),
                mp.getPrecioPorUnidad()
            };
            mt.addRow(fila);
        }
        tablaInventarioAgotado.setModel(mt);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventarioAgotado = new javax.swing.JTable();
        reOrdenarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(235, 235, 235));
        jLabel6.setText("Cinemark Inventario General");

        tablaInventarioAgotado.setBackground(new java.awt.Color(51, 51, 51));
        tablaInventarioAgotado.setForeground(new java.awt.Color(255, 255, 255));
        tablaInventarioAgotado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tablaInventarioAgotado.setGridColor(new java.awt.Color(51, 51, 51));
        tablaInventarioAgotado.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tablaInventarioAgotado.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablaInventarioAgotado);

        reOrdenarButton.setText("Ordenar productos");
        reOrdenarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reOrdenarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(reOrdenarButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(reOrdenarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
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
    
    private void reOrdenarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reOrdenarButtonActionPerformed
        boolean resultado = InventaryController.reabastecerAutomaticamente();
            if (resultado) {
            mt.setRowCount(0);
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Productos reabastecidos exitosamente", 
                    "Reabastecimiento", 
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "No hay productos para reabastecer", 
                    "Reabastecimiento", 
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_reOrdenarButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderProductsSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reOrdenarButton;
    private javax.swing.JTable tablaInventarioAgotado;
    // End of variables declaration//GEN-END:variables
}
