
package Modelo;

public class Perfil {
    
    private int Id_Perfil;
    private String Nombre_Perfil, Descripcion_Perfil;
    
    public Perfil(){}

    public Perfil(int Id_Perfil, String Nombre_Perfil, String Descripcion_Perfil) {
        this.Id_Perfil = Id_Perfil;
        this.Nombre_Perfil = Nombre_Perfil;
        this.Descripcion_Perfil = Descripcion_Perfil;
    }

    public int getId_Perfil() {
        return Id_Perfil;
    }

    public void setId_Perfil(int Id_Perfil) {
        this.Id_Perfil = Id_Perfil;
    }

    public String getNombre_Perfil() {
        return Nombre_Perfil;
    }

    public void setNombre_Perfil(String Nombre_Perfil) {
        this.Nombre_Perfil = Nombre_Perfil;
    }

    public String getDescripcion_Perfil() {
        return Descripcion_Perfil;
    }

    public void setDescripcion_Perfil(String Descripcion_Perfil) {
        this.Descripcion_Perfil = Descripcion_Perfil;
    }
    
    
    
}
