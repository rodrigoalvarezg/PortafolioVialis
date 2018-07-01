/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author detha
 */
public class TInspecciones {
    Conexion con = new Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void registrarInspecciones(int Id_Ins_Ava, double Porcentaje_Ins_Avan, String Descrip_Ins_Avan, String Hito_Id_Hito, String Hito_Id_Proy ){
        
        
    }
}
