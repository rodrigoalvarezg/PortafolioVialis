
package Modelo;

public class Proyecto {
    
    private String Id_Proy, Nombre_Proy, Descripcion_Proy;
    private int Cargo_Proy;
    
    public Proyecto(){}

    public Proyecto(String Id_Proy, String Nombre_Proy, String Descripcion_Proy, int Cargo_Proy) {
        this.Id_Proy = Id_Proy;
        this.Nombre_Proy = Nombre_Proy;
        this.Descripcion_Proy = Descripcion_Proy;
        this.Cargo_Proy = Cargo_Proy;
    }

    public String getId_Proy() {
        return Id_Proy;
    }

    public void setId_Proy(String Id_Proy) {
        this.Id_Proy = Id_Proy;
    }

    public String getNombre_Proy() {
        return Nombre_Proy;
    }

    public void setNombre_Proy(String Nombre_Proy) {
        this.Nombre_Proy = Nombre_Proy;
    }

    public String getDescripcion_Proy() {
        return Descripcion_Proy;
    }

    public void setDescripcion_Proy(String Descripcion_Proy) {
        this.Descripcion_Proy = Descripcion_Proy;
    }

    public int getCargo_Proy() {
        return Cargo_Proy;
    }

    public void setCargo_Proy(int Cargo_Proy) {
        this.Cargo_Proy = Cargo_Proy;
    }
    
    
    
}
