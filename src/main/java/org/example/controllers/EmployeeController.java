package org.example.controllers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Employee;
import org.example.models.Role;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class EmployeeController {
    
    public static boolean actualizarRolEmpleado(String cedula, Role rol){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "UPDATE empleados SET ID_Rol = ? WHERE Cedula = ?";
        Object[] params = {rol.getId(), cedula};
        return CRUD.updateDB(sql, params);
    }
    
    public static Role obtenerRolPorId(int rol){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "select * from rol where id = ?";
        Object[] params = {rol};
        Role role = new Role();
        ResultSet rs = CRUD.consultarDB(sql, params);
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("NombreRol");
                double salario = rs.getDouble("Salario");
                role.setId(id);
                role.setNombre(nombre);
                role.setSalario(salario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }
    
    public static Employee obtenerEmpleadoPorCedula(String cedula){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM empleados WHERE cedula = ?";
        Object[] params = {cedula};
        ResultSet rs = CRUD.consultarDB(sql, params);
        Employee employee = new Employee();
        try {
            while(rs != null && rs.next()){
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                Date fechaNacimiento = rs.getDate("FechaNacimiento");
                int rol = rs.getInt("ID_Rol");
                Role rolEmployee = EmployeeController.obtenerRolPorId(rol);
                employee.setNombre(nombre);
                employee.setApellido(apellido);
                employee.setCedula(cedula);
                employee.setFechaNacimiento(fechaNacimiento);
                employee.setRole(rolEmployee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
    
    public static boolean despedirEmpleados(String cedula){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "DELETE FROM empleados WHERE cedula = ?";
        Object[] params = {cedula};
        return CRUD.eliminarDB(sql, params);
    }
    
    public static boolean insertarEmpleados(Employee employee){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "INSERT INTO empleados (Nombre, Apellido, Cedula, FechaNacimiento, ID_Rol) VALUES (?,?,?,?,?)";
        String nombre = employee.getNombre();
        String apellido = employee.getApellido();
        String cedula = employee.getCedula();
        Date fechaNacimiento = employee.getFechaNacimiento();
        int idRol = employee.getRole().getId();

        Object[] params = {
            nombre,
            apellido,
            cedula,
            fechaNacimiento,
            idRol
        };
        return CRUD.insertarDB(sql, params);
    }
    
    public static ArrayList<Role> listarRolesEmpleados(){
        CRUD.setConexion(ConnectionDB.getConnection());
        ArrayList<Role> listaRoles = new ArrayList();
        String sql = "SELECT * FROM rol";
        try {
            ResultSet rs = CRUD.consultarDB(sql);
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("NombreRol");
                double salario = rs.getDouble("Salario");
                Role role = new Role(id, nombre, salario);
                listaRoles.add(role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRoles;
    }
}
