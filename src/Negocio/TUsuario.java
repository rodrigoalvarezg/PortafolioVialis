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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author detha
 */
public class TUsuario {
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs ;
    DefaultTableModel modelo;
    
    public void registrarUsuario(String usuario, String password, int id_perfil){
        try{
            ps = con.getConexion().prepareStatement("call AG_USUARIO(?,?,?)");
            ps.setString(1, usuario);
            ps.setString(2, password);
            ps.setInt(3, id_perfil);
            ps.executeUpdate();
            System.out.println("Registro Realizado");
        }catch(Exception ex){
            System.out.println("Registro no Realizado");
        }
    }
    
    public void eliminarUsuario(String usuario){
        try{
            String query = "DELETE FROM USUARIO WHERE USUARIO='"+usuario+"'";
        ps = con.getConexion().prepareStatement(query);
        rs = ps.executeQuery();
        System.out.println("Registros eliminado");
        }catch(SQLException ex){
            System.out.println("Registro no Eliminado");
            System.out.println("Error:"+ex);
        }
    }
   
    public void editarUsuario(String usuario, String password, int id_perfil){
        try{
            ps = con.getConexion().prepareStatement("call UP_USUARIO(?,?,?)");
            ps.setString(1, usuario);
            ps.setString(2, password);
            ps.setInt(3, id_perfil);
            ps.executeUpdate();
            System.out.println("Registro Realizado");
        }catch(Exception ex){
            System.out.println("Registro no Realizado");
        }
    }
}
