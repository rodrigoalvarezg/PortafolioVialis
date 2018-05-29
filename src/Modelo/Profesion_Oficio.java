
package Modelo;

public class Profesion_Oficio {
    
    private int Id_Po;
    private String Tipo_Po, Nombre_Po;
    
    public Profesion_Oficio(){}

    public Profesion_Oficio(int Id_Po, String Tipo_Po, String Nombre_Po) {
        this.Id_Po = Id_Po;
        this.Tipo_Po = Tipo_Po;
        this.Nombre_Po = Nombre_Po;
    }

    public int getId_Po() {
        return Id_Po;
    }

    public void setId_Po(int Id_Po) {
        this.Id_Po = Id_Po;
    }

    public String getTipo_Po() {
        return Tipo_Po;
    }

    public void setTipo_Po(String Tipo_Po) {
        this.Tipo_Po = Tipo_Po;
    }

    public String getNombre_Po() {
        return Nombre_Po;
    }

    public void setNombre_Po(String Nombre_Po) {
        this.Nombre_Po = Nombre_Po;
    }
    
    
    
}
