/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
//comentario de prueba git
/**
 *
 * @author Rodrigo
 */
public class MaterialConsultas extends Conexion {
    
    Conexion con = new Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void subirCotizacion (String id_mat, FileInputStream archivo,long longitud)
    { 
            try {
                ps = getConexion().prepareStatement("CALL PRO_SUB_COT(?,?)");
                ps.setBlob(1, archivo,longitud);
                ps.setString(2, id_mat);
                ps.executeUpdate();
                System.out.println("Sentencia sql correcta en Material Consulta");
                rs.close();
            } catch (Exception e) {
                System.out.println("No se Realizo bien la sentencia sql en Material Consulta");
                System.out.println("Error: "+e);
            }  
    }
    
    public void subirCotiServicio (String id_serv, FileInputStream archivo,long longitud)
    { 
        try {
            ps = getConexion().prepareStatement("CALL PRO_SUB_COT_SERV(?,?)");
            ps.setBlob(1, archivo,longitud);
            ps.setString(2, id_serv);
            ps.executeUpdate();
            System.out.println("Sentencia sql correcta en Material Consulta");
            rs.close();
        } catch (Exception e) {
            System.out.println("No se Realizo bien la sentencia sql en Material Consulta");
            System.out.println("Error: "+e);
        }  
    }
    
    public void guardarCotMaterial(InputStream x){
        JFileChooser selector = new JFileChooser();
        File url = null;
        int returnVal = selector.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            File ruta = selector.getSelectedFile();
            url = ruta;
        }
        String nombre = "";
        File fichero = new File(url+nombre+".pdf");
        BufferedInputStream in = new BufferedInputStream(x);
        
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichero));
            byte[] bytes = new byte[10240]; 
            int len = 0;
            while ((len = in.read(bytes))>0){
                out.write(bytes,0,len);
            }
            out.flush();
            out.close();
            in.close();
        } catch (Exception e) {
        }
        
    }
    
    public void descargarCotMaterial(String codigo_cot){
        try {
            String query = "SELECT DOCUMENTO_COT FROM COTI_MAT WHERE CODIGO_COT = "+codigo_cot+"";
            ps = getConexion().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Blob blob = rs.getBlob("DOCUMENTO_COT");
                InputStream is = blob.getBinaryStream();
                guardarCotMaterial(is);
            }
        } catch (Exception e) {
        }
    }
    
    public void guardarCotServicio(InputStream x){
        JFileChooser selector = new JFileChooser();
        File url = null;
        int returnVal = selector.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            File ruta = selector.getSelectedFile();
            url = ruta;
        }
        String nombre = "";
        File fichero = new File(url+nombre+".pdf");
        BufferedInputStream in = new BufferedInputStream(x);
        
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichero));
            byte[] bytes = new byte[10240]; 
            int len = 0;
            while ((len = in.read(bytes))>0){
                out.write(bytes,0,len);
            }
            out.flush();
            out.close();
            in.close();
        } catch (Exception e) {
        }
        
    }
    
    
    public void descargarCotServicio(String codigo_cot){
        try {
            String query = "SELECT DOCUMENTO_COT FROM COTI_SERV WHERE CODIGO_COT = "+codigo_cot+"";
            ps = getConexion().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Blob blob = rs.getBlob("DOCUMENTO_COT");
                InputStream is = blob.getBinaryStream();
                guardarCotMaterial(is);
            }
        } catch (Exception e) {
        }
    }
    
    
    public void agregarMaterial(String nombre, int cantidad) throws SQLException{
        String id = "MAT" + nombre.substring(0,3);
        try{
            ps = con.getConexion().prepareStatement("CALL AG_MATERIAL(?,?,?)");
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setInt(3, cantidad);
            
            ps.executeUpdate();
            System.out.println("Registro Realizado");
        }catch (SQLException e) {
            System.out.println("Registro no Realizado");
            System.out.println("Error:"+e);
        }
    }
    
    public void editarMaterial(String id, String nombre, int cantidad) throws SQLException{
        try{
            ps = con.getConexion().prepareStatement("CALL UP_MATERIAL(?,?,?)");
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setInt(3, cantidad);
            
            ps.executeUpdate();
            System.out.println("Registro Actualizado");
        }catch (SQLException e) {
            System.out.println("Registro no Actualizado");
            System.out.println("Error:"+e);
        }
    }
    
    public void eliminarMaterial(String id){
        try {
        String query = "DELETE FROM material WHERE ID_MAT='"+id+"'";
        ps = con.getConexion().prepareStatement(query);
        rs = ps.executeQuery();
        System.out.println("Registros eliminado");
        }catch(SQLException ex){
            System.out.println("Registro no Eliminado");
            System.out.println("Error:"+ex);
        }
    }
    
     public void aceptarCotMaterial(String codigo_cot_mat){
        
        try {
            String query = "CALL PRO_ACT_COT_MAT(?)";
            ps = getConexion().prepareStatement(query);
            ps.setString(1, codigo_cot_mat);
            ps.executeUpdate();
            rs.close();
        } catch (Exception e) {
        }
    }
    
    public void rechazarCotMaterial(String codigo_cot_mat){
        
        try {
            String query = "CALL PRO_REC_COT_MAT(?)";
            ps = getConexion().prepareStatement(query);
            ps.setString(1, codigo_cot_mat);
            ps.executeUpdate();
            rs.close();
        } catch (Exception e) {
        }
    }
    
    public void aceptarCotServicio(String codigo_cot_mat){
        
        try {
            String query = "CALL PRO_ACT_COT_SERV(?)";
            ps = getConexion().prepareStatement(query);
            ps.setString(1, codigo_cot_mat);
            ps.executeUpdate();
            rs.close();
        } catch (Exception e) {
        }
    }
    
    public void rechazarCotServicio(String codigo_cot_serv){
        
        try {
            String query = "CALL PRO_REC_COT_SERV(?)";
            ps = getConexion().prepareStatement(query);
            ps.setString(1, codigo_cot_serv);
            ps.executeUpdate();
            rs.close();
        } catch (Exception e) {
        }
    }
    
    public void validarCotizacionMateriales(String cod_material){
        try {
            String query = "SELECT COUNT(*) FROM COTI_MAT WHERE MATERIAL_ID_MAT="+cod_material+"";
            ps = getConexion().prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
}
