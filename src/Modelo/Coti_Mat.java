
package Modelo;

import java.io.File;
import java.util.Date;

public class Coti_Mat {
    
    private int Codigo_Cot;
    private Date Fecha_Cot;
    private File Documento_Cot;
    private String Material_Id_Mat, Aceptacion_Cot;
    
    public Coti_Mat(){}

    public Coti_Mat(int Codigo_Cot, Date Fecha_Cot, File Documento_Cot, String Material_Id_Mat, String Aceptacion_Cot) {
        this.Codigo_Cot = Codigo_Cot;
        this.Fecha_Cot = Fecha_Cot;
        this.Documento_Cot = Documento_Cot;
        this.Material_Id_Mat = Material_Id_Mat;
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

    public String getMaterial_Id_Mat() {
        return Material_Id_Mat;
    }

    public void setMaterial_Id_Mat(String Material_Id_Mat) {
        this.Material_Id_Mat = Material_Id_Mat;
    }

    public String getAceptacion_Cot() {
        return Aceptacion_Cot;
    }

    public void setAceptacion_Cot(String Aceptacion_Cot) {
        this.Aceptacion_Cot = Aceptacion_Cot;
    }
    
    
}
