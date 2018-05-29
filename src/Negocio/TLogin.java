package Negocio;

import Conexion.Conexion;
import java.sql.*;

public class TLogin {
    
    private String usuario, password, sql;
    private int id_perfil;
    public Conexion conn = new Conexion();
    public boolean encontrado = false;
    
    public TLogin(){}

    public boolean confirmar(String pass){
        return pass.equals(password);
    }

    public void buscar() throws SQLException{
        sql = "SELECT * FROM usuario WHERE usuario ='"+this.usuario+"'";
        
        conn.getConexion();
        Statement stmt = conn.getConexion().createStatement();
        ResultSet dato = stmt.executeQuery(sql);
        System.out.println(dato);
        try{
            while(dato.next()){
                this.usuario = dato.getString(1);
                this.password = dato.getString(2);
                this.id_perfil = dato.getInt(3);
                this.encontrado = true;
            }
            
        }catch(SQLException e){
            System.out.println("Aca");
        }
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }   
    
}
