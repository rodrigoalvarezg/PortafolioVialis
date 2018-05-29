
package Modelo;

public class Maqui_Herra {
    
    private int Id_Mh;
    private double Precio_Mh;
    private String Nombre_Mh, Tipo_Mh, Disponibilidad_Mh;
    
    public Maqui_Herra(){}

    public Maqui_Herra(int Id_Mh, double Precio_Mh, String Nombre_Mh, String Tipo_Mh, String Disponibilidad_Mh) {
        this.Id_Mh = Id_Mh;
        this.Precio_Mh = Precio_Mh;
        this.Nombre_Mh = Nombre_Mh;
        this.Tipo_Mh = Tipo_Mh;
        this.Disponibilidad_Mh = Disponibilidad_Mh;
    }

    public int getId_Mh() {
        return Id_Mh;
    }

    public void setId_Mh(int Id_Mh) {
        this.Id_Mh = Id_Mh;
    }

    public double getPrecio_Mh() {
        return Precio_Mh;
    }

    public void setPrecio_Mh(double Precio_Mh) {
        this.Precio_Mh = Precio_Mh;
    }

    public String getNombre_Mh() {
        return Nombre_Mh;
    }

    public void setNombre_Mh(String Nombre_Mh) {
        this.Nombre_Mh = Nombre_Mh;
    }

    public String getTipo_Mh() {
        return Tipo_Mh;
    }

    public void setTipo_Mh(String Tipo_Mh) {
        this.Tipo_Mh = Tipo_Mh;
    }

    public String getDisponibilidad_Mh() {
        return Disponibilidad_Mh;
    }

    public void setDisponibilidad_Mh(String Disponibilidad_Mh) {
        this.Disponibilidad_Mh = Disponibilidad_Mh;
    }
    
    
    
}
