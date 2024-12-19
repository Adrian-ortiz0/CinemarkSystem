package org.example.views;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import org.example.controllers.FunctionsController;
import org.example.controllers.PeliculasController;
import org.example.controllers.SalasController;
import org.example.models.Funcion;
import org.example.models.Pelicula;
import org.example.models.Sala;

public class FunctionCreater extends javax.swing.JFrame {
    public FunctionCreater() {
        initComponents();
        cargarPeliculas();
        cargarSalas();
        configurarJspinner();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inputPeliculas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        salasInput = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fechaInicioSpinner = new javax.swing.JSpinner();
        crearFuncionButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cinemark");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pelicula:");

        inputPeliculas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        inputPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPeliculasActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sala:");

        salasInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        salasInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salasInputActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Feha Inicio:");

        fechaInicioSpinner.setModel(new javax.swing.SpinnerDateModel());

        crearFuncionButton.setBackground(new java.awt.Color(51, 51, 51));
        crearFuncionButton.setForeground(new java.awt.Color(255, 255, 255));
        crearFuncionButton.setText("Crear Funcion");
        crearFuncionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearFuncionButtonActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(salirButton)))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(crearFuncionButton)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(salasInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputPeliculas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fechaInicioSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(salasInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fechaInicioSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearFuncionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
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

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        FuncionesSystem fs = new FuncionesSystem();
        fs.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    private void inputPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPeliculasActionPerformed
        
    }//GEN-LAST:event_inputPeliculasActionPerformed

    private void salasInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salasInputActionPerformed
        
    }//GEN-LAST:event_salasInputActionPerformed

    private void crearFuncionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearFuncionButtonActionPerformed
        String nombrePelicula = (String) inputPeliculas.getSelectedItem();
        Pelicula pelicula = getPeliculaPorNombre(nombrePelicula);
        String nombreSala = (String) salasInput.getSelectedItem();
        Sala sala = getSalaPorNombre(nombreSala);
        Date fecha = (Date) fechaInicioSpinner.getValue();
        LocalDateTime fechaInicio = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime fechaFin = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Funcion funcion = new Funcion();
        funcion.setPelicula(pelicula);
        funcion.setSala(sala);
        funcion.setFechaInicio(fechaInicio);
        funcion.setFechaFin(fechaFin);
        FunctionsController.crearFunciones(funcion);
    }//GEN-LAST:event_crearFuncionButtonActionPerformed
    private Pelicula getPeliculaPorNombre(String nombre){
        ArrayList<Pelicula> peliculas = PeliculasController.obtenerPeliculasDisponibles();
        for(Pelicula pelicula : peliculas){
            if(pelicula.getNombre().equals(nombre)){
                return pelicula;
            }
        }
        return null;
    }
    private Sala getSalaPorNombre(String nombre){
        ArrayList<Sala> salas = SalasController.salasDisponibles();
        for(Sala sala : salas){
            if(sala.getNombre().equals(nombre)){
                return sala;
            }
        }
        return null;
    }
    private void cargarPeliculas(){
        inputPeliculas.removeAllItems();
        ArrayList<Pelicula> peliculas = PeliculasController.obtenerPeliculasDisponibles();
        for(Pelicula pelicula : peliculas){
            inputPeliculas.addItem(pelicula.getNombre());
        }
    }
    private void cargarSalas(){
        salasInput.removeAllItems();
        ArrayList<Sala> salas = SalasController.salasDisponibles();
        for(Sala sala : salas){
            salasInput.addItem(sala.getNombre());
        }
    }
    
    private void configurarJspinner(){
        SpinnerDateModel model = new SpinnerDateModel();
        fechaInicioSpinner.setModel(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaInicioSpinner, "yyyy-MM-dd HH:mm:ss");
        fechaInicioSpinner.setEditor(editor);
        fechaInicioSpinner.setValue(new Date());
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FunctionCreater().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearFuncionButton;
    private javax.swing.JSpinner fechaInicioSpinner;
    private javax.swing.JComboBox<String> inputPeliculas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> salasInput;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
