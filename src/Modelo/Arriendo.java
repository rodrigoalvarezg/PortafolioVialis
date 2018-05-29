
package Modelo;

import java.util.Date;

public class Arriendo {
    
    private int Id_Arriendo, Maqui_Herra_Id_Mh;
    private String Proyecto_Id_Proyecto;
    private Date Fecha_Arriendo, Fecha_Entrega;
    
    public Arriendo(){}

    public Arriendo(int Id_Arriendo, int Maqui_Herra_Id_Mh, String Proyecto_Id_Proyecto, Date Fecha_Arriendo, Date Fecha_Entrega) {
        this.Id_Arriendo = Id_Arriendo;
        this.Maqui_Herra_Id_Mh = Maqui_Herra_Id_Mh;
        this.Proyecto_Id_Proyecto = Proyecto_Id_Proyecto;
        this.Fecha_Arriendo = Fecha_Arriendo;
        this.Fecha_Entrega = Fecha_Entrega;
    }

    public int getId_Arriendo() {
        return Id_Arriendo;
    }

    public void setId_Arriendo(int Id_Arriendo) {
        this.Id_Arriendo = Id_Arriendo;
    }

    public int getMaqui_Herra_Id_Mh() {
        return Maqui_Herra_Id_Mh;
    }

    public void setMaqui_Herra_Id_Mh(int Maqui_Herra_Id_Mh) {
        this.Maqui_Herra_Id_Mh = Maqui_Herra_Id_Mh;
    }

    public String getProyecto_Id_Proyecto() {
        return Proyecto_Id_Proyecto;
    }

    public void setProyecto_Id_Proyecto(String Proyecto_Id_Proyecto) {
        this.Proyecto_Id_Proyecto = Proyecto_Id_Proyecto;
    }

    public Date getFecha_Arriendo() {
        return Fecha_Arriendo;
    }

    public void setFecha_Arriendo(Date Fecha_Arriendo) {
        this.Fecha_Arriendo = Fecha_Arriendo;
    }

    public Date getFecha_Entrega() {
        return Fecha_Entrega;
    }

    public void setFecha_Entrega(Date Fecha_Entrega) {
        this.Fecha_Entrega = Fecha_Entrega;
    }
    
    
    
}
