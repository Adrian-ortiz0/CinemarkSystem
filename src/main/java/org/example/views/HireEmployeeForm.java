package org.example.views;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.example.controllers.EmployeeController;
import org.example.models.Employee;
import org.example.models.Role;

public class HireEmployeeForm extends javax.swing.JFrame {
    
    public HireEmployeeForm() {
        initComponents();
        cargarRoles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombreInput = new javax.swing.JTextField();
        apellidoInput = new javax.swing.JTextField();
        cedulaInput = new javax.swing.JTextField();
        roleInput = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        hireButton = new javax.swing.JButton();
        fechaNacimientoInput = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Cedula:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel5.setText("Rol:");

        nombreInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreInputActionPerformed(evt);
            }
        });

        apellidoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoInputActionPerformed(evt);
            }
        });

        cedulaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaInputActionPerformed(evt);
            }
        });

        roleInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roles" }));
        roleInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleInputActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Cinemark");

        hireButton.setText("Contratar");
        hireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(72, 72, 72))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(roleInput, javax.swing.GroupLayout.Alignment.LEADING, 0, 141, Short.MAX_VALUE)
                            .addComponent(cedulaInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(apellidoInput)
                            .addComponent(nombreInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaNacimientoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(151, 151, 151))))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(hireButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(apellidoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cedulaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaNacimientoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(hireButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hireButtonActionPerformed
        String nombre = nombreInput.getText();
        String apellido = apellidoInput.getText();
        String cedula = cedulaInput.getText();
        java.util.Date fechaNacimiento = fechaNacimientoInput.getDate();
        Employee employee = new Employee();
        employee.setNombre(nombre);
        employee.setApellido(apellido);
        employee.setCedula(cedula);
        employee.setFechaNacimiento(fechaNacimiento);
        String roleNombre = (String) roleInput.getSelectedItem();
        Role role = getRoleByName(roleNombre);
        
        if (role != null) {
            employee.setRole(role);
        }
        boolean result = EmployeeController.insertarEmpleados(employee);
        if (result) {
            JOptionPane.showMessageDialog(this, "Empleado contratado exitosamente!");
        } else {
            JOptionPane.showMessageDialog(this, "Error al contratar al empleado.");
        }
    }//GEN-LAST:event_hireButtonActionPerformed
    private void cargarRoles() {
        ArrayList<Role> listaRoles = EmployeeController.listarRolesEmpleados();
        roleInput.removeAllItems();
        for (Role role : listaRoles) {
            roleInput.addItem(role.getNombre());
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
    private void roleInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleInputActionPerformed

    }//GEN-LAST:event_roleInputActionPerformed

    private void cedulaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaInputActionPerformed

    private void apellidoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoInputActionPerformed

    private void nombreInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreInputActionPerformed
  
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HireEmployeeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoInput;
    private javax.swing.JTextField cedulaInput;
    private com.toedter.calendar.JDateChooser fechaNacimientoInput;
    private javax.swing.JButton hireButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nombreInput;
    private javax.swing.JComboBox<String> roleInput;
    // End of variables declaration//GEN-END:variables
}
