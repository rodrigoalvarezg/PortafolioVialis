/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Modelo.Proyecto;
//import com.sun.istack.internal.logging.Logger;
import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.getConnection;

/**
 *
 * @author Ivan Mardones
 */
public class TProyecto extends Conexion {
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs ;
    DefaultTableModel modelo;

    public void registrarProyecto(String nombre, String descripcion){
        String id = nombre.substring(0,3) + descripcion.substring(0,3);
        try{
            ps = con.getConexion().prepareStatement("call AG_PROY(?,?,?)");
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.executeUpdate();
           System.out.println("Registro Realizado");
        }catch(SQLException ex){
            System.out.println("Registro no Realizado");
            System.out.println("Error:"+ex);
        }
        
        
    }
    
    public void eliminarProyecto(String ID_PROY ){
        try {
        String query = "DELETE FROM proyecto WHERE Id_PROY='"+ID_PROY+"'";
        ps = con.getConexion().prepareStatement(query);
        rs = ps.executeQuery();
        System.out.println("Registros eliminado");
        }catch(SQLException ex){
            System.out.println("Registro no Eliminado");
            System.out.println("Error:"+ex);
        }
    }
    
    
    public void editarProyecto(String nombre, String descripcion,String ID_PROY){
        try{
            ps = con.getConexion().prepareStatement("call UP_PROY(?,?,?)");
            ps.setString(1, ID_PROY );
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.executeUpdate();
           System.out.println("Registro Actualizado");
        }catch(SQLException ex){
            System.out.println("Registro no Actualizado");
            System.out.println("Error:"+ex);
        }
        
    }
    
    

    
        
 } 
            
        
    
    

