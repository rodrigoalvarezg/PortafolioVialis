/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;


import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author detha
 */
public class TReunion extends Conexion{
    Conexion con = new Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void registrarReunion(String Citador_Reun, String Motivo_Reun, String Fecha_Reun, String Hora_Ini_Reun, String Hora_Ter_Reun, String hito_id_hito, String hito_proyecto_id_proy) {
        try{
            ps = con.getConexion().prepareStatement("call AG_REUNION(?,?,?,?,?,?,?)");
            ps.setString(1, Citador_Reun);
            ps.setString(2, Motivo_Reun);
            ps.setString(3, Fecha_Reun);
            ps.setString(4, Hora_Ini_Reun);
            ps.setString(5, Hora_Ter_Reun);
            ps.setString(6, hito_id_hito);
            ps.setString(7, hito_proyecto_id_proy);
            ps.executeUpdate();
            System.out.println("Registro Realizado");
        }catch(SQLException ex){
            System.out.println("Registro no Realizado");
            System.out.println("Error:"+ex);
        }
    }
            
}

