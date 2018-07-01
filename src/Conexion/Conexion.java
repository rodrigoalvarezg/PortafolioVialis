/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.sql.*;

/**
 *
 * @author Rodrigo
 */
public class Conexion {
    
    //Conexion AWS
    /*
    private String username ="cons";
    private String password  ="portafolio2018";
    private String host ="@vialis.c1rdtq9kg6sd.us-east-2.rds.amazonaws.com";
    private String port ="1521";
    private String database ="cons";
    private String url  = "jdbc:oracle:thin:"+host+":"+port+":"+database;
    private Connection con;
    */
    
    //Conexion Local
    
    private String username ="cons";
    private String password  ="oracle";
    private String host ="@localhost";
    private String port ="1521";
    private String database ="orcl";
    private String url  = "jdbc:oracle:thin:"+host+":"+port+":"+database;
    private Connection con;    
    
    
    public Conexion(){
        PreparedStatement ps;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Conexion Correcta");
        } catch (ClassNotFoundException e) {
            //System.err  muestra el mensaje de error en rojo
            System.err.println("ERROR"+ e);
        }catch(SQLException e){
            System.err.println("ERROR"+ e );
        }    
    }
    
    public Connection getConexion(){
        return con;
    }
    
    public static void main(String[]arg){
        Conexion con = new Conexion();
    }
}
