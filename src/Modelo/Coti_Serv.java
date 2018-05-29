
package Modelo;

import java.io.File;
import java.util.Date;

public class Coti_Serv {
    
    private int Codigo_Cot;
    private Date Fecha_Cot;
    private File Documento_Cot;
    private String Servicio_Id_Serv, Aceptacion_Cot;
    
    public Coti_Serv(){}

    public Coti_Serv(int Codigo_Cot, Date Fecha_Cot, File Documento_Cot, String Servicio_Id_Serv, String Aceptacion_Cot) {
        this.Codigo_Cot = Codigo_Cot;
        this.Fecha_Cot = Fecha_Cot;
        this.Documento_Cot = Documento_Cot;
        this.Servicio_Id_Serv = Servicio_Id_Serv;
        this.Aceptacion_Cot = Aceptacion_Cot;
    }

    public int getCodigo_Cot() {
        return Codigo_Cot;
    }

    public void setCodigo_Cot(int Codigo_Cot) {
        this.Codigo_Cot = Codigo_Cot;
    }

    public Date getFecha_Cot() {
        return Fecha_Cot;
    }

    public void setFecha_Cot(Date Fecha_Cot) {
        this.Fecha_Cot = Fecha_Cot;
    }

    public File getDocumento_Cot() {
        return Documento_Cot;
    }

    public void setDocumento_Cot(File Documento_Cot) {
        this.Documento_Cot = Documento_Cot;
    }

    public String getServicio_Id_Serv() {
        return Servicio_Id_Serv;
    }

    public void setServicio_Id_Serv(String Servicio_Id_Serv) {
        this.Servicio_Id_Serv = Servicio_Id_Serv;
    }

    public String getAceptacion_Cot() {
        return Aceptacion_Cot;
    }

    public void setAceptacion_Cot(String Aceptacion_Cot) {
        this.Aceptacion_Cot = Aceptacion_Cot;
    }
    
    
}
