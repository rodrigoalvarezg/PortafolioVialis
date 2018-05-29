
package Modelo;

public class Material {
    
    public String id_mat,nombre_mat;

    public Material(String id_mat, String nombre_mat) {
        this.id_mat = id_mat;
        this.nombre_mat = nombre_mat;
    }

    public Material() {
    }


    public String getId_mat() {
        return id_mat;
    }

    public void setId_mat(String id_mat) {
        this.id_mat = id_mat;
    }

    public String getNombre_mat() {
        return nombre_mat;
    }

    public void setNombre_mat(String nombre_mat) {
        this.nombre_mat = nombre_mat;
    }

    @Override
    public String toString() {
        return nombre_mat;
    }
    
    
}
