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
    Conexion con = new Conexion();
    
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
    
    public void registrarHerramientas(String Nombre_Mh, String Tipo_Mh, int Precio_Mh, int Disponibilidad_Mh){
        try{
            ps = getConexion().prepareStatement("CALL AG_HERRAMIENTAS(?,?,?,?)");
            ps.setString(1, Nombre_Mh);
            ps.setString(2, Tipo_Mh);
            ps.setInt(3, Precio_Mh);
            ps.setInt(4, Disponibilidad_Mh);
            ps.executeUpdate();            
            System.out.println("Registro Realizado");
        }catch(Exception ex){
            System.out.println("Error: "+ex);
        }
        
    }
    
    public void eliminarHerramienta(int ID_MH){
        try {
        String query = "DELETE FROM MAQUI_HERRA WHERE Id_MH='"+ID_MH+"'";
        ps = con.getConexion().prepareStatement(query);
        rs = ps.executeQuery();
        System.out.println("Registros eliminado");
        }catch(SQLException ex){
            System.out.println("Registro no Eliminado");
            System.out.println("Error:"+ex);
        }
    }
    

    
}
