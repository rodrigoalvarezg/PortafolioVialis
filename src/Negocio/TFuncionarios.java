/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import Modelo.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Negocio.DRut;

/**
 *
 * @author detha
 */
public class TFuncionarios extends Conexion{ 
    Conexion con = new Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    DefaultTableModel modelo;
    
    public void registrarFunncionario(String rut, String nombre, String apellidoP, String apellidoM, String direccion, String estado_civil, int sueldo, int bono, String tipo_contrato, String afp, String salud, int responsable, int profesion, String correo, String fono){
        
        DRut drut = new DRut();
        rut = drut.Rut(rut);
        try {          
            ps = con.getConexion().prepareStatement("call AG_TRAB(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, rut);
            ps.setString(2, nombre);
            ps.setString(3, apellidoP);
            ps.setString(4, apellidoM);
            ps.setString(5, direccion);
            ps.setString(6, estado_civil);
            ps.setInt(7,sueldo );
            ps.setInt(8, bono);
            ps.setString(9, tipo_contrato);
            ps.setString(10, afp);
            ps.setString(11, salud);
            ps.setInt(12, responsable);
            ps.setInt(13, profesion);
            ps.setString(14, fono);
            ps.setString(15, correo);
            
            ps.executeUpdate();
            System.out.println("Registro Realizado");
        }catch(SQLException ex){
            System.out.println("Registro no Realizado");
            System.out.println("Error:"+ex);
            
        }
    }
    
    public void eliminarFuncionario(String rut ){
        try {
        String query = "DELETE FROM trabajador WHERE RUN_TRAB='"+rut+"'";
        ps = con.getConexion().prepareStatement(query);
        rs = ps.executeQuery();
        System.out.println("Registros eliminado");
        }catch(SQLException ex){
            System.out.println("Registro no Eliminado");
            System.out.println("Error:"+ex);
        }
    }
    
    public void editarProyecto(String rut, String nombre, String apellidoP, String apellidoM, String direccion, String estado_civil, int sueldo, int bono, String tipo_contrato, String afp, String salud, int responsable, int profesion, String correo, String fono){
        try {
            ps = con.getConexion().prepareStatement("call UP_TRAB(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, rut);
            ps.setString(2, nombre);
            ps.setString(3, apellidoP);
            ps.setString(4, apellidoM);
            ps.setString(5, direccion);
            ps.setString(6, estado_civil);
            ps.setInt(7,sueldo );
            ps.setInt(8, bono);
            ps.setString(9, tipo_contrato);
            ps.setString(10, afp);
            ps.setString(11, salud);
            ps.setInt(12, responsable);
            ps.setInt(13, profesion);
            ps.setString(14, fono);
            ps.setString(15, correo);
            
            ps.executeUpdate();
            System.out.println("Registro Actualizado");
        }catch(SQLException ex){
            System.out.println("Registro no Actualizado");
            System.out.println("Error:"+ex);
            
        }
        
    }
    
    
    
}