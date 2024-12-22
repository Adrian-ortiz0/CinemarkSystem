package org.example.views;

import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import org.example.controllers.CombosController;
import org.example.models.Combo;
import org.example.models.Producto;

public class VenderCombos extends javax.swing.JFrame {
    DefaultTableModel mt = new DefaultTableModel();
    DefaultTableModel mtp = new DefaultTableModel();
    public VenderCombos() {
        initComponents();
        String[] columnasTabla = {"ID", "Combo", "Precio", "Seleccionar"};
        mt.setColumnIdentifiers(columnasTabla);
        ArrayList<Combo> listaDeCombos = CombosController.obtenerCombos();
        for (Combo combo : listaDeCombos) {
            Object[] filaTabla = {
                combo.getId(),            
                combo.getNombre(),     
                combo.getPrecioTotal(),     
                false                       
            };
            mt.addRow(filaTabla);
        }
        tablaCombos.setModel(mt);
        tablaCombos.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tablaCombos.getColumnModel().getColumn(3).setCellRenderer(tablaCombos.getDefaultRenderer(Boolean.class));
        
        String [] columnasTablaProductos = {"ID", "Producto", "Precio", "Seleccionar"};
        mtp.setColumnIdentifiers(columnasTablaProductos);
        ArrayList<Producto> listaProductos = CombosController.obtenerProductos();
        for(Producto producto : listaProductos){
            Object[] filaTablaProductos = {
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                false
            };
            mtp.addRow(filaTablaProductos);
        }
        tablaProductos.setModel(mtp);
        tablaProductos.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tablaProductos.getColumnModel().getColumn(3).setCellRenderer(tablaProductos.getDefaultRenderer(Boolean.class));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCombos = new javax.swing.JTable();
        siguienteButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(14, 14, 14));

        tablaCombos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaCombos);

        siguienteButton.setBackground(new java.awt.Color(51, 51, 51));
        siguienteButton.setForeground(new java.awt.Color(255, 255, 255));
        siguienteButton.setText("Siguiente");

        salirButton.setBackground(new java.awt.Color(51, 51, 51));
        salirButton.setForeground(new java.awt.Color(255, 255, 255));
        salirButton.setText("Salir");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(siguienteButton)
                    .addComponent(salirButton))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(siguienteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salirButton)
                .addGap(145, 145, 145))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenderCombos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton siguienteButton;
    private javax.swing.JTable tablaCombos;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
