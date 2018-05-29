
package Modelo;

public class Trabajador {
    
    private String Run_Trab, Dv_Trab, Nombre_Trab, Apellido_Pat_Trab, Apellido_Mat_Trab,Direccion_Trab, Est_Civil_Trab, Tipo_Contrato_Trab, Afp_Trab, Seguro_Salud_Trab, Fono, Correo;
    private int Sueldo_Base_Trab, Bono_Trab, Aceptacion_Id_Acep, Profesion_Oficio_Id_Po;
    
    public Trabajador(){}

    public Trabajador(String Run_Trab, String Dv_Trab, String Nombre_Trab, String Apellido_Pat_Trab, String Apellido_Mat_Trab, String Direccion_Trab, String Est_Civil_Trab, String Tipo_Contrato_Trab, String Afp_Trab, String Seguro_Salud_Trab, String Fono, String Correo, int Sueldo_Base_Trab, int Bono_Trab, int Aceptacion_Id_Acep, int Profesion_Oficio_Id_Po) {
        this.Run_Trab = Run_Trab;
        this.Dv_Trab = Dv_Trab;
        this.Nombre_Trab = Nombre_Trab;
        this.Apellido_Pat_Trab = Apellido_Pat_Trab;
        this.Apellido_Mat_Trab = Apellido_Mat_Trab;
        this.Direccion_Trab = Direccion_Trab;
        this.Est_Civil_Trab = Est_Civil_Trab;
        this.Tipo_Contrato_Trab = Tipo_Contrato_Trab;
        this.Afp_Trab = Afp_Trab;
        this.Seguro_Salud_Trab = Seguro_Salud_Trab;
        this.Fono = Fono;
        this.Correo = Correo;
        this.Sueldo_Base_Trab = Sueldo_Base_Trab;
        this.Bono_Trab = Bono_Trab;
        this.Aceptacion_Id_Acep = Aceptacion_Id_Acep;
        this.Profesion_Oficio_Id_Po = Profesion_Oficio_Id_Po;
    }

    public String getRun_Trab() {
        return Run_Trab;
    }

    public void setRun_Trab(String Run_Trab) {
        this.Run_Trab = Run_Trab;
    }

    public String getDv_Trab() {
        return Dv_Trab;
    }

    public void setDv_Trab(String Dv_Trab) {
        this.Dv_Trab = Dv_Trab;
    }

    public String getNombre_Trab() {
        return Nombre_Trab;
    }

    public void setNombre_Trab(String Nombre_Trab) {
        this.Nombre_Trab = Nombre_Trab;
    }

    public String getApellido_Pat_Trab() {
        return Apellido_Pat_Trab;
    }

    public void setApellido_Pat_Trab(String Apellido_Pat_Trab) {
        this.Apellido_Pat_Trab = Apellido_Pat_Trab;
    }

    public String getApellido_Mat_Trab() {
        return Apellido_Mat_Trab;
    }

    public void setApellido_Mat_Trab(String Apellido_Mat_Trab) {
        this.Apellido_Mat_Trab = Apellido_Mat_Trab;
    }

    public String getDireccion_Trab() {
        return Direccion_Trab;
    }

    public void setDireccion_Trab(String Direccion_Trab) {
        this.Direccion_Trab = Direccion_Trab;
    }

    public String getEst_Civil_Trab() {
        return Est_Civil_Trab;
    }

    public void setEst_Civil_Trab(String Est_Civil_Trab) {
        this.Est_Civil_Trab = Est_Civil_Trab;
    }

    public String getTipo_Contrato_Trab() {
        return Tipo_Contrato_Trab;
    }

    public void setTipo_Contrato_Trab(String Tipo_Contrato_Trab) {
        this.Tipo_Contrato_Trab = Tipo_Contrato_Trab;
    }

    public String getAfp_Trab() {
        return Afp_Trab;
    }

    public void setAfp_Trab(String Afp_Trab) {
        this.Afp_Trab = Afp_Trab;
    }

    public String getSeguro_Salud_Trab() {
        return Seguro_Salud_Trab;
    }

    public void setSeguro_Salud_Trab(String Seguro_Salud_Trab) {
        this.Seguro_Salud_Trab = Seguro_Salud_Trab;
    }

    public String getFono() {
        return Fono;
    }

    public void setFono(String Fono) {
        this.Fono = Fono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getSueldo_Base_Trab() {
        return Sueldo_Base_Trab;
    }

    public void setSueldo_Base_Trab(int Sueldo_Base_Trab) {
        this.Sueldo_Base_Trab = Sueldo_Base_Trab;
    }

    public int getBono_Trab() {
        return Bono_Trab;
    }

    public void setBono_Trab(int Bono_Trab) {
        this.Bono_Trab = Bono_Trab;
    }

    public int getAceptacion_Id_Acep() {
        return Aceptacion_Id_Acep;
    }

    public void setAceptacion_Id_Acep(int Aceptacion_Id_Acep) {
        this.Aceptacion_Id_Acep = Aceptacion_Id_Acep;
    }

    public int getProfesion_Oficio_Id_Po() {
        return Profesion_Oficio_Id_Po;
    }

    public void setProfesion_Oficio_Id_Po(int Profesion_Oficio_Id_Po) {
        this.Profesion_Oficio_Id_Po = Profesion_Oficio_Id_Po;
    }
    
    
    
}
