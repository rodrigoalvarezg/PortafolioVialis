
package Modelo;

public class Servicio {
    
    private String Id_Servicio, Nombre_Serv, Descripcion_Serv;
    
    public Servicio(){}

    public Servicio(String Id_Servicio, String Nombre_Serv, String Descripcion_Serv) {
        this.Id_Servicio = Id_Servicio;
        this.Nombre_Serv = Nombre_Serv;
        this.Descripcion_Serv = Descripcion_Serv;
    }

    public String getId_Servicio() {
        return Id_Servicio;
    }

    public void setId_Servicio(String Id_Servicio) {
        this.Id_Servicio = Id_Servicio;
    }

    public String getNombre_Serv() {
        return Nombre_Serv;
    }

    public void setNombre_Serv(String Nombre_Serv) {
        this.Nombre_Serv = Nombre_Serv;
    }

    public String getDescripcion_Serv() {
        return Descripcion_Serv;
    }

    public void setDescripcion_Serv(String Descripcion_Serv) {
        this.Descripcion_Serv = Descripcion_Serv;
    }
    
    
    
}
