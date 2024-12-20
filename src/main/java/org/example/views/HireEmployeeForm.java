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

        jPanel1 = new javax.swing.JPanel();
        hireButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        roleInput = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        fechaNacimientoInput = new com.toedter.calendar.JDateChooser();
        cedulaInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        apellidoInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nombreInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(17, 17, 17));

        hireButton.setBackground(new java.awt.Color(51, 51, 51));
        hireButton.setForeground(new java.awt.Color(255, 255, 255));
        hireButton.setText("Contratar");
        hireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireButtonActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rol:");

        roleInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roles" }));
        roleInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleInputActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de Nacimiento:");

        cedulaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaInputActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cedula:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellido:");

        apellidoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoInputActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre: ");

        nombreInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreInputActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Cinemark");

        salirBtn.setBackground(new java.awt.Color(51, 51, 51));
        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(salirBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hireButton)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaNacimientoInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(roleInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cedulaInput)
                            .addComponent(apellidoInput)
                            .addComponent(nombreInput))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addComponent(cedulaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaNacimientoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hireButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        EmployeeSystem es = new EmployeeSystem();
        es.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirBtnActionPerformed
  
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreInput;
    private javax.swing.JComboBox<String> roleInput;
    private javax.swing.JButton salirBtn;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton salirButton1;
    // End of variables declaration//GEN-END:variables
}
