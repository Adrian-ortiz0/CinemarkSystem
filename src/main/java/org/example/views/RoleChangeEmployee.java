package org.example.views;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.example.controllers.EmployeeController;
import org.example.models.Employee;
import org.example.models.Role;

public class RoleChangeEmployee extends javax.swing.JFrame {

    public RoleChangeEmployee() {
        initComponents();
        cargarRoles();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        cedulaInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeNombreLbl = new javax.swing.JLabel();
        EmployeeRolLbl = new javax.swing.JLabel();
        buscarEmployeeButton = new javax.swing.JButton();
        inputRoles = new javax.swing.JComboBox<>();
        cambiarRolButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Cinemark");

        cedulaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaInputActionPerformed(evt);
            }
        });

        jLabel1.setText("Cedula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Rol:");

        buscarEmployeeButton.setText("Buscar");
        buscarEmployeeButton.setActionCommand("Buscar");
        buscarEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmployeeButtonActionPerformed(evt);
            }
        });

        cambiarRolButton.setText("Cambiar");
        cambiarRolButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarRolButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(225, 225, 225))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(employeeNombreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(EmployeeRolLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                        .addComponent(buscarEmployeeButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cambiarRolButton)))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(158, 158, 158))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cedulaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedulaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employeeNombreLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(EmployeeRolLbl)
                    .addComponent(buscarEmployeeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cambiarRolButton))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmployeeButtonActionPerformed
        String cedula = cedulaInput.getText();
        Employee employee = EmployeeController.obtenerEmpleadoPorCedula(cedula);
        if(employee == null){
            cedulaInput.setText("");
        }
        employeeNombreLbl.setText(employee.getNombre());
        EmployeeRolLbl.setText(employee.getRole().getNombre());
    }//GEN-LAST:event_buscarEmployeeButtonActionPerformed
    
    private void cargarRoles(){
        ArrayList<Role> listaRoles = EmployeeController.listarRolesEmpleados();
        inputRoles.removeAllItems();
        for(Role role : listaRoles){
            inputRoles.addItem(role.getNombre());
        }
    }
    private Role getRoleByName(String roleNombre) {
    ArrayList<Role> listaRoles = EmployeeController.listarRolesEmpleados();
    for (Role role : listaRoles) {
        if (role.getNombre().equals(roleNombre)) {
            return role;
        }
    }
        return null;
    }
    
    private void cedulaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaInputActionPerformed

    private void cambiarRolButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarRolButtonActionPerformed
        String rolNombre = (String) inputRoles.getSelectedItem();
        String cedula = cedulaInput.getText();
        Role nuevoRol = getRoleByName(rolNombre);
        if(nuevoRol != null){
            boolean success = EmployeeController.actualizarRolEmpleado(cedula, nuevoRol);
            if(success){
                JOptionPane.showMessageDialog(this, "Rol actualizado exitosamente!");
                EmployeeRolLbl.setText(nuevoRol.getNombre());
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar rol!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No existe ese rol");
        }
    }//GEN-LAST:event_cambiarRolButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoleChangeEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmployeeRolLbl;
    private javax.swing.JButton buscarEmployeeButton;
    private javax.swing.JButton cambiarRolButton;
    private javax.swing.JTextField cedulaInput;
    private javax.swing.JLabel employeeNombreLbl;
    private javax.swing.JComboBox<String> inputRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
