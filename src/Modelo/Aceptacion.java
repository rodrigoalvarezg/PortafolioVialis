
package Modelo;

public class Aceptacion {
    
    private int Id_acep;
    private String Descripcion_Acep, Portentaje;
    
    public Aceptacion(){}

    public Aceptacion(int Id_acep, String Descripcion_Acep, String Portentaje) {
        this.Id_acep = Id_acep;
        this.Descripcion_Acep = Descripcion_Acep;
        this.Portentaje = Portentaje;
    }      

    public int getId_acep() {
        return Id_acep;
    }

    public void setId_acep(int Id_acep) {
        this.Id_acep = Id_acep;
    }

    public String getDescripcion_Acep() {
        return Descripcion_Acep;
    }

    public void setDescripcion_Acep(String Descripcion_Acep) {
        this.Descripcion_Acep = Descripcion_Acep;
    }

    public String getPortentaje() {
        return Portentaje;
    }

    public void setPortentaje(String Portentaje) {
        this.Portentaje = Portentaje;
    }
    
    
    
}
