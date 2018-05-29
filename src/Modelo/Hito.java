
package Modelo;

public class Hito {
    
    private String Id_Hito, Nombre_Hito, Proyecto_Id_Proy, Inspeccion_Avance;
    
    public Hito(){}

    public Hito(String Id_Hito, String Nombre_Hito, String Proyecto_Id_Proy, String Inspeccion_Avance) {
        this.Id_Hito = Id_Hito;
        this.Nombre_Hito = Nombre_Hito;
        this.Proyecto_Id_Proy = Proyecto_Id_Proy;
        this.Inspeccion_Avance = Inspeccion_Avance;
    }

    public String getId_Hito() {
        return Id_Hito;
    }

    public void setId_Hito(String Id_Hito) {
        this.Id_Hito = Id_Hito;
    }

    public String getNombre_Hito() {
        return Nombre_Hito;
    }

    public void setNombre_Hito(String Nombre_Hito) {
        this.Nombre_Hito = Nombre_Hito;
    }

    public String getProyecto_Id_Proy() {
        return Proyecto_Id_Proy;
    }

    public void setProyecto_Id_Proy(String Proyecto_Id_Proy) {
        this.Proyecto_Id_Proy = Proyecto_Id_Proy;
    }

    public String getInspeccion_Avance() {
        return Inspeccion_Avance;
    }

    public void setInspeccion_Avance(String Inspeccion_Avance) {
        this.Inspeccion_Avance = Inspeccion_Avance;
    }
    
    
    
}
