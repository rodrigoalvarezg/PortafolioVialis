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
public class RecursosConsultas extends Conexion {
    Conexion con = new Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void agregarFuncionarios(String id_obra, String id_trabajador){
        try {
                String query = "CALL AG_PROY_TRAB(?,?)";
                ps = getConexion().prepareStatement(query);
                ps.setString(1, id_obra);
                ps.setString(2, id_trabajador);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Trabajador agregado correctamente");
                rs.close();
            } catch (Exception e) {

            } 
    }
    
    public void agregarRecurso(String id_material,String id_proyecto,int cantidad){
        try {
                String query = "CALL AG_RECURSO(?,?,?)";
                ps = getConexion().prepareStatement(query);
                ps.setString(1, id_material);
                ps.setString(2, id_proyecto);
                ps.setInt(3, cantidad);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Recurso asignado exitosamente.");
                rs.close();
            } catch (Exception e) {

            } 
    }
}
