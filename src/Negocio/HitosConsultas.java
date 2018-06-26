/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Rodrigo
 */
public class HitosConsultas extends Conexion {
    Conexion con = new Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void agregarHito(String nombre, String proyecto){
               
            try {
                String query = "CALL AG_HITO(?,?)";
                ps = getConexion().prepareStatement(query);
                ps.setString(1, nombre);
                ps.setString(2, proyecto);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Hito Guardado Correctamente");
                rs.close();
            } catch (Exception e) {

            } 
    }
    
    public void agregarTarea(String nombre,String fecha_inicio,String fecha_fin,String id_hito,String id_proyecto){
        try {
                String query = "CALL AG_TAREA(?,?,?,?,?)";
                ps = getConexion().prepareStatement(query);
                ps.setString(1, nombre);
                ps.setString(2, fecha_inicio);
                ps.setString(3, fecha_fin);
                ps.setString(4, id_hito);
                ps.setString(5, id_proyecto);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Tarea Guardada Correctamente");
                rs.close();
            } catch (Exception e) {

            } 
    }
    
    public void actualizarTarea(String id_tarea, String id_hito, String avance){
        try {
                String query = "CALL ACT_TAREA(?,?,?)";
                ps = getConexion().prepareStatement(query);
                ps.setString(1, id_tarea);
                ps.setString(2, id_hito);
                ps.setString(3, avance);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Tarea Actualizada Correctamente");
                rs.close();
            
        } catch (Exception e) {
        }
    }
    
    
}
