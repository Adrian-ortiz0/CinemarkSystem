package org.example.views;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.example.controllers.CombosController;
import org.example.models.Combo;
import org.example.models.ComboBuilder;
import org.example.models.Producto;

public class CombosSystem extends javax.swing.JFrame {
    public CombosSystem() {
        initComponents();
        cargarPalomitas();
        cargarRefrescos();
        cargarAdicionales();
        cargarAdicionales2();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        palomitasComboBox = new javax.swing.JComboBox<>();
        refrescosComboBox = new javax.swing.JComboBox<>();
        adicionalesComboBox = new javax.swing.JComboBox<>();
        adicionalesComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        palomitasCantidadComboBox = new javax.swing.JComboBox<>();
        refrescosCantidadComboBox = new javax.swing.JComboBox<>();
        adicionalesCantidadComboBox = new javax.swing.JComboBox<>();
        adicionalesCantidadComboBox2 = new javax.swing.JComboBox<>();
        nombreComboInput = new javax.swing.JTextField();
        salirButton = new javax.swing.JButton();
        crearComboButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cinemark");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del combo:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Palomitas:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Refrescos:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Adicionales:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Adicionales 2:");

        palomitasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        refrescosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        adicionalesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        adicionalesComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidades");

        palomitasCantidadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        refrescosCantidadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        adicionalesCantidadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        adicionalesCantidadComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        salirButton.setBackground(new java.awt.Color(51, 51, 51));
        salirButton.setForeground(new java.awt.Color(255, 255, 255));
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        crearComboButton.setBackground(new java.awt.Color(51, 51, 51));
        crearComboButton.setForeground(new java.awt.Color(255, 255, 255));
        crearComboButton.setText("Crear");
        crearComboButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearComboButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(168, 168, 168))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(salirButton))
                        .addGap(64, 64, 64)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(crearComboButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreComboInput, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(palomitasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(refrescosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(adicionalesComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(adicionalesComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(palomitasCantidadComboBox, 0, 131, Short.MAX_VALUE)
                                .addComponent(refrescosCantidadComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(adicionalesCantidadComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adicionalesCantidadComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreComboInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(palomitasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(palomitasCantidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(refrescosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refrescosCantidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(adicionalesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionalesCantidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(adicionalesComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionalesCantidadComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crearComboButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
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

    private void cargarPalomitas(){
        ArrayList<Producto> palomitas = CombosController.obtenerPalomitas();
        palomitasComboBox.removeAllItems();
        for(Producto producto : palomitas){
            palomitasComboBox.addItem(producto.getNombre());
        }
    }
    
    private void cargarRefrescos(){
        ArrayList<Producto> refrescos = CombosController.obtenerRefrescos();
        refrescosComboBox.removeAllItems();
        for(Producto producto : refrescos){
            refrescosComboBox.addItem(producto.getNombre());
        }
    }
    
    private void cargarAdicionales(){
        ArrayList<Producto> adicionales = CombosController.obtenerAdicionales();
        adicionalesComboBox.removeAllItems();
        for(Producto producto : adicionales){
            adicionalesComboBox.addItem(producto.getNombre());
        }
    }
    private void cargarAdicionales2(){
        ArrayList<Producto> adicionales = CombosController.obtenerAdicionales();
        adicionalesComboBox2.removeAllItems();
        for(Producto producto : adicionales){
            adicionalesComboBox2.addItem(producto.getNombre());
        }
    }
    
    private void crearComboButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearComboButtonActionPerformed
        String nombreCombo = "";
        if (nombreComboInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de nombre debe estar lleno!");
            return;
        } else {
            nombreCombo = nombreComboInput.getText();
        }

        Producto palomitas = CombosController.obtenerProductoPorNombre((String) palomitasComboBox.getSelectedItem());
        Producto refrescos = CombosController.obtenerProductoPorNombre((String) refrescosComboBox.getSelectedItem());
        Producto adicional = CombosController.obtenerProductoPorNombre((String) adicionalesComboBox.getSelectedItem());
        Producto adicional2 = CombosController.obtenerProductoPorNombre((String) adicionalesComboBox2.getSelectedItem());

        int cantidadPalomitas = Integer.parseInt(palomitasCantidadComboBox.getSelectedItem().toString());
        int cantidadRefrescos = Integer.parseInt(refrescosCantidadComboBox.getSelectedItem().toString());
        int cantidadAdicional = Integer.parseInt(adicionalesCantidadComboBox.getSelectedItem().toString());
        int cantidadAdicional2 = Integer.parseInt(adicionalesCantidadComboBox2.getSelectedItem().toString());

        double precioPalomitas = palomitas.getPrecio() * cantidadPalomitas;
        double precioRefrescos = refrescos.getPrecio() * cantidadRefrescos;
        double precioAdicional = adicional.getPrecio() * cantidadAdicional;
        double precioAdicional2 = adicional2.getPrecio() * cantidadAdicional2;
        double total = precioPalomitas + precioRefrescos + precioAdicional + precioAdicional2 + 5000.0;

        Combo combo = new ComboBuilder()
            .setNombre(nombreCombo)
            .addProducto(palomitas, cantidadPalomitas)
            .addProducto(refrescos, cantidadRefrescos)
            .addProducto(adicional, cantidadAdicional)
            .addProducto(adicional2, cantidadAdicional2)
            .build();
        combo.setPrecioTotal(total);

        if (CombosController.crearNuevoCombo(combo)) {
            JOptionPane.showMessageDialog(this, "Combo creado exitosamente!");
        } else {
            JOptionPane.showMessageDialog(this, "Error al crear el combo.");
        }
    }//GEN-LAST:event_crearComboButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        MainMenuAdmin mma = new MainMenuAdmin();
        mma.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CombosSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> adicionalesCantidadComboBox;
    private javax.swing.JComboBox<String> adicionalesCantidadComboBox2;
    private javax.swing.JComboBox<String> adicionalesComboBox;
    private javax.swing.JComboBox<String> adicionalesComboBox2;
    private javax.swing.JButton crearComboButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreComboInput;
    private javax.swing.JComboBox<String> palomitasCantidadComboBox;
    private javax.swing.JComboBox<String> palomitasComboBox;
    private javax.swing.JComboBox<String> refrescosCantidadComboBox;
    private javax.swing.JComboBox<String> refrescosComboBox;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
