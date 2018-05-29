
package Modelo;

import java.util.Date;

public class Entrada_Salida {
    
    private int Id_Es, Cantidad_Es;
    private Date Fecha_Es;
    private String Tipo_Es, Material_Id_Mat;
    
    public Entrada_Salida(){}

    public Entrada_Salida(int Id_Es, int Cantidad_Es, Date Fecha_Es, String Tipo_Es, String Material_Id_Mat) {
        this.Id_Es = Id_Es;
        this.Cantidad_Es = Cantidad_Es;
        this.Fecha_Es = Fecha_Es;
        this.Tipo_Es = Tipo_Es;
        this.Material_Id_Mat = Material_Id_Mat;
    }

    public int getId_Es() {
        return Id_Es;
    }

    public void setId_Es(int Id_Es) {
        this.Id_Es = Id_Es;
    }

    public int getCantidad_Es() {
        return Cantidad_Es;
    }

    public void setCantidad_Es(int Cantidad_Es) {
        this.Cantidad_Es = Cantidad_Es;
    }

    public Date getFecha_Es() {
        return Fecha_Es;
    }

    public void setFecha_Es(Date Fecha_Es) {
        this.Fecha_Es = Fecha_Es;
    }

    public String getTipo_Es() {
        return Tipo_Es;
    }

    public void setTipo_Es(String Tipo_Es) {
        this.Tipo_Es = Tipo_Es;
    }

    public String getMaterial_Id_Mat() {
        return Material_Id_Mat;
    }

    public void setMaterial_Id_Mat(String Material_Id_Mat) {
        this.Material_Id_Mat = Material_Id_Mat;
    }
    
    
    
}
