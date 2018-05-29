
package Modelo;

import java.util.Date;

public class Tarea {
    
    private String Id_Tar, Nombre_Tar, Hito_Id_Hito, Hito_Id_Proy;
    private int Avance_Tar;
    private Date Fecha_Inicio_Tar, Fecha_Termino_Tar;
    
    public Tarea(){}

    public Tarea(String Id_Tar, String Nombre_Tar, String Hito_Id_Hito, String Hito_Id_Proy, int Avance_Tar, Date Fecha_Inicio_Tar, Date Fecha_Termino_Tar) {
        this.Id_Tar = Id_Tar;
        this.Nombre_Tar = Nombre_Tar;
        this.Hito_Id_Hito = Hito_Id_Hito;
        this.Hito_Id_Proy = Hito_Id_Proy;
        this.Avance_Tar = Avance_Tar;
        this.Fecha_Inicio_Tar = Fecha_Inicio_Tar;
        this.Fecha_Termino_Tar = Fecha_Termino_Tar;
    }

    public String getId_Tar() {
        return Id_Tar;
    }

    public void setId_Tar(String Id_Tar) {
        this.Id_Tar = Id_Tar;
    }

    public String getNombre_Tar() {
        return Nombre_Tar;
    }

    public void setNombre_Tar(String Nombre_Tar) {
        this.Nombre_Tar = Nombre_Tar;
    }

    public String getHito_Id_Hito() {
        return Hito_Id_Hito;
    }

    public void setHito_Id_Hito(String Hito_Id_Hito) {
        this.Hito_Id_Hito = Hito_Id_Hito;
    }

    public String getHito_Id_Proy() {
        return Hito_Id_Proy;
    }

    public void setHito_Id_Proy(String Hito_Id_Proy) {
        this.Hito_Id_Proy = Hito_Id_Proy;
    }

    public int getAvance_Tar() {
        return Avance_Tar;
    }

    public void setAvance_Tar(int Avance_Tar) {
        this.Avance_Tar = Avance_Tar;
    }

    public Date getFecha_Inicio_Tar() {
        return Fecha_Inicio_Tar;
    }

    public void setFecha_Inicio_Tar(Date Fecha_Inicio_Tar) {
        this.Fecha_Inicio_Tar = Fecha_Inicio_Tar;
    }

    public Date getFecha_Termino_Tar() {
        return Fecha_Termino_Tar;
    }

    public void setFecha_Termino_Tar(Date Fecha_Termino_Tar) {
        this.Fecha_Termino_Tar = Fecha_Termino_Tar;
    }
    
    
    
}
