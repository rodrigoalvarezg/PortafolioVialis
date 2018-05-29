
package Modelo;

import java.io.File;
import java.util.Date;

public class Contr_Serv {
    
    private int Id_Cont, Coti_Serv_Codigo_Cot;
    private Date Fecha_Cont;
    private File Documento_Cont;
    
    public Contr_Serv(){}

    public Contr_Serv(int Id_Cont, int Coti_Serv_Codigo_Cot, Date Fecha_Cont, File Documento_Cont) {
        this.Id_Cont = Id_Cont;
        this.Coti_Serv_Codigo_Cot = Coti_Serv_Codigo_Cot;
        this.Fecha_Cont = Fecha_Cont;
        this.Documento_Cont = Documento_Cont;
    }

    public int getId_Cont() {
        return Id_Cont;
    }

    public void setId_Cont(int Id_Cont) {
        this.Id_Cont = Id_Cont;
    }

    public int getCoti_Serv_Codigo_Cot() {
        return Coti_Serv_Codigo_Cot;
    }

    public void setCoti_Serv_Codigo_Cot(int Coti_Serv_Codigo_Cot) {
        this.Coti_Serv_Codigo_Cot = Coti_Serv_Codigo_Cot;
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
