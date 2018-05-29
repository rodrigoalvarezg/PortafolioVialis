/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.Conexion;
import java.sql.*;
import java.text.ParseException;

/**
 *
 * @author kraus
 */
public class TArriendo extends Conexion {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void registrarArriendo(String fecha_arriendo, String fecha_entrega, int id_mh, String id_proy, int cantidad) throws ParseException{
                
        try{
            
            ps = getConexion().prepareStatement("CALL PRO_ARRIENDO(?,?,?,?,?)");
            ps.setString(1, fecha_arriendo);
            ps.setString(2, fecha_entrega);
            ps.setInt(3, id_mh);
            ps.setString(4, id_proy);
            ps.setInt(5, cantidad);
            ps.executeUpdate();            
            System.out.println("Sentencia sql correcta en Arriendo");
            //rs.close();
        } catch (SQLException e) {
            System.out.println("No se Realizo bien la sentencia sql en Arriendo");
            System.out.println("Error: "+e);
        }  
    }
    

    
}
