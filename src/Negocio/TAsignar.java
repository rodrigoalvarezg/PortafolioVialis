/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import java.sql.*;

/**
 *
 * @author kraus
 */
public class TAsignar extends Conexion {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void asignarPersonal(String id_proy, String rut){
        
        try{
            ps = getConexion().prepareStatement("CALL PRO_PROY_TRAB(?,?)");
            ps.setString(1, id_proy);
            ps.setString(2, rut);
            ps.executeUpdate();
            System.out.println("Sentencia sql correcta en Asignacion de Personal");
        }catch(SQLException ex){
            System.out.println("No se Realizo bien la sentencia sql en Asignacion de Personal");
            System.out.println("Error: "+ex);
        }
    }
    
    public void asignarMaterial(String id_proy, String id_material){
        
        try{
            ps = getConexion().prepareStatement("CALL PRO_MATERIAL_PROYECTO(?,?)");
            ps.setString(1, id_proy);
            ps.setString(2, id_material);
            ps.executeUpdate();
            System.out.println("Sentencia sql correcta en Asignacion de Material");
        }catch(SQLException ex){
            System.out.println("No se Realizo bien la sentencia sql en Asignacion de Material");
            System.out.println("Error: "+ex);
        }
        
    }
}
