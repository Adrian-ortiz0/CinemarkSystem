package org.example.views;

import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.example.controllers.FunctionsController;
import org.example.models.Funcion;

public class FuncionesList extends javax.swing.JFrame {
    DefaultTableModel mt = new DefaultTableModel();
    public FuncionesList() {
        initComponents();
        String [] columnas = {"ID", "Pelicula", "Sala", "Fecha Funcion", "Seleccionar"};
        mt.setColumnIdentifiers(columnas);
        ArrayList<Funcion> funciones = FunctionsController.obtenerFunciones();
        for(Funcion funcion : funciones){
            Object[] params = {
                funcion.getId(),
                funcion.getPelicula().getNombre(),
                funcion.getSala().getNombre(),
                funcion.getFechaInicio().toString(),
                false
            };
            mt.addRow(params);
        }
        tablaFunciones.setModel(mt);
        tablaFunciones.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tablaFunciones.getColumnModel().getColumn(4).setCellRenderer(tablaFunciones.getDefaultRenderer(Boolean.class));

    }
    
    private void tablaFuncionesMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tablaFunciones.getSelectedRow();
        if (row >= 0) {
            int idFuncion = (int) tablaFunciones.getValueAt(row, 0);
            EditarFuncion editarFuncionFrame = new EditarFuncion(idFuncion);
            editarFuncionFrame.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFunciones = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        actualizarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(17, 17, 17));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cinemark");

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));

        tablaFunciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaFunciones);

        Add.setBackground(new java.awt.Color(51, 51, 51));
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("Add New");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        actualizarButton.setBackground(new java.awt.Color(51, 51, 51));
        actualizarButton.setForeground(new java.awt.Color(255, 255, 255));
        actualizarButton.setText("Update");
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setBackground(new java.awt.Color(51, 51, 51));
        eliminarButton.setForeground(new java.awt.Color(255, 255, 255));
        eliminarButton.setText("Delete");
        eliminarButton.setToolTipText("");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salirButton)
                            .addComponent(actualizarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Add)
                        .addGap(58, 58, 58)
                        .addComponent(actualizarButton)
                        .addGap(52, 52, 52)
                        .addComponent(eliminarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salirButton)
                        .addGap(85, 85, 85))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        FuncionesSystem fs = new FuncionesSystem();
        fs.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        DefaultTableModel mt = (DefaultTableModel) tablaFunciones.getModel();
        ArrayList<Integer> idsAEliminar = new ArrayList();
        for(int i = 0; i < mt.getRowCount(); i++){
            Boolean seleccionado = (boolean) mt.getValueAt(i, 4);
            if(seleccionado != null && seleccionado){
                int idFuncion = (int) mt.getValueAt(i, 0);
                idsAEliminar.add(idFuncion);
            }
        }
        for (int id : idsAEliminar){
            FunctionsController.removerFunciones(id);
        }
        mt.setRowCount(0);
        ArrayList<Funcion> funciones = FunctionsController.obtenerFunciones();
        for(Funcion funcion : funciones){
            Object[] params = {
                funcion.getId(),
                funcion.getPelicula().getNombre(),
                funcion.getSala().getNombre(),
                funcion.getFechaInicio().toString(),
                false
            };
            mt.addRow(params);
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        FunctionCreater fc = new FunctionCreater();
        fc.setVisible(true);
        dispose();
    }//GEN-LAST:event_AddActionPerformed

    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        int row = tablaFunciones.getSelectedRow();
        if (row >= 0) {
            int idFuncion = (int) tablaFunciones.getValueAt(row, 0);
            EditarFuncion editarFuncionFrame = new EditarFuncion(idFuncion);
            editarFuncionFrame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una función para actualizar.");
        }
    }//GEN-LAST:event_actualizarButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionesList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton actualizarButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salirButton;
    private javax.swing.JTable tablaFunciones;
    // End of variables declaration//GEN-END:variables
}
