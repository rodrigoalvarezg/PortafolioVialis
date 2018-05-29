
package Modelo;

import java.util.Date;

public class Acta_Reunion {
    
    private String Id_Reun, Citador_Reun, Motivo_Reun, Hito_Id_Hito, Hito_Proyecto_Id_Proy;
    private Date Fecha_Reun, Hora_Ini_Reun, Hora_Ter_Reun; 
    
    public Acta_Reunion(){}

    public Acta_Reunion(String Id_Reun, String Citador_Reun, String Motivo_Reun, String Hito_Id_Hito, String Hito_Proyecto_Id_Proy, Date Fecha_Reun, Date Hora_Ini_Reun, Date Hora_Ter_Reun) {
        this.Id_Reun = Id_Reun;
        this.Citador_Reun = Citador_Reun;
        this.Motivo_Reun = Motivo_Reun;
        this.Hito_Id_Hito = Hito_Id_Hito;
        this.Hito_Proyecto_Id_Proy = Hito_Proyecto_Id_Proy;
        this.Fecha_Reun = Fecha_Reun;
        this.Hora_Ini_Reun = Hora_Ini_Reun;
        this.Hora_Ter_Reun = Hora_Ter_Reun;
    }

    public String getId_Reun() {
        return Id_Reun;
    }

    public void setId_Reun(String Id_Reun) {
        this.Id_Reun = Id_Reun;
    }

    public String getCitador_Reun() {
        return Citador_Reun;
    }

    public void setCitador_Reun(String Citador_Reun) {
        this.Citador_Reun = Citador_Reun;
    }

    public String getMotivo_Reun() {
        return Motivo_Reun;
    }

    public void setMotivo_Reun(String Motivo_Reun) {
        this.Motivo_Reun = Motivo_Reun;
    }

    public String getHito_Id_Hito() {
        return Hito_Id_Hito;
    }

    public void setHito_Id_Hito(String Hito_Id_Hito) {
        this.Hito_Id_Hito = Hito_Id_Hito;
    }

    public String getHito_Proyecto_Id_Proy() {
        return Hito_Proyecto_Id_Proy;
    }

    public void setHito_Proyecto_Id_Proy(String Hito_Proyecto_Id_Proy) {
        this.Hito_Proyecto_Id_Proy = Hito_Proyecto_Id_Proy;
    }

    public Date getFecha_Reun() {
        return Fecha_Reun;
    }

    public void setFecha_Reun(Date Fecha_Reun) {
        this.Fecha_Reun = Fecha_Reun;
    }

    public Date getHora_Ini_Reun() {
        return Hora_Ini_Reun;
    }

    public void setHora_Ini_Reun(Date Hora_Ini_Reun) {
        this.Hora_Ini_Reun = Hora_Ini_Reun;
    }

    public Date getHora_Ter_Reun() {
        return Hora_Ter_Reun;
    }

    public void setHora_Ter_Reun(Date Hora_Ter_Reun) {
        this.Hora_Ter_Reun = Hora_Ter_Reun;
    }
    
    
    
}
