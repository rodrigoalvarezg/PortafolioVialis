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
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;

/**
 *
 * @author kraus
 */
public class TCotizacion extends Conexion {
    
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
        } catch (SQLException e) {
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
        } catch (IOException e) {
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
    
    
}
