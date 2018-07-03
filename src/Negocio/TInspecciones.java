/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author detha
 */
public class TInspecciones {
    Conexion con = new Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void registrarInspecciones(double Porcentaje_Ins_Avan, String Descrip_Ins_Avan, String Hito_Id_Hito, String Hito_Id_Proy ){
        
        try{
            ps = con.getConexion().prepareStatement("call AG_INSPECCION(?,?,?,?)");
            ps.setDouble(1, Porcentaje_Ins_Avan);
            ps.setString(2, Descrip_Ins_Avan);
            ps.setString(3, Hito_Id_Hito);
            ps.setString(4, Hito_Id_Proy);
            ps.executeUpdate();
            System.out.println("Registro Realizado");
        }catch(SQLException ex){
            System.out.println("Registro no Realizado");
            System.out.println("Error:"+ex);
        }  
    }
}
