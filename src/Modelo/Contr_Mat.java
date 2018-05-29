
package Modelo;

import java.io.File;
import java.util.Date;

public class Contr_Mat {
    
    private int Id_Cont, Coti_Mat_Codigo_Cot;
    private Date Fecha_Cont;
    private File Documento_Cont;
    
    public Contr_Mat(){}

    public Contr_Mat(int Id_Cont, int Coti_Mat_Codigo_Cot, Date Fecha_Cont, File Documento_Cont) {
        this.Id_Cont = Id_Cont;
        this.Coti_Mat_Codigo_Cot = Coti_Mat_Codigo_Cot;
        this.Fecha_Cont = Fecha_Cont;
        this.Documento_Cont = Documento_Cont;
    }

    public int getId_Cont() {
        return Id_Cont;
    }

    public void setId_Cont(int Id_Cont) {
        this.Id_Cont = Id_Cont;
    }

    public int getCoti_Mat_Codigo_Cot() {
        return Coti_Mat_Codigo_Cot;
    }

    public void setCoti_Mat_Codigo_Cot(int Coti_Mat_Codigo_Cot) {
        this.Coti_Mat_Codigo_Cot = Coti_Mat_Codigo_Cot;
    }

    public Date getFecha_Cont() {
        return Fecha_Cont;
    }

    public void setFecha_Cont(Date Fecha_Cont) {
        this.Fecha_Cont = Fecha_Cont;
    }

    public File getDocumento_Cont() {
        return Documento_Cont;
    }

    public void setDocumento_Cont(File Documento_Cont) {
        this.Documento_Cont = Documento_Cont;
    }
    
    
    
}
